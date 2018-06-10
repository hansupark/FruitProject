package com.fruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fruit.service.FruitBuyerService;
import com.fruit.vo.FruitBuyer;

public class FruitBuyerInformationController implements Controller{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = req.getSession();
		String id = (String) s.getAttribute("currentId");
		FruitBuyerService service = FruitBuyerService.ServiceGetInstance();
		FruitBuyer Buyer = service.FruitBuyerInformationService(id);
		req.setAttribute("Inf", Buyer);
		HttpUtil.forward(req, res, "/buyer/fruitBuyerInformation.jsp");
	}
	

}
