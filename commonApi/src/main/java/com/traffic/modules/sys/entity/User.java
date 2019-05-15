/**
 * Copyright &copy; 2017-2027 <a href="http://www.cnony.com">JeeHook</a> All rights reserved.
 */
package com.traffic.modules.sys.entity;

import java.util.Date;
import java.util.List;



import com.traffic.common.utils.SpringContextHolder;

/*import org.apache.http.conn.ssl.PrivateKeyStrategy;*/


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.traffic.common.config.Global;
import com.traffic.common.utils.Collections3;
import com.traffic.common.utils.excel.annotation.ExcelField;
import com.traffic.core.persistence.DataEntity;

/**
 * 用户Entity
 * @author traffic
 * @version 2016-12-05
 */
public class User extends DataEntity<User> {

	private static final long serialVersionUID = 1L;
	private Office company;	// 归属公司
	private Office office;	// 归属部门
	private String loginName;// 登录名
	private String password;// 密码
	private String no;		// 工号
	private String name;	// 姓名
	private String email;	// 邮箱
	private String phone;	// 电话
	private String mobile;	// 手机
	private String loginIp;	// 最后登陆IP
	private Date loginDate;	// 最后登陆日期
	private String loginFlag;	// 是否允许登陆
	private String photo;	// 头像
	private String qrCode;	//二维码
	private String oldLoginName;// 原登录名
	private String newPassword;	// 新密码
	private String sign;//签名
	private String userType;//用户类型（内部员工：属地化业务员）
	private String sex;//用户性别
	private Date birthday;//用户生日
	private String duties;
	
	private String oldLoginIp;	// 上次登陆IP
	private Date oldLoginDate;	// 上次登陆日期
	
	private Role role;	// 根据角色查询用户条件
	
	private List<Role> roleList = Lists.newArrayList(); // 拥有角色列表
	
	private String officeIds; // 拥有菜单列表
	
	private String roleIds;//暂存新增用户时，为用户赋的角色。 author 杨小波 2018-3-21
	

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public User() {
		super();
		this.loginFlag = Global.YES;
	}
	
	public User(String id){
		super(id);
	}

	public User(String id, String loginName,String mobile){
		super(id);
		this.loginName = loginName;
		this.mobile = mobile;
	}

	public User(Role role){
		super();
		this.role = role;
	}
	
	public String getPhoto() {
		if("".equals(photo)){
			return SpringContextHolder.getStatic()+"/common/images/flat-avatar.png";
		}
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	@ExcelField(title="ID", type=1, align=2, sort=1)
	public String getId() {
		return id;
	}

	/*@NotNull(message="归属公司不能为空")*/
	@ExcelField(title="归属公司", align=2, sort=20)
	public Office getCompany() {
		return company;
	}

	public void setCompany(Office company) {
		this.company = company;
	}

	@ExcelField(title="归属部门", align=2, sort=25)
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	@ExcelField(title="工号", align=2, sort=30)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@ExcelField(title="姓名", align=2, sort=40)
	public String getName() {
		return name;
	}


	@ExcelField(title="工号", align=2, sort=45)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ExcelField(title="邮箱", align=1, sort=50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ExcelField(title="电话", align=2, sort=60)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@ExcelField(title="手机", align=2, sort=70)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@ExcelField(title="备注", align=1, sort=900)
	public String getRemarks() {
		return remarks;
	}
	
	@ExcelField(title="创建时间", type=0, align=1, sort=90)
	public Date getCreateDate() {
		return createDate;
	}

	@ExcelField(title="最后登录IP", type=1, align=1, sort=100)
	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ExcelField(title="最后登录日期", type=1, align=1, sort=110)
	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getOldLoginName() {
		return oldLoginName;
	}

	public void setOldLoginName(String oldLoginName) {
		this.oldLoginName = oldLoginName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldLoginIp() {
		if (oldLoginIp == null){
			return loginIp;
		}
		return oldLoginIp;
	}

	public void setOldLoginIp(String oldLoginIp) {
		this.oldLoginIp = oldLoginIp;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOldLoginDate() {
		if (oldLoginDate == null){
			return loginDate;
		}
		return oldLoginDate;
	}

	public void setOldLoginDate(Date oldLoginDate) {
		this.oldLoginDate = oldLoginDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonIgnore
	public List<Role> getRoleList() {
		return roleList;
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@JsonIgnore
	public List<String> getRoleIdList() {
		List<String> roleIdList = Lists.newArrayList();
		for (Role role : roleList) {
			roleIdList.add(role.getId());
		}
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		roleList = Lists.newArrayList();
		for (String roleId : roleIdList) {
			Role role = new Role();
			role.setId(roleId);
			roleList.add(role);
		}
	}
	
	/**
	 * 用户拥有的角色名称字符串, 多个角色名称用','分隔.
	 */
	public String getRoleNames() {
		return Collections3.extractToString(roleList, "name", ",");
	}
	
	public boolean isAdmin(){
		return isAdmin(this.id);
	}
	
	public static boolean isAdmin(String id){
		return id != null && "1".equals(id);
	}
	
	

	@Override
	public String toString() {
		return "User [updateBy=" + updateBy + ", office=" + office + ", loginName=" + loginName + ", password=" + password
				+ ", no=" + no + ", name=" + name + ", email=" + email + ", phone=" + phone + ", mobile=" + mobile
				+ ", loginIp=" + loginIp + ", loginDate=" + loginDate + ", loginFlag=" + loginFlag + ", photo=" + photo
				+ ", qrCode=" + qrCode + ", oldLoginName=" + oldLoginName + ", newPassword=" + newPassword + ", sign="
				+ sign + ", oldLoginIp=" + oldLoginIp + ", oldLoginDate=" + oldLoginDate + ", role=" + role
				+ ", roleList=" + roleList + "]";
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getQrCode() {
		return qrCode;
	}

	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}
	
	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	

	

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getOfficeIds() {
		return officeIds;
	}

	public void setOfficeIds(String officeIds) {
		this.officeIds = officeIds;
	}

	public String getDuties() {
		return duties;
	}

	public void setDuties(String duties) {
		this.duties = duties;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	

}