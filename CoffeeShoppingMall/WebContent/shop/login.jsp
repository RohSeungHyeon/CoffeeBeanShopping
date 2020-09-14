<%@ page import = "java.net.URLEncoder" %>
<%@ page import = "java.security.SecureRandom" %>
<%@ page import = "java.math.BigInteger" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인 페이지</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- icheck bootstrap -->
<link rel="stylesheet"
	href="../resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../resources/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="hold-transition login-page">
<%-- OAuth 2.0을 이용한 로그인 처리 --%>
	<%
		// NAVER, DAUM OAuth 이용을 위한 설정
    	String clientId_naver = "saB2IXUZKHMePX6dD7xG";
		String clientId_kakao = "0335ebe59915581efeeecc26d992908e";
   		String redirectURI_naver = URLEncoder.encode("http://127.0.0.1:8080/CoffeeShoppingMall/shop/logincallback_naver.jsp", "UTF-8");
   		String redirectURI_kakao = URLEncoder.encode("http://127.0.0.1:8080/CoffeeShoppingMall/shop/logincallback_kakao.jsp", "UTF-8");
   		
   		// 세션 유지 및 위변조 방지를 위한 상태 토큰 생성
    	SecureRandom random = new SecureRandom();
    	String state = new BigInteger(130, random).toString();
    	
    	// 요청 URI
    	String apiURL_Naver = "https://nid.naver.com/oauth2.0/authorize?";
    	String apiURL_Kakao = "https://kauth.kakao.com/oauth/authorize?"; // Kakao는 추후 구현 예정
    	
    	// 네아로 로그인 인증 API에서 요구하는 URI의 헤더 값들
    	apiURL_Naver += "&client_id=" + clientId_naver;
    	apiURL_Naver += "&response_type=code";
    	apiURL_Naver += "&redirect_uri=" + redirectURI_naver;
    	apiURL_Naver += "&state=" + state;
    	
    	// 카카오 로그인 인증 API에서 요구하는 URI의 헤더 값들
    	apiURL_Kakao += "&client_id=" + clientId_kakao;
    	apiURL_Kakao += "&response_type=code";
    	apiURL_Kakao += "&redirect_uri=" + redirectURI_kakao;
 
    	
    	// 세션 객체에 위변조 방지를 위한 상태 토큰 저장
    %>
    
	<div class="login-box">
		<div class="login-logo">
			<a href="${pageContext.request.contextPath}/shop/main.jsp"><b>Green
					Coffee</b></a>
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">로그인 해주세요!</p>

				<div class="input-group mb-3">
					<input type="text" name="email" id="email" class="form-control" placeholder="이메일" autocomplete="off">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-user"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="password" name="pwd" id="pwd" class="form-control" placeholder="비밀번호">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-8">
						<div class="icheck-primary">
							<input type="checkbox" id="remember"> <label for="remember"> 아이디 기억하기 </label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-4">
						<button type="button" class="btn btn-primary btn-block" onclick="checkIdAndPwd()">로그인</button>
					</div>
					<!-- /.col -->
				</div>
				
				<div class="row">
					<span class="" id="checkresult"></span>
				</div>

				<div class="social-auth-links text-center mb-3">
					<p>- OR -</p>
					<a href="<%=apiURL_Kakao%>" class="btn btn-block"> <img src="${pageContext.request.contextPath}/resources/img/login/kakao_login_custom.PNG" width="300px" />
					</a> <a href="<%=apiURL_Naver%>" class="btn btn-block"> <img src="${pageContext.request.contextPath}/resources/img/login/naver_login_custom.PNG" width="300px" />
					</a>
				</div>
				<!-- /.social-auth-links -->

				<p class="mb-1">
					<a href="#">비밀번호 찾기</a>
				</p>
				<p class="mb-0">
					<a href="join.jsp" class="text-center">회원가입</a>
				</p>
			</div>
			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- /.login-box -->


	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE -->
	<script src="../resources/dist/js/adminlte.js"></script>
	<!-- User defined script -->
	<script src="../scripts/requestHttp.js"></script>
	<script src="../scripts/checkIdAndPwd.js"></script>
		
</body>
</html>