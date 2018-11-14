package com.cxhu.comprehensive.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cx_video")
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	// 视频名称
	private String video_name;
	
	// 视频类型
	private String video_type;
	
	// 视频大小
	private Long video_size;
	
	// 视频时长
	private Date video_time;
	
	// 视频地址
	private String video_url;
	
	// 视频封面图片
	private String video_img_url;
	
	// 点赞
	private int praise;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String video_type) {
		this.video_type = video_type;
	}

	public Long getVideo_size() {
		return video_size;
	}

	public void setVideo_size(Long video_size) {
		this.video_size = video_size;
	}

	public Date getVideo_time() {
		return video_time;
	}

	public void setVideo_time(Date video_time) {
		this.video_time = video_time;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public String getVideo_img_url() {
		return video_img_url;
	}

	public void setVideo_img_url(String video_img_url) {
		this.video_img_url = video_img_url;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}
}
