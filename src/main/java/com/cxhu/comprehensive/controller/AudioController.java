package com.cxhu.comprehensive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.comprehensive.dao.AudioDao;
import com.cxhu.comprehensive.domain.Audio;

@Controller
public class AudioController {
	@Autowired
	private AudioDao dao;
	
	// 获取所有的视频信息
	@RequestMapping("/getAudios")
	@ResponseBody
	public Object getAudios() {
		List<Audio> all = dao.findAll();
		return all;
	}
}
