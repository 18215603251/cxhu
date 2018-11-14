package com.cxhu.comprehensive.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**实体类, 表示手机*/
/*对于手机数据表的设计, 应当细化, 意思是说只要有不同的属性, 就应该分为一种小类型
 * 比如其它完全相同, 颜色有经蓝白三种, 则就应分三种小类型
 * 在数据表中体现在: 多添加三个id, 即三条记录*/
@Entity
@Table(name="cell")
public class CellPhone implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cell_id")
	private Integer id;
	
	@Column(name="cell_name")
	private String cellName;		// 名称
	
	@Column(name="type_id")
	private Integer	typeId;			// 外键, 属于哪个大类
	private String photos;			// 手机照片

	@Column(name="discount_link")
	private String discountLink;	// 优惠链接, 每种手机优惠链接可能不同
	
	@Column(name="cell_price")
	private double price;			// 价格
	
	@Column(name="cell_number")
	private long cellNumber;		// 数量(如果数量大于0, 则表示有售)
	
	@Column(name="cell_color")
	private String cellColor;		// 颜色, 每种手机的颜色是不同的
	private String video;			// 代言视频
	private String coupon;			// 优惠券, 每个手机的优惠券可能不同, 有些也可能没有
	
	@Column(name="goods_code")
	private String goodsCode;		// 商品编码, 每种手机编码不同(根据它确定小类型)
	
	private String guarantee_services;	// 保障服务, 一种可手机可能有多种保障服务, 每种手机的保障服务可能不一样
	
	@Column(name="set_meal")
	private String setMeal;			// 套餐, 每个手机的套餐可能不同, 有些也有可能有多种套餐
	
	@Column(name="presenter_gift")
	private String presenterGift;	// 赠品
	private String versions;		// 版本, 版本一般对应价格, 版本不同价格, 一种手机对应一种版本
	
	@Column(name="sale_icon")
	private String saleIcon;		// 热卖, 新品等小图标
	
	@Transient		// 标识此属性不是数据库字段
	private List<List<Additional_goods>> sendGifts;				// 一个手机可能包含多种的赠品, 每种赠品可能有多种颜色等(在构造手机时需要用到)
	@Transient	
	private List<List<Additional_goods>> setMealGift;			// 一个手机可能包含的套餐物品(套餐物品与赠品都是同一类型)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getPresenterGift() {
		return presenterGift;
	}

	public void setPresenterGift(String presenterGift) {
		this.presenterGift = presenterGift;
	}

	public void setDiscountLink(String discountLink) {
		this.discountLink = discountLink;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getDiscountLink() {
		return discountLink;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(long cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getCellColor() {
		return cellColor;
	}

	public void setCellColor(String cellColor) {
		this.cellColor = cellColor;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getSetMeal() {
		return setMeal;
	}

	public void setSetMeal(String setMeal) {
		this.setMeal = setMeal;
	}

	public String getVersions() {
		return versions;
	}

	public void setVersions(String versions) {
		this.versions = versions;
	}

	public String getSaleIcon() {
		return saleIcon;
	}

	public void setSaleIcon(String saleIcon) {
		this.saleIcon = saleIcon;
	}

	public String getGuarantee_services() {
		return guarantee_services;
	}

	public void setGuarantee_services(String guarantee_services) {
		this.guarantee_services = guarantee_services;
	}

	public List<List<Additional_goods>> getSendGifts() {
		return sendGifts;
	}

	public void setSendGifts(List<List<Additional_goods>> sendGifts) {
		this.sendGifts = sendGifts;
	}

	public List<List<Additional_goods>> getSetMealGift() {
		return setMealGift;
	}

	public void setSetMealGift(List<List<Additional_goods>> setMealGift) {
		this.setMealGift = setMealGift;
	}

}