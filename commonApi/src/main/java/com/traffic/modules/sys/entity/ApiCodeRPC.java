package com.traffic.modules.sys.entity;

import java.io.Serializable;
/**
 * @since 2018-3-13
 * @author yangxiaobo
 * @qq 3388169
 *
 */
public class ApiCodeRPC implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String LOGIN_TYPE = "login";
	public static final String RESET_TYPE = "reset";
	public static final String REGIST_TYPE = "regist";
	private String username;
	private String code;
	private String codeType;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public ApiCodeRPC(String codeType) {
		this.codeType = codeType;
	}
	public ApiCodeRPC() {
		
	}
	@Override
	public String toString() {
		return "ApiCodeRPC [username=" + username + ", code=" + code + ", codeType=" + codeType + "]";
	}
	
}
