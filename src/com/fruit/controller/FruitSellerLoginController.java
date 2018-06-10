package com.fruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fruit.service.FruitSellerService;

public class FruitSellerLoginController implements Controller{
	
	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		FruitSellerService service = FruitSellerService.ServiceGetInstance();
		String id = req.getParameter("seller_ID");
		String pwd = req.getParameter("seller_PWD");
		String dbPwd = service.FruitSellerLoginService(id);
		HttpSession session = req.getSession();
		System.out.println("pwd : " + pwd);
		System.out.println("dbpwd : " + dbPwd);
		if(req.getMethod().equals("GET"))
		{
			if(session != null)
			{
				session.invalidate();
				System.out.println("로그아웃 완료 ");
				HttpUtil.forward(req, res, "/seller/fruitSeller.jsp");
				return;
			}
		}
		if(id.isEmpty() || pwd.isEmpty())
		{
			req.setAttribute("error","빈칸이 존재합니다.");
			HttpUtil.forward(req, res, "/seller/fruitSeller.jsp");
			return;
		}
		if(dbPwd == null)
		{
			//로그인 실패 : 아이디가 존재하지않음
			System.out.println("로그인 실패 : 아이디가 존재하지않음");
			req.setAttribute("error","로그인 실패 : 아이디가 존재하지 않습니다.");
			HttpUtil.forward(req, res, "/seller/fruitSeller.jsp");
			return;
		}	
		
		if(pwd.equals(dbPwd))
		{
			System.out.println("로그인 성공");
			session.setAttribute("currentId",id);
			HttpUtil.forward(req, res, "/seller/fruitSellerMenu.jsp");
			return;
		}
		
		else
		{
			//로그인 실패 : 비밀번호가 다릅니다.
			req.setAttribute("error","로그인 실패 : 비밀번호가 틀립니다.");
			HttpUtil.forward(req, res, "/seller/fruitSeller.jsp");
			return;
		}
		
	}
}
