package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Car.CarDAO;
import Car.CarVO;


public class RentController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<CarVO> list = CarDAO.getInstance().getCarList();
		HttpSession session = request.getSession();
		session.setAttribute("carList", list);
		return "rent";
	}

}
