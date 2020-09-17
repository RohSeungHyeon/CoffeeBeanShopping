package controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import model.*;
import notice.service.*;
import product.service.*;
import qna.service.*;

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
