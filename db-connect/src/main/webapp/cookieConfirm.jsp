<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//배열로 떨어지는거 cookie랑 checkbox
	//cookie는 string 배열
	Cookie cookies[] = request.getCookies();
	if(cookies!=null){
		for(int i = 0; i<cookies.length;i++){
			String cookieName = cookies[i].getName();
			String cookieValue = cookies[i].getValue();
			out.println(cookieName+"==="+cookieValue);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>