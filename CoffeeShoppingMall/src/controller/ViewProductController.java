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

/**
 * Servlet implementation class ViewProductController
 */
@WebServlet("/ViewProductController")
public class ViewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		proService service = new proServiceImpl();

		String str = request.getParameter("query");
		if(str.equals("all")) {
			request.setAttribute("products", service.getAllProduct());	
		}else if(str.equals("asia")){
			request.setAttribute("products", service.getProduct("�ƽþ�/�����"));
		}else if(str.equals("amer")){
			request.setAttribute("products", service.getProduct("�߳���"));			
		}else if(str.equals("afri")){
			request.setAttribute("products", service.getProduct("������ī"));
			
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/pro_list.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
