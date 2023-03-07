package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Car.CarDAO;
import Car.CarVO;

public class ReserveController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("log")==null) {
			return "memberLogin";
		}
		String name = request.getParameter("name");
		CarVO car = CarDAO.getInstance().getCarVO(name);
		session.setAttribute("car", car);
		return "reserve";
	}

}
