<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상품 관리 페이지</title>
</head>
<body>
	수정하려면 상품을 클릭해주세요.
	<div class="row">
		<div class="col-sm-3 mt-2">
			<div class="position-relative p-3 bg-white"
				style="height: 180px; border: thin solid gray;">
				<h3>생두 커피 이름</h3>
				<div class="col-5">
					<img src="../resources/img/main/GreenCoffeeLogo.png"
						class="product-image" alt="Product Image" />
				</div>
				<small class="mt-2">지역명/국가명/브랜드/용량</small><br>
				<h5 class="mt-2">가격</h5>
			</div>
		</div>
		<c:forEach var="product" items="${products}">
			<div class="col-sm-3 mt-2" id="t_${product.getId()}">
				<div class="position-relative p-3 bg-white"
					style="height: 180px; border: thin solid gray;">
					<h3>${product.getName()}</h3>
					<div class="col-5">
						<img src="${product.getImg()}"
							class="product-image" alt="Product Image" />
					</div>
					<small class="mt-2">지역명/국가명/브랜드/용량</small><br>
					<h5 class="mt-2">${product.getPrice()}</h5>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-12 mt-2">
		<div class="row float-left">
			<button type="button" class="btn btn-block btn-primary col-12"
				id="addFormToggleBtn">상품 추가</button>
		</div>
		<br> <br>
		<div id="addProductForm" class="col-5">
			<form role="form" enctype="multipart/form-data" method="POST"
				action="#">
				<div class="card-body">
					<div class="form-group">
						<label>제품명</label> <input type="text" class="form-control"
							name="name" placeholder="상품의 이름을 입력하세요.">
					</div>
					<div class="form-group">
						<label>가격</label> <input type="number" class="form-control"
							name="price" placeholder="가격을 입력하세요.">
					</div>
					<div class="form-group">
						<label>대륙</label> <input type="text" class="form-control"
							name="category" placeholder="해당 대륙을 입력하세요.">
					</div>
					<div class="form-group">
						<label>국가</label> <input type="number" class="form-control"
							name="country" placeholder="해당 국가를 입력하세요.">
					</div>
					<div class="form-group">
						<label>브랜드</label> <input type="text" class="form-control"
							name="brand" placeholder="브랜드를 입력하세요.">
					</div>
					<div class="form-group">
						<label>가공 방식</label> <input type="text" class="form-control"
							name="dry" placeholder="가공 방식을 입력하세요.">
					</div>
					<div class="form-group">
						<label>상품 사진</label>
						<div class="input-group">
							<div class="custom-file">
								<input type="file" class="custom-file-input" name="img">
								<label class="custom-file-label">파일을 선택해주십시오.</label>
							</div>
						</div>
					</div>
				</div>
				<!-- /.card-body -->

				<div class="card-footer">
					<input type="button" class="btn btn-primary"
						onclick="checkAddProductForm(this.form)" value="업로드">
				</div>
			</form>
		</div>
	</div>

</body>
</html>