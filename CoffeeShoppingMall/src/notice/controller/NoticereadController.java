package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.service.NoticeService;
import notice.service.NoticeServiceImpl;
import model.Notice;

/**
 * Servlet implementation class NoticereadController
 */
@WebServlet("/NoticereadController")
public class NoticereadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticereadController() {
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
		
		int num = Integer.parseInt(request.getParameter("notID"));
		
		Notice n = notservice.getNotice(num);
		
		request.setAttribute("n", n);
		
//		response.sendRedirect(request.getContextPath() + "/shop/noticeinfo.jsp");
		
//		String path = request.getContextPath()+"/shop/noticeinfo.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/noticeinfo.jsp");
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
