package com.cxhu.comprehensive.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cxhu.comprehensive.dao.CellPhoneDao;
import com.cxhu.comprehensive.domain.CellPhone;
import com.cxhu.comprehensive.service.ShoppingCart;

/**购物车*/
@Controller
public class ShoppingCardController {
//	@Autowired
//	private ShoppingCart cart;
//	
//	@Autowired
//	private CellPhoneDao dao;
//	
//	/*加入购物车*/
//	@RequestMapping("/setShoppingCart")		// 使用不定参是因为加入购物车时不确定有多少个对象
//	public void setShoppingCard(HttpServletRequest request, String count, String id) {
//		
//		// 根据id查询到对象
//		CellPhone cell = dao.findById(Integer.parseInt(id));
//		
//		
//		HttpSession session = request.getSession();
//		Object value = "";
//		session.setAttribute("cart_" + System.currentTimeMillis(), value);
//	}
//	
//	/*获取购物车对象*/
//	@RequestMapping("/getShoppingCart")
//	public Object getShoppingCart(HttpServletRequest request) {
//		List<Object> goods = new ArrayList<>(); 
//		
//		// 从session中获取用户加入的购物车的对象
//		HttpSession session = request.getSession();
//		Enumeration<String> attributeNames = session.getAttributeNames();
//		while (attributeNames.hasMoreElements()) {
//			String str = (String) attributeNames.nextElement();
//			if (str.startsWith("crat_")) {
//				goods.add(session.getAttribute(str));
//			}
//		}
//		
//		// 设置购物车属性值
//		cart.setGoods(goods);
//		return cart;
//	}
}
