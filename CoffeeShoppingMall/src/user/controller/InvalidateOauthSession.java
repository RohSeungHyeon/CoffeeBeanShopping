package user.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;
import org.json.simple.parser.*;


@WebServlet("/oauth/invalidate.do")
public class InvalidateOauthSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		JSONObject result = new JSONObject();
		
		
		if(!session.isNew()) {
			String clientId = "saB2IXUZKHMePX6dD7xG";
			String clientSecret = "ttq2Let4Q8";
			String access_token = (String)session.getAttribute("access_token");
			String grant_type = "delete";
			
			String apiUrl = "https://nid.naver.com/oauth2.0/token?";
			apiUrl += "grant_type=" + grant_type  + "&";
			apiUrl += "client_id=" + clientId  + "&";
			apiUrl += "client_secret=" + clientSecret  + "&";
			apiUrl += "access_token=" + access_token + "&";
			apiUrl += "service_provider=NAVER";
			
			StringBuffer res = new StringBuffer();
			URL url = new URL(apiUrl);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			
			try {
				con.setRequestMethod("GET");
				
				int responseCode = con.getResponseCode();
				
				if(responseCode == HttpURLConnection.HTTP_OK) {
					BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
					byte[] buffer = new byte[100];
					int readByteNo = 0;
					
					while((readByteNo = bis.read(buffer)) != -1) {
						String read = new String(buffer, 0, readByteNo, "UTF-8");
						res.append(read);
					}
					
					bis.close();
				} else {
					out.print("error" + responseCode);
				}
			
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			try {
				JSONParser parser = new JSONParser();
				JSONObject respObject = (JSONObject)parser.parse(res.toString());
				
				String resultCode = (String) respObject.get("result");

				if (resultCode.equals("success")) {
					result.put("result", true);
					session.invalidate();
				}
				 
			} catch (ParseException e) {
				e.printStackTrace();
			}
				
		} else {
			result.put("result", false);
		}
		
		response.getWriter().print(result.toString());
	}

}
