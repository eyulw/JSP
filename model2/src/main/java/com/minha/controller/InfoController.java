package com.minha.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minha.model.MemberDao;
import com.minha.model.MemberDto;

@WebServlet("/member/info")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfoController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		MemberDao memberDao = new MemberDao();
		MemberDto memberInfoDto = memberDao.getMemberInfo(userId);
		request.setAttribute("memberInfoDto",memberInfoDto);

		String detailAddress = memberInfoDto.getDetailaddress();
		if(detailAddress == null ) {
			detailAddress="상세주소 없음";
		}
		request.setAttribute("detailAddress",detailAddress);
		String zonecode = Integer.toString(memberInfoDto.getZonecode());
		if(zonecode.length()==4) {
			zonecode="0"+zonecode;
		}
		request.setAttribute("zonecode",zonecode);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/member/info.jsp");
		dispatcher.forward(request, response);
	}

}
