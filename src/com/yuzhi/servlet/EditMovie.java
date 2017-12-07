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
			currentPage = (int) session.getAttribute("currentPage");
			System.out.println(currentPage);
			currentPage = currentPage + 1;
			System.out.println(currentPage);
			getDataService = new GetDataServiceImpl();
			// 第n次访问的时候获取到的数据
			page = getDataService.findByPage(currentPage, pageSize);
			System.out.println(page.toString());
			// 将数据放入到attribute
			request.setAttribute("list", page);
			// 将当前的页面放入到session对象中
			session.setAttribute("currentPage", currentPage);

			// 转发发页面
			request.getRequestDispatcher("MovieList.jsp").forward(request, response);
			break;
		case "/deletemovie.edit":
			// 删除操作
			// 获取删除的电影的编号
			String id = request.getParameter("id");
			// 调用service的命令进行删除
			getDataService = new GetDataServiceImpl();
			boolean b = getDataService.deleteMovie(Integer.parseInt(id));
			if (b) {

				request.getRequestDispatcher("MovieList.jsp").forward(request, response);
			}

			break;

		}

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
