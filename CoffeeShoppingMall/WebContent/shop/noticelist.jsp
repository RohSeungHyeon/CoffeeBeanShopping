<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인 페이지</title>
<!-- Font Awesome -->
</head>
<body>
	<h2 align="center">공지사항</h2>
	<table class="table table-hover"
		style="text-align: center; border: 1px solid #dddddd">
		<thead class="thead-dark">
			<tr>
				<th style="text-align: center;">번호</th>
				<th style="text-align: center;">제목</th>
				<th style="text-align: center;">작성자</th>
				<th style="text-align: center;">작성날짜</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1(예시확인)</td>
				<td>안녕하세요.</td>
				<td>고길동</td>
				<td>2017-05-04</td>
			</tr>
			<c:forEach var="n" items="${notlist }">
				<tr class="table-default"
					onclick="location.href='${pageContext.request.contextPath }/NoticereadController?notID=${n.notID }'">
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