package com.minha.controller.board;

import java.io.IOException;
import java.util.ArrayList;


import com.minha.model.BoardDao;
import com.minha.model.BoardDto;
import com.minha.model.PageDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//board 테이블의 row값을 가지고 오기
		BoardDao boardDao = new BoardDao();

		int clickPage=0;
		String tempClickPage=request.getParameter("clickPage");
		if(tempClickPage ==null) {
			clickPage=1;
		} else {
			clickPage=Integer.parseInt(tempClickPage);
		}
		
		double total=boardDao.getTotal();	//전체글 개수
		
		double pagePerList=10;	//한 페이지에 보여줄 글 개수
		int pageBlock=5;		//pagenation 페이지번호가 한번에 보여지는 개수
		int pageTotal=(int)(Math.ceil(total/pagePerList));	//전체 페이지번호 개수
		
		int pageStart=(clickPage-1)/pageBlock*pageBlock+1;	//1~pageBlock ...
		int pageEnd=pageStart+pageBlock-1;
		if(pageEnd>pageTotal) pageEnd=pageTotal;

		int start =(clickPage-1)*(int)pagePerList+1;
		int end=start+(int)pagePerList-1;
		
		PageDto pageDto = new PageDto();
		pageDto.setPageTotal(pageTotal);
		pageDto.setTotal(total);
		pageDto.setPageBlock(pageBlock);
		pageDto.setPageStart(pageStart);
		pageDto.setPageEnd(pageEnd);
		pageDto.setPagePerList(pagePerList);
		
		ArrayList<BoardDto> boardList = boardDao.getList(start,end);
		request.setAttribute("boardList", boardList);
		request.setAttribute("clickPage", clickPage);
		request.setAttribute("pageDto", pageDto);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		dispatcher.forward(request, response);
	}

}
