package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Reserve.ReserveDAO;
import Reserve.ReserveVO;


public class CheckRentController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("log")==null) {
			return "memberLogin";
		}
		String id = (String)session.getAttribute("log");
		ArrayList<ReserveVO> idsList = ReserveDAO.getInstance().getIdsReserveVO(id);
		session.setAttribute("idsList", idsList);
		return "checkRent";
	}

}
