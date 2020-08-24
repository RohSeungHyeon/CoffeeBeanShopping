// ajax 사용을 위한 script 엘리먼트 삽입

const script = document.createElement('script');
script.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js';
script.type = 'text/javascript'

document.getElementsByTagName('head')[0].appendChild(script);


function button_idCheck() {
	const idCheckButton = document.getElementById('checkId');

	return true;

}

const textInput_PwdConfirm = document.getElementById('essential.pwd_confirm');
const textInput_Pwd
textInput_PwdConfirm.addEventListener('input', checkPwdValue);

function checkPwdValue() {

}

var textInput_Pwd = document.getElementById('essential.pwd');
var textInput_PwdConfirm = document.getElementById('essential.pwd_confirm');


function checkForm() {
	
};

