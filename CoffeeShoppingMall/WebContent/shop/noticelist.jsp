<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
			<thead>
			<h2>공지사항</h2>
			
				<tr>
					<th style="background-color: #eeeeee; text-align:center;">번호</th>
					<th style="background-color: #eeeeee; text-align:center;">제목</th>
					<th style="background-color: #eeeeee; text-align:center;">작성자</th>
					<th style="background-color: #eeeeee; text-align:center;">작성날짜</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1(예시확인)</td>
					<td>안녕하세요.</td>
					<td>고길동</td>
					<td>2017-05-04</td>
				</tr>
				<c:forEach var = "n" items="${notlist }">
				<tr>
					<td>${n.notID }</td>
					<td>${n.notTitle }</td>
					<td>${n.notWriter }</td>
					<td>${n.notDate }</td>
				</tr>
				</c:forEach>
			</tbody>
			
			</table>
</body>
</html>