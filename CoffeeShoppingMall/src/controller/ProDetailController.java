package controller;

import java.io.IOException;

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
 * Servlet implementation class ProDetailController
 */
@WebServlet("/ProDetailController")
public class ProDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		
		proService ps = new proServiceImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = ps.getProduct(id);
		request.setAttribute("product", p);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/shop/pro_detail.jsp");
		dis.forward(request, response);		
		
	}
}
