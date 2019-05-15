package com.lovnx.pojo.base;

import java.io.Serializable;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;


/**
 *
 * @author yangxiaobo
 *
 */
@ApiModel(value="接收对象",description="接收前端返回的json")
@Data
public class ReqApiParam implements Serializable{
   private static final long serialVersionUID = 1L;
   public static final String CODE_TYPE= "codeType"; //code
   public static final String LOGIN_NAME = "loginName";	//登录名
   public static final String TOKEN = "userToken";
   public static final String REGIST_CODE= "registCode"; //注册识别
   public static final String RESET_CODE= "resetCode"; //重置密码识别
   public static final String EX_CODE= "exType"; //其他识别
   public static final String NEW_PASSWORD= "newPassword"; //其他识别
   public static final String USER_ID= "userId";
   @ApiModelProperty(value="客户端类型",name="client")
   private String client;
   @ApiModelProperty(value="接收的参数",name="param")
   private Map param;
   @ApiModelProperty(value="凭证（可不填）",name="token",hidden=true)
   private String token;
   @ApiModelProperty(value="不需要填",name="loginName",hidden=true)
   private String loginName;
   private String userId;
   public Map getParam() {
      return param;
   }
   public void setParam(Map param) {
      this.param = param;
      if(param.get(TOKEN)!=null) {
         this.token = (String) param.get(TOKEN);
      }
      this.loginName = (String) param.get(LOGIN_NAME);
   }

}
