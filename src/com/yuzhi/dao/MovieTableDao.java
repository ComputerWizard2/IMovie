package com.yuzhi.dao;

import java.util.List;

import com.yuzhi.bean.MovieTable;
import com.yuzhi.bean.Page;

public interface MovieTableDao {

	// 数据的一页的数据
	public List<MovieTable> FindMovieByPage(Page page);

	// 查询所有的数据

	public int FindAllData();

	// 删除的数据
	public boolean deleteDate(int id);

	// 插入一条数据
	public boolean insertData(MovieTable movieTable);

	// 查询一个对象
	public MovieTable findOne(int id);

	// 更新数据
	public boolean updateMovie(MovieTable movieTable);

}
