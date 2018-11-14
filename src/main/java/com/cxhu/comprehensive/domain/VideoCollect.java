package com.cxhu.comprehensive.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="video_collect")
public class VideoCollect implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/*openid微信用户的唯一标识*/
	private String openid;
	
	/*视频的id*/
	@Column(name = "videoid")
	private Integer videoId;
	/*收藏日期*/
	private Date collect_date;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	public Date getCollect_date() {
		return collect_date;
	}
	public void setCollect_date(Date collect_date) {
		this.collect_date = collect_date;
	}
}
