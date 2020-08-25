package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.Service;
import member.service.ServiceImpl;
import model.Member;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		response.setCharacterEncoding("utf-8");
		
		Service service = new ServiceImpl();
		boolean flag = false;
		
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pwd= request.getParameter("pw");
		Member m = service.getMember(id);
		if(m != null && pwd.equals(m.getPw())) {
			session.setAttribute("id", id);
			flag= true;
		}
		session.setAttribute("m", m);
		
		session.setAttribute("flag", flag);
		
		RequestDispatcher dis = request.getRequestDispatcher("/shop/index.jsp");
		dis.forward(request, response);
		
		
	}
	
	

}
