package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import product.service.proService;
import product.service.proServiceImpl;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		proService service = new proServiceImpl();

		String str = request.getParameter("search");
		ArrayList<Product> products = service.getRecoProduct();
		
		request.setAttribute("products", products);	
		for(Product a : products) {
			System.out.println(a.toString());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/main.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
		
	}

}
