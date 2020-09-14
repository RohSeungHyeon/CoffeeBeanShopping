package qna.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.service.CommentService;
import comment.service.CommentServiceImpl;
import model.Comment;
import model.Qna;
import qna.service.QnaService;
import qna.service.QnaServiceImpl;

/**
 * Servlet implementation class QnareadController
 */
@WebServlet("/QnareadController")
public class QnareadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnareadController() {
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
		CommentService comservice = new CommentServiceImpl();
		
		int qnaID = Integer.parseInt(request.getParameter("qnaID"));
		Qna q = qnaservice.getQna(qnaID);
		String content = q.getQnaContent();
		content = content.replaceAll("<br/>", "\n");
		request.setAttribute("q", q);
		request.setAttribute("content", content);
		
		
//		System.out.println("qnaID: " + qnaID);
		ArrayList<Comment> comlist = comservice.getComList(qnaID);
//		for (Comment c : comlist) {
//			System.out.println(c.getComID());
//		}
		request.setAttribute("comlist", comlist);
		
		HttpSession session = request.getSession();
		Optional<Boolean> isLogin = Optional.ofNullable((Boolean) session.getAttribute("flag"));
		if (isLogin.isPresent()) {
			session.setAttribute("q", q);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/qnainfo.jsp");
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
