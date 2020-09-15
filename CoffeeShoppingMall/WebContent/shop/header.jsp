<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인 페이지</title>
</head>
<body>
	<header>
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light"
			style="background-image: url('${pageContext.request.contextPath }/resources/img/main/top.jpg')">
			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item "><a class="nav-link"
					data-widget="pushmenu" href="#" role="button"
					style="background-color: white;"><i class="fas fa-bars"></i></a></li>
			</ul>

		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-light-primary elevation-4">
			<!-- Brand Logo -->
			<a href="${pageContext.request.contextPath}/MainController"
				class="brand-link"> <img
				src="${pageContext.request.contextPath }/resources/img/main/GreenCoffeeLogo.png"
				alt="Green Coffee" class="brand-image img-circle elevation-3"
				style="opacity: .8"> <span
				class="brand-text font-weight-light">Green Coffee</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Search -->
				<form
					action="${pageContext.request.contextPath }/ViewSearchProductController"
					class="form-inline mt-3" method="GET">
					<select name="category" class="form-control">
						<option value="total">통합검색</option>
						<option value="name">상품명</option>
						<option value="number">상품번호</option>
					</select>
					<div class="input-group mt-2">
						<input class="form-control form-control-sidebar" type="text"
							placeholder="Search" aria-label="Search" name="search">
						<div class="input-group-append">
							<button class="btn btn-sidebar" type="submit">
								<i class="fas fa-search"></i>
							</button>
						</div>
					</div>
				</form>
				<!-- Sidebar user panel (optional) -->
				<div class="user-panel mt-3 pb-3 mb-3 d-flex">
					<c:choose>
						<c:when test="${empty sessionScope.userprofile}">
							<div class="info">
								<a href="${pageContext.request.contextPath}/member/login.jsp"
									class="d-block mt-2">로그인</a> <a
									href="${pageContext.request.contextPath}/member/join.jsp"
									class="d-block mt-2">회원가입</a> <a href="#" class="d-block mt-2">아이디/비밀번호
									찾기</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="info">
								<span class="d-block mt-2" id="user_id">${userprofile.name}
									님</span> <a href="#" class="d-block mt-2">내 정보</a> <a
									href="${pageContext.request.contextPath}/ViewCartController"
									class="d-block mt-2">장바구니</a> <a href="#" class="d-block mt-2">주문내역</a>
								<a href="${pageContext.request.contextPath}/logout.do"
									class="d-block mt-2">로그아웃</a> <a
									href="${pageContext.request.contextPath}/goAdmin"
									class="d-block mt-2">관리자페이지</a>

							</div>
						</c:otherwise>
					</c:choose>
				</div>

				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->

						<a
							href="${pageContext.request.contextPath}/ViewProductController?query=all">
							모든 상품 보기 </a>

						<li class="nav-item has-treeview"><a href="#"
							class="nav-link">
								<p>
									지역별 <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=asia"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>아시아/태평양</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=amer"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>중남미</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=afri"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>아프리카</p>
								</a></li>
							</ul></li>
						<li class="nav-item has-treeview"><a href="#"
							class="nav-link">
								<p>
									국가별 <i class="right fas fa-angle-left"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=brazil"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>브라질</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=vietnam"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>베트남</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=columbia"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>콜롬비아</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=indonesia"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>인도네시아</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=honduras"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>온두라스</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=ethiopia"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>에티오피아</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=india"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>인도</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=uganda"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>우간다</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=peru"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>페루</p>
								</a></li>
								<li class="nav-item"><a
									href="${pageContext.request.contextPath }/ViewProductController?query=mexico"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>멕시코</p>
								</a></li>
							</ul></li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>
	</header>
</body>
</html>