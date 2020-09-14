// 비동기 통신을 위한 sendRequest 함수

var xhr;

function createHttpRequest() {
	if(xhr != null) {
		return;
	} else if(window.ActiveXObject) {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		xhr = new XMLHttpRequest();
	}
}

function sendRequest(url, param, method, callback, isAsync) {

	createHttpRequest();

	var HttpMethod = "GET";
	if(method.toUpperCase() == "POST") {
		HttpMethod = "POST"
	}

	var HttpParam = param;
	if(param == "") {
		HttpParam = null;
	}

	var HttpURL = url;
	if(HttpMethod == "GET" && HttpParam != null) {
		HttpURL = HttpURL + "?" + HttpParam;
	}

	xhr.open(HttpMethod, HttpURL, isAsync);
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = callback;

	if(HttpMethod == "GET") {
		xhr.send(null);
	} else {
		xhr.send(HttpParam);
	}

}