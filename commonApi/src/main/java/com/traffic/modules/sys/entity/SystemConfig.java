/**
 * Copyright &copy; 2017-2027 <a href="http://www.cnony.com">JeeHook</a> All rights reserved.
 */
package com.traffic.modules.sys.entity;


import com.traffic.common.utils.excel.annotation.ExcelField;
import com.traffic.core.persistence.DataEntity;

/**
 * 系统配置Entity
 * @author liugf
 * @version 2016-02-07
 */
public class SystemConfig extends DataEntity<SystemConfig> {
	
	private static final long serialVersionUID = 1L;
	private String smtp;		// 邮箱服务器地址
	private String port;		// 邮箱服务器端口
	private String mailName;		// 系统邮箱地址
	private String mailPassword;		// 系统邮箱密码
	private String smsName;		// 短信用户名
	private String smsPassword;		// 短信密码
	private boolean test = false;
	public SystemConfig() {
		super();
	}

	public SystemConfig(String id){
		super(id);
	}


	@ExcelField(title="邮箱服务器地址", align=2, sort=1)
	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}
	

	@ExcelField(title="邮箱服务器端口", align=2, sort=2)
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	

	@ExcelField(title="系统邮箱地址", align=2, sort=3)
	public String getMailName() {
		return mailName;
	}

	public void setMailName(String mailName) {
		this.mailName = mailName;
	}
	

	@ExcelField(title="系统邮箱密码", align=2, sort=4)
	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}
	

	@ExcelField(title="短信用户名", align=2, sort=5)
	public String getSmsName() {
		return smsName;
	}

	public void setSmsName(String smsName) {
		this.smsName = smsName;
	}
	

	@ExcelField(title="短信密码", align=2, sort=6)
	public String getSmsPassword() {
		return smsPassword;
	}

	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	public boolean isTest() {
		return test;
	}
	
}