/**
 * Copyright &copy; 2017-2027 <a href="http://www.cnony.com">JeeHook</a> All rights reserved.
 */
package com.traffic.modules.sys.entity;

import com.traffic.core.persistence.DataEntity;
import com.traffic.common.utils.excel.annotation.ExcelField;

/**
 * 科室覆盖县Entity
 * @author yangxiaobo
 * @version 2018-03-26
 */
public class KjCoverCounty extends DataEntity<KjCoverCounty> {
	
	private static final long serialVersionUID = 1L;
	private Office office;		// 部门ID
	private KjRegion region;		// 覆盖地区
	private String status;		// 是否可用
	private String attribute1;		// 备用1
	private String attribute2;		// 备用2
	private String attribute3;		// 备用3
	private String createName;
	private String UpdateName;
	public KjCoverCounty() {
		super();
	}

	public KjCoverCounty(String id){
		super(id);
	}

	@ExcelField(title="部门ID", align=2, sort=7)
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@ExcelField(title="覆盖地区", fieldType=KjRegion.class, value="", align=2, sort=8)
	public KjRegion getRegion() {
		return region;
	}

	public void setRegion(KjRegion region) {
		this.region = region;
	}
	
	@ExcelField(title="是否可用", align=2, sort=9)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ExcelField(title="备用1", align=2, sort=10)
	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	
	@ExcelField(title="备用2", align=2, sort=11)
	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	
	@ExcelField(title="备用3", align=2, sort=12)
	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getUpdateName() {
		return UpdateName;
	}

	public void setUpdateName(String updateName) {
		UpdateName = updateName;
	}
	
}