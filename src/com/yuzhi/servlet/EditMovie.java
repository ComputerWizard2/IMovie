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
			showList(request, pageSize, session);

			// ת����ҳ��
			request.getRequestDispatcher("MovieList.jsp").forward(request, response);
			break;
		case "/deletemovie.edit":
			// ɾ������
			// ��ȡɾ���ĵ�Ӱ�ı��
			String id = request.getParameter("id1");

			// ����service���������ɾ��
			getDataService = new GetDataServiceImpl();
			boolean b = getDataService.deleteMovie(Integer.parseInt(id));

			if (b) {
				showList(request, pageSize, session);

				request.getRequestDispatcher("MovieList.jsp").forward(request, response);
			}

			break;
		case "/editmovie.edit":
			// �༭����
			// ��ȡ��Ҫ�༭�ĵ�Ӱ��id
			id = request.getParameter("id1");
			// ��service �ķ������в��ұ���
			getDataService = new GetDataServiceImpl();
			MovieTable findOne = getDataService.findOne(Integer.parseInt(id));
			// ��ȡ��һ�������Ϣ
			MovieTableDeailDaoImpl movieTableDeailDaoImpl = new MovieTableDeailDaoImpl();
			MovieTableDetaile movieTableDetaile = movieTableDeailDaoImpl.findOneById(Integer.parseInt(id));
			System.out.println(movieTableDeailDaoImpl);
			if (findOne != null) {

				request.setAttribute("movie", findOne);
				request.setAttribute("movieDetil", movieTableDetaile);

				// ��һ�µ�ǰ��id�������Ϣ���ظ�ҳ��

				showList(request, pageSize, session);

				request.getRequestDispatcher("editmovie.jsp").forward(request, response);
			}
			break;

		case "/updatemovie.edit":
			// ���е�Ӱ���ݵĸ���
			// ��ȡ��Ҫ�༭�ĵ�Ӱ��id
			id = request.getParameter("id");
			System.out.println("id------------------->" + id);
			String imagepath = request.getParameter("imagepath1");
			String play = request.getParameter("play1");
			String score = request.getParameter("score1");

			// ����д��Ϣ��װ��bean��
			MovieTable movieTable = new MovieTable();
			movieTable.setId(Integer.parseInt(id));
			movieTable.setImagePath(imagepath);
			movieTable.setUrl(play);
			movieTable.setScore(Float.parseFloat(score));

			// ��service �ķ������и�������
			getDataService = new GetDataServiceImpl();
			boolean a = getDataService.updateMovie(movieTable);

			if (a) {

				// ��һ�µ�ǰ��id�������Ϣ���ظ�ҳ��

				showList(request, pageSize, session);

				request.getRequestDispatcher("MovieList.jsp").forward(request, response);

				break;
			}

		}
	}

	// ��ʾҳ����б����Ϣ
	private void showList(HttpServletRequest request, int pageSize, HttpSession session) {
		GetDataService getDataService;
		int currentPage;
		List<MovieTable> page;
		currentPage = (int) session.getAttribute("currentPage");
		System.out.println(currentPage);
		currentPage = currentPage + 1;
		System.out.println(currentPage);
		getDataService = new GetDataServiceImpl();
		// ��n�η��ʵ�ʱ���ȡ��������
		page = getDataService.findByPage(currentPage, pageSize);

		// �����ݷ��뵽attribute
		request.setAttribute("list", page);
		// ����ǰ��ҳ����뵽session������
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
