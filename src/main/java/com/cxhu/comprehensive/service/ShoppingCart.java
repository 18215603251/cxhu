package com.cxhu.comprehensive.service;

import java.util.List;

/**此类表示购物车, 在未登陆的情况下仍然有效, 包含多件商品*/
public class ShoppingCart {
	private List<Object> goods;		// 表示多件商品

	public List<Object> getGoods() {
		return goods;
	}

	public void setGoods(List<Object> goods) {
		this.goods = goods;
	}
}
