<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자 페이지</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- SweetAlert2 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/sweetalert2/sweetalert2.min.css">
<!-- Toastr -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/toastr/toastr.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body class="sidebar-collapse">
	<div class="wrapper">
		<header></header>

		<div class="content-wrapper">
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">
							<h4>관리자 페이지</h4>
						</div>
					</div>
					<!-- ./row -->
					<div class="card card-primary card-tabs">
						<div class="card-header p-0 pt-1">
							<ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
								<li class="nav-item"><a class="nav-link active"
									id="custom-tabs-one-home-tab" data-toggle="pill"
									href="#custom-tabs-one-home" role="tab"
									aria-controls="custom-tabs-one-home" aria-selected="true">소개</a>
								</li>
								<li class="nav-item"><a class="nav-link"
									id="custom-tabs-one-member-tab" data-toggle="pill"
									href="#custom-tabs-one-member" role="tab"
									aria-controls="custom-tabs-one-member" aria-selected="false">회원관리</a>
								</li>
								<li class="nav-item"><a class="nav-link"
									id="custom-tabs-one-order-tab" data-toggle="pill"
									href="#custom-tabs-one-order" role="tab"
									aria-controls="custom-tabs-one-order" aria-selected="false">주문내역
										관리</a></li>
								<li class="nav-item"><a class="nav-link"
									id="custom-tabs-one-qna-tab" data-toggle="pill"
									href="#custom-tabs-one-qna" role="tab"
									aria-controls="custom-tabs-one-qna" aria-selected="false">QnA
										관리 </a></li>
								<li class="nav-item"><a class="nav-link"
									id="custom-tabs-one-notice-tab" data-toggle="pill"
									href="#custom-tabs-one-notice" role="tab"
									aria-controls="custom-tabs-one-notice" aria-selected="false">공지사항
										관리</a></li>
								<li class="nav-item"><a class="nav-link"
									id="custom-tabs-one-product-tab" data-toggle="pill"
									href="#custom-tabs-one-product" role="tab"
									aria-controls="custom-tabs-one-product" aria-selected="false">상품
										관리</a></li>
							</ul>
						</div>
						<div class="card-body">
							<div class="tab-content" id="custom-tabs-one-tabContent">
								<div class="tab-pane fade show active" id="custom-tabs-one-home"
									role="tabpanel" aria-labelledby="custom-tabs-one-home-tab">
									이 페이지는 관리자 페이지입니다.<br> <br>회원관리/주문내역 관리/공지사항 관리/QnA
									관리/상품관리 등 할 수 있습니다.
								</div>
								<div class="tab-pane fade" id="custom-tabs-one-member"
									role="tabpanel" aria-labelledby="custom-tabs-one-member-tab">
									<%@include file="memberControl.jsp"%>
								</div>
								<div class="tab-pane fade table-responsive p-0" id="custom-tabs-one-order"
									role="tabpanel" aria-labelledby="custom-tabs-one-order-tab">
									<%@include file="orderControl.jsp"%></div>
								<div class="tab-pane fade" id="custom-tabs-one-qna"
									role="tabpanel" aria-labelledby="custom-tabs-one-qna-tab">
									<%@include file="qnaControl.jsp"%></div>
								<div class="tab-pane fade" id="custom-tabs-one-notice"
									role="tabpanel" aria-labelledby="custom-tabs-one-notice-tab">
									<%@include file="noticeControl.jsp"%></div>
								<div class="tab-pane fade" id="custom-tabs-one-product"
									role="tabpanel" aria-labelledby="custom-tabs-one-product-tab">
									<%@include file="productControl.jsp"%></div>
							</div>
						</div>
						<!-- /.card -->
					</div>
				</div>
			</section>
		</div>


		<!-- Main Footer -->
		<%@ include file="../shop/footer.jsp"%>
	</div>

	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- bs-custom-file-input -->
	<script
		src="${pageContext.request.contextPath}/resources/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
	<!-- AdminLTE -->
	<script
		src="${pageContext.request.contextPath}/resources/dist/js/adminlte.js"></script>

	<!-- Developer -->
	<script
		src="${pageContext.request.contextPath}/scripts/productControl.js">
	</script>
	<script
		src="${pageContext.request.contextPath}/scripts/orderControl.js">
	</script>
	<script
		src="${pageContext.request.contextPath}/scripts/noticeControl.js">
	</script>
</body>
</html>