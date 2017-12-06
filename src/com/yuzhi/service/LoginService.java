package com.yuzhi.service;

import com.yuzhi.bean.Admin;

public interface LoginService {
	// 判断是否是合法的管理员
	public boolean isIllegalAdmin(Admin admin);
}
