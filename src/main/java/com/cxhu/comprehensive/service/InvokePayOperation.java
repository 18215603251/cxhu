package com.cxhu.comprehensive.service;

import java.io.IOException;

import com.cxhu.comprehensive.constant.Pay_Constant;
import com.cxhu.comprehensive.kit.CilentSend;
import com.cxhu.comprehensive.kit.GreateRandomString;
import com.cxhu.comprehensive.kit.MD5Kit;

import net.sf.json.JSONObject;

/**执行支付前的操作, 有生成prepay_id与二次签名*/
public class InvokePayOperation {
	public String randomString = GreateRandomString.getRandomString();
	public String timeStamp = System.currentTimeMillis() + "";

	/**生成prepay_id*/
	public String getPrepay_id(String goodsName, String goodsNumber, String goodsPrice, String ip, String order, String notifyUrl) {
		String body = "商品名称: " + goodsName + ", 购买数量: " + goodsNumber + "部, 总价: " + Integer.parseInt(goodsPrice)*Integer.parseInt(goodsNumber);
		String key = Pay_Constant.KEY;
		
		// 创建对象, 封装预支付参数
		OnceSignParam param = new OnceSignParam();
		param.setAppid(Pay_Constant.APPID);					// 设置小程序id
		param.setMch_id(Pay_Constant.MCH_ID);				// 设置商户号
		param.setNonce_str(this.randomString);				//设置随机字符串
		param.setOut_trade_no(order);						// 设置商户订单号
		param.setTotal_fee(Integer.parseInt(goodsPrice)*Integer.parseInt(goodsNumber) + ""); 	// 设置总金额
		param.setSpbill_create_ip(ip); 						// 设置终端ip
		param.setNotify_url(notifyUrl); 					// 设置支付后的通知地址
		param.setTrade_type(Pay_Constant.TRADE_TYPE);		// 设置默认的交易类型
		param.setBody(body);								// 设置商品描述

		/**生成签名*/
		// 组合临时字符串
		String temp = "appid=" + param.getAppid() + "&body=" + param.getBody() + "&mch_id=" + param.getMch_id()
			+ "&nonce_str=" + param.getNonce_str() + "&notify_url=" + param.getNotify_url() 
			+ "&out_trade_no=" + param.getOut_trade_no() + "&spbill_create_ip=" + param.getSpbill_create_ip()
			+ "&trade_type=" + param.getTrade_type() + "&total_fee=" + param.getTotal_fee() + "&key=" + key;
		// MD5加密得到签名sign
		String sign = MD5Kit.getMD5Message(temp).toUpperCase();
		
		param.setSign(sign);	// 设置签名
		
		
		/**请求微信服务器 https://api.mch.weixin.qq.com/pay/unifiedorder */
		String url = Pay_Constant.URL + "?" + temp + "&sign=" + sign;	// 发送参数时, 要带上sign
		// 创建用户发送请求的模拟客户端
		CilentSend cilentSend = new CilentSend();
		String prepay_id = null;
		try {
			// 执行发送
			String entity = cilentSend.clientSend(url, "GET");
			// 将字符串转换为JSONObject, 这样可以直接通过键取值
			JSONObject jsonObject = JSONObject.fromObject(entity);
			// 通过键名prepay_id取到值
			prepay_id = jsonObject.getString("prepay_id");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prepay_id;
	}
	
	/**二次签名 (预支付完成后, 将真正支付需要的签名参数获取到)*/
	public String getSecondSign(String prepay_id) {
		String appid = Pay_Constant.APPID;
		String key = Pay_Constant.KEY;
		
		String temp = "appId=" + appid + "&nonceStr=" + this.randomString + "&package=prepay_id=" + prepay_id
			+ "&signType=MD5&timeStamp=" + timeStamp + "&key=" + key;
		
		// 按照MD5方式获取签名
		String sign = MD5Kit.getMD5Message(temp).toUpperCase();
		return sign;
	}

}
