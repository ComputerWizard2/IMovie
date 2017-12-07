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
			// ����service ��ȡ����
			GetDataService getDataService = new GetDataServiceImpl();
			int currentPage = 1;
			// ��һ�η��ʵ�ʱ���ȡ��������
			List<MovieTable> page = getDataService.findByPage(currentPage, pageSize);
			// �����ݷ��뵽attribute
			session.setAttribute("currentPage", currentPage);
			request.setAttribute("list", page);
			// ����ǰ��ҳ����뵽session������

			// ת����ҳ��
			request.getRequestDispatcher("MovieList.jsp").forward(request, response);

			break;
		case "/decrease.edit":
			// ��ȡ��ǰ��ҳ���
			currentPage = (int) session.getAttribute("currentPage");
			currentPage = currentPage - 1;
			getDataService = new GetDataServiceImpl();
			// ��n�η��ʵ�ʱ���ȡ��������
			page = getDataService.findByPage(currentPage, pageSize);
			// �����ݷ��뵽attribute
			session.setAttribute("currentPage", currentPage);
			request.setAttribute("list", page);
			// ����ǰ��ҳ����뵽session������

			// ת����ҳ��
			request.getRequestDispatcher("MovieList.jsp").forward(request, response);

			break;
		case "/increase.edit":

			// ��ȡ��ǰ��ҳ���
			currentPage = (int) session.getAttribute("currentPage");
			System.out.println(currentPage);
			currentPage = currentPage + 1;
			System.out.println(currentPage);
			getDataService = new GetDataServiceImpl();
			// ��n�η��ʵ�ʱ���ȡ��������
			page = getDataService.findByPage(currentPage, pageSize);
			System.out.println(page.toString());
			// �����ݷ��뵽attribute
			request.setAttribute("list", page);
			// ����ǰ��ҳ����뵽session������
			session.setAttribute("currentPage", currentPage);

			// ת����ҳ��
			request.getRequestDispatcher("MovieList.jsp").forward(request, response);
			break;
		case "/deletemovie.edit":
			// ɾ������
			// ��ȡɾ���ĵ�Ӱ�ı��
			String id = request.getParameter("id");
			// ����service���������ɾ��
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
