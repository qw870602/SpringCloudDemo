/**
 * Copyright &copy; 2017-2027 <a href="http://www.cnony.com">JeeHook</a> All rights reserved.
 */
package com.traffic.modules.sys.entity;

import java.util.List;
import com.google.common.collect.Lists;
import com.traffic.common.utils.excel.annotation.ExcelField;
import com.traffic.core.persistence.TreeEntity;

/**
 * 字典管理Entity
 * @author yangxiaobo
 * @version 2018-03-27
 */
public class KjSysDict extends TreeEntity<KjSysDict> {
	
	private static final long serialVersionUID = 1L;
	private String rowId;		// 备用主键（导入用）
	private String prowId;		// （导入用）
	private String dictValue;		// 字典值
	private String dictValue2;		// 字典值2
	private String dictValue3;		// 字典值3
	private String dictValue4;		// 字典值
	private String dictValue5;		// 字典值
	private String dictPath;		// 字典路径
	private String status;		// 状态
	private String dictType;		// 字典类型
	private String attribute1;		// 备用1
	private String attribute2;		// 备用2
	private String attribute3;		// 备用3
	
	
/*	private String parentId;//导入专用
*/	
	private List<KjSysDict> kjSysDictList = Lists.newArrayList();		// 子表列表
	
	public KjSysDict() {
		super();
		this.setIdType(IDTYPE_AUTO);
	}

	public KjSysDict(String id){
		super(id);
		this.setIdType(IDTYPE_AUTO);
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	public String getProwId() {
		return prowId;
	}

	public void setProwId(String prowId) {
		this.prowId = prowId;
	}
	@ExcelField(title="dicVal", align=2, sort=4)
	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}
	
	public String getDictValue2() {
		return dictValue2;
	}

	public void setDictValue2(String dictValue2) {
		this.dictValue2 = dictValue2;
	}
	
	public String getDictValue3() {
		return dictValue3;
	}

	public void setDictValue3(String dictValue3) {
		this.dictValue3 = dictValue3;
	}
	
	public String getDictValue4() {
		return dictValue4;
	}

	public void setDictValue4(String dictValue4) {
		this.dictValue4 = dictValue4;
	}
	
	public String getDictValue5() {
		return dictValue5;
	}

	public void setDictValue5(String dictValue5) {
		this.dictValue5 = dictValue5;
	}
	@ExcelField(title="DicPath", align=2, sort=6)
	public String getDictPath() {
		return dictPath;
	}

	public void setDictPath(String dictPath) {
		this.dictPath = dictPath;
	}
	@ExcelField(title="id", align=2, sort=5)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	
	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	
	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	
	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	
	public  KjSysDict getParent() {
			return parent;
	}
	
	@Override
	public void setParent(KjSysDict parent) {
		this.parent = parent;
		
	}
	
	public List<KjSysDict> getKjSysDictList() {
		return kjSysDictList;
	}

	public void setKjSysDictList(List<KjSysDict> kjSysDictList) {
		this.kjSysDictList = kjSysDictList;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
	///temp 
/*--------------------------------------------------*/
/*	@ExcelField(title="pid", align=2, sort=2)
	public String getParentId() {
		return parentId;
	}
	@Override
	@ExcelField(title="id", align=2, sort=1)
	public String getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	@ExcelField(title="key", align=2, sort=3)
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}*/
	
}