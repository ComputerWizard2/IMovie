package com.yuzhi.bean;

import java.util.List;

public class Page {

	private int pageSize;// 页号
	private int currrentPage;// 当前页
	private int MaxCount;// 最大页数
	private List<MovieTable> Movies; // 每页的电影信息
	private int PageSum;// 总页数
	private int row;// 数据表中的总行数

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getPageSum() {
		return PageSum;
	}

	public void setPageSum(int pageSum) {
		PageSum = pageSum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrrentPage() {
		return currrentPage;
	}

	public void setCurrrentPage(int currrentPage) {
		this.currrentPage = currrentPage;
	}

	public int getMaxCount() {
		return MaxCount;
	}

	public void setMaxCount(int maxCount) {
		MaxCount = maxCount;
	}

	public List<MovieTable> getMovies() {
		return Movies;
	}

	public void setMovies(List<MovieTable> movies) {
		Movies = movies;
	}

}
