/*
	작성자 : 주정택
	이메일 : j3470@hotmail.com
	설명 : 로그인 페이지 페이지 관련 함수들
*/

// 로그인 창의 id/pwd 입력 확인 함
function checkIdAndPwd() {
			const emailTxt = document.getElementById("email");
			const pwdTxt = document.getElementById("pwd");

			var element = document.getElementById("checkresult");

			if(emailTxt.value == "" || pwdTxt.value == "") {
				element.innerHTML = "아이디와 패스워드를 입력해주세요";
				return;
			}
			
			const HttpURL = "../login.do";
			const HttpMethod = "POST";
			const HttpParam = "email=" + emailTxt.value + "&" +"pwd=" + pwdTxt.value;
			
			const callBackFunc = function() {
				
				if(xhr.readyState == 4 && xhr.status == 200) {
					const jsonObj = JSON.parse(xhr.responseText);
					
					if(jsonObj.result) {
						location.href = "../shop/main.jsp";
					} else {
						element.innerHTML = "아이디나 패스워드가 일치하지 않습니다";
					}
				}
			};
			
			sendRequest(HttpURL, HttpParam, HttpMethod, callBackFunc, true);
		}