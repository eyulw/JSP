<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pUserId=request.getParameter("userId");
	String pUserPw=request.getParameter("userPw");
	
	String driver = "oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id = "minha";
	String pw = "1234";
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	
	String sql = "select * from member where id = ? and password = ?";
	
	Class.forName(driver);	//driver 찾고
	conn = DriverManager.getConnection(url, id, pw);	//연결
	pstmt = conn.prepareStatement(sql);		//query날리고
	pstmt.setString(1, pUserId);
	pstmt.setString(2, pUserPw);
	
	rs = pstmt.executeQuery();		//결과값 가져오기
	/* .next() 다음게 있으면 true */
	while(rs.next()){
		String userId = rs.getString("id");
		String userName = rs.getString("name");
		String userPw = rs.getString("password");
		System.out.println(userId+"==="+userName+"==="+userPw);
	}
	
	//System.out.println(conn);
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