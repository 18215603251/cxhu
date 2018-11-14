package com.cxhu.comprehensive.service;

import java.util.List;

import com.cxhu.comprehensive.domain.Audio;

/*封装Song类的分页信息*/
public class DivideSongPageService {

	public static final int  nav_max = 5;		// 表示分页导航显示多少个

	/* 已知值 */
	private int currentPage; 			// 前端用户点击时, 传递过来, 要显示的当前页(1,2,3,5...)
	private int pageRecordSize; 		// 每一页要显示的条数(自己设置)
	private int totalSize; 				// 数据库中满足条件的记录总条数

	/* 要计算的值 */
	private int totalPageSize; 			// 总页数
	private int startIndex; 			// limit 查询时的第一个值(查询的起始下标)

	/* 一个页面中分页那部份的数据 */
	private List<Audio> songs; 			// 一个页面包含多条记录
	private int start; 					// 分页的导航中显示的第一个页号
	private int end; 					// 最后一个页号
	
	/*************** 构造页面对象, 包含的是页面中分页部份的信息 ******************/
	public DivideSongPageService(int currentPage, int pageRecordSize, int totalSize) {
		this.currentPage = currentPage;
		this.pageRecordSize = pageRecordSize;
		this.totalSize = totalSize;
		
		// 计算总页数
		if (totalSize % pageRecordSize == 0) {
			totalPageSize = totalSize / pageRecordSize;
		} else {
			totalPageSize = totalSize / pageRecordSize + 1;
		}
		
		// 计算开始索引
		this.startIndex = (currentPage-1) * pageRecordSize;
		
		/*****分页导航*****/
		if(totalPageSize <= DivideSongPageService.nav_max) {   	// 设置最多显示5个分页的导航(可自由设置)
			this.start = 1;
			this.end = this.totalPageSize;		
		} else {
			this.start = this.currentPage - 2;				// 当前页左边显示两个导航(自行设置)
			this.end = this.currentPage + 2;				// 当前页右边显示两个导航(自行设置)
			
			if (start <= 0) {			 // 左边不够显示的情况
				this.start = 1;
				this.end = DivideSongPageService.nav_max;
			}
			if (end >= this.totalPageSize) {			// 右边不够显示的情况
				this.end = totalPageSize;
				this.start = end - DivideSongPageService.nav_max + 1;
			}
		}
	}

	/**********getter/setter*************/
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageRecordSize() {
		return pageRecordSize;
	}

	public void setPageRecordSize(int pageRecordSize) {
		this.pageRecordSize = pageRecordSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPageSize() {
		return totalPageSize;
	}

	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<Audio> getSongs() {
		return songs;
	}

	public void setSongs(List<Audio> songs) {
		this.songs = songs;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}