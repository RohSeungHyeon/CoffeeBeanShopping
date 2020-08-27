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
 * Servlet implementation class NoticeeditController
 */
@WebServlet("/NoticeeditController")
public class NoticeeditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeeditController() {
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
		
		int notID = Integer.parseInt(request.getParameter("notID"));
		String notWriter = request.getParameter("notWriter");
		String notTitle = request.getParameter("notTitle");
		String notContent = request.getParameter("notContent");
		
		Notice n = new Notice(notID,notTitle,notWriter,null,notContent);
		
		notservice.editNotice(n);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/notice.jsp");
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
