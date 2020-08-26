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
<title>카카오 로그인</title>
</head>
<body>

	<%
	    String clientId = "0335ebe59915581efeeecc26d992908e";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "xE4DQyohOQ9XADYnzbo6AeghuYSFvAfl";//애플리케이션 클라이언트 시크릿값";
	        
	    // Authentication code
	    String code = request.getParameter("code");
	    String redirectURI = URLEncoder.encode("http://127.0.0.1:8080/CoffeeShoppingMall/shop/logincallback_kakao.jsp", "UTF-8");
	    String apiURL = "https://kauth.kakao.com/oauth/token?grant_type=authorization_code";
	    
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    
	    String access_token = "";
	    String refresh_token = "";
	    String token_type = "";
	    long expires_in = 0;
	    long refresh_token_expires_in = 0;
	    String scope = "";
	    
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("POST");
	      
	      // Access Token 요청
	      int responseCode = con.getResponseCode();
	      
	      BufferedReader br;
	      System.out.println("responseCode="+responseCode);
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
	        JSONParser parser = new JSONParser();
	        JSONObject obj = (JSONObject)parser.parse(res.toString());
	        
	        access_token = (String)obj.get("access_token");
	        refresh_token = (String)obj.get("refresh_token");
	        token_type = (String)obj.get("token_type");
	        expires_in = (long)obj.get("expires_in");
	        refresh_token_expires_in = (long)obj.get("refresh_token_expires_in");
	        scope = (String)obj.get("scope");
	        
	        session.setAttribute("access_token", access_token);
	        session.setAttribute("refresh_token", refresh_token);
	        session.setAttribute("token_type", token_type);
	        session.setAttribute("expires_in", expires_in);
	        
	        RequestDispatcher dispatcher = 
	        		request.getRequestDispatcher("/oauth/requestprofile_kakao"); 
	        
	        if(dispatcher != null)
	        	dispatcher.forward(request, response); 
	        
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
  %>

</body>
</html>