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
	<form action="${pageContext.request.contextPath }/PaymentController" method="post">
		<table border="1">
			<tr>
				<th>상품번호</th>
				<th>상품이름</th>
				<th>상품이미지</th>
				<th>브랜드</th>
				<th>상품가격</th>
				<th>개수</th>
				<th>총 가격</th>
			</tr>
			<c:set var = "total" value="0"/>
			<c:forEach var="p" items="${products }">
				<c:set var="total" value="${total+p.getPrice() }"/>
				<tr>
					<td>${p.getId() }</td>
					<td>${p.getName() }</td>
					<td>${p.getImg() }</td>
					<td>${p.getBrand() }</td>
					<td>${p.getPrice() }</td>
					<td>
					<input type='button' value='-' id='-' num='${p.getId()}'>
					<span id="count_${p.getId()}">1</span>
					 <input type='button' value='+' id='+' num='${p.getId()}'></td>
					<td><span id="pri_${p.getId() }" num='${p.getPrice()}'>${p.getPrice() }</span></td>
				</tr>
			</c:forEach>
			<tr><td colspan="7">총 합계</td><td  id="pri_to">${total}</td></tr>
			<tr><td>주소입력</td><td colspan="7"><input type="text" name="address" value=""></td>
		</table> 
		<input type="submit" value="구매 하기">
	</form>
	
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	var to = '<c:out value="${total}"/>';
	$(document).on("click","input[value='-']",function(){
		var num = $(this).attr("num");
		var cnt = $("#count_"+num).html();
		if(cnt == 0){cnt++; to = parseInt(to)+parseInt($("#pri_"+num).attr("num"));}
		$("#count_"+num).html(parseInt(cnt)-1);
		$("#pri_"+num).html((parseInt(cnt)-1)*parseInt($("#pri_"+num).attr("num")));	
		to = parseInt(to)-parseInt($("#pri_"+num).attr("num"));
		$("#pri_to").html(to);

	});
	$(document).on("click","input[value='+']",function(){
		var num = $(this).attr("num");
		var cnt = $("#count_"+num).html();
		$("#count_"+num).html(parseInt(cnt)+1);
		$("#pri_"+num).html((parseInt(cnt)+1)*parseInt($("#pri_"+num).attr("num")));		
		to = parseInt(to)+parseInt($("#pri_"+num).attr("num"));
		$("#pri_to").html(to);
	});

    </script>
</body>
</html>