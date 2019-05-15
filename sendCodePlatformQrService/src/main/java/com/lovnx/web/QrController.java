package com.lovnx.web;

import com.lovnx.clients.UserFeignClient;
import com.lovnx.entity.QrTicketInfo;
import com.lovnx.pojo.base.BasePojo;
import com.lovnx.pojo.base.BasePojoObj;
import com.lovnx.pojo.base.ReqApiParam;
import com.lovnx.service.QrTicketInfoFacade;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QrController {

   private final Logger logger = Logger.getLogger(getClass());
   @Autowired
   private UserFeignClient userFeignClient;
   @Autowired
   private QrTicketInfoFacade qrTicketInfoFacade;

   @RequestMapping(value = "/saveQrOrder" ,method = RequestMethod.POST)
   public BasePojoObj saveQrOrder(@RequestBody ReqApiParam clientParam) {
      BasePojoObj result = new BasePojoObj();
      try {
         //Thread.sleep(40000);
         //通过feign调用用户相关服务
         BasePojoObj obj=userFeignClient.getUserInfo(clientParam);
         if(obj!=null) {
            qrTicketInfoFacade.saveQrTicketInfos();
            result.setStatus(BasePojo.CODE_SUCCESS);
            result.setMsg("新增订单成功");
         }
      } catch (Exception e) {
         logger.error("异常:{}",e);
         result.setStatus(BasePojo.CODE_FAIL);
         result.setMsg(e.getMessage());
      }
      return result;
   }
}