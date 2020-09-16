package user.controller;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;

import user.model.*;
import user.model.enums.*;
import user.service.*;

/**
 * Servlet implementation class Join
 */
@WebServlet(name="JoinController", urlPatterns = "/join")
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
	
		HttpSession session = request.getSession(false);
		Service service = new ServiceImpl();
		
		User user = null;
		Business business = null;
		
		String oauth_rserver = null;
		String oauth_user_id = null;
		
		String email = null;
		String password = null;
		String userName = null;
		String userType = null;
		String userNickname = null;
		String address = null;
		
		String phone = null;
		String phone_head = null;
		String phone_front = null;
		String phone_back = null;
		
		Genders gender = null;
		Date birth = null;
		String birthYYYY = null;
		String birthMM = null;
		String birthDD = null;
		
		
		@SuppressWarnings("unused")
		String companyName = null;
		@SuppressWarnings("unused")
		String companyAddress = null;
		@SuppressWarnings("unused")
		String companyPhone = null;
		@SuppressWarnings("unused")
		String rank = null;
		
		// OAuth를 이용한 회원 가입 처리를 위한 코드
		if (session.getAttribute("userprofile") != null) {
			JSONObject profile = (JSONObject) session.getAttribute("userprofile");
			oauth_rserver = (String) profile.get("infoFrom");
			oauth_user_id = (String) profile.get("id");
		} else {
			oauth_rserver = "없음";
			oauth_user_id = "없음";
		}

		// 요청 문자열 속 데이터 추출
		email = request.getParameter("essential.emailId") + "@" + request.getParameter("essential.emailDomain");
		password = request.getParameter("essential.pwd");
		userName = request.getParameter("essential.name");
		userType = request.getParameter("essential.userType");
		userNickname = request.getParameter("essential.nickname");

		// 필수 사항 정보 => 이메일 / 패스워드 / 사용자명 / 사용자 유형 / 별명
		email = request.getParameter("essential.emailId") + "@" + request.getParameter("essential.emailDomain");
		password = request.getParameter("essential.pwd");
		userName = request.getParameter("essential.name");
		userType = request.getParameter("essential.userType");
		userNickname = request.getParameter("essential.nickname");
		
		phone_head = request.getParameter("essential.phone_head");
		phone_front = request.getParameter("essential.phone_front");
		phone_back = request.getParameter("essential.phone_back");
		phone = phone_head + "-" + phone_front + "-" + phone_back;
		
		address = request.getParameter("essential.address");
		
		
		// 선택 사항 정보 => 성별 / 생년월일
		gender = request.getParameter("optional.gender").equals("N") ? null : 
			(request.getParameter("optional.gender").equals("M") ? Genders.M : Genders.F);		
	
		birthYYYY = request.getParameter("optional.birth_yy");
		birthMM = request.getParameter("optional.birth_mm");
		birthDD = request.getParameter("optional.birth_dd");
		
		if(!(birthYYYY.equals("") || birthMM.equals("") || birthDD.equals(""))) 
			birth = Date.valueOf(birthYYYY+"-"+birthMM+"-"+birthDD);
		
		
		// 선택 사항 정보 => 사업자 추가 정보 
		
		if(userType.equals("사업자")) {
			companyName = request.getParameter("optional.buyer.name");
			companyAddress = request.getParameter("optional.buyer.address");
			phone_head = request.getParameter("optional.phone_head");
			phone_front = request.getParameter("optional.phone_front");
			phone_back = request.getParameter("optional.phone_back");
			companyPhone = phone_head + "-" + phone_front + "-" + phone_back;
			rank = request.getParameter("optional.buyer.rank");
			
			user = new Business();
			business = (Business)user;
			
		} else {
			companyName = "";
			companyAddress = "";
			companyPhone = "";
			
			user = new Indivisual();
		}
	
		// VO 객체에 값 설정
		
		user.setOauth_rserver(oauth_rserver);
		user.setOauth_user_id(oauth_user_id);
		
		user.setEmail(email);
		user.setPassword(password);
		user.setUserName(userName);
		user.setUserNickName(userNickname);
		user.setAddress(address);
		user.setPhone(phone);
		
		if(gender != null) user.setGender(gender);
		if(birth != null) user.setBirth(birth);
		
		if(business != null) {
			business.setCompanyName(companyName);
			business.setCompanyAddress(companyAddress);
			business.setCompanyPhone(companyPhone);
			business.setRank(rank);
		}
		
		if(service.createUser(user) == 1) {
			
			out.print("<script type='text/javascript'>");
			out.print("alert('등록되었습니다');");
			out.print("location.href='shop/main.jsp';");
			out.print("</script>");
		}
		else {
			out.println("<html><body>실패</body></html>");
			if(session != null) session.invalidate();
		}
		
		
		out.close();
	
	}

}
