<%@page import="com.minha.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ include file="include/header.jsp"%>
<%
	String driver = "oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="minha";
	String pw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	
	String sql = "select * from board";
	
	Class.forName(driver);
	conn = DriverManager.getConnection(url,id,pw);
	pstmt=conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	
	ArrayList<BoardDto> boardList = new ArrayList<>();
	
	while(rs.next()){
		BoardDto boardDto = new BoardDto();
		boardDto.setId(rs.getInt("id"));
		boardDto.setName(rs.getString("name"));
		boardDto.setTitle(rs.getString("title"));
		boardDto.setContents(rs.getString("contents"));
		boardDto.setDate(rs.getString("regdate"));
		boardDto.setHit(rs.getInt("hit"));
		boardList.add(boardDto);
	}
	
%>
<div class="container">
  <ul>
    <li><span>1</span></li>
    <li><span>제목</span></li>
    <li><span>이름</span></li>
    <li><span>날짜</span></li>
    <li><span>조회수</span></li>
  </ul>
</div>
<%@ include file="include/footer.jsp"%>
