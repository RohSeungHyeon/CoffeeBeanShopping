package user.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

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
		String apiUrl = "https://kapi.kakao.com";
		//apiUrl += "Authorization=" + keyVal;
		
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
					String read = new String(buffer, 0, readByteNo, "UTF-8");
					res.append(read);
				}
				
				bis.close();
				
				out.println(res.toString());
						
			} else {
				out.print("error: " + responseCode);
				out.close();
				return;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		/*
		 * try { JSONParser parser = new JSONParser(); JSONObject obj =
		 * (JSONObject)parser.parse(res.toString());
		 * 
		 * String resultcode = (String)obj.get("resultcode"); String message =
		 * (String)obj.get("message");
		 * 
		 * if(resultcode.equals("00") && message.equals("success")) {
		 * 
		 * JSONObject resObject = (JSONObject)obj.get("response");
		 * session.setAttribute("userprofile", resObject);
		 * 
		 * } else {
		 * 
		 * JSONObject errorObject = new JSONObject(); errorObject.put("id", "error");
		 * session.setAttribute("userprofile", errorObject);
		 * 
		 * } } catch (ParseException e) { e.printStackTrace(); }
		 * 
		 * RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
		 * 
		 * if(dispatcher != null) dispatcher.forward(request, response);
		 */
		 
		
		
		out.close();
	}

}
