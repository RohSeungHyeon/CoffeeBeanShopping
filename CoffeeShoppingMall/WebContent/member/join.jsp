<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인 페이지</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- SweetAlert2 -->
<link rel="stylesheet"
	href="../resources/plugins/sweetalert2/sweetalert2.min.css">
<!-- Toastr -->
<link rel="stylesheet" href="../resources/plugins/toastr/toastr.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../resources/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<!-- Header -->
		<%@ include file="../shop/header.jsp"%>

		<div class="content-wrapper">
			<section class="content">
				<h2>회원 가입</h2>
		<div id="join">
			<form method="post" action="${pageContext.servletContext.contextPath}/join" name="joinForm" onsubmit="return checkForm()">
				<div id="join_essential">
					<table class="table">
						<caption style="text-align: left;">필수 정보</caption>
						<thead></thead>
						<tbody>
							<tr>
								<th class="header"> 이메일 </th>
								<td class="content"> 
									 <input type="text" name="essential.emailId" id="essential.emailId" placeholder="Email Id" autocomplete = "off"/>&nbsp;@&nbsp;
									 <input type="text" name="essential.emailDomain" id="essential.emailDomain" placeholder="Email Domain" autocomplete = "off"/>
									 <select name="select_domain" id="select_domain" onchange="changeDomain()">
									 	<option value="manual">직접 입력</option>
									 	<option value="naver.com">naver.com</option>
									 	<option value="kakao.com">kakao.com</option>
									 	<option value="gmail.com">gmail.com</option>
									 	<option value="nate.com">nate.com</option>
									 	<option value="hotmail.com">hotmail.com</option>
									 </select>
								</td>
								
							</tr>
							<tr>
								<th class="header"> 패스워드 </th>
								<td class="content"> <input type="password" name="essential.pwd" id="essential.pwd" onkeyup="checkPwd()" />
								<span id="checkresult_policy"></span></td>
							</tr>
							<tr>
								<th class="header"> 패스워드 확인 </th>
								<td class="content"> <input type="password" name="essential.pwd_confirm" id="essential.pwd_confirm" onkeyup="checkPwd()" /> 
								<span id="checkresult_confirm"></span></td>
							</tr>
							<tr>
								<th class="header"> 사용자 유형 </th>
								<td class="content">
									개인 <input type="radio" name="essential.userType" id="essential.userType" value="개인" onclick="checkOpenAndHide();"/>
									사업자 <input type="radio" name="essential.userType" id="essential.userType" value="사업자" onclick="checkOpenAndHide();"/>
								</td>
							</tr>
							<tr>
								<th class="header"> 이름 </th>
								<td class="content"> <input type="text" name="essential.name" id="essential.name" placeholder="이름" autocomplete = "off"/> </td>
							</tr>
							<tr>
								<th class="header"> 닉네임 </th>
								<td class="content"> <input type="text" name="essential.nickname" id="essential.nickname" placeholder="별명" autocomplete = "off" /> </td>
							</tr>
							<tr>
								<th class="header"> 주소 </th>
								<td class="content"> <input type="text" name="essential.address" id="essential.address" placeholder="주소" autocomplete = "off" /> </td>
							</tr>
							<tr>
								<th class="header">연락처</th>
								<td class="content"> 
									<input type="text" name="essential.phone_head" id="essential.phone_head" autocomplete = "off" maxlength="3" style="width: 70px;" onkeyup="checkPhone(event)" />
									-
									<input type="text" name="essential.phone_front" id="essential.phone_front" autocomplete = "off" maxlength="4" style="width: 70px;" onkeyup="checkPhone(event)" />
									-
									<input type="text" name="essential.phone_back" id="essential.phone_back" autocomplete = "off" maxlength="4" style="width: 70px;" onkeyup="checkPhone(event)" /> 
								</td>
							</tr>
							
						</tbody>
					</table>
				</div>
				
				<div id="join_addtional">
					<table class="table">
						<caption style="text-align: left;">추가 정보</caption>
						<thead></thead>
						<tbody>
							<tr>
								<th class="header">성별</th>
								<td class="content">
									<select name="optional.gender" id="optional.gender">
										<option value="N"></option>
										<option value="M">남성</option>
										<option value="F">여성</option>
									</select>
								</td>
							</tr>
							
						<tr>
							<th class="header">생년월일</th>
							<td class="content">
							 
							<select name="optional.birth_yy" id="optional.birth_yy" style="width: 80px">
									<option value=""></option>
									<option value="2006">2006</option>
									<option value="2005">2005</option>
									<option value="2004">2004</option>
									<option value="2003">2003</option>
									<option value="2002">2002</option>
									<option value="2001">2001</option>
									<option value="2000">2000</option>
									<option value="1999">1999</option>
									<option value="1998">1998</option>
									<option value="1997">1997</option>
									<option value="1996">1996</option>
									<option value="1995">1995</option>
									<option value="1994">1994</option>
									<option value="1993">1993</option>
									<option value="1992">1992</option>
									<option value="1991">1991</option>
									<option value="1990">1990</option>
									<option value="1989">1989</option>
									<option value="1988">1988</option>
									<option value="1987">1987</option>
									<option value="1986">1986</option>
									<option value="1985">1985</option>
									<option value="1984">1984</option>
									<option value="1983">1983</option>
									<option value="1982">1982</option>
									<option value="1981">1981</option>
									<option value="1980">1980</option>
									<option value="1979">1979</option>
									<option value="1978">1978</option>
									<option value="1977">1977</option>
									<option value="1976">1976</option>
									<option value="1975">1975</option>
									<option value="1974">1974</option>
									<option value="1973">1973</option>
									<option value="1972">1972</option>
									<option value="1971">1971</option>
									<option value="1970">1970</option>
									<option value="1969">1969</option>
									<option value="1968">1968</option>
									<option value="1967">1967</option>
									<option value="1966">1966</option>
									<option value="1965">1965</option>
									<option value="1964">1964</option>
									<option value="1963">1963</option>
									<option value="1962">1962</option>
									<option value="1961">1961</option>
									<option value="1960">1960</option>
									<option value="1959">1959</option>
									<option value="1958">1958</option>
									<option value="1957">1957</option>
									<option value="1956">1956</option>
									<option value="1955">1955</option>
									<option value="1954">1954</option>
									<option value="1953">1953</option>
									<option value="1952">1952</option>
									<option value="1951">1951</option>
									<option value="1950">1950</option>
									<option value="1949">1949</option>
									<option value="1948">1948</option>
									<option value="1947">1947</option>
									<option value="1946">1946</option>
									<option value="1945">1945</option>
									<option value="1944">1944</option>
									<option value="1943">1943</option>
									<option value="1942">1942</option>
									<option value="1941">1941</option>
									<option value="1940">1940</option>
									<option value="1939">1939</option>
									<option value="1938">1938</option>
									<option value="1937">1937</option>
									<option value="1936">1936</option>
									<option value="1935">1935</option>
									<option value="1934">1934</option>
									<option value="1933">1933</option>
									<option value="1932">1932</option>
									<option value="1931">1931</option>
									<option value="1930">1930</option>
									<option value="1929">1929</option>
									<option value="1928">1928</option>
									<option value="1927">1927</option>
									<option value="1926">1926</option>
									<option value="1925">1925</option>
									<option value="1924">1924</option>
									<option value="1923">1923</option>
									<option value="1922">1922</option>
									<option value="1921">1921</option>
									<option value="1920">1920</option>
							</select>
								년 
							<select name="optional.birth_mm" id="optional.birth_mm" style="width: 60px">
									<option value=""></option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
							</select>
								월 
							<select name="optional.birth_dd" id="optional.birth_dd" style="width: 60px">
									<option value=""></option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
							</select>
								일
							</td>
						</tr>
					</tbody>
					</table>
				</div>
				
				<div id="join_bussiness" style="display: none;">
					<table class="table">
						<caption style="text-align: left;">사업자 추가 정보</caption>
						<thead></thead>
						<tbody>
							<tr>
								<th class="header">상호명</th>
								<td class="content"><input type="text" name="optional.buyer.name" id="optional.buyer.name" autocomplete = "off"/> </td>
							</tr>
							<tr>
								<th class="header">사업지 주소</th>
								<td class="content"><input type="text" name="optional.buyer.address" id="optional.buyer.address" autocomplete = "off" /> </td>
							</tr>
							<tr>
								<th class="header">사업지 연락처</th>
								<td class="content"><input type="text" name="optional.buyer.phone" id="optional.buyer.phone" autocomplete = "off"/> </td>
							</tr>
							<tr>
								<th class="header">직급</th>
								<td class="content"><input type="text" name="optional.buyer.rank" id="optional.buyer.rank" autocomplete = "off"/> </td>
							</tr>
							
						</tbody>
					</table>
				</div>
				
				<input type="submit" value="등록" />
				<input type="button" value="취소" onclick="location.href='main.jsp'" />
			</form>
		</div>
			</section>
		</div>

		<!-- Main Footer -->
		<%@ include file="../shop/footer.jsp"%>
	</div>


	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- User defined JavaScript -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/join.js" charset="UTF-8" defer="defer"></script>
	<!-- Bootstrap -->
	<script src="../resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE -->
	<script src="../resources/dist/js/adminlte.js"></script>
</body>
</html>