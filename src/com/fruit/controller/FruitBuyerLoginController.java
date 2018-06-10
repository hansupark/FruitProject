package com.fruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fruit.service.FruitBuyerService;

public class FruitBuyerLoginController implements Controller{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FruitBuyerService service = FruitBuyerService.ServiceGetInstance();
		String id = req.getParameter("Buyer_ID");
		String pwd = req.getParameter("Buyer_PWD");
		String dbPwd = service.FruitBuyerLoginService(id);
		HttpSession session = req.getSession();
		System.out.println("pwd : " + pwd);
		System.out.println("dbpwd : " + dbPwd);
		if(req.getMethod().equals("GET"))
		{
			if(session != null)
			{
				session.invalidate();
				System.out.println("로그아웃 완료 ");
				HttpUtil.forward(req, res, "/buyer/fruitBuyer.jsp");
			}
		}
		if(id.isEmpty() || pwd.isEmpty())
		{
			req.setAttribute("error","빈칸이 존재합니다.");
			HttpUtil.forward(req, res, "/buyer/fruitBuyer.jsp");
			return;
		}
		if(dbPwd == null)
		{
			//로그인 실패 : 아이디가 존재하지않음
			System.out.println("로그인 실패 : 아이디가 존재하지않음");
			req.setAttribute("error","로그인 실패 : 아이디가 존재하지 않습니다.");
			HttpUtil.forward(req, res, "/buyer/fruitBuyer.jsp");
			return;
		}
		
		if(pwd.equals(dbPwd))
		{
			System.out.println("로그인 성공");
			session.setAttribute("currentId",id);
			HttpUtil.forward(req, res, "/buyer/fruitBuyerMenu.jsp");
			return;
		}
		
		else
		{
			//로그인 실패 : 비밀번호가 다릅니다.
			req.setAttribute("error","로그인 실패 : 비밀번호가 틀립니다.");
			HttpUtil.forward(req, res, "/buyer/fruitBuyer.jsp");
			return;
		}
		
	}
	
}
