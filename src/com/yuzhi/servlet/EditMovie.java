package com.yuzhi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuzhi.bean.MovieTable;
import com.yuzhi.bean.MovieTableDetaile;
import com.yuzhi.daoImpl.MovieTableDeailDaoImpl;
import com.yuzhi.service.GetDataService;
import com.yuzhi.serviceImpl.GetDataServiceImpl;

/**
 * Servlet implementation class EditMovie
 */
@WebServlet("*.edit")
public class EditMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pageSize = 18;
		String path = request.getServletPath();
		HttpSession session = request.getSession();

		switch (path) {
		case "/EditMovie.edit":
			// 调用service 获取数据
			GetDataService getDataService = new GetDataServiceImpl();
			int currentPage = 1;
			// 第一次访问的时候获取到的数据
			List<MovieTable> page = getDataService.findByPage(currentPage, pageSize);
			// 将数据放入到attribute
			session.setAttribute("currentPage", currentPage);
			request.setAttribute("list", page);
			// 将当前的页面放入到session对象中

			// 转发发页面
			request.getRequestDispatcher("MovieList.jsp").forward(request, response);

			break;
		case "/decrease.edit":
			// 获取当前的页面号
			currentPage = (int) session.getAttribute("currentPage");
			currentPage = currentPage - 1;
			getDataService = new GetDataServiceImpl();
			// 第n次访问的时候获取到的数据
			page = getDataService.findByPage(currentPage, pageSize);
			// 将数据放入到attribute
			session.setAttribute("currentPage", currentPage);
			request.setAttribute("list", page);
			// 将当前的页面放入到session对象中

			// 转发发页面
			request.getRequestDispatcher("MovieList.jsp").forward(request, response);

			break;
		case "/increase.edit":

			// 获取当前的页面号
			showList(request, pageSize, session);

			// 转发发页面
			request.getRequestDispatcher("MovieList.jsp").forward(request, response);
			break;
		case "/deletemovie.edit":
			// 删除操作
			// 获取删除的电影的编号
			String id = request.getParameter("id1");

			// 调用service的命令进行删除
			getDataService = new GetDataServiceImpl();
			boolean b = getDataService.deleteMovie(Integer.parseInt(id));

			if (b) {
				showList(request, pageSize, session);

				request.getRequestDispatcher("MovieList.jsp").forward(request, response);
			}

			break;
		case "/editmovie.edit":
			// 编辑操作
			// 获取到要编辑的电影的id
			id = request.getParameter("id1");
			// 调service 的方法进行查找遍历
			getDataService = new GetDataServiceImpl();
			MovieTable findOne = getDataService.findOne(Integer.parseInt(id));
			// 获取另一个表的信息
			MovieTableDeailDaoImpl movieTableDeailDaoImpl = new MovieTableDeailDaoImpl();
			MovieTableDetaile movieTableDetaile = movieTableDeailDaoImpl.findOneById(Integer.parseInt(id));
			System.out.println(movieTableDeailDaoImpl);
			if (findOne != null) {

				request.setAttribute("movie", findOne);
				request.setAttribute("movieDetil", movieTableDetaile);

				// 找一下当前的id对象的信息返回给页面

				showList(request, pageSize, session);

				request.getRequestDispatcher("editmovie.jsp").forward(request, response);
			}
			break;

		case "/updatemovie.edit":
			// 进行电影数据的更新
			// 获取到要编辑的电影的id
			id = request.getParameter("id");
			System.out.println("id------------------->" + id);
			String imagepath = request.getParameter("imagepath1");
			String play = request.getParameter("play1");
			String score = request.getParameter("score1");

			// 将这写信息封装在bean中
			MovieTable movieTable = new MovieTable();
			movieTable.setId(Integer.parseInt(id));
			movieTable.setImagePath(imagepath);
			movieTable.setUrl(play);
			movieTable.setScore(Float.parseFloat(score));

			// 调service 的方法进行更新数据
			getDataService = new GetDataServiceImpl();
			boolean a = getDataService.updateMovie(movieTable);

			if (a) {

				// 找一下当前的id对象的信息返回给页面

				showList(request, pageSize, session);

				request.getRequestDispatcher("MovieList.jsp").forward(request, response);

				break;
			}

		}
	}

	// 显示页面的列表的信息
	private void showList(HttpServletRequest request, int pageSize, HttpSession session) {
		GetDataService getDataService;
		int currentPage;
		List<MovieTable> page;
		currentPage = (int) session.getAttribute("currentPage");
		System.out.println(currentPage);
		currentPage = currentPage + 1;
		System.out.println(currentPage);
		getDataService = new GetDataServiceImpl();
		// 第n次访问的时候获取到的数据
		page = getDataService.findByPage(currentPage, pageSize);

		// 将数据放入到attribute
		request.setAttribute("list", page);
		// 将当前的页面放入到session对象中
		session.setAttribute("currentPage", currentPage);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
