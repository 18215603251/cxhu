package com.cxhu.comprehensive.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.comprehensive.dao.VideoDao;
import com.cxhu.comprehensive.domain.Video;

@Controller
public class VideoController {
	@Autowired
	private VideoDao dao;

	// 获取所有的视频信息
	@RequestMapping("/getVideos")
	@ResponseBody
	public Object getVideo() {
		List<Video> all = dao.findAll();
		return all;
	}

	// 根据id获取单个视频
	@RequestMapping("/getVideoById")
	@ResponseBody
	public Object getVideoById(HttpServletRequest request) {
		String id = request.getParameter("videoId");
		if (id == null) {
			return null;
		}
		int videoId = Integer.parseInt(id);
		
		Video obj = dao.getById(videoId);
		return obj;
	}
}
