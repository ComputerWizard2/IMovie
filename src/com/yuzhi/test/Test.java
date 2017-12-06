package com.yuzhi.test;

import java.sql.Connection;

import com.yuzhi.util.JdbcUtil;

public class Test {
	@org.junit.Test
	public void test() {
		Connection connection = null;
		try {
			connection = JdbcUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(connection.toString());

	}
}
