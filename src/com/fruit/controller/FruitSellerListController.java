package com.fruit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruit.service.FruitSellerService;
import com.fruit.vo.FruitSeller;

public class FruitSellerListController implements Controller{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<FruitSeller> list = null;
		FruitSellerService service = FruitSellerService.ServiceGetInstance();
		list = service.fruitSellerListService();
		/*if(list == null)
		{
			System.out.println("list is null");
		}*/
		req.setAttribute("sellerList", list);
	/*	System.out.println("리스트 forward 전 ");*/
		HttpUtil.forward(req, res,"/buyer/fruitBuyerBuyFruit.jsp");
		/*System.out.println("리스트 forward 후 ");*/
		return;
	}
	
	

}
