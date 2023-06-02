<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	/* 전역변수 선언 느낌표 붙이기  */
	String name = "kim min ha";
	String msg = "hello";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html파일 안에 java code 쓰기  -->
	<h1>hello jsp</h1>
	<h2>
	<% out.println(name); %>
	<!-- 태그 안에 쓸때는 out.println() 생략가능 앞에 = 붙여주기  -->
	<%= name %>
	</h2>
	<% 
		out.println("hello jsp");
		out.println(name + msg);
		for(int i=0; i<100;i++){
			out.println("hello jsp <br>");
		}
	%>
</body>
</html>