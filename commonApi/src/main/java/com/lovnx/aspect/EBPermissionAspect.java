package com.lovnx.aspect;



import java.lang.reflect.Method;
import java.util.Date;
import javax.annotation.Resource;

import com.lovnx.pojo.base.BasePojoObj;
import com.lovnx.utils.RedisUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
 * @author yangxiaobo
 *
 */
@Component
@Aspect
public class EBPermissionAspect {
	private final static Logger logger = LoggerFactory.getLogger(EBPermissionAspect.class);
	@Resource
	private RedisUtils redisUtils;
	@Around("@annotation(com.lovnx.annotation.EBTokenAccess)")
	public Object checkPermission(ProceedingJoinPoint joinPoint) throws Throwable{
		String methodName = joinPoint.getSignature().getName();  
		BasePojoObj result = new BasePojoObj();
		Object[] args = joinPoint.getArgs();
		//HttpServletRequest request=(HttpServletRequest)args[0];
		String reqApiParam = null;
		if (args[0] instanceof String) {
			reqApiParam=(String)args[0];
		}
		JsonParser parser = new JsonParser();
		JsonObject obj = (JsonObject) parser.parse(reqApiParam);
		String token = obj.get("token").toString().replace("\"","").replace("\"","");
		logger.info(new Date().toString()+" method: "+methodName+"/n Token:"+token);
		//如果token存在于缓存中，则返回用户数据，
		Object object = redisUtils.get(token);
		Object rvt = null;
		//if (object instanceof UserTransfDTO) {
		//		  rvt = joinPoint.proceed(); //这里不对用户名进行验证
		//}else {
		//	result.setStatus(BasePojo.CODE_ERROR);
		//	result.setMsg("登录信息失效或在其他设备登录,请重新登录！");
		//	JSONObject jsonObject = JSONObject.fromObject(result);
		//	return jsonObject;
		//}//无法将object转换为string或者是缓存中没有此用户的token
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
