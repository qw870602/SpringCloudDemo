package com.lovnx.pojo.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * @author yangxiaobo
 *
 */
public class BasePojo implements Serializable
{
	
    public interface hasNotPage {};  /*not contain data*/
    public interface hasPage extends hasNotPage {};  
    private static final long serialVersionUID = 1L;
    
    /**
    * 查询结果状态码
    */
    @ApiModelProperty(value="结果状态",name="status",example="1")
    private Integer status = 1;
    
    /**
     * 凭证
     */
    @ApiModelProperty(value="用户凭证",name="token")
     private String token ;
    /**
    * 查询结果信息
    */
    @ApiModelProperty(value="查询结果信息",name="msg",example="成功")
    private String msg = "失败";


    /**
     * @Fields CODE_ERROR : TODO(token校验失败)
     */
    public static Integer CODE_ERROR = 2;

    /** 
    * @Fields CODE_FAIL : TODO(失败) 
    */ 
    public static Integer CODE_FAIL = 1;
   
    /** 
    * @Fields CODE_SUCCESS : TODO(成功) 
    */ 
    public static Integer CODE_SUCCESS = 0;
    
    /** 
    * @Fields CODE_UNLOGIN : TODO(未登录) 
    */ 
    public static Integer CODE_UNLOGIN = 3;
    
    /** 
    * @Fields CODE_LOCK : TODO(禁用) 
    */ 
    public static Integer CODE_LOCK = 4;
    
    /** 
    * @Fields CODE_DATANULL : TODO(参数错误，资料为空) 
    */ 
    public static Integer CODE_DATANULL = 5;
    
    /** 
    * @Fields CODE_INEXIST : TODO(用户/数据不存在)
    */ 
    public static Integer CODE_INEXIST = 6;
   
    /** 
    * @Fields CODE_CIPHER_ERROR : TODO(密码、验证码错误) 
    */ 
    public static Integer CODE_CIPHER_ERROR = 7;
   
    /** 
    * @Fields CODE_DISABLED : TODO(账号已注册) 
    */ 
    public static int CODE_DISABLED = 8;
    
    /** 
     * @Fields MSG_BLACKED : TODO(已拉黑) 
     */ 
     public static int CODE_BLACKED = 9;
     
     /** 
    * @Fields CODE_PWD_DISCORD : TODO(密码不一致) 
    */ 
    public static int CODE_PWD_DISCORD = 10;
    /** 
    * @Fields CODE_DISABLED_14 : TODO(不能保存，账号已存在) 
    */ 
    public static int CODE_DISABLED_14 = 14;
    /** 
    * @Fields MSG_DISABLED_14 : TODO(不能保存，账号已存在) 
    */ 
    public static String MSG_DISABLED_14 = "不能保存，账号已存在";
    /**
     * @Fields CODE_DISABLED_15 : TODO(不能保存，处理中)
     */
    public static int CODE_DISABLED_15 = 15;
    /**
     * @Fields CODE_DISABLED_16 : TODO(操作失败，订单发布中)
     */
    public static int CODE_DISABLED_16 = 16;

    /**
    * @Fields MSG_DISABLED_14 : TODO(不能保存，处理中)
    */
    public static String MSG_DISABLED_15 = "报告老板，还在审核啦";
    /**
    * @Fields MSG_DISABLED_16 : TODO(操作失败，订单发布中)
    */
    public static String MSG_DISABLED_16 = "操作失败，订单发布中";

    /** 
     * @Fields CODE_999 : TODO(没有执行权限) 
     */ 
    public static int CODE_999 = 999;
    
    
    /** 
    * @Fields MSG_SUCCESS : TODO(成功) 
    */ 
    public static String MSG_SUCCESS = "成功";
    
    /** 
    * @Fields MSG_UNLOGIN : TODO(未登录) 
    */ 
    public static String MSG_UNLOGIN = "未登录";
    /**
    * @Fields MSG_DATA_ERROR : TODO(数据错误)
    */
    public static String MSG_DATA_ERROR = "数据错误/数据不存在";
    
    /** 
    * @Fields MSG_LOCK : TODO(禁用) 
    */ 
    public static String MSG_LOCK = "禁用";
   
    /** 
    * @Fields MSG_DATANULL : TODO(参数错误，资料为空) 
    */ 
    public static String MSG_DATANULL = "参数错误，资料为空";
    
    /** 
    * @Fields MSG_INEXIST : TODO(用户/数据不存在)
    */ 
    public static String MSG_INEXIST = "用户/数据不存在";
    
    /** 
     * @Fields MSG_INEXIST : TODO(用户/数据不存在)
     */ 
     public static String MSG_CODEERROR = "token效验失败";
     
    /** 
    * @Fields MSG_CIPHER_ERROR : TODO(密码错误) 
    */ 
    public static String MSG_CIPHER_ERROR = "密码、验证码错误";
    
    /** 
    * @Fields MSG_DISABLED : TODO(账号已注册) 
    */ 
    public static String MSG_DISABLED = "账号已注册";
    
    /** 
     * @Fields MSG_BLACKED : TODO(已拉黑) 
     */ 
     public static String MSG_BLACKED = "已拉黑";
     
     /** 
    * @Fields MSG_PWD_DISCORD : TODO(两次密码不一致) 
    */ 
    public static String MSG_PWD_DISCORD = "两次密码不一致";
    
    /** 
    * @Fields MSG_ERROR : TODO(异常) 
    */ 
    public static String MSG_ERROR = "异常";
    
    /** 
     * @Fields MSG_999 : TODO(没有执行权限) 
     */ 
    public static String MSG_999 = "没有执行权限";
    
    /** 
    * @Fields MSG_NO_PWD : TODO(信息保密，你看不到的)
    */ 
    public static String MSG_NO_PWD = "信息保密，你看不到的";

    /**
     * @Fields MSG_ERROR : TODO(登录超时) 
     */
    public static String MSG_998 = "998";
    /**
     * @Fields MSG_MAX : TODO(订单人数已满)
     */
    public static String MSG_MAX = "订单人数已满";
    /**
     * @Fields MSG_ORDER_DELETE : TODO(不允许撤回该订单，已有报名)
     */
    public static String MSG_ORDER_DELETE = "不允许撤回该订单，已有团员报名";

    public static int CODE_ORDER_NO = 997;
    public static String MSG_ORDER_NO="订单无人报名，不能结束。";
    
    @JsonView(BasePojo.hasNotPage.class) 
    public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	 @JsonView(BasePojo.hasNotPage.class) 
	public String getMsg()
    {
        return msg;
    }
    public void setMsg( String msg )
    {
        this.msg = msg;
    }
    @JsonView(BasePojo.hasNotPage.class) 
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
