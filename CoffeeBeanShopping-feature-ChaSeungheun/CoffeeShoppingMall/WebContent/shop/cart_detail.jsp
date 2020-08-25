<%@page import="java.util.ArrayList"%>
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
	<form action="${pageContext.request.contextPath }/PayController" method="post">
		<table border="1">
			<tr>
				<th>상품번호</th>
				<th>상품이름</th>
				<th>상품이미지</th>
				<th>브랜드</th>
				<th>상품가격</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="p" items="${products }">
				<tr>
					<td>${p.getId() }</td>
					<td>${p.getName() }</td>
					<td>${p.getImg() }</td>
					<td>${p.getBrand() }</td>
					<td>${p.getPrice() }</td>
					<td><input type='button' num='${p.getId()}' value='del'></td>
				
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="구매 하기">
	</form>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$(document).on("click","input[value='del']",function(){
		var num = $(this).attr("num");
		var tr = $(this).parent().parent();
		alert(num);
			$.ajax({
				url: '${pageContext.request.contextPath}/DelCartController',
				data: "num="+num,
				type:'POST',
				success: function(result){
					tr.remove();	
				}
			});
	});
	</script>
</body>
</html>