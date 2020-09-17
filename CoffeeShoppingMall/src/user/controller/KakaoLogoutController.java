package user.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;
import org.json.simple.parser.*;

import user.service.*;


@WebServlet("/logout_kakao")
public class KakaoLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		boolean result = false;
		
		HttpSession session = req.getSession();
		Service service = new ServiceImpl();
		
		String email = (String)(((JSONObject)session.getAttribute("userprofile")).get("email"));
		String accessToken = (String)session.getAttribute("access_token");
		String keyVal = "Bearer " + accessToken;
		
		String apiURL = "https://kapi.kakao.com/v1/user/logout?";
		
		StringBuffer res = new StringBuffer();
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
	
			con.setRequestProperty("Authorization", keyVal);
			con.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			con.setRequestMethod("POST");
	
			int responseCode = con.getResponseCode();
			
			BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
			byte[] buffer = new byte[100];
			int readByteNo = 0;
			
			while((readByteNo = bis.read(buffer)) != -1) {
				String read = new String(buffer, 0, readByteNo, "UTF-8");
				res.append(read);
			}
			
			bis.close();
			
			if(responseCode == 200) {
				JSONParser parser = new JSONParser();
				
				JSONObject object = (JSONObject)parser.parse(res.toString()); 
				String id = String.valueOf((Long)object.get("id"));
				
				if(id.equals(service.getUserOauthId(email)))
					result = true;
				else
					result = false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("oauth_logout_result", result);
	}
       

}
