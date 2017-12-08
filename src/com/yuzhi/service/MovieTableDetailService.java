package com.yuzhi.service;

import com.yuzhi.bean.MovieTableDetaile;

public interface MovieTableDetailService {
	/**
	 * 访问表的细节
	 */
	// 查询指定表的指定对象根据ID
	public MovieTableDetaile findOne(int id);

}
