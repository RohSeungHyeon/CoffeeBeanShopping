<%@ page import="org.json.simple.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.userprofile }">
	<c:redirect url="/member/login.jsp" />
</c:if>

<%
	JSONObject userProfile = (JSONObject) session.getAttribute("userprofile");
	String infoFrom = (String)userProfile.get("infoFrom");
	String email = (String) userProfile.get("email");
	String[] idAndDomain = email.split("@");
	String name = (String)userProfile.get("name");
	String nickName = (String)userProfile.get("nickname");
	String birthday = (String)userProfile.get("birthday");
	String gender = (String)userProfile.get("gender");
	
	if(infoFrom.equals("naver") && birthday != null) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(birthday.charAt(0));
		buffer.append(birthday.charAt(1));
		buffer.append(birthday.charAt(3));
		buffer.append(birthday.charAt(4));
		
		birthday = buffer.toString();
	}
	
	pageContext.setAttribute("birthday", birthday);
	pageContext.setAttribute("gender", gender);

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 가입</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/join.css"/>
	</head>
	<body>
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
									 <input type="text" name="essential.emailId" id="essential.emailId" 
									 	value="<%=idAndDomain[0] %>" readonly/>&nbsp;@&nbsp;
									 <input type="text" name="essential.emailDomain" id="essential.emailDomain" 
									 	value="<%=idAndDomain[1] %>" readonly/>
									 <select name="select_domain" id="select_domain" onchange="changeDomain()" disabled>
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
								<td class="content"> <input type="text" name="essential.name" id="essential.name" value="<%=name%>" autocomplete="off"/> </td>
							</tr>
							<tr>
								<th class="header"> 닉네임 </th>
								<td class="content"> <input type="text" name="essential.nickname" id="essential.nickname" value="<%=nickName%>" autocomplete="off"/> </td>
							</tr>
							<tr>
								<th class="header"> 주소 </th>
								<td class="content"> <input type="text" name="essential.address" id="essential.address" autocomplete="off"/> </td>
							</tr>
							<tr>
								<th class="header">연락처</th>
								<td class="content"> 
									<input type="text" name="essential.phone_head" id="essential.phone_head" maxlength="3" style="width: 70px;" autocomplete="off" onkeyup="checkPhone(event)" />
									-
									<input type="text" name="essential.phone_front" id="essential.phone_front" maxlength="4" style="width: 70px;" autocomplete="off" onkeyup="checkPhone(event)" />
									-
									<input type="text" name="essential.phone_back" id="essential.phone_back" maxlength="4" style="width: 70px;" autocomplete="off" onkeyup="checkPhone(event)" /> 
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
									<script type='text/javascript'>
										var select = document.getElementById('optional.gender');
										select.options[${pageScope.gender == 'M' ? 1 : 2}].selected = true;
									</script>
								</td>
							</tr>
							
						<tr>
							<th class="header">생년월일</th>
							<td class="content">
							 
							<select name="optional.birth_yy" id="optional.birth_yy$" style="width: 80px">
									<option value=""></option>
									<option value="2020">2020</option>
									<option value="2019">2019</option>
									<option value="2018">2018</option>
									<option value="2017">2017</option>
									<option value="2016">2016</option>
									<option value="2015">2015</option>
									<option value="2014">2014</option>
									<option value="2013">2013</option>
									<option value="2012">2012</option>
									<option value="2011">2011</option>
									<option value="2010">2010</option>
									<option value="2009">2009</option>
									<option value="2008">2008</option>
									<option value="2007">2007</option>
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
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
							</select>
								월
							<script type="text/javascript">
								var select_month = document.getElementById('optional.birth_mm');
									
								var month = '${pageScope.birthday}'.substring(0,2);
								
								for(i = 0; i < select_month.options.length; i++) {
									if(select_month.options[i].value == month)
										select_month.options[i].selected = true;
								}
								
							</script>
							<select name="optional.birth_dd" id="optional.birth_dd" style="width: 60px">
									<option value=""></option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
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
							<script type="text/javascript">
								var select_day = document.getElementById('optional.birth_dd');
									
								var day = '${pageScope.birthday}'.substring(2);
								
								for(i = 0; i < select_day.options.length; i++) {
									if(select_day.options[i].value == day){
										select_day.options[i].selected = true;
									}
								}
								
							</script>	
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
								<td class="content"><input type="text" name="optional.buyer.name" id="optional.buyer.name" autocomplete="off" /> </td>
							</tr>
							<tr>
								<th class="header">사업지 주소</th>
								<td class="content"><input type="text" name="optional.buyer.address" id="optional.buyer.address" autocomplete="off" /> </td>
							</tr>
							<tr>
								<th class="header">사업지 연락처</th>
								<td class="content"><input type="text" name="optional.buyer.phone" id="optional.buyer.phone" autocomplete="off" /> </td>
							</tr>
							<tr>
								<th class="header">직급</th>
								<td class="content"><input type="text" name="optional.buyer.rank" id="optional.buyer.rank" autocomplete="off" /> </td>
							</tr>
							
						</tbody>
					</table>
				</div>
				
				<input type="submit" value="등록" />
				<!--  등록 취소 시 OAuth를 이용해 세션 객체에 할당한 정보 소거 -->
				<input type="button" id="btn_cancel" value="취소" onclick="cancelRegister()">
			</form>		
		</div>

		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"> </script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/requestHttp.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/join.js" charset="utf-8"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/register.js" charset="utf-8"></script>
	</body>
</html>