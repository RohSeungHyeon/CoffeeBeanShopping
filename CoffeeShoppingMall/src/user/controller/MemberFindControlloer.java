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
@WebServlet(name = "MemberFindController", urlPatterns = "/find_memberinfo.do")
public class MemberFindControlloer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFindControlloer() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		Service service = new ServiceImpl();
		
		JSONObject profileObject = (JSONObject)session.getAttribute("userprofile");
		String email = (String)profileObject.get("email");
		
		// 자체 DB에 존재하는 사용자일 경우, 서비스 유저 인증으로 간주
		// 자체 로그인 서비스를 이용하지 않고 각 플랫폼의 로그인을 통해 인증 되었기 때문.
		// 사용자에 대한 세션은 각 플랫폼에서 access token을 받아오는 시점에 생성 
		if(service.isRegisterdUser(email)) {
			
			profileObject.put("userType", service.getUserType(email));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
			
			if(dispatcher != null)
				dispatcher.forward(request, response);
			
		// 자체 DB에 존재하지 않는 자체 서비스 최초 이용자일 경우 별도 정보 등록 필요
		} else {
			out.print("<script type='text/javascript'>");
			out.print("alert('서비스 이용 시 추가 정보를 기입해주셔야 합니다');");
			out.print("location.href='register.jsp';");
			out.print("</script>");
		}
		
		
		out.close();
	}

}
