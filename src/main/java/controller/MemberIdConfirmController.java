package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Member.MemberDAO;

public class MemberIdConfirmController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		MemberDAO manager = MemberDAO.getInstance();
		int check= manager.confirmId(id);
		response.getWriter().print(check);
		return null;
	}

}
