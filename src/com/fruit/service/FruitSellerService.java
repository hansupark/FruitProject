package com.fruit.service;

import java.util.ArrayList;

import com.fruit.DAO.FruitSellerDAO;
import com.fruit.vo.FruitSeller;

public class FruitSellerService {

	private static FruitSellerService service = new FruitSellerService();
	private FruitSellerDAO dao = FruitSellerDAO.getInstance();
	private FruitSellerService() {};
	
	public static FruitSellerService ServiceGetInstance() 
	{
		return service;	
	}
	
	public String FruitSellerLoginService(String id)
	{
		return dao.fruitSellerLogin(id);
	}
	
	public FruitSeller FruitSellerInformationService(String id)
	{
		return dao.fruitSellerInformation(id);
	}
	
	public void FruitSellerRegisterService(String id,int appleCount, int applePrice)
	{
		dao.fruitSellerRegister(id, appleCount, applePrice);
	}
	
	public ArrayList<FruitSeller> fruitSellerListService()
	{
		return dao.fruitSellerList();
	}
}
