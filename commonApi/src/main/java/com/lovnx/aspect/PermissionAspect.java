package com.lovnx.aspect;


import java.lang.reflect.Method;
import java.util.Date;
import javax.annotation.Resource;

import com.lovnx.pojo.base.BasePojoObj;
import com.lovnx.pojo.base.ReqApiParam;
import com.lovnx.utils.RedisUtils;
import com.lovnx.pojo.base.BasePojo;
import com.lovnx.pojo.base.BasePojoList;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.traffic.common.utils.Tools;

import net.sf.json.JSONObject;

/**
 * 
 * @author yangxiaobo
 *
 */
@Component
@Aspect
public class PermissionAspect {
	private final static Logger logger = LoggerFactory.getLogger(PermissionAspect.class);
	@Resource
	private RedisUtils redisUtils;
	@Around("@annotation(com.lovnx.annotation.TokenAccess)")
	public Object checkPermission(ProceedingJoinPoint joinPoint) throws Throwable{
		BasePojo result = new BasePojo();
		String methodName = joinPoint.getSignature().getName();  
		Object target = joinPoint.getTarget();  
		Method method = getMethodByClassAndName(target.getClass(), methodName);    //得到拦截的方法  
		Class<?> returnType = method.getReturnType();
		String typeName = returnType.getTypeName();
		Object[] args = joinPoint.getArgs();
		if (typeName.equals("BasePojoList")) {
			 result = new BasePojoList();
		}else if (typeName.equals("BasePojoObj")) {
			 result = new BasePojoObj();
		}else {
			JSONObject obj = JSONObject.fromObject(joinPoint.getArgs()[0]);
			JSONObject param = JSONObject.fromObject(obj.get("param")); 
			
			String loginName = Tools.str(obj.get("loginName"),"");
			if ("".equals(loginName)) {
				loginName = Tools.str(Tools.str(param.get("loginName"),""), "");
			}
			if ("".equals(loginName)) {
				loginName = Tools.str(Tools.str(obj.get("userAccount"),""), "");
			}
			if ("".equals(loginName)) {
				loginName = Tools.str(Tools.str(JSONObject.fromObject(obj.get("param")).get("userAccount"),""), "");
			}
			String token = Tools.str(obj.get("token"),"");
			if ("".equals(token)) {
				token = Tools.str(obj, Tools.str(param.get("token"),""));
			}
			if (StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(token) ) {
				String object = Tools.str(redisUtils.get(loginName),"");
				if (object.equals(token)) {
					return joinPoint.proceed();
				}
			}
			return JSONObject.fromObject("{\"status\": 1,\"msg\": \"登录信息失效或在其他设备登录,请重新登录！\",\"data\": \"\"}");
			
		}
		//HttpServletRequest request=(HttpServletRequest)args[0];
		ReqApiParam reqApiParam = null;
		if (args[0] instanceof ReqApiParam) {
			reqApiParam=(ReqApiParam)args[0];
		}
		String username = reqApiParam.getLoginName();
		if (username==null||username.equals("")) {
			result.setStatus(BasePojo.CODE_FAIL);
			result.setMsg("系统未查询到该用户，请使用正确用户名登录！！");
			return result;
		}
		String token = reqApiParam.getToken();
		logger.info(new Date().toString()+" method: "+methodName+"/n Token:"+token);
		//如果token存在于缓存中，则返回用户数据，
		Object object = redisUtils.get(username);
		Object rvt = null;
		if (object instanceof String) {
			String temp = (String)object;
			if (temp.equals(token)) {
				  rvt = joinPoint.proceed();
				  //这里判断如果data没有数据的话，去掉data属性
				  
			}else {
				//封装token校验失败返回数据
				result.setStatus(BasePojo.CODE_ERROR);
				result.setMsg("已在其他设备登录,请重新登录！！");
				/*JSONObject json = JSONObject.fromObject(result);
				rvt = json;*/
				return result;
			}//token验证不通过
		}else {
			//封装缓存中没有此用户的token失败返回数据
			result.setStatus(BasePojo.CODE_FAIL);
			result.setMsg("登录信息失效,请重新登录！！");
			/*JSONObject json = JSONObject.fromObject(result);
			rvt = json;*/
			return result;
		}//无法将object转换为string或者是缓存中没有此用户的token
		return rvt;
	
	}
	/** 
     * 得到请求中的token
     */  
    private String findToken(Object[] args) {
    	for(int i = 0;args.length>i;i++) {
    		if (args[i] instanceof String) {
    			String temp = (String)args[i];
    				if (temp.equals("token")) {
						return temp;
					}
				}
			}
    	
		return null;
	}

	/** 
     * 根据类和方法名得到方法 
     */  
    public Method getMethodByClassAndName(Class c , String methodName){  
        Method[] methods = c.getDeclaredMethods();  
        for (Method method : methods) {  
            if(method.getName().equals(methodName)){  
                return method ;  
            }  
        }  
        return null;  
    }
}
