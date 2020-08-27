<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 가입</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/join.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/join.js" charset="utf-8 "defer="defer"></script>
	</head>
	<body>
		<div id="join">
			<form method="post" action="${pageContext.servletContext.contextPath}/join" name="joinForm" onsubmit="return checkForm();">
				<div id="join_essential">
					<table class="table">
						<caption style="text-align: left;">필수 정보</caption>
						<thead></thead>
						<tbody>
							<tr>
								<th class="header"> 이메일 </th>
								<td class="content"> 
									 <input type="text" name="emailId" id="essential.emaidId" />&nbsp;@&nbsp;
									 <input type="text" name="emailDomain" id="essential.emailDomain" />
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
								<td class="content"> <input type="text" name="essential.name" id="essential.name" value="${sessionScope.userprofile.name}" readonly/> </td>
							</tr>
							<tr>
								<th class="header"> 닉네임 </th>
								<td class="content"> <input type="text" name="essential.nickname" id="essential.nickname" value="${sessionScope.userprofile.nickname}" /> </td>
							</tr>
							<tr>
								<th class="header">연락처</th>
								<td class="content"> <input type="text" name="essential.phone" id="essential.phone" /> </td>
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
									남 <input type="radio" name="optional.gender" id="optional.gender" value="male" />
									여 <input type="radio" name="optional.gender" id="optional.gender" value="female" />
								</td>
							</tr>
							<tr>
								<th class="header">연령대</th>
								<td class="content">
									<select name="optional.age" id="optional.age">
										<option value="10">10대</option>
										<option value="20">20~30대</option>
										<option value="30">40~50대</option>
									</select>
								</td >
							</tr>
							<tr>
								<th class="header"> 주소 </th>
								<td class="content"> <input type="text" name="optional.address" id="optional.address" /> </td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div id="join_bussiness">
					<table class="table">
						<caption style="text-align: left;">사업자 추가 정보</caption>
						<thead></thead>
						<tbody>
							<tr>
								<th class="header">상호명</th>
								<td class="content"><input type="text" name="optional.buyer.name" id="optional.buyer.name"/> </td>
							</tr>
							<tr>
								<th class="header">사업지 주소</th>
								<td class="content"><input type="text" name="optional.buyer.address" id="optional.buyer.address" /> </td>
							</tr>
							<tr>
								<th class="header">사업지 연락처</th>
								<td class="content"><input type="text" name="optional.buyer.phone" id="optional.buyer.phone" /> </td>
							</tr>
							<tr>
								<th class="header">직급</th>
								<td class="content"><input type="text" name="optional.buyer.rank" id="optional.buyer.rank" /> </td>
							</tr>
							
						</tbody>
					</table>
				</div>
				
				<input type="submit" value="등록" />
			</form>
		</div>

	</body>
</html>