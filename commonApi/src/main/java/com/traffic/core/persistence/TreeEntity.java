/**
 * Copyright &copy; 2017-2027 <a href="http://www.cnony.com">JeeHook</a> All rights reserved.
 */
package com.traffic.core.persistence;





import com.fasterxml.jackson.annotation.JsonBackReference;

import com.traffic.common.utils.Reflections;
import com.traffic.common.utils.StringUtils;

/**
 * 数据Entity类
 * @author traffic
 * @version 2017-05-16
 */
public abstract class TreeEntity<T> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;

	protected T parent;	// 父级编号
	protected String parentIds; // 所有父级编号
	protected String name; 	// 名称
	protected Integer sort;		// 排序
	private boolean hasChildren;//是否有子节点
	
	public TreeEntity() {
		super();
		this.sort = 30;
	}
	
	public TreeEntity(String id) {
		super(id);
	}
	
	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
	@JsonBackReference

	public abstract T getParent();

	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
	public abstract void setParent(T parent);


	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getParentId() {
		String id = null;
		if (parent != null){
			id = (String)Reflections.getFieldValue(parent, "id");
		}
		return StringUtils.isNotBlank(id) ? id : "0";
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	
}
