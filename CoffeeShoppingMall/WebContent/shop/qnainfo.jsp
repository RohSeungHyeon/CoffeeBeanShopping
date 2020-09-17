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
function del(qnaID){
	location.href="${pageContext.request.contextPath}/QnadeleteController?qnaID="+qnaID;
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
<c:if test="${sessionScope.id !=q.qnaWriter }"></c:if>
</c:set>

	<div class="wrapper">
		<!-- Header -->
		<%@ include file="header.jsp"%>

		<div class="content-wrapper">
			<section class="content">
			<div class="container">
			<form action = "${pageContext.request.contextPath }/QnaeditController"method="post">
			<div class = "row">
				<h3>Q&A상세보기</h3>
				<table class = "table table-default" style="text-align:center; border: 1px solid #dddddd">
						<tr>
						<th style=" text-align:center;">작성날짜</th>
						<td><input type = "text" value="${q.qnaDate }"name="qnaDate" class="form-control" maxlength="50" readonly></td>
						</tr>
						<tr>
						<th style=" text-align:center;">번호</th>
						<td><input type = "text" value="${q.qnaID }" name="qnaID" class="form-control" maxlength="50" readonly></td>
						</tr>
						<tr>
						<th style="text-align:center;">제목</th>
						<td><input type = "text" value="${q.qnaTitle }"name="qnaTitle" class="form-control" maxlength="50" readonly></td>
						</tr>
						<tr>
						<th style="text-align:center;">작성자</th>
						<td><input type = "text" value="${q.qnaWriter }"name="qnaWriter" class="form-control" maxlength="50" readonly></td>
						</tr>
						<tr>
						<th style="text-align:center;">내용</th>
						<td><textarea name="qnaContent" rows="15" cols="45" class="form-control" maxlength="50" readonly>${requestScope.content }</textarea></td>
						</tr>
					<c:if test="${sessionScope.userprofile.nickname == q.qnaWriter }">
						<tr>
						<td colspan="2">
						<input type = "submit" value="수정" class="btn btn-primary pull-right">
						<input type = "button" value="삭제" class="btn btn-primary pull-right" onclick="del(${q.qnaID })">
						</td>
						</tr>
						<script>
						window.onload = function(){
							document.getElementsByName("qnaTitle")[0].readOnly = false;
							document.getElementsByName("qnaContent")[0].readOnly = false;
						}
						</script>
					</c:if>
				</table>
			</div>
			</form>
			
			<c:if test="${sessionScope.id != null }">
				<form method="post" action="${pageContext.request.contextPath}/CommentWriteController">
					<div>
						<h4>Comment</h4>
						<textarea name="comContent" rows="4" cols="40" class="form-control" maxlength="50" placeholder="댓글입력해"></textarea>
						<input type="hidden" name="qnaID" value="${q.qnaID }">
						<input type = "submit" value="댓글달기" class="btn btn-primary pull-right" id="btnComment">
					</div>
				</form>
			</c:if>
			
			
			<div>
			<%-- 		<c:import url="/CommentlistController"></c:import> --%>
				<c:if test="${not empty comlist}">
					<hr>
				</c:if>
			
				<c:forEach var = "comlist" items="${comlist }">
					<h4>${comlist.comDate }  작성자명:${comlist.comWriter }</h4>
					<c:choose>
						<c:when test="${sessionScope.userprofile.nickname == comlist.comWriter }">
							<%-- 수정, 삭제 버튼 생성 --%>
							<div>
								<textarea name="comContent" rows="4" cols="40" class="form-control" maxlength="50">${comlist.comContent }</textarea>
								<input type = "hidden" name="comID" value="${comlist.comID }">
								<input type = "hidden" name="qnaID" value="${q.qnaID}"/>
								<input type = "button" value="수정" onclick="modify(this);" class="btn btn-info pull-right">
								<input type = "button" value="삭제" onclick="remove(this);" class="btn btn-success pull-right">
							</div>
							<br>
						</c:when>
						
						<c:otherwise>
							<textarea name="comContent" rows="4" cols="40" class="form-control" maxlength="50" readonly>${comlist.comContent }</textarea>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<!-- <h4>댓글목록</h4>
				<textarea name="text"rows="2" cols="40" class="form-control" maxlength="50" readonly>이거문제는 아니잖아?</textarea> -->
			</div>
			
			</div>
			</section>
		</div>

		<!-- Main Footer -->
		<%@ include file="footer.jsp"%>
	</div>


	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE -->
	<script src="${pageContext.request.contextPath}/resources/dist/js/adminlte.js"></script>
	<script>
		function modify(btn) {
			btn = btn.parentNode;
			let url      = "${pageContext.request.contextPath}/CommentModifyController";
			let textarea = btn.querySelector('textarea');
			let hidden   = btn.querySelectorAll('input[type="hidden"]');
			
			// ?comContent=날짜가+바뀔까123&comID=21
			//url = url + '?' + textarea.name + '=' + textarea.value;
			var data = "";
			data += textarea.name+"="+textarea.value+"&";
			console.log(url);
			for(let i = 0; i<hidden.length; ++i){
				if(i == hidden.length - 1){
					data += hidden[i].name + "=" + hidden[i].value;
				} else {
					data += hidden[i].name + "=" + hidden[i].value + "&";
				}
			}
			data = data.trim();
			console.log(data);
			// url 로 query 는 comContent 랑 hidden[i].name 으로 전달
			$.ajax({
				url: url,
				type:'POST',
				data:data,
			});
			
			window.location.reload();
		}
		function remove(btn) {
			btn = btn.parentNode;
			let url = "${pageContext.request.contextPath}/CommentDeleteController";
			let hidden = btn.querySelectorAll('input[type="hidden"]');
			var data = "";
			console.log(url);
			for(let i = 0; i<hidden.length; ++i){
				if(i == hidden.length - 1){
					data += hidden[i].name + "=" + hidden[i].value;
				} else {
					data += hidden[i].name + "=" + hidden[i].value + "&";
				}
			}
			data = data.trim();
			console.log(data)
		
			$.ajax({
				"url": url,
				"data": data,
				"type":"POST",
			});
			
			window.location.reload();
		}
	</script>
</body>
</html>