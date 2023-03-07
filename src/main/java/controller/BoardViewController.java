package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board.BoardDAO;
import Board.BoardVO;


public class BoardViewController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("num")==null) {
			return "boardView";			
		}
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		ArrayList<BoardVO> list = BoardDAO.getInstance().getBoardList();
		for(BoardVO b : list) {
			if(b.getNum()==num) {
				HttpSession session = request.getSession();
				session.setAttribute("board", b);
				String ctx = request.getContextPath();
				return "redirect:"+ctx+"/boardView.do";
			}
		}
		return null;
	}


	
	
}
