package com.cxhu.comprehensive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxhu.comprehensive.domain.Video;

public interface VideoDao extends JpaRepository<Video, Integer> {

	// 根据视频的id查询
	public Video getById(Integer id);

	// 点赞
	@Modifying	//因为是修改操作, 所以在加上Query注解的同时, 还要加上Modifying注解
	@Query(nativeQuery = true, value = "update cx_video set praise=praise+1 where id=?1")
	public int updatePraise(int id);

}
