package com.lovnx.filter;

import com.google.gson.Gson;
import com.lovnx.pojo.base.BasePojo;
import com.lovnx.pojo.base.BasePojoObj;
import com.lovnx.pojo.base.ReqApiParam;
import com.lovnx.utils.RedisUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PreFilter extends ZuulFilter  {

   private static Logger log = LoggerFactory.getLogger(PreFilter.class);
   @Resource
   private RedisUtils redisUtils;

   @Override
   public String filterType() {
      return "pre";
   }

   @Override
   public int filterOrder() {
      return 0;
   }

   @Override
   public boolean shouldFilter() {
      return true;
   }

   @Override
   public Object run() {
      RequestContext ctx = RequestContext.getCurrentContext();
      HttpServletRequest request = ctx.getRequest();
      log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>第一级过滤器>>>>>>>>>>>>>>>>>>>>>>>>>>！");
      BufferedReader bufferReaderBody = null;
      try {
         bufferReaderBody = new BufferedReader(request.getReader());
         StringBuffer wholeStr=new StringBuffer();
         String str;
         while((str = bufferReaderBody.readLine()) != null){
            wholeStr.append(str);
         }
         Gson gson=new Gson();
         Map<String,String> map=new HashMap<>(16);
         map=gson.fromJson(wholeStr.toString(),map.getClass());

         /*** 打印上送的请求参数明细 ***/
         this.PrintMap(map);
         log.info(">>>>>>>>>>>>>>>>调用地址:{}",request.getRequestURI());
         BasePojoObj result=new BasePojoObj();
         boolean isSendZuulResponse=false;
         String userId = map.get(ReqApiParam.USER_ID);
         String token = map.get(ReqApiParam.TOKEN);
         //注册和登录不验证TOKEN
         if("login".equals(map.get("method"))){
            String token2="111111";  //假设用户登陆返回1个token，这里简单处理，实际情况下TOKEN需要某种算法算出来，且每个用户唯一
            redisUtils.set(userId,token2); //将 userId-token 键值对放入缓存中
            result.setToken(token2);
            result.setMsg("登陆成功");
            result.setStatus(0);
         }else {
            //如果token存在于缓存中，则返回用户数据，
            Object object = redisUtils.get(userId);
            if (object instanceof String) {
               String temp = (String) object;
               if (temp.equals(token)) {
                  //这里判断如果data没有数据的话，去掉data属性
                  isSendZuulResponse = true;
               } else {
                  //封装token校验失败返回数据
                  result.setStatus(BasePojo.CODE_ERROR);
                  result.setMsg("已在其他设备登录,请重新登录！！");
               }//token验证不通过
            } else {
               //封装缓存中没有此用户的token失败返回数据
               result.setStatus(BasePojo.CODE_FAIL);
               result.setMsg("登录信息失效,请重新登录！！");
            }
         }
         JSONObject json = JSONObject.fromObject(result);
         String strJson = json.toString();
         if(!isSendZuulResponse){
            ctx.setResponseBody(strJson);
         }
         ctx.setSendZuulResponse(isSendZuulResponse);
         ctx.getResponse().setContentType("text/html;charset=UTF-8");
      } catch (IOException e) {
         log.error("异常:{}",e);
      } finally {
         try {
            if (bufferReaderBody != null) {
               bufferReaderBody.close();
            }
         } catch (IOException e) {
            e.printStackTrace();
            log.error("字符流关闭失败!");
         }
      }

      //系统级参数校验，令牌校验等
      log.info("===============");


      return null;
   }

   /**
    * 打印上送的请求参数
    * @param map
    */
   private void PrintMap(Map map){
      log.info("收到的请求信息:*************");
      map.forEach((key,value)->log.info("{}: {}",key,value));
      log.info("收到的请求信息:*************");
   }

}
