<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>���� ������</title>
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
			<h2>��������</h2>
			
				<tr>
					<th style="background-color: #eeeeee; text-align:center;">��ȣ</th>
					<th style="background-color: #eeeeee; text-align:center;">����</th>
					<th style="background-color: #eeeeee; text-align:center;">�ۼ���</th>
					<th style="background-color: #eeeeee; text-align:center;">�ۼ���¥</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1(����Ȯ��)</td>
					<td>�ȳ��ϼ���.</td>
					<td>��浿</td>
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