package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Notice;
import notice.service.NoticeService;
import notice.service.NoticeServiceImpl;

/**
 * Servlet implementation class NotwriteController
 */
@WebServlet("/NotwriteController")
public class NotwriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotwriteController() {
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
		
		NoticeService notservice = new NoticeServiceImpl();
		
		String notwriter = request.getParameter("notWriter");
		String nottitle = request.getParameter("notTitle");
		String notcontent = request.getParameter("notContent");
		
		Notice n = new Notice();
		n.setNotWriter(notwriter);
		n.setNotTitle(nottitle);
		n.setNotContent(notcontent);
		
		notservice.writeNotice(n);
		
		response.sendRedirect(request.getContextPath() + "/shop/notice.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/notice.jsp");
//		if(dispatcher !=null) {
//			dispatcher.forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
