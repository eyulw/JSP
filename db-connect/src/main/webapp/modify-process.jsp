<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pUserId = request.getParameter("userId");
	String pUserName = request.getParameter("userName");
	String pUserEmail = request.getParameter("userEmail");
	String pUserPw = request.getParameter("userPw");
	int pZonecode=Integer.parseInt(request.getParameter("zonecode"));
	String pUserAddress = request.getParameter("userAddress");
	String pUserDetailAddress = request.getParameter("datailAddress");
	String pUserExtraAddress = request.getParameter("extraAddress");
	
	String driver = "oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="minha";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt= null;
	ResultSet rs =null;
	
	String sql = "update member set name=?,zonecode=?,address=?, detailAddress=?,extraAddress=? where id=?";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(url,id,pw);	//manager가 연결해줘야함
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1,pUserName);
	pstmt.setInt(2,pZonecode);
	pstmt.setString(3,pUserAddress);
	pstmt.setString(4,pUserDetailAddress);
	pstmt.setString(5,pUserExtraAddress);
	pstmt.setString(6,pUserId);
	
	/* select를 제외한 모든건(insert update delete) executeUpdate()이고 결과값은 int형 */
	int result = pstmt.executeUpdate();
	if(result > 0){	/* row에 영향을 미친 개수가 0보다 크면~ */
		session.invalidate();
		response.sendRedirect("login-form.jsp");
	}else{
		out.println("<script>alert('서버오류입니다.'); history.back();</script>");
	}
	
%>