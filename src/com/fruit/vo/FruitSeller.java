package com.fruit.vo;

public class FruitSeller {
	private String id;
	private String pwd;
	private int money = 0;
	private int appleCount;
	private int applePrice;
	
	public FruitSeller()
	{
		
	}
	
	public FruitSeller(String id, String pwd)
	{
		this.id = id;
		this.pwd = pwd;
		money = 0;
	}
	
	public FruitSeller(String id,String pwd, int money, int appleCount, int applePrice)
	{
		this(id,pwd);
		this.money = money;
		this.appleCount = appleCount;
		this.applePrice = applePrice;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public int getAppleCount()
	{
		return appleCount;
	}
	
	public int getApplePrice()
	{
		return applePrice;
	}
	
	public int salesFruit(int money) //buyer에게 받은 돈을 seller에 대한 가격에 따라 갯수를 돌려줌
	{
		int count = money/applePrice;
		this.appleCount -= count;
		this.money += money;
		return count;
	}
}
