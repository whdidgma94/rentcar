package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Board.BoardDAO;
import Board.BoardVO;
import Member.MemberDAO;
import Member.MemberVO;


public class BoardAddController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("title")==null) {
			return "boardAdd";
		}			
		if(request.getParameter("title").equals("")) {
			return "boardAdd";
		}
		HttpSession session = request.getSession();
		String writerId = (String)session.getAttribute("log");
		ArrayList<MemberVO> list = MemberDAO.getInstance().getMemberList();
		String writer = "";
		
		for(MemberVO m :list) {
			if(m.getId().equals(writerId)) {
				writer=m.getName();
				break;
			}
		}
		String content = request.getParameter("content").replaceAll("\n", "<br/>");
		BoardVO b = new BoardVO();	
		b.setTitle(request.getParameter("title"));
		b.setContent(content);
		b.setWriter(writer);
		b.setWriterId(writerId);
		BoardDAO.getInstance().addBoard(b);
		String ctx=request.getContextPath();
		return "redirect:"+ctx+"/boardList.do";
	}

}
