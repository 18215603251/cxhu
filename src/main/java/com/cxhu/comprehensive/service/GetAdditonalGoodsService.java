package com.cxhu.comprehensive.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxhu.comprehensive.dao.Additional_goodsDao;
import com.cxhu.comprehensive.dao.Additional_typeDao;
import com.cxhu.comprehensive.domain.Additional_goods;
import com.cxhu.comprehensive.domain.Additional_type;
import com.cxhu.comprehensive.domain.CellPhone;
import com.cxhu.comprehensive.kit.StringEachArrayKit;

@Service
public class GetAdditonalGoodsService {
	@Autowired
	private Additional_typeDao giftDao;
	@Autowired
	private Additional_goodsDao giftDetailDao;

	/****************** 传入一个手机对象后, 获取到该对象的赠品或套餐物品, 再将其返回 *******************/
	// dest 为数据库中的赠品或套餐物品字段
	public CellPhone get(CellPhone lowerCell, String dest, String type) {

		List<List<Additional_goods>> goods = new ArrayList<List<Additional_goods>>();

		String[] gifts = StringEachArrayKit.StringToArray(",", dest);
		for (String gift : gifts) {
			// 如果是空字符串, 则表示没有赠品或套餐物品
			if ("".equals(gift)) {
				break;
			}
			int id = Integer.parseInt(gift);
			// 查询赠品或套餐物品(赠品与套餐物品属于同类, 都是小物件)
			Additional_type one_gift = giftDao.findOne(id); // 获得赠品或套餐的对象(如xx耳机, xx电池等)

			// 如果为空, 则无赠品或套餐物品
			if (one_gift == null) {
				continue;
			}

			double score = one_gift.getScore();
			int evaluate = one_gift.getEvaluate();

			// 根据id关联的type_id去查询 赠品详情表(比如xx耳机可能分红绿蓝等多种小类型)
			List<Additional_goods> needGifts = giftDetailDao.getNeededGift(id);
			for (Additional_goods g : needGifts) { // 为小类型赋公有的值 (如红绿蓝等xx耳机设置评星与总评价数)
				g.setScore(score);
				g.setEvaluate(evaluate); 
			}
			goods.add(needGifts);
		}

		// 如果是赠品, 设置赠品属性
		if ("send".equals(type)) {
			lowerCell.setSendGifts(goods);
		}

		// 如果是套餐物品, 设置套餐物品属性
		if ("set".equals(type)) {
			lowerCell.setSetMealGift(goods);
		}
		
		return lowerCell;
	}
}
