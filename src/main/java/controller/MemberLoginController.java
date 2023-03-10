package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member.MemberDAO;


public class MemberLoginController implements Controller {


	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id==null) {
			return "memberLogin";
		}
		if(MemberDAO.getInstance().memberLogin(id,pw)) {
			HttpSession session = request.getSession();
			session.setAttribute("log", id);
			response.getWriter().print(1);
			return null;
		}else {
			response.getWriter().print(0);
			return null;
		}
	}


       


}
