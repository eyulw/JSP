package com.minha.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.minha.model.BoardDao;
import com.minha.model.BoardDto;
import com.minha.utils.ScriptWriter;

@WebServlet("/board/modifyProcess")
public class ModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = new BoardDto();
		boardDto.setId(Integer.parseInt(request.getParameter("id")));
		boardDto.setUserId(request.getParameter("userId"));
		boardDto.setTitle(request.getParameter("title"));
		boardDto.setName(request.getParameter("userName"));
		boardDto.setContents(request.getParameter("contents"));
		
		int result = boardDao.modifyBoard(boardDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response,"수정되었습니다", "../board/list");
		}else {
			ScriptWriter.alertAndBack(response,"알 수 없는 오류 발생");
		}
	}

}
