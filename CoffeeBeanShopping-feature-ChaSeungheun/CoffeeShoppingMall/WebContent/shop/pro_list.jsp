<%@page import="java.util.ArrayList"%>
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
					<c:forEach var="product" items="${products}">
						<div class="col-sm-3 mt-2" id="t_${product.getPro_id()}">
							<div class="position-relative p-3 bg-white"
								style="height: 300px; border: thin solid gray; border-radius: 0.25rem">
								<h5>ID : ${product.getPro_id()}</h5>
								<h3>${product.getPro_name()}</h3>
								<div class="col-5 float-left">
									<img
										src="${pageContext.request.contextPath}${product.getPro_img()}"
										class="product-image" alt="Product Image"
										style="height: 150px; width: auto" />
								</div>
								<div>
									<small class="mt-2"><b>지역</b> :
										${product.getPro_region()}</small><br> <small class="mt-2"><b>국가</b>
										: ${product.getPro_country()}</small><br> <br>
									${product.getPro_description()}</small><br>
									<h5 class="mt-2">￦${product.getPro_price()}</h5>
								</div>
								<div class="float-right">
									<input type='button' value="장바구니"
										class="btn btn-block btn-secondary col-12"
										style="width: 120px;"
										onclick="addCart(${product.getPro_id()}, '${sessionScope.id }' )" />
								</div>
								<form action="ProDetailController?id=${product.getPro_id()}">
									<input type="hidden" name="id" value="${product.getPro_id()}" />
									<div class="float-right">
										<input type="submit" class="btn btn-block btn-primary col-12"
											style="width: 120px;" value="상세 보기">
									</div>
								</form>

							</div>
						</div>
					</c:forEach>
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

</body>
</html>