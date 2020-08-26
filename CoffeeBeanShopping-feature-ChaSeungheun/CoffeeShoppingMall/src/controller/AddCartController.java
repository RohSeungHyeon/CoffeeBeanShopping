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
 * Servlet implementation class AddCartController
 */
@WebServlet("/AddCartController")
public class AddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");

		String m_id = request.getParameter("m_id");
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		
		System.out.println(m_id + p_id);
		proService ps = new proServiceImpl();
		String message = null;
		
		request.setAttribute("product", ps.getProduct(p_id));
		
		if(m_id == null) {
			message="로그인 해주세요";
			System.out.println("?");
		}
		else if(ps.addCart(m_id, p_id)) {
			message = "장바구니에 담겼습니다.";
			System.out.println("??");		
		}else {
			message = "이미 있는 품목입니다.";
			System.out.println("???");
		}
		request.setAttribute("message", message);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("/shop/index.jsp");
		dis.forward(request, response);
		
		
	}
}
