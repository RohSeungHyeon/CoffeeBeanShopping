package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import product.service.proService;
import product.service.proServiceImpl;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		
		String addr = request.getParameter("address");
		String to = request.getParameter("total");
		System.out.println(addr+to);
		
		HttpSession session = request.getSession();
		session.setAttribute("addr", addr);
		session.setAttribute("cnt", request.getParameter("count"));
		System.out.println(request.getParameter("count"));
		
		RequestDispatcher dis = request.getRequestDispatcher("/shop/pay.jsp");
		dis.forward(request, response);
		
		
	}
}
