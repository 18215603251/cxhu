package com.cxhu.comprehensive.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cxhu.comprehensive.domain.Additional_goods;

public interface Additional_goodsDao extends JpaRepository<Additional_goods, Integer>{

	// 根据type_id查询 
	@Query(nativeQuery=true, value="select * from additional_goods where type_id = ?1")
	List<Additional_goods> getNeededGift(Integer type_id);

}
