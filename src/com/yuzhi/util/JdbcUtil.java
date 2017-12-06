package com.yuzhi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static Connection getConnection() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/imovie?user='root'&password=123&CharacterEncoding=utf-8");

		return connection;

	}

	public static void closeResourse(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection = null;

		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			resultSet = null;

		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			preparedStatement = null;

		}
	}

}
