package user.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * Servlet implementation class KakaoRequestProfileController
 */
@WebServlet(name="KaKaoRequestProfileController", urlPatterns = "/oauth/requestprofile_kakao")
public class KakaoRequestProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoRequestProfileController() {
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
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out= response.getWriter();
		
		HttpSession session = request.getSession();
		
		String token_type = (String)session.getAttribute("token_type");
		String access_token = (String)session.getAttribute("access_token");
		String keyVal = token_type + " " + access_token;
		String apiUrl = "https://kapi.kakao.com/v2/user/me";
		
		
		StringBuffer res = new StringBuffer();
		
		URL url = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		try {
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", keyVal);
			
			int responseCode = con.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
				// 응답 메시지를 스트림을 통해 읽어옴
				BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
				byte[] buffer = new byte[100];
				int readByteNo = 0;
				
				while((readByteNo = bis.read(buffer)) != -1) {
					String read = new String(buffer, 0, readByteNo, "UTF-8");
					res.append(read);
				}
				
				bis.close();
				
				// 스트림을 통해 읽어 온 메시지를 JSON 객체로 변환
				JSONParser parser = new JSONParser();
				JSONObject responseObj = (JSONObject)parser.parse(res.toString());
				
				JSONObject kakaoAccountObj = (JSONObject)responseObj.get("kakao_account");
				JSONObject profileObj = (JSONObject)kakaoAccountObj.get("profile");
				
				String id = String.valueOf((long)responseObj.get("id"));
				String nickName = (String)profileObj.get("nickname");
				String age = ((boolean)kakaoAccountObj.get("has_age_range") == true) ? (String)kakaoAccountObj.get("age_range") : "noInfo";
				String gender = ((boolean)kakaoAccountObj.get("has_gender") == true) ? (String)kakaoAccountObj.get("gender") : "noInfo";
				String email = ((boolean)kakaoAccountObj.get("has_email") == true) ? (String)kakaoAccountObj.get("email") : "noInfo";
				String name = (String)profileObj.get("nickname");
				String birthday = ((boolean)kakaoAccountObj.get("has_birthday") == true) ? (String)kakaoAccountObj.get("birthday") : "noInfo";
				
				
				JSONObject resultObj = new JSONObject();
				resultObj.put("infoFrom", "kakao");
				resultObj.put("id", id);
				resultObj.put("nickname", nickName);
				resultObj.put("age", age);
				resultObj.put("gender", (gender.equals("male")) ? "M" : "F");
				resultObj.put("email", email);
				resultObj.put("name", name);
				resultObj.put("birthday", birthday);
				
				session.setAttribute("userprofile", resultObj);
				
			} else {
				out.print("error: " + responseCode);
				out.close();
				return;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			out.close();
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/find_memberinfo.do");

		if (dispatcher != null)
			dispatcher.forward(request, response);
		 		
		out.close();
	}

}
