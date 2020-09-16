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
								<table class="table table-head-fixed text-nowrap" id="tt">
									<tbody id="ttt">
										<tr>
											<td>상품 번호</td>
											<td><%=p.getPro_id()%></td>
										</tr>
										<tr>
											<td>상품 명</td>
											<td><%=p.getPro_name()%></td>
										</tr>
										<tr>
											<td>사진</td>
											<td><img
												src="${pageContext.request.contextPath}/<%=p.getPro_img() %>"
												class="product-image" alt="Product Image"
												style="height: 150px; width: auto" /></td>
										</tr>
										<tr>
											<td>지역</td>
											<td><%=p.getPro_region()%></td>
										</tr>
										<tr>
											<td>나라</td>
											<td><%=p.getPro_country()%></td>
										</tr>

										<tr>
											<td>가격</td>
											<td><%=p.getPro_price()%></td>
										</tr>
										<tr>
											<td>상세설명</td>
											<td><%=p.getPro_description()%></td>
									</tbody>

								</table>
							</div>

							<div style="text-align: right;">
								<input type='button' value="장바구니 담기"
									class="btn btn-block btn-secondary col-12"
									style="width: 130px; display: inline-block;"
									onclick="addCart(<%=p.getPro_id()%>, '${sessionScope.id }' )" />
							</div>
							<div style="text-align: right;">
								<button class="btn btn-block btn-primary col-12"
									style="width: 130px; display: inline-block;"
									onclick="window.location.href='${pageContext.request.contextPath}/ViewCartController'">
									장바구니 가기</button>
							</div>
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
	<script>
	function addCart(id, m_id) {
		var data = "p_id="+id+"&m_id="+m_id;
		$.ajax({
			"url" : "AddCartController",
			"data" : data,
			"type" : "POST",
			"success" : function(data) {
				alert("장바구니에 담겼습니다.");
			}
		});
	}
	</script>
</body>
</html>