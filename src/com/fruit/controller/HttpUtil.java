package com.fruit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {

	public static void forward(HttpServletRequest req, HttpServletResponse res, String path) throws ServletException,IllegalStateException ,IOException
	{
		try
		{
			RequestDispatcher rd = req.getRequestDispatcher(path);
			rd.forward(req,res);
		}
		catch(Exception e)
		{
			System.out.println("httputil 오류 발생 : " + e);
		}
	}
}
