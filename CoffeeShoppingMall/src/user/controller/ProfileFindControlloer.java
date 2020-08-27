package user.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;

import user.service.*;

/**
 * Servlet implementation class ProfileFindControlloer
 */
@WebServlet(name = "ProfileFindController", urlPatterns = "/find")
public class ProfileFindControlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileFindControlloer() {
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
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		Service service = new ServiceImpl();
		
		JSONObject profileObject = (JSONObject)session.getAttribute("userprofile");
		String email = (String)profileObject.get("email");
			
		if(service.isRegisterd(email)) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
			
			if(dispatcher != null)
				dispatcher.forward(request, response);
			
		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('서비스 이용 시 추가 정보를 기입해주셔야 합니다');");
			out.print("location.href='join_jjt.jsp';");
			out.print("</script>");
		}
		
		
		out.close();
	}

}
