package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Car.CarVO;
import Reserve.ReserveDAO;
import Reserve.ReserveVO;

public class ReserveAddController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		if(request.getParameter("rday").equals("")) {
			return "rent";
		}
		ReserveVO vo = new ReserveVO();
		CarVO car = (CarVO)session.getAttribute("car");
		String id = (String)session.getAttribute("log");
		vo.setId(id);
		vo.setQty(Integer.parseInt(request.getParameter("qty")));
		vo.setDday(Integer.parseInt(request.getParameter("dday")));
		vo.setRday(request.getParameter("rday"));
		vo.setUsein(Integer.parseInt(request.getParameter("usein")));
		vo.setUsewifi(Integer.parseInt(request.getParameter("usewifi")));
		vo.setUsenavi(Integer.parseInt(request.getParameter("usenavi")));
		vo.setUseseat(Integer.parseInt(request.getParameter("useseat")));
		vo.setCarNo(car.getNo());
		ReserveDAO.getInstance().addReserve(vo);
		session.setAttribute("reserveList", ReserveDAO.getInstance().getIdsReserveVO(id));
		String ctx=request.getContextPath();
		return "redirect:"+ctx+"/checkRent.do";		
	}

}
