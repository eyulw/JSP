package com.minha.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.minha.model.BoardDao;
import com.minha.utils.ScriptWriter;

@WebServlet("/board/delete")
public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		BoardDao boardDao = new BoardDao();
		int result = boardDao.deleteBoard(id);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "삭제되었습니다.", "../board/list");
		}else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류 발생");
		}
	}

}
