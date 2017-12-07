package com.yuzhi.serviceImpl;

import java.util.List;

import com.yuzhi.bean.MovieTable;
import com.yuzhi.bean.Page;
import com.yuzhi.daoImpl.MovieDaoImp;
import com.yuzhi.service.GetDataService;

public class GetDataServiceImpl implements GetDataService {
	private static MovieDaoImp movieDaoImp = new MovieDaoImp();

	@Override
	public List<MovieTable> findByPage(int currrentPage, int pageSize) {
		// curentPage ��ǰҳ
		// pageSize ҳ��
		// PageSUm ��ҳ��
		// row ������
		Page page = new Page();
		// ���õ�ǰ��dao���ѯ���ݵ�������

		int i = movieDaoImp.FindAllData();
		// �����ݷ��뵽page��
		page.setRow(i);
		// ������ҳ��
		int sumPage = i % pageSize == 0 ? i / pageSize : i / pageSize + 1;
		// �ж�һ�µ�ǰҳ���Ƿ���Ϲ���
		if (currrentPage <= 1) {
			currrentPage = 1;

		}
		if (currrentPage >= sumPage) {
			currrentPage = sumPage;

		}

		// ���뵽page��
		page.setMaxCount(sumPage);
		// ����ǰҳ��ҳ�ŷ��뵽page��
		page.setCurrrentPage(currrentPage);
		page.setPageSize(pageSize);
		// ����dao��ķ���������
		int pageSum = (currrentPage - 1) * pageSize;
		page.setPageSum(pageSum);
		List<MovieTable> list = movieDaoImp.FindMovieByPage(page);
		// ���ؽ������
		return list;
	}

	@Override
	public boolean deleteMovie(int id) {
		// ����dao����������ɾ��
		boolean b = movieDaoImp.deleteDate(id);
		if (b) {
			return true;

		}

		return false;
	}

}
