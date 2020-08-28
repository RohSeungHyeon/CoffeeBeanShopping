function addCart(id, m_id) {
	var data = "p_id=" + id + "&m_id=" + m_id;
	$.ajax({
		"url" : "AddCartController",
		"data" : data,
		"type" : "POST",
		"success" : function(data) {
			alert("장바구니에 담겼습니다.");
		}
	});
}