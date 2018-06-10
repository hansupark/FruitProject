package com.fruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fruit.service.FruitSellerService;
import com.fruit.vo.FruitSeller;

public class FruitSellerInformationController implements Controller{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		FruitSeller seller = null;
		FruitSellerService service = FruitSellerService.ServiceGetInstance();
		String currentId = (String)session.getAttribute("currentId");
		System.out.println("currnet id : " + currentId);
		seller = service.FruitSellerInformationService(currentId);
		if(seller != null)
		{
			req.setAttribute("Inf", seller);
			System.out.println(seller.getAppleCount());
		}
		HttpUtil.forward(req, res,"/seller/fruitSellerInformation.jsp");
	}
	

}
