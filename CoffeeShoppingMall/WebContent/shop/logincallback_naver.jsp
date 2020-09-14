<%@page import="org.json.simple.parser.JSONParser"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="org.json.simple.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 로그인</title>
</head>
<body>

	<%
	    String clientId = "saB2IXUZKHMePX6dD7xG"; //애플리케이션 클라이언트 아이디
	    String clientSecret = "ttq2Let4Q8"; //애플리케이션 클라이언트 시크릿
	    
	    // 메시지로 받은 위/변조 공격 방지 상태 토큰과 세션 객체에 저장 된 상태 토큰 값 비교
	    String state = request.getParameter("state");
	    
	    // 메시지로 받은 Authentication code
	    String code = request.getParameter("code");
	    
	    // Access token을 요청 할 리소스 서버 주소와 리소스 서버에서 콜백 할 주소 설정
	    String redirectURI = URLEncoder.encode("http://127.0.0.1:8080/CoffeeShoppingMall/shop/logincallback_naver.jsp", "UTF-8");
	    
	    String apiURL;
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    
	    // 리소스 서버에서 정상 응답 시 보내는 데이터를 저장할 변수 선언
	    String access_token = "";
	    String refresh_token = "";
	    String token_type = "";
	    String expires_in = "";
	    
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      
	      // 리소스 서버에 Access Token 요청
	      int responseCode = con.getResponseCode();
	      
	      BufferedReader br;
	      // System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 응답 시 출력 스트림
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
	      
	   	  // Access token 요청에 대한 응답이 성공적으로 올 경우,
	      if(responseCode==200) {
	        
	    	// 응답 메시지를 JSON 객체로 변환하여 Access token과 관련 정보를 얻어 세션 객체에 저장
	        JSONParser parser = new JSONParser();
	        JSONObject obj = (JSONObject)parser.parse(res.toString());
	        
	        access_token = (String)obj.get("access_token");
	        refresh_token = (String)obj.get("refresh_token");
	        token_type = (String)obj.get("token_type");
	        expires_in = (String)obj.get("expires_in");
	        
	        session.setAttribute("platform", "naver");
	        session.setAttribute("access_token", access_token);
	        session.setAttribute("refresh_token", refresh_token);
	        session.setAttribute("token_type", token_type);
	        session.setAttribute("expires_in", expires_in);
	        
	        // 사용자 정보 요청 컨트롤러로 포워드
	        RequestDispatcher dispatcher = 
	        		request.getRequestDispatcher("/oauth/requestprofile_naver");
	        
	        if(dispatcher != null)
	        	dispatcher.forward(request, response);
	        
	      } 
	      else {
	    	  session.invalidate();
	    	  out.print("<script type='text/javascript'>");
	    	  out.print("alert('로그인 중 오류 발생. 다시 시도해주세요')");
	    	  out.print("location.href='login.jsp'");
			  out.print("</script>");    	 
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
  %>

</body>
</html>