package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Car.CarDAO;
import Car.CarVO;


public class AdminInsertCarVOController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String img = request.getParameter("img");
		String name =request.getParameter("name");
		int category =Integer.parseInt(request.getParameter("category"));
		int price = Integer.parseInt(request.getParameter("price"));
		String company =request.getParameter("company");
		String info =request.getParameter("info");
		CarVO vo = new CarVO();
		vo.setName(name);
		vo.setCategory(category);
		vo.setPrice(price);
		vo.setCompany(company);
		vo.setImg(img);
		vo.setInfo(info);
		int check = CarDAO.getInstance().addCarVO(vo);
		String ctx=request.getContextPath();
		if(check == 1) {
			return "redirect:"+ctx+"/_main.do";
		}else {
			System.out.println("추가 실패");
			return "redirect:"+ctx+"/_main.do";
		}
	}

}
