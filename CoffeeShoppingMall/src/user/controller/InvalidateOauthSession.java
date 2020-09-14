package user.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;


@WebServlet("/oauth/invalidate.do")
public class InvalidateOauthSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		JSONObject result = new JSONObject();
		
		if(!session.isNew()) {
			session.invalidate();
			result.put("result", true);
		} else {
			result.put("result", false);
		}
		
		response.getWriter().print(result.toString());
	}

}
