<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>qna ������</title>
<!-- Font Awesome -->
</head>
<body>
<h2 align="center">Q&A</h2>
<table class="table table-hover" style="text-align:center; border: 1px solid #dddddd">
			<thead class="thead-dark">
				<tr>
					<th style=" text-align:center;">��ȣ</th>
					<th style="text-align:center;">����</th>
					<th style="text-align:center;">�ۼ���</th>
					<th style=" text-align:center;">�ۼ���¥</th>
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