<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
</head>
<body>
	누르면 수정 페이지로 넘어갈 수 있습니다.
	<br>
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
			<c:forEach var="notice" items="${requestScope.notices}">
				<tr class="table-default"
					onclick='editNotice(${notice.toJSONString()})'>
					<td>${notice.getNotID()}</td>
					<td>${notice.getNotTitle()}</td>
					<td>${notice.getNotWriter()}</td>
					<td>${notice.getNotDate()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" class="btn btn-primary pull-right" value="글쓰기"
		onclick="writeNotice()" />
</body>
</html>