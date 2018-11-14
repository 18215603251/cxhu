package com.cxhu.comprehensive.vo;

/**保存的是分页信息查询时, 只需要的图片, 名称, 价格, 剩余数量等大致信息*/
public class CellPhoneDivideVo {
	private int id;			// 商品id
	private String img;		// 商品封面
	private String name;	// 商品名称
	private double price;	// 商品单价
	private int restCount;	// 商品剩余数量
	private int evaluateCount;	// 总评价数量
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRestCount() {
		return restCount;
	}
	public void setRestCount(int restCount) {
		this.restCount = restCount;
	}
	public int getEvaluateCount() {
		return evaluateCount;
	}
	public void setEvaluateCount(int evaluateCount) {
		this.evaluateCount = evaluateCount;
	}
	
}
