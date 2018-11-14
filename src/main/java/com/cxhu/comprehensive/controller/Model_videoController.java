package com.cxhu.comprehensive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.comprehensive.dao.Model_videoDao;
import com.cxhu.comprehensive.domain.Model_video;

@Controller
public class Model_videoController {
	@Autowired
	private Model_videoDao dao;
	
	// 获取所有的模特视频信息
		@RequestMapping("/getModel_videos")
		@ResponseBody
		public Object getAudios() {
			List<Model_video> all = dao.findAll();
			return all;
		}
}
