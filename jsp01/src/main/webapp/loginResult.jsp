<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	/* request, response, out ==> 내장객체  */
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String isLogin= "";
	if(userId.equals("aaa")&&userPw.equals("1111")){
		isLogin = "success";
	} else{
		isLogin="fail";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%out.println(isLogin); %></h1>
	<h1><%= isLogin %></h1>
</body>
</html>