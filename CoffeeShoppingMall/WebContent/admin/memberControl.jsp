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
	누르면 조회 페이지로 넘어갈 수 있습니다.
	<br>
	<h2 align="center">회원 목록</h2>
	<table class="table table-hover"
		style="text-align: center; border: 1px solid #dddddd">
		<thead class="thead-dark">
			<tr>
				<th style="text-align: center;">이메일</th>
				<th style="text-align: center;">이름</th>
				<th style="text-align: center;">휴대폰 번호</th>
				<th style="text-align: center;">유형</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${requestScope.users}">
				<tr class="table-default"
					onclick="readUserInfo('${user.getEmail()}')">
					<td>${user.getEmail()}</td>
					<td>${user.getUserName()}</td>
					<td>${user.getPhone()}</td>
					<c:choose>
						<c:when
							test='${user.getClass().getName().equals("user.model.Business")}'>
							<td>사업자</td>
						</c:when>
						<c:otherwise>
							<td>개인</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>