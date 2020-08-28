function editNotice(data) {
	var jData = data;
	$.ajax({
		"url" : "editNotice",
		"data" : jData,
		"method" : "POST",
		"success" : function(data) {
			$('#custom-tabs-one-notice').html(data);
		}
	});
}

function editNoticeConfirm(f) {
	if (f.notTitle.value == '') {
		alert('제목을 입력해주세요.')
		f.notTitle.focus();
		return;
	} else if (f.notContent.value == '') {
		alert('내용을 입력해주세요.');
		f.notContent.focus();
		return;
	}

	var data = $('#editNoticeForm').serialize();

	$.ajax({
		"url" : "editNotice.do",
		"data" : data,
		"success" : function(data) {
			$('#custom-tabs-one-notice').html(data);
		}
	});
}

function deleteNotice(notID) {
	var data = 'notID=' + notID;

	$.ajax({
		"url" : "deleteNotice.do",
		"data" : data,
		"method" : "post",
		"success" : function(data) {
			$('#custom-tabs-one-notice').html(data);
		}
	});
}

function writeNotice() {
	$.ajax({
		"url" : "writeNotice",
		"method" : "POST",
		"success" : function(data) {
			$('#custom-tabs-one-notice').html(data);
		}
	});
}

function writeNoticeConfirm(f) {

	if (f.notTitle.value == '') {
		alert('제목을 입력해주세요.')
		f.notTitle.focus();
		return;
	} else if (f.notContent.value == '') {
		alert('내용을 입력해주세요.');
		f.notContent.focus();
		return;
	}

	var data = $('#writeNoticeForm').serialize();

	$.ajax({
		"url" : "writeNotice.do",
		"data" : data,
		"success" : function(data) {
			$('#custom-tabs-one-notice').html(data);
		}
	});
}