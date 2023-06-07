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
	
	String driver = "oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="minha";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt= null;
	ResultSet rs =null;
	
	String sql = "update member set id=? name=? password=? zonecode=? address=?  where id=?";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,pLoggedUserId);
	rs = pstmt.executeQuery();
	
	String address = null;
	String detailAddress = null;
	String zonecode = null;
	String name = null;
	
	if(rs.next()){
		address = rs.getString("address");
		detailAddress = rs.getString("detailAddress");
		zonecode = rs.getString("changeZonecode");
		name = rs.getString("name");
	}
	if(detailAddress==null) detailAddress = "상세주소 없음";
%>