<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메인 페이지</h1>
<a href="${pageContext.request.contextPath}/LoginController">로그인</a><br>
<a href="a">회원가입</a><br>
<a href="a">비밀번호 id 찾기</a><br>
<a href="a">마이페이지</a><br>
<a href="a">공지사항</a><br>
<a href="a">QnA</a><br>
<a href="a">카테고리 별 상품 페이지</a><br>
<a href="${pageContext.request.contextPath}/ProDetailController">상품 디테일</a><br>
<a href="${pageContext.request.contextPath}/ViewCartController">장바구니</a><br>
<a href="a">결제</a><br>
<a href="a">관리자페이지</a><br>
	<form action ="${pageContext.request.contextPath }/LoginController" method="post">
		id:<input type="text" name="id"><br>
		pw:<input type="text" name="pw"><br>
		<input type="submit" value="로그인"><br>
		
	</form>
	<c:if test="${not empty sessionScope.id }">
	${sessionScope.id }님 로그인
	<br>
		<a href="${pageContext.request.contextPath }/SearchController">내정보수정</a>
		<a href="${pageContext.request.contextPath }/LogOutController">로그아웃</a>
		<a href="${pageContext.request.contextPath }/DelController">탈퇴</a>
	</c:if>
	<c:if test="${empty sessionScope.id }">
		로그인 실패
		<a href="${pageContext.request.contextPath }/member/loginForm.jsp">로그인</a>
	</c:if>		
<form >
<input type="text">
<input type="button" value="검색">
</form>
</body>
</html>