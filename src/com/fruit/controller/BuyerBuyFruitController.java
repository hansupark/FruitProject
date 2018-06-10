package com.fruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fruit.service.FruitBuyerService;

public class BuyerBuyFruitController implements Controller{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean state;
		FruitBuyerService service = FruitBuyerService.ServiceGetInstance();
		HttpSession s = req.getSession();
		String buyerId = (String) s.getAttribute("currentId");
		System.out.println("buyid = " + buyerId);
		if(req.getParameter("sellerId").isEmpty() || req.getParameter("appleCount").isEmpty())
		{
			req.setAttribute("error", "빈칸이 존재합니다.(in BuyFruit)");
			HttpUtil.forward(req, res, "/buyer/fruitBuyerMenu.jsp");
		}
		String sellerId = req.getParameter("sellerId");
		int appleCount = Integer.parseInt(req.getParameter("appleCount"));
		state = service.BuyerBuyFruitService(sellerId, buyerId, appleCount);
		if(state)
		{
			req.setAttribute("update","구매 성공");
		}
		else
		{
			req.setAttribute("update","구매 실패");
		}
		HttpUtil.forward(req, res, "/buyer/BuyerBuyFruitOutput.jsp");
		
	}

}
