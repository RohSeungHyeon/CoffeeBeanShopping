package user.controller;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class NaverCallback
 */
@WebServlet(name="NaverCallback", urlPatterns="/OAuth/naver")
public class NaverCallbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverCallbackController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String clientId = "saB2IXUZKHMePX6dD7xG";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "ttq2Let4Q8";//애플리케이션 클라이언트 시크릿값";
	    
	    // 메시지로 받은 위/변조 공격 방지 상태 토큰과 세션 객체에 저장 된 상태 토큰 값 비교
	    String state = request.getParameter("state");
	    
	    /* if(!storedState.equals(state)) {
	    	System.out.println("Not matched status code");
	    	return;
	    } */
	    
	    // Authentication code
	    String code = request.getParameter("code");
	    String redirectURI = URLEncoder.encode("http://127.0.0.1:8080/CoffeeShoppingMall/OAuth/naver", "UTF-8");
	    String apiURL;
	    
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    
	    System.out.println("apiURL="+apiURL);
	    
	    String access_token = "";
	    String refresh_token = "";
	    
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      // Access Token 요청
	      int responseCode = con.getResponseCode();
	      
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출 시 출력 스트림
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생 시 에러 출력 스트림
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      
	      if(responseCode==200) {
	        out.println(res.toString());
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	}

}
