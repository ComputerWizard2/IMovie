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

}
