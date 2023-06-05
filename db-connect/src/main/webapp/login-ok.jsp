<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
	//getAttribute는 object 타입이라 형변환 해주어야함.
	String pageUserId = (String) pageContext.getAttribute("userId");
	String requestuserId = (String)request.getAttribute("userId");
	String sessionUserId = (String)session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>로그인 성공</p>
	<p><%=userId %>님 안녕하세요</p>
	<p><%=pageUserId %>님 안녕하세요</p>
	<p><%=requestuserId %>님 안녕하세요</p>
	<p><%=sessionUserId %>님 안녕하세요</p>
</body>
</html>