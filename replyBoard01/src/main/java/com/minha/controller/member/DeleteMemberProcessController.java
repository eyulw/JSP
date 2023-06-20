package com.minha.controller.member;

import java.io.IOException;

import com.minha.model.MemberDao;
import com.minha.model.MemberDto;
import com.minha.utils.ScriptWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/member/deleteProcess")
public class DeleteMemberProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteMemberProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		
		int result = memberDao.deleteMember(memberDto);
		if(result > 0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response,"탈퇴완료", "../index/index");
		}else {
			ScriptWriter.alertAndBack(response, "비밀번호를 확인해 주세요");
		}
	}

}
