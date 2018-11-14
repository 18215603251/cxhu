package com.cxhu.comprehensive.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxhu.comprehensive.dao.VideoDao;
import com.cxhu.comprehensive.domain.Video;
import com.cxhu.comprehensive.kit.RedisHand;

/*点赞控制*/
@RestController
public class PraiseController {
	@Autowired
	private VideoDao dao;

	@Transactional
	@RequestMapping("/praise")
	public int praise(HttpServletRequest request) {
		// 获取要点赞的视频id, 把它看作是一个标识, 用来判断videoid是否重复
		String videoId_token = request.getParameter("videoId");
		if (videoId_token == null) {
			return -1;
		}

		// 获取微信头像地址, 也把它看作是一个标识, 用于判断是不同用户是否重复
		String headurl_token = request.getHeader("praise");
		
		// 如果从redis中获取的token与传入的标记相同, 则不能点赞
		if ((headurl_token + videoId_token).equals(RedisHand.getByKey("token"))) {
			System.out.println("已点赞");
			return -1;
		}

		// 否则将它们做为标记存入redis中, 并执行点赞
		String token_sum = headurl_token + videoId_token;
		RedisHand.setKey("token", token_sum, 24 * 60 * 60);

		System.out.println("执行点赞");
		// sql执行点赞
		dao.updatePraise(Integer.parseInt(videoId_token));
		
		// 点赞以后返回该videoId视频点赞的总数
		Video video = dao.getById(Integer.parseInt(videoId_token));
		
		return video.getPraise();
	}
}