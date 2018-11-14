package com.cxhu.comprehensive.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cxhu.comprehensive.constant.Login_Constant;
import com.cxhu.comprehensive.kit.CilentSend;
import com.cxhu.comprehensive.kit.RedisHand;

import net.sf.json.JSONObject;
/*用于登陆和储存openid*/
@RestController
public class OpenidLoginController {
	
	@ResponseBody
	@RequestMapping("/openidLogin")
	public Object create3redSession(HttpServletRequest request, HttpServletResponse response) throws ClientProtocolException, IOException, NoSuchAlgorithmException {
				
		String JSCODE = request.getParameter("code");
		String APPID = Login_Constant.APPID;
		String SECRET = Login_Constant.SECRET;
		
		String URL = Login_Constant.LOGIN_URL;
		URL = URL.replace("APPID", APPID);
		URL = URL.replace("SECRET", SECRET);
		URL = URL.replace("JSCODE", JSCODE);
		
		// 调用方法发送请求
		CilentSend cilentSend = new CilentSend();
		String entityString = cilentSend.clientSend(URL, "get");
		
		// 解析json形式的字符串
		JSONObject jsonObject = JSONObject.fromObject(entityString);
		String openid = jsonObject.getString("openid");
		String session_key = jsonObject.getString("session_key");
		
		//redis key-vlaue储存
		RedisHand.saveOpenid(openid, session_key, Login_Constant.OPENID_SECOND);
        //System.out.println(OpenidRedisHand.getOpenid(openid));
		
		return openid;
	}
}
