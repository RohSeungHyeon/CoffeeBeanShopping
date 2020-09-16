package user.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;

import user.service.*;


@WebServlet("/find_id.do")
public class FindAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/shop/main.jsp");
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		Service service = new ServiceImpl();
		JSONObject result = new JSONObject();
		
		String name = request.getParameter("username");
		String phone = request.getParameter("phone");
		
		String email = service.findUserAccount(name, phone);
		
		if(email != null) {
			result.put("result", true);
			result.put("message", name+" 님이 등록하신 이메일은 " + email + "입니다");
		} else {
			result.put("result", false);
			result.put("message", "입력하신 정보와 일치하는 이메일이 없습니다");
		}
		
		out.print(result.toString());
		
		out.close();
	}

}
