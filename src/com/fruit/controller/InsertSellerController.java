package com.fruit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruit.service.FruitSellerService;
import com.fruit.vo.FruitBuyer;
import com.fruit.vo.FruitSeller;

public class InsertSellerController implements Controller{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FruitSellerService service = FruitSellerService.ServiceGetInstance();
		ArrayList<FruitSeller> list = service.fruitSellerListService();
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		for(FruitSeller cseller : list)
		{
			if((cseller.getId()).equals(id))
			{
				req.setAttribute("error","중복된 아이디가 존재합니다.");
				HttpUtil.forward(req, res,"InsertSeller.jsp");
				return;
			}
		}
		FruitSeller seller = new FruitSeller();
		seller.setId(id);
		seller.setPwd(pw);
		service.InsertSeller(seller);
		req.setAttribute("msg",seller.getId());
		HttpUtil.forward(req, res,"InsertSellerOutput.jsp");
		return;
		
	}

	
}
