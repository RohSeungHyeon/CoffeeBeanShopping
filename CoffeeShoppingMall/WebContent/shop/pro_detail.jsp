<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인 페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/plugins/sweetalert2/sweetalert2.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/plugins/toastr/toastr.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/dist/css/adminlte.min.css">

<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<!-- Header -->
		<%@ include file="header.jsp"%>

		<div class="content-wrapper">
			<section class="content">
			
							<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">제품 상세</h3>
							</div>
<div class="card-body table-responsive p-0"
									style="height: 600px;">
									
				<%
					Product p = (Product) request.getAttribute("product");
				String m = (String) request.getAttribute("message");
				%>
								<table class="table table-head-fixed text-nowrap" id="tt" >
									<tbody id="ttt">
											<tr> <td>상품 번호</td><td><%=p.getPro_id() %></td></tr>
											<tr><td>상품 명</td><td><%=p.getPro_name() %></td></tr>
											<tr><td>사진</td><td><img src=<%=p.getPro_img() %>><%=p.getPro_img() %></td></tr>
											<tr><td>지역</td><td><%=p.getPro_region() %> </td></tr>
											<tr><td>나라</td><td><%=p.getPro_country() %> </td></tr>
											
											<tr><td>가격</td><td><%=p.getPro_price() %></td></tr>
											<tr><td>상세설명</td><td>이 커피는~~~~~~~
											~~~~~~~~~<br>
											<%=p.getPro_description() %>
											~~~~~~~~~~<br>
											~~~~~~~~~<br>
											~~~~~~~~~~<br>
											~~~~~~~~~~~<br>
											~~~~~~~~~~~<br>
											~~~~~~~~~~~이다.</td>
									</tbody>
								
								</table>
								</div>

				<form action="${pageContext.request.contextPath }/AddCartController"
					method="post">
					<input type="submit" value="장바구니 담기"
						class="btn btn-block btn-primary"><br> <input
						type="hidden" value=<%=p.getPro_id() %> name="p_id"> <input
						type="hidden" value=${sessionScope.id } name="m_id">
				</form>


			</section>
		</div>

		<!-- Main Footer -->
		<%@ include file="footer.jsp"%>
	</div>


	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath }/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE -->
	<script
		src="${pageContext.request.contextPath }/resources/dist/js/adminlte.js"></script>

</body>
</html>