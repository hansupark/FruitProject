package com.fruit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fruit.service.FruitBuyerService;
import com.fruit.vo.FruitBuyer;

public class InsertBuyerController implements Controller{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		FruitBuyerService service = FruitBuyerService.ServiceGetInstance();
		ArrayList<FruitBuyer> list = service.getListService();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		if(id.isEmpty() || pw.isEmpty())
		{
			req.setAttribute("error","빈칸이 존재합니다");
			HttpUtil.forward(req, res,"InsertBuyer.jsp");
			return;
		}
		for(FruitBuyer cbuyer : list)
		{
			if((cbuyer.getId()).equals(id))
			{
				req.setAttribute("error","중복된 아이디가 존재합니다.");
				HttpUtil.forward(req, res,"InsertBuyer.jsp");
				return;
			}
		}
		FruitBuyer buyer = new FruitBuyer();
		buyer.setId(id);
		buyer.setPwd(pw);
		service.InsertBuyerService(buyer);
		req.setAttribute("msg",buyer.getId());
		HttpUtil.forward(req, res,"InsertBuyerOutput.jsp");
		return;
	}

	
}
