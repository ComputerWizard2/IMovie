package com.yuzhi.dao;

import java.util.List;

import com.yuzhi.bean.MovieTable;
import com.yuzhi.bean.Page;

public interface MovieTableDao {

	// ���ݵ�һҳ������
	public List<MovieTable> FindMovieByPage(Page page);

	// ��ѯ���е�����

	public int FindAllData();

	// ɾ��������
	public boolean deleteDate(int id);

	// ����һ������
	public boolean insertData(MovieTable movieTable);

	// ��ѯһ������
	public MovieTable findOne(int id);

	// ��������
	public boolean updateMovie(MovieTable movieTable);

}
