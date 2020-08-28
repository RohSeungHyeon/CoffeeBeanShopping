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
	<form method="post" id="editNoticeForm">
		<div class="row">
			<h3>공지사항 상세보기</h3>
			<table class="table table-default"
				style="text-align: center; border: 1px solid #dddddd">
				<tr>
					<th style="text-align: center;">작성날짜</th>
					<td><input type="text" value="${param.notDate }"
						name="notDate" class="form-control" maxlength="50" readonly></td>
				</tr>
				<tr>
					<th style="text-align: center;">번호</th>
					<td><input type="text" value="${param.notID}" name="notID"
						class="form-control" maxlength="50" readonly></td>
				</tr>
				<tr>
					<th style="text-align: center;">제목</th>
					<td><input type="text" value="${param.notTitle }"
						name="notTitle" class="form-control" maxlength="50"></td>
				</tr>
				<tr>
					<th style="text-align: center;">작성자</th>
					<td><input type="text" value="${param.notWriter }"
						name="notWriter" class="form-control" maxlength="50" readonly></td>
				</tr>
				<tr>
					<th style="text-align: center;">내용</th>
					<td><textarea name="notContent" rows="15" cols="45"
							class="form-control" maxlength="50">${requestScope.notContent }</textarea></td>
				</tr>
				<tr>
					<td colspan="3"><input type="button" value="수정"
						class="btn btn-primary pull-right"
						onclick="editNoticeConfirm(this.form)"> <input
						type="button" value="삭제" class="btn btn-primary pull-right"
						onclick="deleteNotice('${param.notID}')"> <input
						type="button" value="돌아가기" class="btn btn-primary pull-right"
						onclick="location.href='${pageContext.request.contextPath}/goAdmin'"></td>
				</tr>
			</table>
		</div>
	</form>

	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>