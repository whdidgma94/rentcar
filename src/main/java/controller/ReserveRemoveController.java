package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car.CarDAO;
import Reserve.ReserveDAO;

public class ReserveRemoveController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		ReserveDAO.getInstance().removeReserve(num);
		CarDAO.getInstance().cancleReserve(Integer.parseInt(request.getParameter("carNo")), Integer.parseInt(request.getParameter("qty")));
		String ctx=request.getContextPath();
		return "redirect:"+ctx+"/checkRent.do";	
	}

}
