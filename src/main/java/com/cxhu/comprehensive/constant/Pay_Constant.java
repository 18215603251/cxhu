package com.cxhu.comprehensive.constant;

public class Pay_Constant {
	// 小程序id
	public static final String APPID = "wxc499239e5e62e84e";
	// 商户号
	public static final String MCH_ID = "10000100";
	// 交易类型
	public static final String TRADE_TYPE = "JSAPI";
	// 商户密钥
	public static final String KEY = "0000";
	
	// 支付后推送通知的地址
	public static String notify_url = "http://localhost:4040/updatOrderStatu";	
	// 预支付接口
	public static final String URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
}
