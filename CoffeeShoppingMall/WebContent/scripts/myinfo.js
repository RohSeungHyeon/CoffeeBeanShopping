var checkPwdResult = false;

function checkPwd() {
	var pwdTxt = document.getElementById("essential.pwd");
	var pwd_confirmTxt = document.getElementById("essential.pwd_confirm");
	
	var span_policy = document.getElementById("checkresult_policy");
	var span_confirm = document.getElementById("checkresult_confirm");

	// 비밀번호 입력단 출력 문구 제어
	if(pwdTxt.value.length < 4 || pwdTxt.value.length > 12) {
		span_policy.style = "color: red;";

		if(pwdTxt.value.length != 0) {
			span_policy.innerHTML = "비밀번호는 4~12글자 사이여야 합니다"
		} else 
			span_policy.innerHTML = "";
	} else {
		span_policy.style = "color: black;";
		span_policy.innerHTML = "";
	}

	// 비밀번호 확인 입력단 출력 문구 제어
	// 수정 사항 제출 시 유효성 검증
	if(pwdTxt.value === pwd_confirmTxt.value) {
		span_confirm.style = "color: green;"

		if(pwd_confirmTxt.value.length != 0) {
			if(pwd_confirmTxt.value.length >= 4 && pwd_confirmTxt.value.length <= 12) {
				span_confirm.innerHTML = "패스워드 일치";
				checkPwdResult = true;
			} else {
				span_confirm.style = "color: red;";
				span_confirm.innerHTML = "비밀번호는 4~12글자 사이여야 합니다";
				checkPwdResult = false;
			}
		}

	} else {
		span_confirm.style = "color: red;"

		if(pwd_confirmTxt.value.length != 0)
			span_confirm.innerHTML = "패스워드 불일치";
		else
			span_confirm.innerHTML = "";

		checkPwdResult = false;
	}

}

function checkPhone(event) {
	let numberTxt = event.target;

	if(isNaN(numberTxt.value)) {
		numberTxt.value = numberTxt.value.substring(0, numberTxt.value.length-1);
	}
}

function checkForm() {
	const essential_pwd = document.getElementById("essential.pwd");
	const essential_pwd_confirm = document.getElementById("essential.pwd_confirm");
	const essential_nickname = document.getElementById("essential.nickname");
	const essential_address = document.getElementById("essential.address");
	const essential_phone_head = document.getElementById("essential.phone_head");
	const essential_phone_front = document.getElementById("essential.phone_front");
	const essential_phone_back = document.getElementById("essential.phone_back");
	
	const optional_gender = document.getElementById("optional.gender");
	const optional_birth_yy = document.getElementById("optional.birth_yy");
	const optional_birth_mm = document.getElementById("optional.birth_mm");
	const optional_birth_dd = document.getElementById("optional.birth_dd");

	if(document.getElementById(optional.buyer.name) != undefined) 
		const optional_buyer_name = document.getElementById(optional.buyer.name);

	if(document.getElementById(optional.buyer.address) != undefined) 
		const optional_buyer_address = document.getElementById(optional.buyer.address);

	if(document.getElementById(optional.buyer.name) != undefined) 
		const optional_buyer_name = document.getElementById(optional.buyer.name);


}