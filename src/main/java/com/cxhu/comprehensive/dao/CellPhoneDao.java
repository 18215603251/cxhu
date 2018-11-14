package com.cxhu.comprehensive.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cxhu.comprehensive.domain.CellPhone;


/** 手机信息dao, 对应 cellPhone表 */
public interface CellPhoneDao extends JpaRepository<CellPhone, Integer> {

	// 根据id查询得到手机信息
	public CellPhone findById(Integer id);
	
	// 根据类型查询手机, 并找到价格最低的其中一种手机
	@Query(nativeQuery=true, value="select * from cell where type_id = ?1 order by cell_price LIMIT 1")
	public List<CellPhone> selectCellByTypeid(Integer typeId);

	// 获取所有的颜色
	@Query(nativeQuery=true, value="select DISTINCT cell_color from cell where type_id = ?1")
	public List<String> getAllColors(Integer typeId);

	// 获取所有版本
	@Query(nativeQuery=true, value="select distinct versions from cell where type_id = ?1")
	public List<String> getAllVersion(Integer typeId);

	// 获得所有套餐
	@Query(nativeQuery=true, value="select distinct set_meal from cell where type_id = ?1")
	public List<String> getAllSetMeals(Integer type_id);

}