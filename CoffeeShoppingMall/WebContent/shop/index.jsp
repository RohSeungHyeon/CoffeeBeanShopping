<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>���� ������</h1>
<a href="${pageContext.request.contextPath}/LoginController">�α���</a><br>
<a href="a">ȸ������</a><br>
<a href="a">��й�ȣ id ã��</a><br>
<a href="a">����������</a><br>
<a href="a">��������</a><br>
<a href="a">QnA</a><br>
<a href="a">ī�װ� �� ��ǰ ������</a><br>
<a href="a">��ٱ���</a><br>
<a href="a">����</a><br>
<a href="a">������������</a><br>
	<form action ="${pageContext.request.contextPath }/LoginController" method="post">
		id:<input type="text" name="id"><br>
		pw:<input type="text" name="pw"><br>
		<input type="submit" value="�α���"><br>
		
	</form>
	<c:if test="${not empty sessionScope.id }">
	${sessionScope.id }�� �α���
	<br>
		<a href="${pageContext.request.contextPath }/SearchController">����������</a>
		<a href="${pageContext.request.contextPath }/LogOutController">�α׾ƿ�</a>
		<a href="${pageContext.request.contextPath }/DelController">Ż��</a>

	</c:if>
	<c:if test="${empty sessionScope.id }">
		�α��� ����
		<a href="${pageContext.request.contextPath }/member/loginForm.jsp">�α���</a>
	</c:if>		
	<form >
<input type="text">
<input type="button" value="�˻�">
</form>
</body>
</html>