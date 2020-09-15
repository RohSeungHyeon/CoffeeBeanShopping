<%@page import="user.model.Business"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<h3>회원 정보</h3>
		<table class="table table-default"
			style="text-align: center; border: 1px solid #dddddd">
			<tr>
				<th style="text-align: center;">이메일</th>
				<td><input type="text" value="${requestScope.user.getEmail()}"
					class="form-control" maxlength="50" readonly></td>
			</tr>
			<tr>
				<th style="text-align: center;">이름</th>
				<td><input type="text"
					value="${requestScope.user.getUserName()}" class="form-control"
					maxlength="50" readonly></td>
			</tr>
			<tr>
				<th style="text-align: center;">가입일자</th>
				<td><input type="text" value="${requestScope.joindate}"
					class="form-control" maxlength="50" readonly></td>
			</tr>
			<tr>
				<th style="text-align: center;">별명</th>
				<td><input type="text"
					value="${requestScope.user.getUserNickName()}" class="form-control"
					maxlength="50" readonly></td>
			</tr>
			<tr>
				<th style="text-align: center;">거주지</th>
				<td><input type="text"
					value="${requestScope.user.getAddress()}" class="form-control"
					maxlength="50" readonly></td>
			</tr>
			<tr>
				<th style="text-align: center;">개인 연락처</th>
				<td><input type="text" value="${requestScope.user.getPhone()}"
					class="form-control" maxlength="50" readonly></td>
			</tr>
			<c:if test="${requestScope.user.getGender() != null}">
				<tr>
					<th style="text-align: center;">성별</th>
					<td><input type="text"
						value="${requestScope.user.getGender()}" class="form-control"
						maxlength="50" readonly></td>
				</tr>
			</c:if>
			<c:if test="${requestScope.user.getBirth() != null}">
				<tr>
					<th style="text-align: center;">출생일자</th>
					<td><input type="text" value="${requestScope.user.getBirth()}"
						class="form-control" maxlength="50" readonly></td>
				</tr>
			</c:if>
			<c:if
				test='${requestScope.user.getClass().getName().equals("user.model.Business")}'>
				<tr>
					<th style="text-align: center;">사업장 이름</th>
					<td><input type="text"
						value="<%=((Business) request.getAttribute("user")).getCompanyName()%>"
						class="form-control" maxlength="50" readonly></td>
				</tr>
				<tr>
					<th style="text-align: center;">사업장 주소</th>
					<td><input type="text"
						value="<%=((Business) request.getAttribute("user")).getCompanyAddress()%>"
						class="form-control" maxlength="50" readonly></td>
				</tr>
				<tr>
					<th style="text-align: center;">사업장 연락처</th>
					<td><input type="text"
						value="<%=((Business) request.getAttribute("user")).getCompanyPhone()%>"
						class="form-control" maxlength="50" readonly></td>
				</tr>
				<tr>
					<th style="text-align: center;">직급</th>
					<td><input type="text"
						value="<%=((Business) request.getAttribute("user")).getRank()%>"
						class="form-control" maxlength="50" readonly></td>
				</tr>
			</c:if>
			<tr>
				<td colspan="3"><input type="button" value="돌아가기"
					class="btn btn-primary pull-right"
					onclick="location.href='${pageContext.request.contextPath}/goAdmin'"></td>
			</tr>
		</table>
	</div>

	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>