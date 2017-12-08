package com.yuzhi.serviceImpl;

import java.util.List;

import com.yuzhi.bean.MovieTable;
import com.yuzhi.bean.Page;
import com.yuzhi.dao.MovieTableDao;
import com.yuzhi.daoImpl.MovieDaoImp;
import com.yuzhi.service.GetDataService;

public class GetDataServiceImpl implements GetDataService {
	private static MovieDaoImp movieDaoImp = new MovieDaoImp();

	@Override
	public List<MovieTable> findByPage(int currrentPage, int pageSize) {
		// curentPage 当前页
		// pageSize 页号
		// PageSUm 总页数
		// row 总行数
		Page page = new Page();
		// 调用当前的dao层查询数据的总条数

		int i = movieDaoImp.FindAllData();
		// 将数据放入到page中
		page.setRow(i);
		// 计算总页数
		int sumPage = i % pageSize == 0 ? i / pageSize : i / pageSize + 1;
		// 判断一下当前页的是否符合规则
		if (currrentPage <= 1) {
			currrentPage = 1;

		}
		if (currrentPage >= sumPage) {
			currrentPage = sumPage;

		}

		// 放入到page中
		page.setMaxCount(sumPage);
		// 将当前页和页号放入到page中
		page.setCurrrentPage(currrentPage);
		page.setPageSize(pageSize);
		// 调用dao层的方法找数据
		int pageSum = (currrentPage - 1) * pageSize;
		page.setPageSum(pageSum);
		List<MovieTable> list = movieDaoImp.FindMovieByPage(page);
		// 返回结果数据
		return list;
	}

	@Override
	public boolean deleteMovie(int id) {
		// 调用dao层的命令进行删除
		boolean b = movieDaoImp.deleteDate(id);
		if (b) {
			return true;

		}

		return false;
	}

	@Override
	public MovieTable findOne(int id) {
		// 调用dao的命令进行对象的查找
		MovieTableDao movieTableDao = new MovieDaoImp();
		MovieTable one = movieTableDao.findOne(id);

		return one;
	}

	@Override
	public boolean updateMovie(MovieTable movieTable) {
		// 调用到曾的方法进行实现数据的更新
		boolean b = movieDaoImp.updateMovie(movieTable);
		if (b) {
			return true;

		}

		return false;
	}

}
