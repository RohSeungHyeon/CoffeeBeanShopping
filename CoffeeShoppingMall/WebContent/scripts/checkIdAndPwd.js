
(function fillEmailInTextbox() {
	const savedEmail = localStorage.getItem("user_email");
	
	if(savedEmail != null) {
		document.getElementById("email").value = savedEmail;
	}
})();

var pwdElement = document.getElementById("pwd");

pwdElement.addEventListener("keyup", function(event) {
	if(event.keyCode == 13) {
		event.preventDefault();
		document.getElementById("btn_login").click();
	}
})

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
			const HttpParam = "email=" + emailTxt.value + "&" + "pwd=" + pwdTxt.value;
			
			const callBackFunc = function() {
				
				if(xhr.readyState == 4 && xhr.status == 200) {
					const jsonObj = JSON.parse(xhr.responseText);
					const checkIdRemember = document.getElementById("remember");
					
					if(jsonObj.result) {
						if(checkIdRemember.checked == true)
							localStorage.setItem("user_email", emailTxt.value);
						else {
							if(localStorage.getItem("user_email") != null)
								localStorage.removeItem("user_email");
						}
						location.href = "../MainController";
					} else {
						element.style.color = "red";
						element.innerHTML = "아이디나 패스워드가 일치하지 않습니다";
					}
				}
			};
			
			sendRequest(HttpURL, HttpParam, HttpMethod, callBackFunc, true);
		}