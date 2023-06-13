package com.minha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minha.model.MemberDao;
import com.minha.model.PasswordDto;
import com.minha.utils.ScriptWriter;

@WebServlet("/member/modifyPasswordProcecss")
public class ModifyPasswordProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyPasswordProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDao memberDao = new MemberDao();
		String userPw = request.getParameter("userPw");
		String newUserPw = request.getParameter("newUserPw");
		String userId = request.getParameter("userId"); 	//form에 input hidden으로 넘겨줌
		PasswordDto passwordDto = new PasswordDto();
		passwordDto.setUserId(userId);
		passwordDto.setUserPw(userPw);
		passwordDto.setNewUserPw(newUserPw);
		int result = memberDao.modifyPassword(passwordDto);
		
		if(result > 0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response,"비밀번호가 변경 되었습니다. 다시 로그인 해주세요","../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "알수없는 오류 발생");
		}
	}

}
