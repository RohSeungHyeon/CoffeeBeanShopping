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
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">장바구니</h3>
							</div>
							<form action="${pageContext.request.contextPath }/PayController"
								method="post">
								<div class="card-body table-responsive p-0"
									style="height: 300px;">
									<table class="table table-head-fixed text-nowrap">
										<tr>
											<th>상품번호</th>
											<th>상품이름</th>
											<th>상품이미지</th>
											<th>대분류</th>
											<th>상품가격</th>
											<th>삭제</th>
										</tr>
										<c:forEach var="p" items="${products }">
											<tr>
												<td>${p.getPro_id() }</td>
												<td>${p.getPro_name() }</td>
												<td>
												<img src="${pageContext.request.contextPath}/${p.getPro_img()}" class="product-image"
							alt="Product Image" style="height: 150px; width: auto" />
												</td>
												<td>${p.getPro_region() }</td>
												<td>${p.getPro_price() }</td>
												<td><input type='button'
													class="btn btn-block btn-secondary" num='${p.getPro_id()}'
													value='del'></td>

											</tr>
										</c:forEach>
									</table>
								</div>

								<input type="submit" class="btn btn-block btn-primary"
									value="구매 하기">
							</form>
						</div>
					</div>
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
		$(document).on("click", "input[value='del']", function() {
			var num = $(this).attr("num");
			var tr = $(this).parent().parent();
			alert(num);
			$.ajax({
				url : '${pageContext.request.contextPath}/DelCartController',
				data : "num=" + num,
				type : 'POST',
				success : function(result) {
					tr.remove();
				}
			});
		});
	</script>
</body>
</html>