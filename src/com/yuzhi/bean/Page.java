package com.yuzhi.bean;

import java.util.List;

public class Page {

	private int pageSize;// ҳ��
	private int currrentPage;// ��ǰҳ
	private int MaxCount;// ���ҳ��
	private List<MovieTable> Movies; // ÿҳ�ĵ�Ӱ��Ϣ
	private int PageSum;// ��ҳ��
	private int row;// ���ݱ��е�������

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
