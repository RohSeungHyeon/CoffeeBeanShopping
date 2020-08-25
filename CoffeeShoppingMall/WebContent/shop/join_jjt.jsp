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
			<form method="post" action="" name="joinForm" onsubmit="return checkForm">
				<table border="1">
					<caption style="text-align: left;">필수 정보</caption>
					<thead></thead>
					<tbody>
						<tr>
							<th class="header"> 아이디 </th>
							<td> 
								 <input type="text" name="essential.id" /> 
								 <button type="button" name="checkId" id="checkId" onclick="button_idCheck();">중복 확인</button>
							</td>
							
						</tr>
						<tr>
							<th class="header"> 패스워드 </th>
							<td> <input type="password" name="essential.pwd" id="essential.pwd" /> </td>
						</tr>
						<tr>
							<th class="header"> 패스워드 확인 </th>
							<td> <input type="password" name="essential.pwd_confirm" id="essential.pwd_confirm" /> </td>
						</tr>
						<tr>
							<th class="header"> 사용자 유형 </th>
							<td>
								개인 <input type="radio" name="essential.userType" value="1"/>
								사업자 <input type="radio" name="essential.userType" value="2"/>
							</td>
						</tr>
						<tr>
							<th class="header"> 이름 </th>
							<td> <input type="text" name="essential.name" /> </td>
						</tr>
						<tr>
							<th class="header"> 닉네임 </th>
							<td> <input type="text" name="essential.nickname" /> </td>
						</tr>
						<tr>
							<th class="header"> 이메일 </th>
							<td> <input type="email" name="essential.email" /> </td>
						</tr>
						<tr>
							<th class="header">연락처</th>
							<td> <input type="text" name="essential.phone" /> </td>
						</tr>
						
					</tbody>
				</table>
				
				<table border="1">
					<caption style="text-align: left;">추가 정보</caption>
					<thead></thead>
					<tbody>
						<tr>
							<th class="header">성별</th>
							<td>
								남 <input type="radio" name="optional.gender" value="male" />
								여 <input type="radio" name="optional.gender" value="female" />
							</td>
						</tr>
						<tr>
							<th class="header">연령대</th>
							<td>
								<select name="optional.age">
									<option value="10">10대</option>
									<option value="20">20~30대</option>
									<option value="30">40~50대</option>
								</select>
							</td>
						</tr>
						<tr>
							<th class="header"> 주소 </th>
							<td> <input type="text" name="optional.address" /> </td>
						</tr>
					</tbody>
				</table>
				
				<table border="1">
					<caption style="text-align: left;">사업자 추가 정보</caption>
					<thead></thead>
					<tbody>
						<tr>
							<th class="header">상호명</th>
							<td><input type="text" name="optional.buyer.name" /> </td>
						</tr>
						<tr>
							<th class="header">사업지 주소</th>
							<td><input type="text" name="optional.buyer.address" /> </td>
						</tr>
						<tr>
							<th class="header">사업지 연락처</th>
							<td><input type="text" name="optional.buyer.phone" /> </td>
						</tr>
						<tr>
							<th class="header">직급</th>
							<td><input type="text" name="optional.buyer.rank" /> </td>
						</tr>
						
					</tbody>
				</table>
			</form>
		</div>

	</body>
</html>