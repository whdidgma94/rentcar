package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member.MemberDAO;
import Member.MemberVO;



public class MemberJoinController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		if(request.getParameter("id")==null) {
			return "memberJoin";
		}
		
		MemberVO m = new MemberVO();
		m.setId(request.getParameter("id"));
		m.setPw(request.getParameter("pw"));
		m.setName(request.getParameter("name"));
		m.setAge(Integer.parseInt(request.getParameter("age")));
		m.setEmail(request.getParameter("email"));
		m.setPhone(request.getParameter("phone"));
		m.setGender(request.getParameter("gender"));
		int check = MemberDAO.getInstance().addMemberVO(m);
		String ctx = request.getContextPath();		
		if(check>0) {	
			return "redirect:"+ctx+"/memberLogin.do";
		}else {
			return "redirect:"+ctx+"/memberJoin.do";
		}		
	}

}
