package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderlist.service.OrderService;
import orderlist.service.OrderServiceImpl;

@WebServlet("/changeOrderStatus.do")
public class ChangeOrderStatusController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		OrderService service = new OrderServiceImpl();
		
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		String status = request.getParameter("status");
		
		service.editOrderStatus(order_id, status);
		
		request.setAttribute("orderMap", service.getOrderMap());
		request.setAttribute("orderStatus", service.getOrderStatus());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/orderControl.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
