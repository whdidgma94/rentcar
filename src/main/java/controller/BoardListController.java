package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board.BoardDAO;
import Board.BoardVO;


public class BoardListController implements Controller {


	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<BoardVO> list = BoardDAO.getInstance().getBoardList();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		String ctx=request.getContextPath();
		return "redirect:"+ctx+"/boardMain.do";
	}


	
}
