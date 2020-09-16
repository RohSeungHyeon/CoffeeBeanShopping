package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import notice.service.NoticeService;
import notice.service.NoticeServiceImpl;
import orderlist.service.OrderService;
import orderlist.service.OrderServiceImpl;
import product.service.proService;
import product.service.proServiceImpl;
import qna.service.QnaService;
import qna.service.QnaServiceImpl;
import user.service.Service;
import user.service.ServiceImpl;

@WebServlet("/goAdmin")
public class AdminController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String userType = (String) ((JSONObject) request.getSession().getAttribute("userprofile")).get("userType");
		if (userType.equals("관리자")) {
			proService service = new proServiceImpl();
			OrderService oService = new OrderServiceImpl();
			NoticeService notservice = new NoticeServiceImpl();
			QnaService qnaService = new QnaServiceImpl();
			Service userService = new ServiceImpl();

			request.setAttribute("products", service.getAllProduct());
			request.setAttribute("orderMap", oService.getOrderMap());
			request.setAttribute("orderStatus", oService.getOrderStatus());
			request.setAttribute("notices", notservice.getAll());
			request.setAttribute("qnas", qnaService.getAll());
			request.setAttribute("users", userService.getAllUser());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/adminMain.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/MainController");
		}

	}
}
