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
<script type="text/javascript">
function del(notID){
	location.href="${pageContext.request.contextPath}/NoticedeleteController?notID="+notID;
}

</script>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- SweetAlert2 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/sweetalert2/sweetalert2.min.css">
<!-- Toastr -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/toastr/toastr.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
</head>
<body>

<c:set var="str">
<c:if test="${sessionScope.id !=n.notWriter }"></c:if>
</c:set>

	<div class="wrapper">
		<!-- Header -->
		<%@ include file="header.jsp"%>

		<div class="content-wrapper">
			<section class="content">
			<div class="container">
			<form action = "${pageContext.request.contextPath }/NoticeeditController"method="post">
			<div class = "row">
			
			
			<h3>공지사항 상세보기</h3>
			<table class = "table table-default" style="text-align:center; border: 1px solid #dddddd">
					<tr>
					<th style=" text-align:center;">작성날짜</th>
					<td><input type = "text" value="${n.notDate }"name="notDate" class="form-control" maxlength="50" readonly></td>
					</tr>
					<tr>
					<th style=" text-align:center;">번호</th>
					<td><input type = "text" value="${n.notID }" name="notID" class="form-control" maxlength="50" readonly></td>
					</tr>
					<tr>
					<th style="text-align:center;">제목</th>
					<td><input type = "text" value="${n.notTitle }"name="notTitle" class="form-control" maxlength="50" readonly></td>
					</tr>
					<tr>
					<th style="text-align:center;">작성자</th>
					<td><input type = "text" value="${n.notWriter }"name="notWriter" class="form-control" maxlength="50" readonly></td>
					</tr>
					<tr>
					<th style="text-align:center;">내용</th>
					<td><textarea name="notContent" rows="15" cols="45" class="form-control" maxlength="50" readonly>${n.notContent }</textarea></td>
					</tr>
				<c:if test="${sessionScope.id == n.notWriter and sessionScope.id != null}">
					<tr>
					<td colspan="2">
					<input type = "submit" value="수정" class="btn btn-primary pull-right">
					<input type = "button" value="삭제" class="btn btn-primary pull-right" onclick="del(${n.notID })">
					</td>
					</tr>
					<script>
					window.onload = function(){
						alert("관리자님 hi");
						document.getElementsByName("notTitle")[0].readOnly = false;
						document.getElementsByName("notContent")[0].readOnly = false;
					}
					</script>
				</c:if>
					
			</table>
			</div>
			</form>
			</div>
			</section>
		</div>

		<!-- Main Footer -->
		<%@ include file="footer.jsp"%>
	</div>


	<!-- JQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE -->
	<script src="${pageContext.request.contextPath}/resources/dist/js/adminlte.js"></script>
</body>
</html>