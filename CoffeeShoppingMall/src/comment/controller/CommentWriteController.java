package comment.controller;

import java.io.IOException;
import java.util.Enumeration;

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
 * Servlet implementation class CommentWriteController
 */
@WebServlet("/CommentWriteController")
public class CommentWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentWriteController() {
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
		

		CommentService comservice= new CommentServiceImpl();
		
		HttpSession session = request.getSession();
		Boolean isLogin = (Boolean) session.getAttribute("flag");
		
//			Service service = new ServiceImpl();
			String id = (String) session.getAttribute("id");
			String comcontent = request.getParameter("comContent");
			Qna q = (Qna) session.getAttribute("q");
//			Member m = service.getMember(id);
						
			QnaService qnaservice = new QnaServiceImpl();
			
			//int qnaId = (int) request.getAttribute("qnaID");
			String qnaId1 = request.getParameter("qnaID");
			int qnaId = Integer.parseInt(qnaId1);
		
			Comment com = new Comment();
			
			com.setComContent(comcontent);
			com.setComWriter(id);
			com.setComQnaid(qnaId);
			
			comservice.addCom(com);
			response.setHeader("Refresh", "0; URL=" + request.getContextPath() + "/QnareadController?qnaID=" + qnaId);
		
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
