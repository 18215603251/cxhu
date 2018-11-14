package com.cxhu.comprehensive.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxhu.comprehensive.domain.VideoCollect;

public interface VideoCollectDao extends JpaRepository<VideoCollect, Integer>{

	// 根据openid查询, 查询可能得到多个视频的id
	public List<VideoCollect> findByOpenid(String openid);

}
