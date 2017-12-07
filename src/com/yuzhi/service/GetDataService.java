package com.yuzhi.service;

import java.util.List;

import com.yuzhi.bean.MovieTable;

public interface GetDataService {
	// 分页查询的操作
	public List<MovieTable> findByPage(int currentPage, int pageSize);

	// 删除电影的操作
	public boolean deleteMovie(int id);
}
