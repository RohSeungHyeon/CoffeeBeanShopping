package user.controller;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import user.model.*;
import user.model.enums.*;
import user.service.*;

/**
 * Servlet implementation class Join
 */
@WebServlet(name="JoinController", urlPatterns = "/Join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		Service service = new ServiceImpl();
		
		User user;
		
		user = new Indivisual("test2", "12345", "테스트이름", "테스트닉네임", "테스트주소", "테스트메일", "테스트번호");
		user.setGender(Genders.F);
		user.setBirth(new Date(System.currentTimeMillis()));

		
		if(service.createUser(user) == 1)
			out.println("<html><body>성공</body></html>");
		else {
			out.println("<html><body>실패</body></html>");
		}
		
		
		out.close();
	
	}

}
