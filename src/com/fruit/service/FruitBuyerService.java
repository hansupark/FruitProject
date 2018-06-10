package com.fruit.service;

import com.fruit.DAO.FruitBuyerDAO;
import com.fruit.vo.FruitBuyer;

public class FruitBuyerService {
	private static FruitBuyerService service = new FruitBuyerService();
	private FruitBuyerDAO dao = FruitBuyerDAO.getInstance();
	private FruitBuyerService() {};
	
	public static FruitBuyerService ServiceGetInstance() 
	{
		return service;	
	}
	
	public String FruitBuyerLoginService(String id)
	{
		return dao.fruitBuyerLogin(id);
	}
	
	public void FruitBuyerMoneyRegisterService(String id,int money)
	{
		 dao.fruitBuyerMoneyRegister(id,money);
	}
	
	public FruitBuyer FruitBuyerInformationService(String id)
	{
		return dao.fruitBuyerInformation(id);
	}
	
	public boolean BuyerBuyFruitService(String sellerId,String buyerId, int appleCount)
	{
		return dao.BuyerBuyFruit(sellerId, buyerId, appleCount);
	}
}
