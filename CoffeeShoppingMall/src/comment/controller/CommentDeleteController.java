package comment.controller;

import java.io.IOException;
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
 * Servlet implementation class CommentDeleteController
 */
@WebServlet("/CommentDeleteController")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteController() {
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
		int comId = Integer.parseInt(request.getParameter("comID"));
		
		HttpSession session = request.getSession();
		Boolean isLogin = (Boolean) session.getAttribute("flag");
		if (isLogin) {
//			Service service = new ServiceImpl();
			String id = (String) session.getAttribute("id");
//			Member m = service.getMember(id);
			
			QnaService qnaservice = new QnaServiceImpl();
			Qna q = (Qna) session.getAttribute("q");
			
			int qnaId = q.getQnaID();
			Comment com = comservice.getComment(comId, qnaId);
			
			// 이게 사용자 것이 맞는지 확인
			if (com.getComWriter().equals(id) == false)
				return;
			
			// 게시물 삭제
			comservice.deleteCom(com);
			
//			response.setHeader("Refresh", "0; URL=" + request.getContextPath() + "/QnareadController?qnaID=" + qnaId);
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
