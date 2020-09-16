<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인 페이지</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- SweetAlert2 -->
<link rel="stylesheet"
	href="../resources/plugins/sweetalert2/sweetalert2.min.css">
<!-- Toastr -->
<link rel="stylesheet" href="../resources/plugins/toastr/toastr.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../resources/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<!-- Header -->
		<%@ include file="../shop/header.jsp"%>

		<div class="content-wrapper">
			<section class="content">
				<div id="check-pwd">
					<span>패스워드를 다시 한번 입력해주세요</span>
					<div>
						<form action="../checkPwd.do" method="post" onsubmit="return checkPwd()"> 
							<input type="password" id="pwd" name="pwd" size="30" />
							<input type="hidden" name="email" value="${userprofile.email}"/>
							<input type="submit" value="확인" />
						</form>
					</div>
					<c:if test="${sessionScope.checkPwdResult != null && sessionScope.checkPwdResult == false}">
						<span id="checkresult" style="color: red;">비밀번호가 일치하지 않습니다</span>
						<c:remove var="checkPwdResult" scope="session" />
					</c:if>
					
				</div>
			</section>
		</div>

		<!-- Main Footer -->
		<%@ include file="../shop/footer.jsp"%>
	</div>


	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- User defined JavaScript -->
	<script 
		src="../scripts/checkPwd.js"></script>
	<!-- Bootstrap -->
	<script src="../resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE -->
	<script src="../resources/dist/js/adminlte.js"></script>
</body>
</html>