<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pUserId = request.getParameter("userId");	//input name값으로 가져오기
	String pUserPw = request.getParameter("userPw");

	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id="minha";
	String pw="1234";
	
	Connection conn = null;	//연결
	PreparedStatement pstmt=null;	//sql문에 값넣기 ,미리 db가서 sql문 대기시켜둠
	ResultSet rs =null;
	
	String sql = "select * from member where id = ? and password = ?";
		
	Class.forName(driver);	//driver에서 class 뽑기, 뽑으면 DriverManager 생김
	conn = DriverManager.getConnection(url,id,pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, pUserId);
	pstmt.setString(2, pUserPw);
	rs = pstmt.executeQuery();	//sql 결과 query 가져옴
	
	response.setContentType("text/html; charset=utf-8");
	/*	
	변수유효범위
	pageContext (페이지 내에서 유효) 
	< request(한페이지만 넘겨짐) 
	< session (session을 끊기 전까지 넘겨짐)
	< applicationContext(session을 끊어도 유지, 메모리 많이써서 잘 안씀)
	*/
	if(rs.next()){
		String userId=rs.getString("id");	//컬럼명
		String userPw=rs.getString("password");
		String userName=rs.getString("name");
		/* out.println("로그인성공"); */
		// 특정페이지로 넘김
		// sendRedirect는 페이지 자체가 바뀜
		//response.sendRedirect("login-ok.jsp?userId="+userId);
		//직접 주소창을 바꾸는 거
		pageContext.setAttribute("pageUserId",userId); //값 안넘어감
		request.setAttribute("userId",userId); //값
		session.setAttribute("userId", userId);
		//페이지는 안바뀌는데(login-process) 내용은 login-ok.jsp
		request.getRequestDispatcher("login-ok.jsp").forward(request,response);
	}else{
		out.println("로그인실패");
	}
	
%>