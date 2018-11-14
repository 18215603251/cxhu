package com.cxhu.comprehensive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cxhu.comprehensive.dao.CellPhoneDao;
import com.cxhu.comprehensive.domain.CellPhone;
import com.cxhu.comprehensive.service.CellDetailShow;
import com.cxhu.comprehensive.service.GetAdditonalGoodsService;

/**用于获取单独手机详情页面信息的控制器*/

@RestController
public class GetCellDetailShowController {
	
	@Autowired
	private GetAdditonalGoodsService service;
	
	@Autowired
	private CellPhoneDao dao;
	
	@RequestMapping("/getCellDetailShowInfo")
	public Object getCellDetailShowInfo(String type_id) {		// type_id为前端传入的手机大类
		
		/*根据type_id可查询到其下面的子类型中价格最低的小类型, 作为点击进来时默认显示
		 * 因为大类型显示的就是小类型中价格最低的手机照片及价格*/
		List<CellPhone> list = dao.selectCellByTypeid(Integer.parseInt(type_id));
		CellPhone lowerCell = list.get(0);		// 最低价格的那种手机
		
		/********************相关赠品对象*******************/
		String presenterGift = lowerCell.getPresenterGift();	// 数据库中的赠品字段值
		lowerCell = service.get(lowerCell, presenterGift, "send");
		
		/********************相关套餐*******************/
		String setMeal = lowerCell.getSetMeal();				// 数据库表中的套餐字段值
		lowerCell = service.get(lowerCell, setMeal, "set");
		
		
		// 创建并封装对象(手机展示详情的对象)
		CellDetailShow cellShow = new CellDetailShow();
		// 设置手机
		cellShow.setCell(lowerCell);
		// 设置服务说明
		double price = lowerCell.getPrice();
		if (price >= 48) {
			cellShow.setService("已满48元已免运费 | 由华为商城负责发货，并提供售后服务");
		} else {
			cellShow.setService("满48元可免运费 | 由华为商城负责发货，并提供售后服务");
		}
		// 设置全部颜色(一个手机只有一种颜色, 无法全部展示, 所以将这种非单个手机的属性作为外层对象的属性)
		List<String> allColors = dao.getAllColors(Integer.parseInt(type_id));
		cellShow.setColors(allColors);
		// 设置全部版本(同样版本也要全部展示出来, 而它也不是一个手机可以展示出来的)
		List<String> allVersions = dao.getAllVersion(Integer.parseInt(type_id));
		cellShow.setVersions(allVersions);
		// 设置全部套餐
		List<String> allSetMeals = dao.getAllSetMeals(Integer.parseInt(type_id));
		cellShow.setSetMeals(allSetMeals);
		
		return cellShow;
	}
}
