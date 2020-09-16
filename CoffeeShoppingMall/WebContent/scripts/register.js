// OAuth를 이용한 회원 가입 도중 취소 시 처리해야 할 상황

function cancelRegister() {
	const HttpURL = "../oauth/invalidate.do";
	const HttpParam = "";
	const HttpMethod = "GET";

	var callback = function() {
		var resObj = JSON.parse(xhr.responseText);
		if(resObj.result == true)
		location.href = "../MainController";
		else {
			alert("문제 발생");
		}
	};

	sendRequest(HttpURL, HttpParam, HttpMethod, callback, false);
};