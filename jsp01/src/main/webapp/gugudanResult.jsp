<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int dan = Integer.parseInt(request.getParameter("dan"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= dan %>단을 출력합니다.</h1>
	<%
		/* 자바 코드 출력하는 부분이라 바로 html 태그를 쓸 수 없음.  */
		for(int i=0; i<10; i++){
			out.println("<p>"+dan+"x"+i+"="+dan*i +"</p>");
		}
	%>
</body>
</html>