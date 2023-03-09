package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Car.CarDAO;
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
			return "reserve";
		}
		CarVO car = (CarVO)session.getAttribute("car");
		if(Integer.parseInt(request.getParameter("qty"))>car.getUsepeople()) {
			return "rent";
		}
		session.setAttribute("msg", "예약완료.");
		int qty = Integer.parseInt(request.getParameter("qty"));
		int dday = Integer.parseInt(request.getParameter("dday"));
		int totalUse=Integer.parseInt(request.getParameter("usein"))+Integer.parseInt(request.getParameter("usewifi"))+Integer.parseInt(request.getParameter("useseat"));
		ReserveVO vo = new ReserveVO();
		String id = (String)session.getAttribute("log");
		vo.setId(id);
		vo.setQty(qty);
		vo.setDday(dday);
		vo.setRday(request.getParameter("rday"));
		vo.setUsein(Integer.parseInt(request.getParameter("usein")));
		vo.setUsewifi(Integer.parseInt(request.getParameter("usewifi")));
		vo.setUsenavi(Integer.parseInt(request.getParameter("usenavi")));
		vo.setUseseat(Integer.parseInt(request.getParameter("useseat")));
		vo.setCarNo(car.getNo());
		vo.setPrice(qty*(car.getPrice()*dday+totalUse*10000*dday));
		ReserveDAO.getInstance().addReserve(vo);
		CarDAO.getInstance().carused(car.getName(),qty);
		session.setAttribute("reserveList", ReserveDAO.getInstance().getIdsReserveVO(id));
		String ctx=request.getContextPath();
		return "redirect:"+ctx+"/checkRent.do";		
	}

}
