<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>���� ������</h1>
<a href="${pageContext.request.contextPath}/shop/login.jsp">�α���</a><br>
<a href="${pageContext.request.contextPath}/shop/join.jsp">ȸ������</a><br>
<%
	if (!session.isNew()) {
%>
	<a href="${pageContext.request.contextPath}/shop/logout.jsp">�α׾ƿ�</a>
<%
	}
%>
<a href="a">��й�ȣ id ã��</a><br>
<a href="a">����������</a><br>
<a href="a">��������</a><br>
<a href="a">QnA</a><br>
<a href="a">ī�װ� �� ��ǰ ������</a><br>
<a href="a">��ٱ���</a><br>
<a href="a">����</a><br>
<a href="a">������������</a><br>
<form >
<input type="text">
<input type="button" value="�˻�">
</form>
</body>
</html>