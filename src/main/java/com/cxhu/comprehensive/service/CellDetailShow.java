package com.cxhu.comprehensive.service;

import java.util.List;

import com.cxhu.comprehensive.domain.CellPhone;

/**用于封装页面中手机展示的详细信息*/
public class CellDetailShow {
	private CellPhone cell;						// 手机(小类型)
	private List<String> colors;				// 颜色集(颜色可有多种, 一种小类型手机只能是一种颜色, 所以单独拿出来)
	private List<String> versions;				// 版本集(可有多种)
	private List<String> setMeals;				// 套餐集(可有多种)
	private	String service;						// 服务说明(每种小类型手机都是一样的服务说明)
	
	public CellPhone getCell() {
		return cell;
	}
	public void setCell(CellPhone cell) {
		this.cell = cell;
	}
	public List<String> getColors() {
		return colors;
	}
	public void setColors(List<String> colors) {
		this.colors = colors;
	}
	public List<String> getVersions() {
		return versions;
	}
	public void setVersions(List<String> versions) {
		this.versions = versions;
	}
	public List<String> getSetMeals() {
		return setMeals;
	}
	public void setSetMeals(List<String> setMeals) {
		this.setMeals = setMeals;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
}
