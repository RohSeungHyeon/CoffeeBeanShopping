package user.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import user.service.*;


@WebServlet(name="LogoutController", urlPatterns = "/logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		Service service = new ServiceImpl();
		
		// 잘못된 접근 처리
		if(session.getAttribute("userprofile") == null) {
			
			response.setContentType("text/html;charset=UTF-8");
			
			out.print("<script type='text/javascript'>alert('잘못된 접근입니다');location.href='"
					+getServletContext().getContextPath()+"/MainController';");
			out.print("</script>");
			
		} else {
			// OAuth를 이용해 로그인 했을 경우 리소스 서버에 로그아웃 REST API 처리 요청
			if (session.getAttribute("platform") != null) {
				
				String oauth_rserver = (String) session.getAttribute("platform");
				if (oauth_rserver.equals("naver") || oauth_rserver.equals("kakao")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/logout_" + oauth_rserver);

					// 처리 결과를 request 객체에 저장 => 속성이름 : oauth_logout_result
					dispatcher.include(request, response);
					
				} else {
					out.print("로그인 에러 : Oauth");
				}
			}
			
			// 로그인 시 세션 객체에 할당 된 정보 및 세션 객체 소거
			session.invalidate();
			
			out.print("<script type='text/javascript'>");
			if(request.getAttribute("oauth_logout_result") != null)
				if((Boolean)request.getAttribute("oauth_logout_result") == false)
					out.print("alert('OAuth 로그아웃 처리 실패');");
			
			out.print("location.href='" + getServletContext().getContextPath() + "/MainController';");
			out.print("</script>");
		}
	}

}
