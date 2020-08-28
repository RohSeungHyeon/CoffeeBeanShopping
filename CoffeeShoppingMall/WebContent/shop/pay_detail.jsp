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

				<div class="row" >
					<div class="col-12">
						<div class="card" style="height:800px;">
							<div class="card-header">
								<h3 class="card-title">상품 주문</h3>
							</div>

							<form
								action="${pageContext.request.contextPath }/PaymentController"
								method="post" onsubmit="fun();">
												<div class="card-body table-responsive p-0"
									style="height: 800px;">
								<table class="table table-head-fixed text-nowrap" id="tt" >
									<tr>
										<th>상품번호</th>
										<th>상품이름</th>
										<th>상품이미지</th>
										<th>지역</th>
										<th>상품가격</th>
										<th>개수</th>
										<th>총 가격</th>
									</tr>
									<tbody id="ttt">
										<c:set var="total" value="0" />
										<c:forEach var="p" items="${products }">
											<c:set var="total" value="${total+p.getPro_price() }" />
											<tr>
												<td>${p.getPro_id() }</td>
												<td>${p.getPro_name() }</td>
												<td><img src="${pageContext.request.contextPath}/${p.getPro_img()}" class="product-image"
							alt="Product Image" style="height: 150px; width: auto" /></td>
												<td>${p.getPro_region() }</td>
												<td>${p.getPro_price() }</td>
												<td><input type='button' value='-' id='-'
													num='${p.getPro_id()}'> <span id="count_${p.getPro_id()}">1</span>
													<input type='button' value='+' id='+' num='${p.getPro_id()}'></td>
												<td><span id="pri_${p.getPro_id() }" num='${p.getPro_price()}'>${p.getPro_price() }</span></td>
											</tr>
										</c:forEach>
									</tbody>
									<tr>
										<td colspan="6" style="text-align:center"><h3>총 합계</h3></td>
										<td id="pri_to"><h3>${total}</h3></td>
									</tr>
									<tr>
										<td>주소입력</td>
										<td colspan="6" ><input type="text" name="address"
											value="" style='width:100%; height:4em'></td>
									<tr>
										<td colspan="7"><input type="submit"
											class="btn btn-block btn-primary" value="결제 하기"
											style="width: 100px; float: right;"></td>
								</table>
								</div>
								<input type="hidden" id="to" name="total" value=${total} >
								<input type="hidden" id="count" name="count" value=1>
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

	<script type="text/javascript"
		src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath }/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE -->
	<script
		src="${pageContext.request.contextPath }/resources/dist/js/adminlte.js"></script>
	<script>
		function fun() {
			var cnt = "";
			var tbo = $("#ttt");
			var tr = tbo.children();
			tr.each(function(i) {
				//alert(tr.eq(i).text());
				var td = tr.eq(i).children();
				cnt = cnt + td.eq(0).text() + ','
						+ td.eq(5).children().eq(1).text() + '@';
			});
			alert("결제 페이지로 이동합니다.");
			$('#count').val(cnt);
		};
		var to = '<c:out value="${total}"/>';
		$(document).on(
				"click",
				"input[value='-']",
				function() {
					var num = $(this).attr("num");
					var cnt = $("#count_" + num).html();
					if (cnt == 0) {
						cnt++;
						to = parseInt(to)
								+ parseInt($("#pri_" + num).attr("num"));
					}
					$("#count_" + num).html(parseInt(cnt) - 1);
					$("#pri_" + num).html(
							(parseInt(cnt) - 1)
									* parseInt($("#pri_" + num).attr("num")));
					to = parseInt(to) - parseInt($("#pri_" + num).attr("num"));
					$("#pri_to").html('<h3>'+to+'</h3>');
					$('#to').val(to);
				});
		$(document).on(
				"click",
				"input[value='+']",
				function() {
					var num = $(this).attr("num");
					var cnt = $("#count_" + num).html();
					$("#count_" + num).html(parseInt(cnt) + 1);
					$("#pri_" + num).html(
							(parseInt(cnt) + 1)
									* parseInt($("#pri_" + num).attr("num")));
					to = parseInt(to) + parseInt($("#pri_" + num).attr("num"));
					$("#pri_to").html('<h3>'+to+'</h3>');
					$('#to').val(to);

				});
	</script>
</body>
</html>