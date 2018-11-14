package com.cxhu.comprehensive.constant;

/*保存微信登陆相关的常量*/
public class Login_Constant {
	public static final String HOST = "127.0.0.1"; 
	public static String APPID = "wxc499239e5e62e84e";
	public static String SECRET = "398b23cfc2387f902a7e722408a2a712";
	public static String LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
	public static int OPENID_SECOND = 900;
}
