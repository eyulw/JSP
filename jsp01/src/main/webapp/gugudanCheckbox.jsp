<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gugudanCheckboxResult.jsp">
		<%
			for(int i=1;i<10;i++){
				out.println("<label><span>"+i+"단</span><input type='checkbox' name='dan' value='"+i+"'></label>");
			}
		%>
		<button>구구단 출력 부탁드립니다.</button>
	</form>
</body>
</html>