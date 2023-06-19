package com.minha.controller.member;

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


@WebServlet("/member/loginProcess")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		MemberDto loggedMember = memberDao.loginMember(memberDto);
//		jsp에선 session이 내장객체로 있었는데 여기선 이렇게 선언해줘야함
		HttpSession session = request.getSession();
		if(loggedMember !=null) {
//			session.setAttribute("loggedMemberId",loggedMember.getId());
//			session.setAttribute("loggedMemberName",loggedMember.getName());
//			객체로 담을수도 있음
			session.setAttribute("loggedMember", loggedMember);
			ScriptWriter.alertAndNext(response,loggedMember.getName()+"님 안녕하세요","../index/index");
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생되었습니다.");
		}
		System.out.println(loggedMember.toString());
	}

}
