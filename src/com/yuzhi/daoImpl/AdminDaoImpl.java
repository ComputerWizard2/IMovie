package com.yuzhi.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yuzhi.bean.Admin;
import com.yuzhi.dao.AdminDao;
import com.yuzhi.util.JdbcUtil;

public class AdminDaoImpl implements AdminDao {

	public static Connection connection = null;
	public static PreparedStatement preparedStament = null;
	public static ResultSet resultSet = null;

	@Override
	public boolean isIllegalAdmin(Admin admin) {

		try {
			connection = JdbcUtil.getConnection();
			preparedStament = connection.prepareStatement("select * from user where username =? and password=?");
			preparedStament.setString(1, admin.getUserName());
			preparedStament.setString(2, admin.getPassWord());
			resultSet = preparedStament.executeQuery();
			if (resultSet.next()) {
				return true;

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
