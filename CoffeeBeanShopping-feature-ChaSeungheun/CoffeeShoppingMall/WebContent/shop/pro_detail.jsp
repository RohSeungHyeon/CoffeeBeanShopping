<%@page import="model.Product"%>
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
	<%
		Product p = (Product)request.getAttribute("product");
		String m = (String)request.getAttribute("message");
	%>
	<%=p.getId() %><br>
	<%=p.getName() %><br>
	<%=p.toString() %>
	
	<form action="${pageContext.request.contextPath }/PayOneController" method="post">
		<input type="submit" value="바로 구매"><br>
		<input type="hidden" value=<%=p.getId() %> name="p_id">
		<input type="hidden" value=${sessionScope.id } name="m_id">
		
	</form>
	<br>
	
	<form action="${pageContext.request.contextPath }/AddCartController" method="post">
		<input type="submit" value="장바구니 담기"><br>
		<input type="hidden" value=<%=p.getId() %> name="p_id">
		<input type="hidden" value=${sessionScope.id } name="m_id">
	</form>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
		alert(<%=m%>);

		
	});
	</script>
</body>
</html>