<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="login-box">
		<div class="login-logo">
			<a href="${pageContext.request.contextPath}/shop/main.jsp"><b>Green
					Coffee</a>
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">로그인 해주세요!</p>

				<form action="#" method="post">
					<div class="input-group mb-3">
						<input type="id" class="form-control" placeholder="아이디">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-user"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" class="form-control" placeholder="비밀번호">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="remember"> <label
									for="remember"> 아이디 기억하기 </label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block">로그인</button>
						</div>
						<!-- /.col -->
					</div>
				</form>

				<div class="social-auth-links text-center mb-3">
					<p>- OR -</p>
					<a href="#" class="btn btn-block"> <img
						src="${pageContext.request.contextPath}/resources/img/login/kakao_login_custom.PNG" width="300px" />
					</a> <a href="#" class="btn btn-block"> <img
						src="${pageContext.request.contextPath}/resources/img/login/naver_login_custom.PNG" width="300px" />
					</a>
				</div>
				<!-- /.social-auth-links -->

				<p class="mb-1">
					<a href="#">비밀번호 찾기</a>
				</p>
				<p class="mb-0">
					<a href="#" class="text-center">회원가입</a>
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
</body>
</html>