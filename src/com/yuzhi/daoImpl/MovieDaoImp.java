package com.yuzhi.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuzhi.bean.MovieTable;
import com.yuzhi.bean.Page;
import com.yuzhi.dao.MovieTableDao;
import com.yuzhi.util.JdbcUtil;

public class MovieDaoImp implements MovieTableDao {

	private static Connection connection = null;
	private static PreparedStatement preparestament = null;
	private static ResultSet resultSet = null;

	@Override
	public List<MovieTable> FindMovieByPage(Page page) {
		List<MovieTable> list = null;
		try {

			connection = JdbcUtil.getConnection();
			preparestament = connection.prepareStatement(
					"select id ,moviename,url,imagepath ,score, DATE_FORMAT(SUBSTR(imagepath,31,8),\"%Y-%m-%d\") publishdate from movietable limit ?,?");
			preparestament.setInt(1, page.getPageSum());
			preparestament.setInt(2, page.getPageSize());

			resultSet = preparestament.executeQuery();
			list = new ArrayList<>();

			while (resultSet.next())

			{

				MovieTable movieTable = new MovieTable();
				// id
				movieTable.setId(resultSet.getInt(1));
				// movieName
				movieTable.setMovieName(resultSet.getString(2));
				// Url
				movieTable.setUrl(resultSet.getString(3));
				// imagePath
				movieTable.setImagePath(resultSet.getString(4));
				// score
				movieTable.setScore(resultSet.getFloat(5));
				// ʱ��
				movieTable.setTimePublish(resultSet.getString(6));

				list.add(movieTable);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int FindAllData() {
		try {
			connection = JdbcUtil.getConnection();
			preparestament = connection.prepareStatement("select count(*) from MovieTable ");
			resultSet = preparestament.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResourse(connection, preparestament, resultSet);
		}

		return 0;
	}

	@Override
	public boolean deleteDate(int id) {
		try {

			connection = JdbcUtil.getConnection();
			preparestament = connection.prepareStatement("delete  from movietable where id=?");
			preparestament.setInt(1, id);
			int i = preparestament.executeUpdate();
			if (i > 0) {
				return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResourse(connection, preparestament, resultSet);
		}
		return false;
	}

	@Override
	public boolean insertData(MovieTable movieTable) {
		// connection = JdbcUtil.getConnection();
		// preparestament = connection.prepareStatement("");
		return false;
	}

	@Override
	public MovieTable findOne(int id) {
		try {
			connection = JdbcUtil.getConnection();
			preparestament = connection.prepareStatement("select * from movietable where id =?");
			preparestament.setInt(1, id);
			resultSet = preparestament.executeQuery();
			MovieTable movieTable = new MovieTable();
			if (resultSet.next()) {
				movieTable.setId(id);
				movieTable.setMovieName(resultSet.getString(2));
				;
				movieTable.setTime(resultSet.getString(3));
				movieTable.setUrl(resultSet.getString(4));
				movieTable.setImagePath(resultSet.getString(5));
				movieTable.setSaveImagePath(resultSet.getString(6));
				movieTable.setScore(resultSet.getFloat(7));
				movieTable.setStatus(resultSet.getInt(8));
				movieTable.setSource(resultSet.getString(9));

			}
			return movieTable;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResourse(connection, preparestament, resultSet);
		}

		return null;
	}

	@Override
	public boolean updateMovie(MovieTable movieTable) {
		// �������ݿ�����ݽ��и��²���
		try {
			connection = JdbcUtil.getConnection();
			preparestament = connection.prepareStatement("update movietable set imagepath=?, url=?, score=? ");
			preparestament.setString(1, movieTable.getImagePath());
			preparestament.setString(2, movieTable.getUrl());
			preparestament.setFloat(3, movieTable.getScore());
			int executeUpdate = preparestament.executeUpdate();
			if (executeUpdate > 0) {
				return true;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.closeResourse(connection, preparestament, null);
		}
		return false;
	}

}
