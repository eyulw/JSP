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
		String sql="select id,name from member where id=? and password=?";
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

	public int idCheck(String userId) {
		int result=0;
		getConnection();
		String sql = "select count(*) as count from member where id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public MemberDto getMemberInfo(String userId) {
		MemberDto memberInfoDto=null;
		getConnection();
		String sql="select * from member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberInfoDto = new MemberDto();
				memberInfoDto.setId(rs.getString("id"));
				memberInfoDto.setName(rs.getString("name"));
				memberInfoDto.setEmail(rs.getString("email"));
				memberInfoDto.setAddress(rs.getString("address"));
				memberInfoDto.setDetailaddress(rs.getString("detailaddress"));
				memberInfoDto.setExtraaddress(rs.getString("extraaddress"));
				memberInfoDto.setZonecode(rs.getInt("zonecode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberInfoDto;
	}
	
	public int modifyMember(MemberDto memberDto) {	
		int result=0;
		getConnection();
		String sql = "update member set name=?,zonecode=?,address=?, detailAddress=?,extraAddress=? where id=? and password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getName());
			pstmt.setInt(2, memberDto.getZonecode());
			pstmt.setString(3, memberDto.getAddress());
			pstmt.setString(4, memberDto.getDetailaddress());
			pstmt.setString(5, memberDto.getExtraaddress());
			pstmt.setString(6, memberDto.getId());
			pstmt.setString(7, memberDto.getPassword());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int modifyPassword(PasswordDto passwordDto) {	
		int result=0;
		getConnection();
		String sql = "update member set password=? where id=? and password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, passwordDto.getNewUserPw());
			pstmt.setString(2, passwordDto.getUserId());
			pstmt.setString(3, passwordDto.getUserPw());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public int deleteMember(MemberDto memberDto) {
		int result=0;
		getConnection();
		String sql = "delete from member where id=? and password=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
