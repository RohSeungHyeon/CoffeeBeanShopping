package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.service.proService;
import product.service.proServiceImpl;

@WebServlet("/goAdmin")
public class AdminController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		proService service = new proServiceImpl();

		request.setAttribute("products", service.getAllProduct());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/adminMain.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
