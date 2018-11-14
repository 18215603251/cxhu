package com.cxhu.comprehensive.vo;

import java.io.Serializable;
import java.sql.Date;

/*保存查询的视频收藏信息*/
public class Video_Collect  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/*视频id*/
	private Integer id;
	/*视频的url*/
	private  String video_url;
	/*视频的封面url*/
	private String video_img_url;
	/*视频名称*/
	private String video_name;
	/*视频的收藏日期*/
	private Date collect_date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}
	public Date getCollect_date() {
		return collect_date;
	}
	public void setCollect_date(Date collect_date) {
		this.collect_date = collect_date;
	}
	
}
