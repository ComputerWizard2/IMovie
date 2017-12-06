package com.yuzhi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuzhi.bean.Admin;
import com.yuzhi.service.LoginService;
import com.yuzhi.serviceImpl.LogInServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("*.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ����
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		// ��װ����
		Admin admin = new Admin();
		admin.setUserName(name);
		admin.setPassWord(pwd);
		// ���÷���
		LoginService loginService = new LogInServiceImpl();
		HttpSession session = request.getSession();
		boolean b = loginService.isIllegalAdmin(admin);
		if (b) {
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {
			session.setAttribute("mess", "�������");
			response.sendRedirect("login.jsp");

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
