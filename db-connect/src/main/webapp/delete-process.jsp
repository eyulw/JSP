<!-- prettier-ignore -->
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ include file="include/header.jsp" %>
<!-- prettier-ignore -->
<%
	//db접속
	
	String pLoggedUserId=(String)session.getAttribute("loggedUserId");
	String pUserPw = request.getParameter("userPw");

	String driver = "oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="minha";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt= null;
	int rs = 0;
	
	String sql = "delete from member where id=? and password=?";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,pLoggedUserId);
	pstmt.setString(2,pUserPw);
	rs = pstmt.executeUpdate();
	
	if(rs > 0){
		session.invalidate();
		response.sendRedirect("login-form.jsp");
	}else{
		out.println("<script>alert('서버오류입니다.');</script>");
	}
%>