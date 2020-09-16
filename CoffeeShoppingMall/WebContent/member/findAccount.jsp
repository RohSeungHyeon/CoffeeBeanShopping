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
				<h3>가입 이메일 / 비밀번호 찾기</h3>
				<hr>
				<h4>가입 이메일 찾기</h4><br>
				<p>가입 시 등록하신 성함과 연락처를 입력해주세요<p>
				<form action="#" method="post" onsubmit="return checkAccount()">
				<table>
				<tr>
				<th>이름</th> 
				<td><input type="text" id="username" placeholder="이름을 입력해주세요" size="24"/></td>
				</tr>
				<tr>
				<th>연락처 </th>
				<td>
				<input type="text" id="phone_head" autocomplete = "off" maxlength="3" style="width: 70px;"/>
				-
				<input type="text" id="phone_front" autocomplete = "off" maxlength="4" style="width: 70px;"/>
				-
				<input type="text" id="phone_back" autocomplete = "off" maxlength="4" style="width: 70px;"/>
				</td>
				<tr>
				<td>
				<input type="submit" value="확인" />
				</td>
				</tr>
				</table>	
				</form>	
				<div>
					<span id="result_account"></span>
				</div>
				<hr>
				<h4>패스워드 분실</h4><br>
				<p>가입 시 등록하신 이메일, 성함, 연락처를 입력하시면 임시 비밀번호를 발급해드립니다</p>
				<form action="#" method="POST" onsubmit="return checkResetPwd()">
				<table>
				<tr>
				<th>이메일</th>
				<td><input type="text" id="email" placeholder="이메일을 입력해주세요" /></td>
				</tr>
				<tr>
				<th>이름</th> 
				<td><input type="text" id="pwd_username" placeholder="이름을 입력해주세요" size="24"/></td>
				</tr>
				<tr>
				<th>연락처</th>
				<td>
				<input type="text" id="pwd_phone_head" autocomplete = "off" maxlength="3" style="width: 70px;"/>
				-
				<input type="text" id="pwd_phone_front" autocomplete = "off" maxlength="4" style="width: 70px;"/>
				-
				<input type="text" id="pwd_phone_back" autocomplete = "off" maxlength="4" style="width: 70px;"/>
				</td>
				</tr>
				<tr>
				<td><input type="submit" value="제출" /></td>
				</tr>
				</table>
				<div>
					<span id="result_pwd"></span>
				</div>
				</form>
			</section>
		</div>

		<!-- Main Footer -->
		<%@ include file="../shop/footer.jsp"%>
	</div>


	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- User defined script -->
	<script src="../scripts/requestHttp.js"></script>
	<script src="../scripts/checkAccount.js"></script>
	<!-- Bootstrap -->
	<script src="../resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE -->
	<script src="../resources/dist/js/adminlte.js"></script>
</body>
</html>