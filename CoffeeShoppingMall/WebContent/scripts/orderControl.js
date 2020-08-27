function editOrderStatus(order_id) {
	var status = $('#slt_order_' + order_id).val();
	var data = 'order_id=' + order_id + '&status=' + status;

	$.ajax({
		"url" : "changeOrderStatus.do",
		"data" : data,
		"method" : "POST",
		"success" : function(data) {
			$('#custom-tabs-one-order').html(data);
		}
	});
}