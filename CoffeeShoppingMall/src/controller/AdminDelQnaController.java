package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.service.QnaService;
import qna.service.QnaServiceImpl;

@WebServlet("/deleteQna.do")
public class AdminDelQnaController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		QnaService service = new QnaServiceImpl();
		service.delQna(Integer.parseInt(request.getParameter("qnaID")));
		
		request.setAttribute("qnas", service.getAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/qnaControl.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
