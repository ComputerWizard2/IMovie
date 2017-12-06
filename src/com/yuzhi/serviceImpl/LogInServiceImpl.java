package com.yuzhi.serviceImpl;

import com.yuzhi.bean.Admin;
import com.yuzhi.dao.AdminDao;
import com.yuzhi.daoImpl.AdminDaoImpl;
import com.yuzhi.service.LoginService;

public class LogInServiceImpl implements LoginService {
	/**
	 * 用来实现逻辑分析
	 */
	@Override
	public boolean isIllegalAdmin(Admin admin) {
		// 访问dao层的进行校验
		AdminDao adminDao = new AdminDaoImpl();
		boolean b = adminDao.isIllegalAdmin(admin);
		if (b) {
			return true;

		}

		return false;
	}

}
