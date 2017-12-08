package com.yuzhi.serviceImpl;

import com.yuzhi.bean.MovieTableDetaile;
import com.yuzhi.dao.MovieTableDetailDao;
import com.yuzhi.daoImpl.MovieTableDeailDaoImpl;
import com.yuzhi.service.MovieTableDetailService;

public class MovieTableDetailServiceImpl implements MovieTableDetailService {

	@Override
	public MovieTableDetaile findOne(int id) {
		// ����dao��ķ������ݿ�
		MovieTableDetailDao movieTableDetailDao = new MovieTableDeailDaoImpl();
		MovieTableDetaile movieTableDetaile = movieTableDetailDao.findOneById(id);

		return movieTableDetaile;
	}

}
