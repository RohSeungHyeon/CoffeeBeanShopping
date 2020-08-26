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
	
	<%-- OAuth 2.0을 이용한 로그인 처리 --%>
	<%!
		private String stateToken;
	%>
	<%
		// NAVER, DAUM OAuth 이용을 위한 설정
    	String clientId = "saB2IXUZKHMePX6dD7xG";//애플리케이션 클라이언트 아이디값";
   		String redirectURI = URLEncoder.encode("http://127.0.0.1:8080/CoffeeShoppingMall/shop/logincallback_naver.jsp", "UTF-8");
   		
   		// 세션 유지 및 위변조 방지를 위한 상태 토큰 생성
    	SecureRandom random = new SecureRandom();
    	String state = new BigInteger(130, random).toString();
    	
    	// 요청 URI
    	String apiURL_Naver = "https://nid.naver.com/oauth2.0/authorize?";
    	String apiURL_Kakao = ""; // Kakao는 추후 구현 예정
    	
    	// 네아로 로그인 인증 API에서 요구하는 URI의 헤더 값들
    	apiURL_Naver += "&client_id=" + clientId;
    	apiURL_Naver += "&response_type=code";
    	apiURL_Naver += "&redirect_uri=" + redirectURI;
    	apiURL_Naver += "&state=" + state;
    	
    	// 세션 객체에 위변조 방지를 위한 상태 토큰 저장
    	session.setAttribute("state", state);
    %>
    
    
    <div id="login" style="text-align: center;'">
    	<h3>로그인</h3>
    	
    	<form method="POST" action="" name="loginForm">
    	<table id="loginTable" border="0">
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