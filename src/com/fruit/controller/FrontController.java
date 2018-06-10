package com.fruit.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//모든 요청을 여기서 받아서 처리
public class FrontController extends HttpServlet{

	HashMap<String,Controller> list = null;
	public void init(ServletConfig config) throws ServletException
	{
		list = new HashMap<String,Controller>();
		list.put("/seller/FruitSellerLogin.do", new FruitSellerLoginController());
		list.put("/seller/FruitSellerInformation.do", new FruitSellerInformationController());
		list.put("/seller/FruitSellerRegister.do", new FruitSellerRegisterController());
		list.put("/seller/InsertSeller.do", new InsertSellerController());
		list.put("/buyer/FruitBuyerLogin.do", new FruitBuyerLoginController());
		list.put("/buyer/FruitBuyerRegisterMoney.do", new FruitBuyerRegisterMoneyController());
		list.put("/buyer/FruitBuyerInformation.do", new FruitBuyerInformationController());
		list.put("/buyer/FruitBuyerBuyFruit.do", new FruitSellerListController());
		list.put("/buyer/BuyerBuyFruit.do", new BuyerBuyFruitController());
		list.put("/buyer/InsertBuyer.do", new InsertBuyerController());
	}

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		System.out.println("path : " + path);
		Controller subController = list.get(path);
		subController.excute(req, res);
	}
}
