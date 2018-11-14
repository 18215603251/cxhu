package com.cxhu.comprehensive.kit;

/*用于判断客户端传过来的openid是否有效*/
public class CheckOpenid {
	
	public  static boolean checkOpenid(String openid) {
		if (openid == null) {
			return false;
		}
		
		// 从redis中获取到的openid对应的值
		String session_token = RedisHand.getByKey(openid);
		if (session_token == null) {
			return false;
		}
		String[] split = session_token.split(",");
		if (split[0].equals(openid)) {
			return true;
		}
		
		return false;
	}
}
