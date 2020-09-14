function readQna(data) {
	var jData = data;
	$.ajax({
		"url" : "readQna",
		"data" : jData,
		"method" : "POST",
		"success" : function(data) {
			$('#custom-tabs-one-qna').html(data);
		}
	});
}

function deleteQna(qnaID) {
	var data = 'qnaID=' + qnaID;

	$.ajax({
		"url" : "deleteQna.do",
		"data" : data,
		"method" : "post",
		"success" : function(data) {
			$('#custom-tabs-one-qna').html(data);
		}
	});
}