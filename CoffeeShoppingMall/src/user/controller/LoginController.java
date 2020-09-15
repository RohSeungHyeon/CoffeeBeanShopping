package user.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;

import user.model.*;
import user.service.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginController", urlPatterns = "/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// HTTP 요청 메시지에서 id/pwd 가져오기
		String emailTxt = request.getParameter("email");
		String pwdTxt = request.getParameter("pwd");
		
		Service service = new ServiceImpl();
		JSONObject result = new JSONObject();
		
		// 서비스 객체를 이용해 id/pwd 확인
		if(service.isRegisterdUser(emailTxt)) {
			
			// 패스워드 일치 시
			if(pwdTxt.equals(service.getUserPwd(emailTxt))) {
				
				// 로그인 세션 생성
				HttpSession session = request.getSession();
				
				// 로그인 세션에 필요한 정보 등록
				JSONObject userProfile = new JSONObject();
				User user = service.getUserInfo(emailTxt);
				
				userProfile.put("nickname", user.getUserNickName());
				userProfile.put("name", user.getUserName());
				userProfile.put("email", user.getEmail());
				userProfile.put("userType", service.getUserType(emailTxt));
				
				session.setAttribute("userprofile", userProfile);
				
				// 응답 메시지 출력
				result.put("result", true);	
				result.put("message", "Is correct");
			} else {
				result.put("result", false);
				result.put("message", "Is not correct");
			}
		} else {
			result.put("result", false);
			result.put("message", "Is not correct");
		}
	
		out.print(result.toString());
		out.close();
	}

}
