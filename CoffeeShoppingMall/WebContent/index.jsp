<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shop/index.jsp");
		if(dispatcher != null)
			dispatcher.forward(request, response);
	%>
</body>
</html>

