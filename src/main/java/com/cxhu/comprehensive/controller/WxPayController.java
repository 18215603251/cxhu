package com.cxhu.comprehensive.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxhu.comprehensive.constant.Pay_Constant;
import com.cxhu.comprehensive.dao.Order_Cell_Dao;
import com.cxhu.comprehensive.service.InvokePayOperation;
import com.cxhu.comprehensive.service.PayService;

/*用于控制微信支付*/

@Controller
public class WxPayController {
//	@Autowired
//	private InvokePayOperation service;
//	
//	@Autowired
//	private PayService pay_service;
//	
//	@Autowired
//	private Order_Cell_Dao orderCellDao;
//
//	/** 执行预支付 */
//	@RequestMapping("/invokePay")
//	public Object pay(String openid, String goodsName, String goodsNumber, String username, String goods_id, String goodsPrice, HttpServletRequest request) {
//		String ip = request.getLocalAddr();
//		
//		// 生成手机订单, 返回订单号
//		String order = pay_service.createCellOrder(openid, Integer.parseInt(goods_id), username);
//		
//		String notifyUrl = Pay_Constant.notify_url;		// 支付成功后, 推送通知给开发者服务器的地址, 根据通知再去更新订单状态
//		
//		// 传入参数生成prepay_id
//		String prepay_id = service.getPrepay_id(goodsName, goodsNumber, goodsPrice, ip, order, notifyUrl);
//		
//		// 二次签名
//		String paySign = service.getSecondSign(prepay_id);
//		
//		// 封装信息到Map中
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("appid", Pay_Constant.APPID);
//		map.put("timStamp", service.timeStamp);
//		map.put("nonceStr", service.randomString);
//		map.put("signType", "MD5");
//		map.put("package", prepay_id);
//		map.put("paySign", paySign);
//		
//		// 返回给前端
//		return map;
//	}
//	
//	/**支付真正完成后, 更订单状态(修改订单中的payed字段)*/
//	@RequestMapping("/updatOrderStatu")
//	public void updateOrderStatu(String id) {
//		orderCellDao.updateOrderStatu(id);
//	}
}
