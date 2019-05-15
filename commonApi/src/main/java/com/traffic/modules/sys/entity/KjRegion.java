/**
 * Copyright &copy; 2017-2027 <a href="http://www.cnony.com">JeeHook</a> All rights reserved.
 */
package com.traffic.modules.sys.entity;


import com.traffic.core.persistence.TreeEntity;
import com.traffic.common.utils.excel.annotation.ExcelField;

/**
 * 维护/展示市县地区Entity
 * @author yangxiaobo
 * @version 2018-03-22
 */
public class KjRegion extends TreeEntity<KjRegion> {
	
	private static final long serialVersionUID = 1L;
	private String regionId;		// 地区ID
	private String regionCode;		// 地区编码
	private String regionName;		// 地区名称
	private Integer areaNum;		// 下级地区数量
	private Integer populationNum;		// 人口数量
	private String distributorId;		// 批发商ID
	private String regionType;		// 地区类型（0：国家，1：省，2：市，3区）
	private String regionTypeName;		// 地区类型名称
	private String idPath;		// id深度
	private String codePath;		// 地区编码深度
	private String namePath;		// 名称深度
	private String status;		// 状态（0：停用，1：启用）
	private String latitude;		// 纬度
	private String longitude;		// 经度
	private String pRegionID;		// 父地区ID
	
	public KjRegion() {
		super();
	}

	public KjRegion(String id){
		super(id);
	}

	@ExcelField(title="地区ID", align=2, sort=7)
	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	
	@ExcelField(title="地区编码", align=2, sort=8)
	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	
	@ExcelField(title="地区名称", align=2, sort=9)
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	@ExcelField(title="下级地区数量", align=2, sort=10)
	public Integer getAreaNum() {
		return areaNum;
	}

	public void setAreaNum(Integer areaNum) {
		this.areaNum = areaNum;
	}
	
	@ExcelField(title="人口数量", align=2, sort=11)
	public Integer getPopulationNum() {
		return populationNum;
	}

	public void setPopulationNum(Integer populationNum) {
		this.populationNum = populationNum;
	}
	
	@ExcelField(title="批发商ID", align=2, sort=12)
	public String getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	
	@ExcelField(title="地区类型（0：国家，1：省，2：市，3区）", align=2, sort=13)
	public String getRegionType() {
		return regionType;
	}

	public void setRegionType(String regionType) {
		this.regionType = regionType;
	}
	
	@ExcelField(title="地区类型名称", align=2, sort=14)
	public String getRegionTypeName() {
		return regionTypeName;
	}

	public void setRegionTypeName(String regionTypeName) {
		this.regionTypeName = regionTypeName;
	}
	
	@ExcelField(title="id深度", align=2, sort=15)
	public String getIdPath() {
		return idPath;
	}

	public void setIdPath(String idPath) {
		this.idPath = idPath;
	}
	
	@ExcelField(title="地区编码深度", align=2, sort=16)
	public String getCodePath() {
		return codePath;
	}

	public void setCodePath(String codePath) {
		this.codePath = codePath;
	}
	
	@ExcelField(title="名称深度", align=2, sort=17)
	public String getNamePath() {
		return namePath;
	}

	public void setNamePath(String namePath) {
		this.namePath = namePath;
	}
	
	@ExcelField(title="状态（0：停用，1：启用）", align=2, sort=18)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ExcelField(title="纬度", align=2, sort=19)
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	@ExcelField(title="经度", align=2, sort=20)
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@ExcelField(title="父地区ID", align=2, sort=21)
	public String getPRegionID() {
		return pRegionID;
	}

	public void setPRegionID(String pRegionID) {
		this.pRegionID = pRegionID;
	}

	@Override
	public KjRegion getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public void setParent(KjRegion parent) {
		this.parent = parent;
		
	}
	
}