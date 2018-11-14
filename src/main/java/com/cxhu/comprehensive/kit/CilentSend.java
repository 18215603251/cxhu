package com.cxhu.comprehensive.kit;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/*模拟客户端发送请求*/
public class CilentSend {

	// url 为发送请求的地址, type为发送方式
	public String clientSend(String url, String type) throws ClientProtocolException, IOException {
		if (url == null || type == null) {
			return null;
		}
		// 创建cilent
		CloseableHttpClient client = HttpClients.createDefault();
		
		// 创建响应
		CloseableHttpResponse cilentResponse = null;
		
		// 判断创建的请求是get还是post
		if ("GET".equalsIgnoreCase(type)) {
			HttpGet get = new HttpGet(url);		// 创建get
			cilentResponse = client.execute(get);
		} else {
			HttpPost post = new HttpPost(url);	// 创建post
			cilentResponse = client.execute(post);
		}
		
		// 从响应中获取实体内容
		HttpEntity entity = cilentResponse.getEntity();
		String entityString = EntityUtils.toString(entity);
		client.close();
		
		return entityString;
	}
}
