package com.yuzhi.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			preparestament = connection
					.prepareStatement("select id ,moviename,url,imagepath ,score from movietable limit ?,?");
			preparestament.setInt(1, page.getPageSum());
			preparestament.setInt(2, page.getPageSize());

			resultSet = preparestament.executeQuery();
			list = new ArrayList<>();

			while (resultSet.next())

			{

				MovieTable movieTable = new MovieTable();
				movieTable.setId(resultSet.getInt(1));
				movieTable.setMovieName(resultSet.getString(2));
				movieTable.setUrl(resultSet.getString(3));
				movieTable.setImagePath(resultSet.getString(4));
				movieTable.setScore(resultSet.getFloat(6));
				list.add(movieTable);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
