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
		<%@ include file="header.jsp"%>

		<div class="content-wrapper">
			<section class="content">
			
	<form method="post" action="${pageContext.request.contextPath}/NotwriteController">
		<div class="container">
		<div class="row">
			<h3>공지사항작성</h3>
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>작성자<input type="text" class="form-control" placeholder="작성자" name="notWriter" maxlength="50" value="${sessionScope.id }" readonly style="background-color: #eeeeee; text-align: center; "/></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" placeholder="글 제목" name="notTitle" maxlength="50"/></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" name="notContent" maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>	
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기" />
			
		</div>
	</div>
	</form></section>
		</div>

		<!-- Main Footer -->
		<%@ include file="footer.jsp"%>
	</div>


	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="../resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE -->
	<script src="../resources/dist/js/adminlte.js"></script>
</body>
</html>