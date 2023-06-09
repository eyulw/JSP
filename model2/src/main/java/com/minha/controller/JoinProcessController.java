package com.minha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minha.model.MemberDao;
import com.minha.model.MemberDto;
import com.minha.utils.ScriptWriter;

@WebServlet("/member/joinProcess")
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPw = request.getParameter("userPw");
		int zonecode=Integer.parseInt(request.getParameter("zonecode"));
		String userAddress = request.getParameter("userAddress");
		String userDetailAddress = request.getParameter("datailAddress");
		String userExtraAddress = request.getParameter("extraAddress");
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		memberDto.setName(userName);
		memberDto.setEmail(userEmail);
		memberDto.setZonecode(zonecode);
		memberDto.setAddress(userAddress);
		memberDto.setDetailaddress(userDetailAddress);
		memberDto.setExtraaddress(userExtraAddress);
		int result = memberDao.insertMember(memberDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생 되었습니다. 다시 시도해 주세요");
		}
		
	}

}
