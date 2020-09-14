package qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Qna;
import qna.service.QnaService;
import qna.service.QnaServiceImpl;

/**
 * Servlet implementation class QnawriteController
 */
@WebServlet("/QnawriteController")
public class QnawriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnawriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		
		QnaService qnaservice = new QnaServiceImpl();
		
		String qnawriter = request.getParameter("qnaWriter");
		String qnatitle = request.getParameter("qnaTitle");
		String qnacontent = request.getParameter("qnaContent");
		qnacontent = qnacontent.replaceAll("(\r\n|\r|\n|\n\r)", "<br/>");
		
		Qna q = new Qna();
		q.setQnaWriter(qnawriter);
		q.setQnaTitle(qnatitle);
		q.setQnaContent(qnacontent);
		
		qnaservice.writeQna(q);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/qna.jsp");
		if(dispatcher !=null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
