package com.minha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minha.model.MemberDao;
import com.minha.model.MemberDto;
import com.minha.utils.ScriptWriter;

@WebServlet("/member/deleteProcess")
public class DeleteMemberProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteMemberProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(request.getParameter("userId"));
		memberDto.setPassword(request.getParameter("userPw"));
		
		int result = memberDao.deleteMember(memberDto);
		if(result > 0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response,"탈퇴완료", "../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류 발생");
		}
	}

}
