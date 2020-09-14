package user.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.simple.*;
import org.json.simple.parser.*;

@WebServlet(name="NaverRequestProfileController", urlPatterns = "/oauth/requestprofile_naver")
public class NaverRequestProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out= response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(session.isNew()) {
			out.print("<script type='text/javascript'>");
			out.print("alert('잘못된 접근입니다')");
			out.print("location.href='login.jsp'");
			out.print("</script>");
		}
		
		String token_type = (String)session.getAttribute("token_type");
		String access_token = (String)session.getAttribute("access_token");
		String keyVal = token_type + " " + access_token;
		String apiUrl = "https://openapi.naver.com/v1/nid/me";
		
		StringBuffer res = new StringBuffer();
		
		URL url = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		try {
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", keyVal);
			
			int responseCode = con.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
				BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
				byte[] buffer = new byte[100];
				int readByteNo = 0;
				
				while((readByteNo = bis.read(buffer)) != -1) {
					String read = new String(buffer, 0, readByteNo, "EUC-KR");
					res.append(read);
				}
				
				bis.close();
						
			} else {
				out.print("error: " + responseCode);
				out.close();
				return;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject)parser.parse(res.toString());

			String resultcode = (String)obj.get("resultcode");
			String message = (String)obj.get("message");
			
			if(resultcode.equals("00") && message.equals("success")) {
		
				JSONObject resObject = (JSONObject)obj.get("response");
				resObject.put("infoFrom", "naver");
				session.setAttribute("userprofile", resObject);
				
			} else {
				
				JSONObject errorObject = new JSONObject();
				errorObject.put("id", "error");
				session.setAttribute("userprofile", errorObject);

			}
		} catch (ParseException e) {
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
