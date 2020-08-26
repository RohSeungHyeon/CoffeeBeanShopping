<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
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
	    String redirectURI = URLEncoder.encode("http://127.0.0.1:8080/CoffeeShoppingMall/shop/logincallback_naver.jsp", "UTF-8");
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
  %>

</body>
</html>