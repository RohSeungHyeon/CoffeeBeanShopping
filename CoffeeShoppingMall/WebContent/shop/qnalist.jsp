<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>qna 페이지</title>
<!-- Font Awesome -->
</head>
<body>
<h2 align="center">Q&A</h2>
<table class="table table-hover" style="text-align:center; border: 1px solid #dddddd">
			<thead class="thead-dark">
				<tr>
					<th style=" text-align:center;">번호</th>
					<th style="text-align:center;">제목</th>
					<th style="text-align:center;">작성자</th>
					<th style=" text-align:center;">작성날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "q" items="${qnalist }">
				<tr class = "table-default" onclick="location.href='${pageContext.request.contextPath }/QnareadController?qnaID=${q.qnaID }'">
					<td>${q.qnaID }</td>
					<td>${q.qnaTitle }</td>
					<td>${q.qnaWriter }</td>
					<td>${q.qnaDate }</td>
				</tr>
				</c:forEach>
			</tbody>
			
			</table>

</body>
</html>