package com.cxhu.comprehensive.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cell_type")
public class CellType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private	Integer id;						// id
	
	private	String type_name;				// 名称
	private double price;					// 价格
	private int evaluate;					// 评价数量
	private String flag_icon;				// 热卖, 新品, 促销等标识图标
	private int is_sale;					// 是否在售
	private String photo;					// 封面
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}
	public String getFlag_icon() {
		return flag_icon;
	}
	public void setFlag_icon(String flag_icon) {
		this.flag_icon = flag_icon;
	}
	public int getIs_sale() {
		return is_sale;
	}
	public void setIs_sale(int is_sale) {
		this.is_sale = is_sale;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
