package user.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;
import org.json.simple.parser.*;

import user.service.*;


@WebServlet("/logout_naver")
public class NaverLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		boolean result = false;
		
		HttpSession session = req.getSession();
		Service service = new ServiceImpl();
		
		String email = (String)(((JSONObject)session.getAttribute("userprofile")).get("email"));
		String client_id = "saB2IXUZKHMePX6dD7xG";
		String client_secret = "ttq2Let4Q8";
		String grant_type = "delete";
		String access_token = (String)session.getAttribute("access_token");
		String service_provider = "NAVER";

		String apiURL = "https://nid.naver.com/oauth2.0/token?";
		apiURL += "&grant_type=" + grant_type;
		apiURL += "&client_id=" + client_id;
		apiURL += "&client_secret=" + client_secret;
		apiURL += "&access_token=" + URLEncoder.encode(access_token, "UTF-8");
		apiURL += "&service_provider=" + service_provider;
		
		StringBuffer res = new StringBuffer();
		
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			con.setRequestMethod("GET");
			
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
				
				String success = (String)object.get("result");
				String returned_access_token = (String)object.get("access_token");
				
				if(success != null && success.equals("success")) {
					if(returned_access_token != null && returned_access_token.equals(access_token))
						result = true;
					else 
						result = false;
				} else 
					result = false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("oauth_logout_result", result);
	}
    
}
