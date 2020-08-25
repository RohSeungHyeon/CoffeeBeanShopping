package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.service.proService;
import product.service.proServiceImpl;

/**
 * Servlet implementation class DelCartController
 */
@WebServlet("/DelCartController")
public class DelCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		proService ps = new proServiceImpl();
		HttpSession session = request.getSession();
		ps.delCart((String)session.getAttribute("id"), num);
		
	}
}
