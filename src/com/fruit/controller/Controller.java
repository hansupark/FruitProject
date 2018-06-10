package com.fruit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	public void excute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
