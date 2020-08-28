// ajax 사용을 위한 script 엘리먼트 삽입

/* const script = document.createElement('script');
script.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js';
script.type = 'text/javascript'

document.getElementsByTagName('head')[0].appendChild(script); */


function changeDomain() {
	const select = document.getElementById("select_domain");
	let emailDomain = document.getElementById("essential.emailDomain");

	if (select.value == "manual") {
		emailDomain.value = "";
		emailDomain.readOnly = "";
	}
	else if(select.value == "naver.com") {
		emailDomain.value = "naver.com";
		emailDomain.readOnly = true;
	}

	else if(select.value == "kakao.com") {
		emailDomain.value = "kakao.com";
		emailDomain.readOnly = true;
	}

	else if(select.value == "gmail.com") {
		emailDomain.value = "gmail.com";
		emailDomain.readOnly = true;
	}

	else if(select.value == "nate.com") {
		emailDomain.value = "nate.com";
		emailDomain.readOnly = true;
	}

	else if(select.value == "hotmail.com") {
		emailDomain.value = "hotmail.com";
		emailDomain.readOnly = true;
	}

	else {

	}
};

function checkPwd() {
	var pwdTxt = document.getElementById("essential.pwd");
	var pwd_confirmTxt = document.getElementById("essential.pwd_confirm");
	
	var span_policy = document.getElementById("checkresult_policy");
	var span_confirm = document.getElementById("checkresult_confirm");

	// 비밀번호 입력단 출력 문구 제어
	if(pwdTxt.value.length < 4 || pwdTxt.value.length > 12) {
		span_policy.style = "color: red;";

		if(pwdTxt.value.length != 0)
			span_policy.innerHTML = "비밀번호는 4~12글자 사이여야 합니다"
		else
			span_policy.innerHTML = "";
	} else {
		span_policy.style = "color: black;";
		span_policy.innerHTML = "";
	}

	// 비밀번호 확인 입력단 출력 문구 제어
	if(pwdTxt.value === pwd_confirmTxt.value) {
		span_confirm.style = "color: green;"

		if(pwd_confirmTxt.value != 0) {
			if(pwd_confirmTxt.value.length >= 4 && pwd_confirmTxt.value.length <= 12)
				span_confirm.innerHTML = "패스워드 일치";
			else {
				span_confirm.style = "color: red;";
				span_confirm.innerHTML = "비밀번호는 4~12글자 사이여야 합니다";
			}
		}

	} else {
		span_confirm.style = "color: red;"

		if(pwd_confirmTxt.value != 0)
			span_confirm.innerHTML = "패스워드 불일치";
		else
			span_confirm.innerHTML = "";

	}

}

function checkOpenAndHide() {
	var bussinessAdditionalDiv = document.getElementById("join_bussiness");

	var buyerNameTxt = document.getElementById("optional.buyer.name");
	var buyerAddressTxt = document.getElementById("optional.buyer.address");
	var buyerPhoneTxt = document.getElementById("optional.buyer.phone");
	var buyerRankTxt = document.getElementById("optional.buyer.rank");

	if(document.getElementsByName("essential.userType")[0].checked) {
		bussinessAdditionalDiv.style.display = "none";
		
		buyerNameTxt.value = "";
		buyerAddressTxt.value = "";
		buyerPhoneTxt.value = "";
		buyerRankTxt.value = "";

	}
	else if(document.getElementsByName("essential.userType")[1].checked) {
		bussinessAdditionalDiv.style.display = "block";
	}
	else
		bussinessAdditionalDiv.style.display = "none";
};

function checkPhone(event) {
	let numberTxt = event.target;

	if(isNaN(numberTxt.value)) {
		numberTxt.value = numberTxt.value.substring(0, numberTxt.value.length-1);
	}
}

function checkForm() {
	const emailId = document.getElementById("essential.emailId");
	const emailDomain = document.getElementById("essential.emailDomain");
	const pwd = document.getElementById("essential.pwd");
	const pwd_confirm = document.getElementById("essential.pwd_confirm");
	const userType = document.getElementsByName("essential.userType");
	const name = document.getElementById("essential.name");
	const nickname = document.getElementById("essential.nickname");
	const phone_head = document.getElementById("essential.phone_head");
	const phone_front = document.getElementById("essential.phone_front");
	const phone_back = document.getElementById("essential.phone_back");
	const address = document.getElementById("essential.address");

	if(emailId.value == "") {
		alert("이메일 주소를 확인해주세요");
		emailId.focus();
		return false;
	}

	else if(emailDomain.value == "") {
		alert("이메일 주소를 확인해주세요");
		emailDomain.focus();
		return false;
	}

	else if (pwd.value.length < 4 || pwd.value.length > 12) {
		alert("비밀번호는 4~12글자 사이여아 합니다");
		pwd.focus();
		return false;
	}

	else if (pwd.value !== pwd_confirm.value) {
		alert("비밀번호를 확인해주세요");
		pwd.focus();
		return false;
	}

	else if (userType[0].checked == "" && userType[1].checked == "" ) {
		alert("사용자 유형을 선택해주세요");
		userType[0].focus();
		return false;
	}

	else if(name.value == "") {
		alert("이름을 입력해주세요");
		name.focus();
		return false;
	}

	else if(nickname.value == "") {
		alert("닉네임을 입력해주세요");
		nickname.focus();
		return false;
	}

	else if(address.value == "") {
		alert("주소를 입력해주세요");
		address.focus();
		return false;
	}

	else if(phone_head.value == "") {
		alert("연락처를 입력해주세요");
		phone_head.focus();
		return false;
	}

	else if(phone_front.value == "") {
		alert("연락처를 입력해주세요");
		phone_front.focus();
		return false;
	}

	else if(phone_back.value == "") {
		alert("연락처를 입력해주세요");
		phone_back.focus();
		return false;
	} else if(userType[1].checked == true) {

		const buyer_name = document.getElementById("optional.buyer.name");
		const buyer_address = document.getElementById("optional.buyer.address");
		const buyer_phone = document.getElementById("optional.buyer.phone");
		const rank = document.getElementById("optional.buyer.rank");

		if(buyer_name.value == "") {
			alert("사업지명을 입력해주세요");
			buyer_name.focus();
			return false;
		} 

		else if (buyer_address.value == "") {
			alert("사업지 주소를 입력해주세요");
			buyer_address.focus();
			return false;
		}

		else if (buyer_phone.value == "") {
			alert("사업지 연락처를 입력해주세요");
			buyer_phone.focus();
			return false;
		}

		else if (rank.value == "") {
			alert("회원님의 직급을 입력해주세요");
			rank.focus();
			return false;
		}

		else {
		
		}
	}

	return true;
};

