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
import notice.service.NoticeService;
import notice.service.NoticeServiceImpl;
import product.service.proService;
import product.service.proServiceImpl;
import qna.service.QnaService;
import qna.service.QnaServiceImpl;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		proService service = new proServiceImpl();
		NoticeService notService = new NoticeServiceImpl();
		QnaService qnaService = new QnaServiceImpl();

		ArrayList<Product> products = service.getRecoProduct();

		request.setAttribute("products", products);
		request.setAttribute("notices", notService.getAll());
		request.setAttribute("qnas", qnaService.getAll());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/main.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}

	}

}
