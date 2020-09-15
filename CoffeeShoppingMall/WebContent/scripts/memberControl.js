function readUserInfo(userEmail) {
	var data = 'userEmail=' + userEmail;
	$.ajax({
		"url" : "readUserInfo",
		"data" : data,
		"method" : "POST",
		"success" : function(data) {
			$('#custom-tabs-one-member').html(data);
		}
	});
}