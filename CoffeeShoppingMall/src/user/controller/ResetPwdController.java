package user.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;

import user.service.*;


@WebServlet("/reset_pwd.do")
public class ResetPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("MainController");
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		Service service = new ServiceImpl();
		
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String name = request.getParameter("username");
		
		if(service.findUserAccount(name, phone).equals(email)) {
			
			// 임시 비밀번호 생성
			StringBuffer pwd_temp = new StringBuffer();
			Random rnd = new Random();
			
			for(int i = 0; i < 10; i++) {
				if(i % 3 == 0) {
					pwd_temp.append(String.valueOf((char) ((int) (rnd.nextInt(26)) + 97)));
				} else if(i % 3 == 1) {
					pwd_temp.append(String.valueOf((char) ((int) (rnd.nextInt(26)) + 65)));
				} else {
					pwd_temp.append(String.valueOf((char) ((int) (rnd.nextInt(4) + 35))));
				}
			}
			
			service.setUserPwd(email, pwd_temp.toString());
			
			request.setAttribute("from", "jjk3470@naver.com");
			request.setAttribute("to", email);
			request.setAttribute("userName", name);
			request.setAttribute("pwd_temp", pwd_temp.toString());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/sendmail.do");
			if(dispatcher != null)
				dispatcher.forward(request, response);
			
		} else {
			JSONObject object = new JSONObject();
			object.put("result", false);
			object.put("message", "가입 정보가 존재하지 않습니다");
			
			out.print(object.toString());
			
		}
		
		out.close();
	}

}
