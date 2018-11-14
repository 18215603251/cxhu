package com.cxhu.comprehensive.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxhu.comprehensive.dao.Order_Cell_Dao;
import com.cxhu.comprehensive.domain.CellOrder;
import com.cxhu.comprehensive.kit.GreateRandomString;


/**提供各种订单服务*/
@Service
public class PayService {

	@Autowired
	private Order_Cell_Dao cellDao;
	
	/**根据openid生成一个手机的订单, 返回订单号*/
	public String createCellOrder(String openid, int goods_id, String name) {
		/** 创建一个订单对象*/
		CellOrder order = new CellOrder();
		order.setOpenid(openid);			// 设置openid
		order.setGoods_id(goods_id);		// 设置商品id
		order.setPayed(0);					// 设置是否支付, 0.是求支付, 1.是已支付
		
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		order.setOrder_time(timestamp.toString());	// 设置下单时间
		
		order.setUser_name(name);			// 设置该订单的用户名称
		
		// 随机生成一个不字符串, 用于表示订单号
		String randomString = GreateRandomString.getRandomString();
		// 组合一个订单号
		String order_code = randomString + openid + timestamp.toString();
		order.setOrder_code(order_code);
		
		CellOrder cellOrder = cellDao.save(order);		// 生成订单
		if (cellOrder == null) {
			return null;
		}
		
		return order_code;
	}
	
	/**生成订单明细*/
	public void createOrderDetail() {
		
	}
	
	/**生成其它订单*/
}
