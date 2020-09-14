<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>메인 페이지</h1>
<a href="${pageContext.request.contextPath}/shop/login.jsp">로그인</a><br>
<a href="${pageContext.request.contextPath}/shop/join.jsp">회원가입</a><br>
<%
	if (!session.isNew()) {
%>
	<a href="${pageContext.request.contextPath}/shop/logout.jsp">로그아웃</a>
<%
	}
%>
<a href="a">비밀번호 id 찾기</a><br>
<a href="a">마이페이지</a><br>
<a href="a">공지사항</a><br>
<a href="a">QnA</a><br>
<a href="a">카테고리 별 상품 페이지</a><br>
<a href="a">장바구니</a><br>
<a href="a">결제</a><br>
<a href="a">관리자페이지</a><br>
<form >
<input type="text">
<input type="button" value="검색">
</form>
</body>
</html>