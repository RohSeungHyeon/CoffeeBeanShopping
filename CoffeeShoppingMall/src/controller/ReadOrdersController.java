package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderlist.service.OrderService;
import orderlist.service.OrderServiceImpl;

@WebServlet("/ReadOrdersController")
public class ReadOrdersController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		OrderService service = new OrderServiceImpl();
		String id = (String) request.getSession().getAttribute("id");

		request.setAttribute("orderMap", service.getOrder(id));
		request.setAttribute("orderStatus", service.getOrderStatusById(id));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/orderlist.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
