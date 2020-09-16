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
						<article>
							<div class="card">
								<div class="card-header">
									<h3 class="card-title">나의 주문 내역</h3>
								</div>
								<div class="card-body table-responsive p-0">
									<table class="table table-head-fixed text-nowrap"
										style="text-align: center; vertical-align: middle">
										<thead style="text-align: center">
											<tr>
												<th style="width: auto">주문일자</th>
												<th>주소</th>
												<th style="width: auto">상품번호</th>
												<th>수량</th>
												<th>처리상태</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach var="key"
												items="${requestScope.orderMap.keySet()}">
												<c:forEach var="order"
													items="${requestScope.orderMap.get(key)}"
													varStatus="status">
													<tr>
														<c:if test="${status.count == 1}">
															<td rowspan="${requestScope.orderMap.get(key).size()}"
																style="text-align: center; vertical-align: middle">${order.getOrder_date()}</td>
															<td rowspan="${requestScope.orderMap.get(key).size()}"
																style="text-align: center; vertical-align: middle">${order.getOrder_address()}</td>
														</c:if>
														<td>${order.getPro_id()}</td>
														<td>${order.getOrder_count()}</td>
														<c:if test="${status.count == 1}">
															<td rowspan="${requestScope.orderMap.get(key).size()}"
																style="text-align: center; vertical-align: middle">${requestScope.orderStatus.get(key)}</td>
														</c:if>
													</tr>
												</c:forEach>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</article>
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
</body>
</html>