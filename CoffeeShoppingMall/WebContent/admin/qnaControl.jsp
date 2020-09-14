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
	누르면 조회 및 삭제 페이지로 넘어갈 수 있습니다.
	<br>
	<h2 align="center">QnA</h2>
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
			<c:forEach var="qna" items="${requestScope.qnas}">
				<tr class="table-default"
					onclick='readQna(${qna.toJSONString()})'>
					<td>${qna.getQnaID()}</td>
					<td>${qna.getQnaTitle()}</td>
					<td>${qna.getQnaWriter()}</td>
					<td>${qna.getQnaDate()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>