/*
 * 작성자 : 주정택
 * email : j3470@hotmail.com
 * 설명 : 회원 정보 수정 페이지 진입 전 패스워드 확인 페이지를 처리해 주는 컨트롤러
 */

package user.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import user.service.*;

@WebServlet("/checkPwd.do")
public class CheckPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Service service = new ServiceImpl();
		
		String email = request.getParameter("email");
		String passString = request.getParameter("pwd");
		
		if(service.getUserPwd(email).equals(passString)) {
			response.sendRedirect("member/myinfo.jsp");
		} else {
			request.getSession().setAttribute("checkPwdResult", false);
			response.sendRedirect("member/checkpwd.jsp");
		}
		
		
	}

}
