package com.cxhu.comprehensive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cxhu.comprehensive.domain.CellOrder;

/**手机订单dao*/
public interface Order_Cell_Dao extends JpaRepository<CellOrder, Integer>{

	// 根据id修改订单状态
	@Modifying	//修改操作, 需要加上Modifying
	@Query(nativeQuery = true, value = "update cell_order set payed = 1 where id=?1")
	void updateOrderStatu(String id);

}
