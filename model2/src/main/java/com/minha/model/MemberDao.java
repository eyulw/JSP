package com.minha.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String id="minha";
	private String pw = "1234";
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs =null;
	
	//MVC design pattern : Model View Controller 확장시킨게 spring
	private void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(MemberDto memberDto) {
		int result=0;
		getConnection();
		String sql = "insert into member values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getName());
			pstmt.setString(3, memberDto.getPassword());
			pstmt.setString(4, memberDto.getEmail());
			pstmt.setInt(5, memberDto.getZonecode());
			pstmt.setString(6, memberDto.getAddress());
			pstmt.setString(7, memberDto.getDetailaddress());
			pstmt.setString(8, memberDto.getExtraaddress());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public MemberDto loginMember(MemberDto memberDto) {
		MemberDto loggedMemberDto=null;
		getConnection();
		String sql="select * from member where id=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loggedMemberDto = new MemberDto();
				loggedMemberDto.setId(rs.getString("id"));
				loggedMemberDto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return loggedMemberDto;
	}
}