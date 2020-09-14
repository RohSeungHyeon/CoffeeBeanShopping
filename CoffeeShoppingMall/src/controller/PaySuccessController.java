package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.service.proService;
import product.service.proServiceImpl;
import user.model.User;

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
		
		//�ֹ� ��¥
		Date d = new java.sql.Date(System.currentTimeMillis());
		
		// ��������Ʈ ������ ����
		for(int i=0;i<order.length;i++) {
			String pro_id = order[i].split(",")[0];
			String count= order[i].split(",")[1];
			ps.addOrder((String)session.getAttribute("addr"), 
					 d, Integer.parseInt(count),m.getEmail(),
					Integer.parseInt(pro_id));
		}
		// īƮ ��� ����
		ps.clearCart(m.getEmail());
		// �����������ͽ� ����
		ps.addOrderStatus(d, m.getEmail());
		
		RequestDispatcher dis = request.getRequestDispatcher("/shop/pay_success.jsp");
		dis.forward(request, response);
		
		
	}

}
