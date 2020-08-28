package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Notice;
import notice.service.NoticeService;
import notice.service.NoticeServiceImpl;
import orderlist.service.OrderService;
import orderlist.service.OrderServiceImpl;
import product.service.proService;
import product.service.proServiceImpl;

@WebServlet("/goAdmin")
public class AdminController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		proService service = new proServiceImpl();
		OrderService oService = new OrderServiceImpl();
		NoticeService notservice = new NoticeServiceImpl();
	
		request.setAttribute("products", service.getAllProduct());
		request.setAttribute("orderMap", oService.getOrderMap());
		request.setAttribute("orderStatus", oService.getOrderStatus());
		request.setAttribute("notices", notservice.getAll());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/adminMain.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}
}
