package com.lovnx.clients;

import com.lovnx.pojo.base.BasePojoObj;
import com.lovnx.pojo.base.ReqApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fengxiao on 2018/11/5.
 */
@FeignClient("sendCodePlatformUserService")
public interface UserFeignClient {

   @RequestMapping(value = "/getUserInfo" ,method = RequestMethod.POST)
   BasePojoObj getUserInfo(@RequestBody ReqApiParam clientParam);
}
