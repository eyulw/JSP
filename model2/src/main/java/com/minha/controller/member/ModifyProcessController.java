package com.minha.controller.member;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.minha.model.MemberDao;
import com.minha.model.MemberDto;
import com.minha.utils.ScriptWriter;

@WebServlet("/member/modifyProcess")
public class ModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto= new MemberDto();
		memberDto.setId(request.getParameter("userId"));
		memberDto.setPassword(request.getParameter("userPw"));
		String userName = request.getParameter("userName");
		memberDto.setName(userName);
		memberDto.setEmail(request.getParameter("userEmail"));
		memberDto.setZonecode(Integer.parseInt(request.getParameter("zonecode")));
		memberDto.setAddress(request.getParameter("userAddress"));
		memberDto.setDetailaddress(request.getParameter("detailAddress"));
		memberDto.setExtraaddress(request.getParameter("extraAddress"));
		int result = memberDao.modifyMember(memberDto);
		if(result > 0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response,userName+"님 회원정보가 수정되었습니다. 다시 로그인 해주세요","../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "알수없는 오류 발생");
		}
	}

}
