function checkAccount() {
	var username = document.getElementById("username");
	var phone_head = document.getElementById("phone_head");
	var phone_front = document.getElementById("phone_front");
	var phone_back = document.getElementById("phone_back");

	if(username.value == "") {
		alert('이름을 입력해주세요');
		username.focus();
		return false;

	} else if(phone_head.value == "") {
		alert('연락처를 입력해주세요');
		phone_head.focus();
		return false;

	} else if(phone_front.value == "") {
		alert('연락처를 입력해주세요');
		phone_front.focus();
		return false;

	} else if(phone_back.value == "") {
		alert('연락처를 입력해주세요');
		phone_back.focus();
		return false;
	} else {
		var HttpMethod = "POST";
		var HttpURL = "../find_id.do";
		var HttpParam = "username="+username.value+"&"+"phone="+phone_head.value+"-"+phone_front.value+"-"+phone_back.value;

		var callback = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				const resultObj = JSON.parse(xhr.responseText);

				if(resultObj.result == true) {
					var message = resultObj.message;
					document.getElementById("result_account").innerHTML = message;
				} else {
					var message = resultObj.message;
					document.getElementById("result_account").innerHTML = message;
				}
			}
		};

		sendRequest(HttpURL, HttpParam, HttpMethod, callback, true);

	}

	return false;
}