<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		//session.invalidate(); // 로그아웃
	%>
	<h2>${member}</h2>
	<h2>${member.id}</h2>
	<h2>${member.getId()}</h2>
	<h2>${member.name}</h2>
	<h2>${member.email}</h2>
	<h2>${member.num}</h2>
	<hr>
	<h2>${number}</h2>
	<h2>page : ${pageScope.number}</h2>
	<h2>request : ${requestScope.number}</h2>
	<h2>session : ${sessionScope.number}</h2>
	<h2>application : ${applicationScope.number}</h2>
	<h2>cookie : ${cookie.layer.value}</h2>
	<h2>cookie : ${cookie['remember-id'].value}</h2>
</body>
</html>