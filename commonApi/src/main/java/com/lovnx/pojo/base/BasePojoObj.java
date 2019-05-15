package com.lovnx.pojo.base;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="restful返回对象",description="返回给app端的参数由此对象接收")
public class BasePojoObj extends BasePojo
{

   private static final long serialVersionUID = 1L;

   /**
    * 查询结果
    */
   @ApiModelProperty(value="返回的json数据",name="data")
   private Object data = "";
   @JsonView(hasNotPage.class)
   public Object getData() {
      return data;
   }

   public void setData(Object data) {
      this.data = data;
   }





}
