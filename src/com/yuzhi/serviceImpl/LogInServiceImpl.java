package com.yuzhi.serviceImpl;

import com.yuzhi.bean.Admin;
import com.yuzhi.dao.AdminDao;
import com.yuzhi.daoImpl.AdminDaoImpl;
import com.yuzhi.service.LoginService;

public class LogInServiceImpl implements LoginService {
	/**
	 * ����ʵ���߼�����
	 */
	@Override
	public boolean isIllegalAdmin(Admin admin) {
		// ����dao��Ľ���У��
		AdminDao adminDao = new AdminDaoImpl();
		boolean b = adminDao.isIllegalAdmin(admin);
		if (b) {
			return true;

		}

		return false;
	}

}
