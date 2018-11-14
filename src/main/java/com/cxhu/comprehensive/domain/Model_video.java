package com.cxhu.comprehensive.domain;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*此类表示模特视频*/
@Entity
@Table(name="model_video")
public class Model_video implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="model_id")
	private Integer id;				//模特视频id
	private String model_name;		// 视频名称
	private String model_url;		// 视频url
	private String model_img;		// 视频封面
	private int model_size;			// 视频大小
	private Time model_time;		// 视频时长
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public String getModel_url() {
		return model_url;
	}
	public void setModel_url(String model_url) {
		this.model_url = model_url;
	}
	public String getModel_img() {
		return model_img;
	}
	public void setModel_img(String model_img) {
		this.model_img = model_img;
	}
	public int getModel_size() {
		return model_size;
	}
	public void setModel_size(int model_size) {
		this.model_size = model_size;
	}
	public Time getModel_time() {
		return model_time;
	}
	public void setModel_time(Time model_time) {
		this.model_time = model_time;
	}
	
}
