package com.fruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fruit.service.FruitBuyerService;

public class FruitBuyerRegisterMoneyController implements Controller{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = req.getSession();
		String id = (String) s.getAttribute("currentId");
		if(req.getParameter("BuyerMoney").isEmpty())
		{
			HttpUtil.forward(req, res, "/buyer/fruitBuyerRegisterMoney.jsp");
			return;
		}
		FruitBuyerService service = FruitBuyerService.ServiceGetInstance();
		int money = Integer.parseInt((String) req.getParameter("BuyerMoney"));
		if(money < 0)
		{
			req.setAttribute("error","0이하 숫자 x");
			HttpUtil.forward(req, res, "/buyer/fruitBuyerRegisterMoney.jsp");
			return;
		}
		service.FruitBuyerMoneyRegisterService(id, money);
		HttpUtil.forward(req, res, "/buyer/fruitBuyerRegisterMoneyOutput.jsp");
		return;
		
	}
	

}
