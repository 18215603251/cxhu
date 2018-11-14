package com.cxhu.comprehensive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cxhu.comprehensive.dao.CellPhoneDao;
import com.cxhu.comprehensive.dao.CellTypeDao;
import com.cxhu.comprehensive.domain.CellPhone;
import com.cxhu.comprehensive.domain.CellType;
import com.cxhu.comprehensive.service.DivideCellTypePageService;

/**用于获取手机大类型(带分页)*/
/*购物流程的入口, 获得手机大类, 展示出来后, 用户就可以点击了*/

@Controller
public class GetDivideCellTypePageController {
	@Autowired
	private CellTypeDao dao;
	@Autowired
	private CellPhoneDao cellPhoneDao;

	@RequestMapping("/getCellTypePage")
	@ResponseBody
	public Object detail(String currentPage, String item) { // 要获取第几页的数据, 每一页显示多少条

		// 根据查询, 并计算出符合要求的记录总数
		int total_size = (int) dao.count();

		// 创建变量表示当前页和每页要显示的条数
		int current_page = 0;
		int item_size = 0;

		// 如果后台没有得到数据, 对于不符合要求的参数, 默认设置为查询第一页, 每页6条
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

		// 如果要显示的记录数大于总记录数
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
		DivideCellTypePageService pageBean = new DivideCellTypePageService(current_page, item_size, total_size);

		/********** 为pageBean集合属性赋值 ************/
		pageBean.setCellTypes(new ArrayList<CellType>());

		// 查询获取记录
		List<Object> objs = dao.getCurrentCellTypeData(pageBean.getStartIndex(), pageBean.getPageRecordSize());

		// 将查询到的记录注入到pageBean中
		for (Object obj : objs) {
			CellType c = new CellType();
			Object[] data = (Object[]) obj;

			int type_id = Integer.parseInt((data[0] + ""));
			/*根据大类查询小类, 因为大类需要小类的一此信息*/
			List<CellPhone> cellPhones = cellPhoneDao.selectCellByTypeid(type_id);
			
			/*如果大类下面没有小类, 则continue*/
			if (cellPhones.size() == 0) {
				continue;
			}
			
			CellPhone cellPhone = cellPhones.get(0);
			
			String photos = cellPhone.getPhotos();
			String photo = photos.split(",")[0];				// 图片
			
			long cell_number = cellPhone.getCellNumber();		// 数量
			int is_sale = 0;
			if (cell_number > 0) {
				is_sale = 1;
			}
			
			c.setId(type_id);										// 设置id
			c.setType_name(data[1] + "");							// 设置名称
			c.setEvaluate(Integer.parseInt((data[2] + "")));		// 设置评价
			c.setPrice(cellPhone.getPrice());						// 设置价格
			c.setFlag_icon(cellPhone.getSaleIcon());				// 设置图标
			c.setIs_sale(is_sale);									// 设置是否有售
			c.setPhoto(photo);										// 设置图片
			
			pageBean.getCellTypes().add(c);
		}
		return pageBean;
	}
}
