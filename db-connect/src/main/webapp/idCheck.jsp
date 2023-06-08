<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String pUserId = request.getParameter("userId");	//input name값으로 가져오기

String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id="minha";
String pw="1234";

Connection conn = null;	//연결
PreparedStatement pstmt=null;	//sql문에 값넣기 ,미리 db가서 sql문 대기시켜둠
ResultSet rs =null;

String sql = "select count(*) as count from member where id=?";
	
Class.forName(driver);	//driver에서 class 뽑기, 뽑으면 DriverManager 생김
conn = DriverManager.getConnection(url,id,pw);
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, pUserId);
rs = pstmt.executeQuery();	//sql 결과 query 가져옴

response.setContentType("text/html; charset=utf-8");

int result=0;
boolean isState = true;
if(rs.next()){
	result=rs.getInt("count");
	if(result <=0){
		isState =true;
	} else{
		isState=false;
	}
}
%>
{"isOk":<%= isState %>}		