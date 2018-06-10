package com.fruit.vo;

public class FruitBuyer {
	private String id;
	private String pwd;
	private int appleCount = 0;
	private int money = 0;
	private int count = 0;
	
	public FruitBuyer(String id, String pwd) 
	{
		this.id = id;
		this.pwd = pwd;
	}
	
	public FruitBuyer(int money, int appleCount)
	{
		this.money = money;
		this.appleCount = appleCount;
	}
	
	public FruitBuyer(String id, String pwd, int money, int appleCount)
	{
		this(id,pwd);
		this.money = money;
		this.appleCount = appleCount;
	}
	public String getId()
	{
		return id;
	}
	public int getMoney() 
	{
		return money;
	}
	
	public int getAppleCount()
	{
		return appleCount;
	}
	public int getCount()
	{
		return count;
	}
	public void buyFruit(FruitSeller s, int money) //이 seller s에게 money을 통해 과일을 buy함
	{
		int count = s.salesFruit(money);
		System.out.println("count : " + count);
		this.appleCount += count;
		this.money -= money;
	}
}
