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


@WebServlet("/modify_userinfo.do")
public class ModifyUserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@SuppressWarnings({ "null", "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		JSONObject object = (JSONObject)session.getAttribute("userprofile");
		
		if(object == null) {
			
			out.print("<html>");
			out.print("<head>");
			out.print("<script>alert('잘못된 접근');location.href='../shop/main.jsp';</script>");
			out.print("</head><body></body>");
			out.print("</html>");
			
			out.close();
			return;
		}
		
		String email = (String)object.get("email");
		String userType = (String)object.get("userType");
		
		Service service = new ServiceImpl();
		User user = null;
		
		if(userType.equals("개인"))
			user = new Indivisual();
		else 
			user = new Business();
		
		user.setEmail(email);
		
		// 기본 사항 수정 => 패스워드 / 닉네임 / 주소 / 연락처
		user.setPassword(request.getParameter("essential.pwd"));
		user.setUserNickName(request.getParameter("essential.nickname"));
		user.setAddress(request.getParameter("essential.address"));
		
		String userPhone = request.getParameter("essential.phone_head") + "-"
				+ request.getParameter("essential.phone_front") + "-"
				+ request.getParameter("essential.phone_back");
		
		user.setPhone(userPhone);
		
		// 공통 추가사항 수정 => 성별 / 생년월일
		String gender = request.getParameter("optional.gender");
		user.setGender(Genders.valueOf(gender));
		
		Date birth = null;
		String birthYYYY = request.getParameter("optional.birth_yy");
		String birthMM = request.getParameter("optional.birth_mm");
		String birthDD = request.getParameter("optional.birth_dd");
		
		if(!(birthYYYY.equals("") || birthMM.equals("") || birthDD.equals(""))) 
			birth = Date.valueOf(birthYYYY+"-"+birthMM+"-"+birthDD);
		
		user.setBirth(birth);
		
		// 사업자 추가사항 수정 => 사업지 명 / 사업지 주소 / 사업지 연락처 / 회원 사내 직급
		if(userType.equals("사업자")) {
			((Business)user).setCompanyName(request.getParameter("optional.buyer.name"));
			((Business)user).setCompanyAddress(request.getParameter("optional.buyer.address"));
			
			String companyPhoneString = request.getParameter("optional.phone_head") + "-"
					+ request.getParameter("optional.phone_front") + "-" + request.getParameter("optional.phone_back");
			
			((Business)user).setCompanyPhone(companyPhoneString);
			((Business)user).setRank(request.getParameter("optional.buyer.rank"));
		}
			
		
		// 사용자 정보 서비스  업데이트 요청
		if(service.modifyUserInfo(user, userType)) {
			JSONObject userprofile = (JSONObject)session.getAttribute("userprofile");
			userprofile.put("nickname", request.getParameter("essential.nickname"));
			
			session.setAttribute("userprofile", userprofile);
			
			out.print("<html>");
			out.print("<head>");
			out.print("<script type='text/javascript'>alert('수정되었습니다'); location.href='../MainController';</script>");
			out.print("</head><body></body></html>");
		} else {
			out.print("실패");
		}
		
		out.close();
	}
}
