package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import product.service.proService;
import product.service.proServiceImpl;

/**
 * Servlet implementation class PaySuccessController
 */
@WebServlet("/PaySuccessController")
public class PaySuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String cnt = (String)session.getAttribute("cnt");
		String[] order = cnt.split("@");
		proService ps = new proServiceImpl();
		
		User m = (User)session.getAttribute("m");
		
		//주문 날짜
		Date d = new java.sql.Date(System.currentTimeMillis());
		
		// 오더리스트 데이터 생성
		for(int i=0;i<order.length;i++) {
			String pro_id = order[i].split(",")[0];
			String count= order[i].split(",")[1];
			ps.addOrder((String)session.getAttribute("addr"), 
					 d, Integer.parseInt(count),m.getId(),
					Integer.parseInt(pro_id));
		}
		// 카트 목록 삭제
		ps.clearCart(m.getId());
		// 오더스테이터스 생성
		ps.addOrderStatus(d, m.getId());
		
		RequestDispatcher dis = request.getRequestDispatcher("/shop/pay_success.jsp");
		dis.forward(request, response);
		
		
	}

}
