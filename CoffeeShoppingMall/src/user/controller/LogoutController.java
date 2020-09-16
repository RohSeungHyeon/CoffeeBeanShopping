package user.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet(name="LogoutController", urlPatterns = "/logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userprofile") == null) {
			
			response.setContentType("text/html;charset=UTF-8");
			out.print("<html><head>");
			out.print("<script type='text/javascript'>alert('잘못된 접근입니다');location.href='"
					+getServletContext().getContextPath()+"/MainController';");
			out.print("</script></head><body></body></html>");
		} else {
			session.invalidate();
			out.print("<html><head>");
			out.print("<script type='text/javascript'>location.href='"
					+getServletContext().getContextPath()+"/MainController';");
			out.print("</script></head><body></body></html>");
		}
	}

}
