<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
</head>
<body>
	처리상태를 변경하면 자동으로 반영됩니다.
	<table class="table table-head-fixed text-nowrap"
		style="text-align: center; vertical-align: middle">
		<thead style="text-align: center">
			<tr>
				<th style="width: auto">주문일자</th>
				<th>아이디</th>
				<th>주소</th>
				<th style="width: auto">상품번호</th>
				<th>수량</th>
				<th>처리상태</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="key" items="${requestScope.orderMap.keySet()}">
				<c:forEach var="order" items="${requestScope.orderMap.get(key)}"
					varStatus="status">
					<tr>
						<c:if test="${status.count == 1}">
							<td rowspan="${requestScope.orderMap.get(key).size()}"
								style="text-align: center; vertical-align: middle">${order.getOrder_date()}</td>
							<td rowspan="${requestScope.orderMap.get(key).size()}"
								style="text-align: center; vertical-align: middle">${order.getId()}</td>
							<td rowspan="${requestScope.orderMap.get(key).size()}"
								style="text-align: center; vertical-align: middle">${order.getOrder_address()}</td>
						</c:if>
						<td>${order.getPro_id()}</td>
						<td>${order.getOrder_count()}</td>
						<c:if test="${status.count == 1}">
							<td rowspan="${requestScope.orderMap.get(key).size()}"
								style="text-align: center; vertical-align: middle"><select
								onchange="editOrderStatus('${order.getOrder_id()}')"
								id="slt_order_${order.getOrder_id()}">
									<option value="결제완료"
										<c:if test="${requestScope.orderStatus.get(key) eq '결제완료'}">selected</c:if>>결제완료</option>
									<option value="포장 준비"
										<c:if test="${requestScope.orderStatus.get(key) eq '포장 준비'}"> selected</c:if>>포장
										준비</option>
									<option value="배송중"
										<c:if test="${requestScope.orderStatus.get(key) eq '배송중'}">selected</c:if>>배송중</option>
									<option value="배송완료"
										<c:if test="${requestScope.orderStatus.get(key) eq '배송완료'}">selected</c:if>>배송완료</option>
							</select></td>
						</c:if>
					</tr>
				</c:forEach>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>