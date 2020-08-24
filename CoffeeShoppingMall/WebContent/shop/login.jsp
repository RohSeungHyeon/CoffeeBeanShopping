<%@ page import = "java.net.URLEncoder" %>
<%@ page import = "java.security.SecureRandom" %>
<%@ page import = "java.math.BigInteger" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css" />
	</head>
	<body>
	<%
		// NAVER, DAUM OAuth 이용을 위한 설정
    	String clientId = "YOUR_CLIENT_ID";//애플리케이션 클라이언트 아이디값";
   		String redirectURI = URLEncoder.encode("YOUR_CALLBACK_URL", "UTF-8");
    	SecureRandom random = new SecureRandom();
    	String state = new BigInteger(130, random).toString();
    	String apiURL_Naver = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    	String apiURL_Kakao = "";
    	apiURL_Naver += "&client_id=" + clientId;
    	apiURL_Naver += "&redirect_uri=" + redirectURI;
    	apiURL_Naver += "&state=" + state;
    	apiURL_Kakao += "&client_id=" + clientId;
    	apiURL_Kakao += "&redirect_uri=" + redirectURI;
    	apiURL_Kakao += "&state=" + state;
    	session.setAttribute("state", state);
    	
    
    %>
    
    
    <div id="login" style="text-align: center;'">
    	<h3>로그인</h3>
    	
    	<form method="POST" action="" name="loginForm">
    	<table id="loginTable" border = "0">
    		<tr>
    			<th>아이디 </th>
    			<td> <input type="text" id="id" name="id"/> </td>
    		</tr>
    		<tr>
    			<th>패스워드</th>
    			<td> <input type="password" id="id" name="id"/> </td>
    		</tr>
    	</table>
    	</form>
    	<br> 
    	<a href="<%=apiURL_Naver%>"><img height="50" src="${pageContext.request.contextPath}/resources/image/button/naver_login/PNG/Log in with NAVER_Official_Green.PNG"/></a>
    	<br>
    	<a href="<%=apiURL_Kakao%>"><img height="50" src="${pageContext.request.contextPath}/resources/image/button/kakao_login/en/kakao_login_large_wide.png"/></a>
    </div>
  	
  </body>
</html>