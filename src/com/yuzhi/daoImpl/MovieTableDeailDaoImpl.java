package com.yuzhi.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yuzhi.bean.MovieTableDetaile;
import com.yuzhi.dao.MovieTableDetailDao;
import com.yuzhi.util.JdbcUtil;

public class MovieTableDeailDaoImpl implements MovieTableDetailDao {
	// 数据库的连接对象
	private static Connection connection = null;
	private static PreparedStatement preparedStament = null;
	private static ResultSet resultSet = null;

	@Override
	public MovieTableDetaile findOneById(int id) {
		try {
			connection = JdbcUtil.getConnection();
			preparedStament = connection.prepareStatement("select * from MovieDetailTable where id =?");
			preparedStament.setInt(1, id);
			resultSet = preparedStament.executeQuery();
			MovieTableDetaile movieTableDetaile = new MovieTableDetaile();
			if (resultSet.next()) {
				movieTableDetaile.setId(resultSet.getInt(1));
				movieTableDetaile.setDirector(resultSet.getString(2));

				movieTableDetaile.setKeyword(resultSet.getString(3));
				movieTableDetaile.setCategroy(resultSet.getString(4));
				movieTableDetaile.setDes(resultSet.getString(5));

			}
			return movieTableDetaile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResourse(connection, preparedStament, resultSet);
		}

		return null;
	}

}
