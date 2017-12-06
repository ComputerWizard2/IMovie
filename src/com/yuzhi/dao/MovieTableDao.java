package com.yuzhi.dao;

import java.util.List;

import com.yuzhi.bean.MovieTable;
import com.yuzhi.bean.Page;

public interface MovieTableDao {
	public List<MovieTable> FindMovieByPage(Page page);

}
