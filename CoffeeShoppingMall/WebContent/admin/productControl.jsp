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
	<div class="row">
		<c:forEach var="product" items="${products}">
			<div class="col-sm-3 mt-2" id="t_${product.getPro_id()}">
				<div class="position-relative p-3 bg-white"
					style="height: 300px; border: thin solid gray; border-radius: 0.25rem">
					<h5>ID : ${product.getPro_id()}</h5>
					<h3>${product.getPro_name()}</h3>
					<div class="col-5 float-left">
						<img src="${pageContext.request.contextPath}/${product.getPro_img()}" class="product-image"
							alt="Product Image" style="height: 150px; width: auto" />
					</div>
					<div>
						<small class="mt-2"><b>지역</b> : ${product.getPro_region()}</small><br>
						<small class="mt-2"><b>국가</b> :
							${product.getPro_country()}</small><br> <small class="mt-2"><b>상세설명</b>
							:<br> ${product.getPro_description()}</small><br>
						<h5 class="mt-2">￦${product.getPro_price()}</h5>
					</div>
					<div class="float-right">
						<input type='button' value="삭제"
							class="btn btn-block btn-primary col-12"
							onclick="deleteProduct(${product.getPro_id()})" />
					</div>
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
				id="productForm">
				<div class="card-body">
					<div class="form-group">
						<label>상품명</label> <input type="text" class="form-control"
							name="name" placeholder="상품의 이름을 입력하세요.">
					</div>
					<div class="form-group">
						<label>가격</label> <input type="number" class="form-control"
							name="price" placeholder="가격을 입력하세요.">
					</div>
					<div class="form-group">
						<label>지역</label><select class="form-control" name="region">
							<option value="아시아/태평양">아시아/태평양</option>
							<option value="중남미">중남미</option>
							<option value="아프리카">아프리카</option>
						</select>
					</div>
					<div class="form-group">
						<label>국가</label> <input type="text" class="form-control"
							name="country" placeholder="해당 국가를 입력하세요.">
					</div>
					<div class="form-group">
						<label>상세설명</label>
						<textarea class="form-control" rows="3" placeholder="상세 설명..."
							name="description"></textarea>
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