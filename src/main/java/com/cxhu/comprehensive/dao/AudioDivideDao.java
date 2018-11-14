package com.cxhu.comprehensive.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cxhu.comprehensive.domain.Audio;

/**音频分页dao*/
public interface AudioDivideDao extends JpaRepository<Audio, Integer> {

	// 分页查询
	@Query(nativeQuery = true, value = "select * from song order by song_name desc limit ?1, ?2")
	public List<Object> getCurrentPageData(int startIndex, int limit);

}
