package com.fruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fruit.service.FruitSellerService;

public class FruitSellerRegisterController implements Controller{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FruitSellerService service = FruitSellerService.ServiceGetInstance();
		HttpSession s = req.getSession();
		String id = (String) s.getAttribute("currentId");
		if(req.getParameter("appleCount").isEmpty() || req.getParameter("applePrice").isEmpty())
		{
			req.setAttribute("error", "모두다 채워주셈");
			HttpUtil.forward(req, res,"/seller/fruitSellerRegister.jsp");
		}
		int appleCount = Integer.parseInt(req.getParameter("appleCount"));
		int applePrice = Integer.parseInt(req.getParameter("applePrice"));
		if(appleCount < 0 || applePrice < 0)
		{
			req.setAttribute("error", "0보다 작은 숫자 x");
			HttpUtil.forward(req, res,"/seller/fruitSellerRegister.jsp");
			return;
		}
		service.FruitSellerRegisterService(id, appleCount, applePrice);
		HttpUtil.forward(req, res,"/seller/fruitSellerRegisterOutput.jsp");
	}

}
