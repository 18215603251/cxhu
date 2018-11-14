package com.cxhu.comprehensive.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.comprehensive.dao.AudioDivideDao;
import com.cxhu.comprehensive.domain.Audio;
import com.cxhu.comprehensive.service.DivideSongPageService;

@Controller
public class DivideSongPageController {
	@Autowired
	private AudioDivideDao dao;

	@RequestMapping("/getPageData")
	@ResponseBody
	public Object detail(String currentPage, String item) { // 要获取第几页的数据, 每一页显示多少条

		// 根据查询, 并计算出符合要求的记录总数
		int total_size = (int) dao.count();

		// 创建变量表示当前页和每页要显示的条数
		int current_page = 0;
		int item_size = 0;

		// 如果后台没有得到数据, 对于不符合要求的参数, 默认设置为查询第一页, 每页10条
		if (currentPage == null || item == null) {
			current_page = 1;
			item_size = 6;
		}

		try {
			current_page = Integer.parseInt(currentPage);
			item_size = Integer.parseInt(item);
		} catch (NumberFormatException e) {
			current_page = 1;
			item_size = 6;
			e.printStackTrace();
		}

		// 如果当前页小于0, 或每一页显示的个数小于0, 显然不合要求
		if (current_page <= 0 || item_size <= 0) {
			current_page = 1;
			item_size = 6;
		}

		// 计算总页数
		int max_page = 0; // 表示总页数
		if (total_size % item_size == 0) {
			max_page = total_size / item_size;
		} else {
			max_page = total_size / item_size + 1;
		}

		// 如果当前页面 大于 最大页面
		if (current_page >= max_page) {
			current_page = max_page;
		}

		// 要显示的记录数大于总记录数
		if (item_size >= total_size) {
			item_size = total_size;
			current_page = 1;
		}
		
		// 如果当前页数如果当前页面 大于 最大页面 和 要显示的记录数大于总记录数, 显示第一页
		if (item_size >= total_size || item_size >= total_size) {
			current_page = 1;
			item_size = 6;
		}
		
		/************** 创建PageBean对象 *************/
		DivideSongPageService pageBean = new DivideSongPageService(current_page, item_size, total_size);

		/********** 为pageBean的Song属性赋值 ************/
		pageBean.setSongs(new ArrayList<Audio>());

		// 查询获取记录
		List<Object> objs = dao.getCurrentPageData(pageBean.getStartIndex(), pageBean.getPageRecordSize());

		// 将查询到的记录注入到pageBean中
		for (Object obj : objs) {
			Audio audio = new Audio();
			Object[] data = (Object[]) obj;

			audio.setId(Integer.parseInt(data[0] + "")); // Object先转换为String, 再强制转换为int
			audio.setSong_name(data[1] + "");
			audio.setArtist(data[2] + "");
			audio.setAlbum(data[3] + "");
			audio.setUrl(data[5] + "");

			// 设置Time
			String[] s = (data[4] + "").split(":");
			// 换成Time表示的时间, 最后要减去8小时表示的毫秒数
			int msecond = (Integer.parseInt(s[1]) * 60 + Integer.parseInt(s[2])) * 1000 - 28800000;
			Time time = new Time(msecond);
			audio.setLength(time);

			pageBean.getSongs().add(audio);
		}
		return pageBean;
	}
}
