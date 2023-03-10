package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member.MemberDAO;

//import Member.MemberVO;

public class AdminMemberDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id =  request.getParameter("id");
		int check=MemberDAO.getInstance().removeMemberVO(id);
		response.getWriter().print(check);
		return null;
	}

}
