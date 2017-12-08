package com.yuzhi.service;

import java.util.List;

import com.yuzhi.bean.MovieTable;

public interface GetDataService {
	// ��ҳ��ѯ�Ĳ���
	public List<MovieTable> findByPage(int currentPage, int pageSize);

	// ɾ����Ӱ�Ĳ���
	public boolean deleteMovie(int id);

	// ����id�Ҷ���
	public MovieTable findOne(int id);

	// ��������
	public boolean updateMovie(MovieTable movieTable);

}
