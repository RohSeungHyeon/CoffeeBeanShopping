package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.User;

@WebServlet("/readUserInfo")
public class AdminReadMemberController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		user.service.Service service = new user.service.ServiceImpl();
		User user = service.getUserInfo(request.getParameter("userEmail"));

		request.setAttribute("user", user);
		request.setAttribute("joindate", service.getUserJoinDate(request.getParameter("userEmail")));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/memberInfo.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
