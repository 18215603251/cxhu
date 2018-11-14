package com.cxhu.comprehensive.kit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**MD5加密处理*/
public class MD5Kit {
	public static String getMD5Message(String data) {
		String dest = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(data.getBytes());
			dest = digest.digest().toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
		return dest;
	}
}
