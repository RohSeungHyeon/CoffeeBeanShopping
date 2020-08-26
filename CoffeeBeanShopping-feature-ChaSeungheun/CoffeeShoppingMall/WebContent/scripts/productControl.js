$(document).ready(function() {
	$('#addProductForm').hide();
	bsCustomFileInput.init();
});

$('#addFormToggleBtn').on('click', function() {
	if ($(this).text() == '상품 추가') {
		$('#addProductForm').show();
		$(this).text('숨기기');
	} else {
		$('#addProductForm').hide();
		$(this).text('상품 추가');
	}
});

function checkAddProductForm(f) {
	if (f.name.value == '') {
		alert('상품명을 채워주십시오.');
		f.name.focus();
		return;
	} else if (isNaN(f.price.value)) {
		alert('숫자로만 입력해주세요.');
		f.price.focuse();
		return;
	} else if (f.price.value == '') {
		alert('가격을 입력해주세요.');
		f.price.focus();
		return;
	} else if (f.region.value == '') {
		alert('지역을 선택해주세요.');
		f.category.focus();
		return;
	} else if (f.country.value == '') {
		alert('국가를 입력해주세요.');
		f.country.focus();
		return;
	} else if (f.description.value == '') {
		alert('상세 설명을 입력해주세요.');
		f.dry.value();
		return;
	} else if (f.img.value == '') {
		alert('상품 사진을 업로드해주세요.');
		return;
	} else {
		var form = $('#productForm')[0];
		var formData = new FormData(form);

		$.ajax({
			"url" : "addProduct.do",
			"data" : formData,
			"processData" : false,
			"contentType" : false,
			"type" : "POST",
			"success" : function(data) {
				$('#custom-tabs-one-product').html(data);
				$('#addProductForm').hide();
				bsCustomFileInput.init();
			}
		});
	}

	$('#addProductForm').hide();
	$('#addFormToggleBtn').text('상품 추가');

}

function deleteProduct(id) {
	$.ajax({
		"url" : "delProduct.do",
		"data" : "id=" + id,
		"type" : "POST",
		"success" : function(data) {
			$('#custom-tabs-one-product').html(data);
			$('#addProductForm').hide();
			bsCustomFileInput.init();
		}
	});
}

