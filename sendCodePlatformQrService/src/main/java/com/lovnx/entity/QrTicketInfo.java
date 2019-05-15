package com.lovnx.entity;

import com.lovnx.pojo.base.ReqApiParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class QrTicketInfo extends ReqApiParam{


   private Integer id;

   private String userNo;

   private String qrNo;

   private String qrStr;


}