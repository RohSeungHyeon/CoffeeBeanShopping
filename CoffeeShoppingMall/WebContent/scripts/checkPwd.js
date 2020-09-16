/*
	작성자 : 주정택
	이메일 : j3470@hotmail.com
	설명 : 회원 정보 수정 페이지 진입 전 비밀번호 확인 페이지 관련 함수들
*/

// 패스워드 창의 빈 입력 확인
function checkPwd() {
	const pwd = document.getElementById("pwd");

	if(pwd.value == "") {
		alert('비밀번호를 입력해주세요');
		return false;
	} else {
		return true;
	}
}

