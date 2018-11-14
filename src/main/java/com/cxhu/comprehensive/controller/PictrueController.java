package com.cxhu.comprehensive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cxhu.comprehensive.dao.PictureDao;
import com.cxhu.comprehensive.domain.Picture;

@RestController
public class PictrueController {
	@Autowired
	private PictureDao dao;
	
	@RequestMapping("/getPictures")
	@ResponseBody
	public Object getPictures() {
		List<Picture> all = dao.findAll();
		return all;
	}
}
