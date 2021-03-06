<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인 페이지</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- SweetAlert2 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/plugins/sweetalert2/sweetalert2.min.css">
<!-- Toastr -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/plugins/toastr/toastr.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
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
				<div class="containter-fluid">
					<div class="row">
						<div class="col-md-6">
							<article>
								<div class="card mt-2">
									<div class="card-header">
										<h3 class="card-title">공지사항</h3>
										<div class="card-tools">
											<a href="${pageContext.request.contextPath}/shop/notice.jsp">더
												보기</a>
										</div>
									</div>
									<!-- /.card-header -->
									<div class="card-body table-responsive p-0"
										style="height: 300px;">
										<table class="table table-head-fixed table-hover text-nowrap">
											<thead>
												<tr>
													<th style="width: 10px">#</th>
													<th>제목</th>
													<th>작성자</th>
													<th style="width: auto">작성일자</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="notice" items="${requestScope.notices}">
													<tr
														onclick="location.href='${pageContext.request.contextPath }/NoticereadController?notID=${notice.getNotID()}'">
														<td>${notice.getNotID() }</td>
														<td>${notice.getNotTitle()}</td>
														<td>${notice.getNotWriter()}</td>
														<td>${notice.getNotDate()}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<!-- /.card-body -->
								</div>
							</article>
						</div>
						<div class="col-md-6">
							<article>
								<div class="card mt-2">
									<div class="card-header">
										<h3 class="card-title">QnA</h3>
										<div class="card-tools">
											<a href="${pageContext.request.contextPath}/shop/qna.jsp">더
												보기</a>
										</div>
									</div>
									<!-- /.card-header -->
									<div class="card-body table-responsive p-0"
										style="height: 300px;">
										<table class="table table-head-fixed table-hover text-nowrap">
											<thead>
												<tr>
													<th style="width: 10px">#</th>
													<th>제목</th>
													<th>작성자</th>
													<th style="width: auto">작성일자</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="qna" items="${requestScope.qnas}">
													<tr
														onclick="location.href='${pageContext.request.contextPath }/QnareadController?qnaID=${qna.getQnaID()}'">
														<td>${qna.getQnaID() }</td>
														<td>${qna.getQnaTitle()}</td>
														<td>${qna.getQnaWriter()}</td>
														<td>${qna.getQnaDate()}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<!-- /.card-body -->
								</div>
							</article>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<article>
								<div class="card">
									<div class="card-header">
										<h3 class="card-title">추천 상품</h3>
									</div>
									<div class="row">
										<c:set var="p_cnt" value="0" />
										<c:forEach var="product" items="${products}">
											<c:set var="p_cnt" value="${ p_cnt+1}" />
											<c:if test="${p_cnt <= 4 }">

												<div class="col-sm-3 mt-2" id="t_${product.getPro_id()}">
													<div class="position-relative p-3 bg-white"
														style="height: auto; border: thin solid gray; border-radius: 0.25rem;">
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
														<br>
														<div style="text-align: right;">
															<input type='button' value="장바구니"
																class="btn btn-block btn-secondary col-12"
																style="width: 120px; display: inline-block;"
																onclick="addCart(${product.getPro_id()}, '${sessionScope.id }' )" />
														</div>
														<form
															action="ProDetailController?id=${product.getPro_id()}">
															<input type="hidden" name="id"
																value="${product.getPro_id()}" />
															<div style="text-align: right;">
																<input type="submit"
																	class="btn btn-block btn-primary col-12"
																	style="width: 120px; display: inline-block;"
																	value="상세 보기">
															</div>
														</form>

													</div>
												</div>
											</c:if>
										</c:forEach>
									</div>

								</div>
							</article>
						</div>
						<!-- /.col -->
					</div>
				</div>
			</section>
		</div>
		<!-- Footer -->
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
	<script src="${pageContext.request.contextPath}/scripts/main.js"></script>
</body>
</html>