package com.cxhu.comprehensive.kit;

import java.util.Random;

/**用于生成随机字符串*/
public class GreateRandomString {
	public static String getRandomString() {
		String str = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		char c = 0;
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<str.length(); i++) {
			c = str.charAt(random.nextInt(str.length()));
			sb.append(c);
		}
		String dest = sb.toString();
		
		return dest;
	}
}
