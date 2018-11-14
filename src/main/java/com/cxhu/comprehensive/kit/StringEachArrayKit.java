package com.cxhu.comprehensive.kit;

/**此工具用于String与数组之间的转换*/
public class StringEachArrayKit {
	
	// String 到 数组
	public static String[] StringToArray(String split, String data) {
		String[] arr = data.split(split);
		return arr;
	}
	
	// 数组 到 String
	public static String ArrayToString(String[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}
