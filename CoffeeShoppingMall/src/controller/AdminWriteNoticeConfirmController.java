package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.Notice;
import notice.service.NoticeService;
import notice.service.NoticeServiceImpl;

@WebServlet("/writeNotice.do")
public class AdminWriteNoticeConfirmController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NoticeService service = new NoticeServiceImpl();
		String content = request.getParameter("notContent");
		content = content.replaceAll("(\r\n|\r|\n|\n\r)", "<br/>");
		service.writeNotice(new Notice(0, request.getParameter("notTitle"),
				(String)((JSONObject) request.getSession().getAttribute("userprofile")).get("nickname"), null, content));

		request.setAttribute("notices", service.getAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/noticeControl.jsp");
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

}
