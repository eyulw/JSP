<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join-process.jsp" method="post">
		<div>
			<label><span>ID</span><input type="text" name="userId"></label>
		</div>
		<div>
			<label><span>PW</span><input type="password" name="userPw"></label>
		</div>
		<div>
			<label><span>NAME</span><input type="text" name="userName"></label>
		</div>
		<div>
			<label><span>ADDRESS</span><input type="text" name="address"></label>
		</div>
		<div>
			<label><span>ZIPCODE</span><input type="text" name="zipcode"></label>
		</div>
		<div>
			<span>성별</span>
			<label><span>여자</span><input type="radio" name="gender" value="female"></label>
			<label><span>남자</span><input type="radio" name="gender" value="male"></label>
		</div>
		<div>
			<button>JOIN</button>
		</div>
	</form>
</body>
</html>