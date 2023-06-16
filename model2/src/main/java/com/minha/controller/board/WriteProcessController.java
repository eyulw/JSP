package com.minha.controller.board;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.minha.model.BoardDao;
import com.minha.model.BoardDto;
import com.minha.utils.ScriptWriter;

@WebServlet("/board/writeProcess")
public class WriteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WriteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto.setUserId(userId);
		boardDto.setName(userName);
		boardDto.setTitle(title);
		boardDto.setContents(contents);
		
//		for(int i = 71; i<200; i++) {
//			boardDto.setName(userName+"_"+i);
//			boardDto.setTitle(title+"_"+i);
//			boardDto.setContents(contents+"_"+i);
//			boardDao.writeBoard(boardDto);
//		}
		
		int result = boardDao.writeBoard(boardDto);
		if(result > 0) {
			response.sendRedirect("../board/list");
		}else {
			ScriptWriter.alertAndBack(response,"알 수 없는 오류 발생");
		}
		
	}

}
