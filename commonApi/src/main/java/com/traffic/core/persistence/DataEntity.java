/**
 * Copyright &copy; 2017-2027 <a href="http://www.cnony.com">JeeHook</a> All rights reserved.
 */
package com.traffic.core.persistence;

import java.util.Date;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/*import com.traffic.common.utils.IdGen;*/
import com.traffic.modules.sys.entity.User;
/*import com.traffic.modules.sys.utils.UserUtils;*/

/**
 * 数据Entity类
 * @author traffic
 * @version 2017-05-16
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	protected String remarks;	// 备注
	protected User createBy;	// 创建者
	protected Date createDate;	// 创建日期
	protected User updateBy;	// 更新者
	protected Date updateDate;	// 更新日期
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
	
	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	public DataEntity(String id) {
		super(id);
	}
	
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	@Override
	public void preInsert(){
	/*	if (!this.isNewRecord){
			if(this.getIdType().equals(IDTYPE_UUID)){
				setId(IdGen.uuid());
			}else if(this.getIdType().equals(IDTYPE_AUTO)){
				//使用自增长不需要设置主键
			}

		}
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
			this.createBy = user;
		}
		this.updateDate = new Date();
		this.createDate = this.updateDate;*/
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	@Override
	public void preUpdate(){
	/*	User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getId())){
			this.updateBy = user;
		}
		this.updateDate = new Date();*/
	}
	

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@JsonIgnore
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}
