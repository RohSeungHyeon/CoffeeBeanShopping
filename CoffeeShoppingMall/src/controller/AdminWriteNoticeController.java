package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/writeNotice")
public class AdminWriteNoticeController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/noticeWrite.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
