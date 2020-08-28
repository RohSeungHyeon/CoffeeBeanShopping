package controller;

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

@WebServlet("/editNotice.do")
public class AdminEditNoticeConfirmController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NoticeService service = new NoticeServiceImpl();
		service.editNotice(new Notice(Integer.parseInt(request.getParameter("notID")), request.getParameter("notTitle"),
				request.getParameter("notWriter"), null, request.getParameter("notContent")));
		
		request.setAttribute("notices", service.getAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/noticeControl.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
