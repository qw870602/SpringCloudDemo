package com.lovnx.web;



import com.lovnx.entity.ctr.UserInfo;
import com.lovnx.pojo.base.BasePojo;
import com.lovnx.pojo.base.BasePojoObj;
import com.lovnx.pojo.base.ReqApiParam;
import com.lovnx.service.UserInfoFacade;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

   private final Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired
   private UserInfoFacade userInfoFacade;

   @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.POST)
  // @HystrixCommand(fallbackMethod = "getUserInfoError")
   public BasePojoObj getUserInfo(@RequestBody ReqApiParam clientParam) {
      BasePojoObj result = new BasePojoObj();
      try {
         //Thread.sleep(60000);
         String userId =  clientParam.getUserId();
         UserInfo user=userInfoFacade.getUserInfo(userId);
         // if user has exist
         result.setData(user);
         result.setStatus(BasePojo.CODE_SUCCESS);
         result.setMsg(BasePojo.MSG_SUCCESS);

      } catch (Exception e) {
         logger.error("异常:{}",e);
         result.setStatus(BasePojo.CODE_FAIL);
         result.setMsg(e.getMessage());
      }
      return result;
   }

   @RequestMapping(value = "/login" ,method = RequestMethod.POST)
   public BasePojoObj login(@RequestBody ReqApiParam clientParam) {
      BasePojoObj result = new BasePojoObj();
      try {
         // if user has exist
         result.setStatus(BasePojo.CODE_SUCCESS);
         result.setMsg("登陆成功");
      } catch (Exception e) {
         logger.error("异常:{}",e);
         result.setStatus(BasePojo.CODE_FAIL);
         result.setMsg(e.getMessage());
      }
      return result;
   }

   public BasePojoObj getUserInfoError(ReqApiParam reqApiParam) {
      BasePojoObj result = new BasePojoObj();
      try {
         //Thread.sleep(60000);
         //String username =  clientParam.getUserId();
         //UserInfo user=userInfoFacade.getUserInfo(username);
         //// if user has exist
         //result.setData(user);
         result.setStatus(BasePojo.CODE_FAIL);
         result.setMsg("熔断返回");

      } catch (Exception e) {
         logger.error("异常:{}",e);
         result.setStatus(BasePojo.CODE_FAIL);
         result.setMsg(e.getMessage());
      }
      return result;
   }


}