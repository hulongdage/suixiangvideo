package com.suixiang.utils;

import java.util.List;

/**
 * @Description: 封装分页后的数据格式
 */
public class PageResult {
	
	private int currentPage;    // 当前页数
	private int totalPage;		// 总页数	
	private long totalSize;		// 总记录数
	private List<?> rows;		// 每行显示的内容
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}