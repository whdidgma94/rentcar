package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board.BoardDAO;
import Board.BoardVO;



public class BoardDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		BoardVO b = (BoardVO)session.getAttribute("board");
		BoardDAO.getInstance().deleteBoard(b);
		String ctx=request.getContextPath();
		return "redirect:"+ctx+"/boardList.do";
	}

	
	
}
