package com.cxhu.comprehensive.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cxhu.comprehensive.domain.CellType;

public interface CellTypeDao extends JpaRepository<CellType, Integer> {

	// 分页查询
	@Query(nativeQuery = true, value = "select id, type_name, evaluate from cell_type limit ?1, ?2")
	public List<Object> getCurrentCellTypeData(int startIndex, int limit);

}
