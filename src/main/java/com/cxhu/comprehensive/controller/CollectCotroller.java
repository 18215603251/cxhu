package com.cxhu.comprehensive.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.comprehensive.dao.VideoCollectDao;
import com.cxhu.comprehensive.dao.VideoDao;
import com.cxhu.comprehensive.domain.Video;
import com.cxhu.comprehensive.domain.VideoCollect;
import com.cxhu.comprehensive.kit.CheckOpenid;
import com.cxhu.comprehensive.vo.Video_Collect;

/*收藏*/
@Controller
public class CollectCotroller {
	@Autowired
	private VideoCollectDao videoCollectDao;
	@Autowired
	private VideoDao videoDao;

	// 视频收藏
	@RequestMapping("/videoCollect")
	@ResponseBody
	public String videoCollect(HttpServletRequest request) {
		// 获取到openid
		String openid = request.getParameter("openid");
		
		// 获取要收藏的视频的id
		String videoId = request.getParameter("videoId");
		
		// 判断openid有效性
		boolean flag = CheckOpenid.checkOpenid(openid);
		if (!flag) {
			return "未登陆或登陆错误";
		}

		// 调用方法将openid与视频id写入一张收藏表中
		VideoCollect entity = new VideoCollect();
		entity.setOpenid(openid);
		entity.setVideoId(Integer.parseInt(videoId));
		entity.setCollect_date(new Date(System.currentTimeMillis()));
		
		VideoCollect save = videoCollectDao.save(entity);
		if (save == null) {
			return "收藏失败";
		} else {
			return "收藏成功";
		}
	}

	// 获取收藏的视频
	@RequestMapping("/getCollectVideo")
	@ResponseBody
	public Object getCollectVideo(HttpServletRequest request) {
		String openid = request.getParameter("openid");

		// 判断openid
		boolean flag = CheckOpenid.checkOpenid(openid);
		if (!flag) {
			return "未登陆或登陆错误";
		}

		// 先通过传入的openid 查询到收藏的视频
		List<VideoCollect> c = videoCollectDao.findByOpenid(openid);
		List<Video_Collect> data = new ArrayList<Video_Collect>(); // 用于返回

		for (VideoCollect co : c) {
			Integer videoId = co.getVideoId();
			// 通过视频的id, 再去查询满足条件的视频
			Video video = videoDao.getById(videoId);
			Video_Collect vo = new Video_Collect();

			// 为vo对象赋值
			vo.setId(video.getId());
			vo.setVideo_name(video.getVideo_name());
			vo.setVideo_url(video.getVideo_url());
			vo.setVideo_img_url(video.getVideo_img_url());
			vo.setCollect_date(co.getCollect_date());

			// 将vo对象放入集合
			data.add(vo);
		}

		return data;
	}
}
