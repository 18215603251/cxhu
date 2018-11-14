package com.cxhu.comprehensive.kit;

import com.cxhu.comprehensive.constant.Login_Constant;

import redis.clients.jedis.Jedis;

/*用于向redis中存储 和 获取openid*/
public class RedisHand {

	// 向redis中存储openid
	public static void saveOpenid(String openid, String session_key, int second) {
		Jedis jedis = new Jedis(Login_Constant.HOST);
		// 使用redis储存openid与session_key
		jedis.set(openid, openid + "," + session_key);
		// 设置有效时间
		jedis.expire(openid, second);
		jedis.close();
	}
	
	// 向redis中设置值
	public static void setKey(String key, String value, int second) {
		Jedis jedis = new Jedis(Login_Constant.HOST);
		jedis.set(key, value);
		jedis.expire(key, second);
		jedis.close();
	}
	
	// 从redis中获取值
	public static String getByKey(String key) {
		Jedis jedis = new Jedis(Login_Constant.HOST);
		jedis.close();
		return jedis.get(key);
	}
	
}
