package com.fruit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fruit.controller.Update;
import com.fruit.vo.FruitBuyer;
import com.fruit.vo.FruitSeller;

public class FruitBuyerDAO {

private static FruitBuyerDAO dao = new FruitBuyerDAO();
	
	public static FruitBuyerDAO getInstance() //static FruitSellerDAO를 반환
	{
		return dao;
	}
	
	private FruitBuyerDAO() {};
	
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/fruit";
			String user = "root";
			String password = "cs1234";
			conn = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e)
		{
			System.out.println("connection 오류 발쌩  : " + e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement ps)
	{
		if(conn != null)
		{
			try
			{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println("conn close 오류 발생 : " + e);
			}
		}
		
		if(ps != null)
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				System.out.println("ps close 오류 발생 : " + e);
			}
		}
	}
	//유저
		public String fruitBuyerLogin(String id)
		{
			String pwd = null;
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			try
			{
				conn = connect();
				psmt = conn.prepareStatement("select pwd from buyer where id = ?");
				//id pwd money appleCount applePrice
				psmt.setString(1, id);
				//System.out.println("id : " + id);
				rs = psmt.executeQuery();
				while(rs.next())
				{
					pwd = rs.getString(1);
					//System.out.println("pwd in db : " + pwd);
				}
			}
			catch(Exception e)
			{
				System.out.println("Login 오류 발생 : " + e);
			}
			
			finally
			{
				close(conn,psmt);
			}
			return pwd;
		}
		public void fruitBuyerMoneyRegister(String id, int money)
		{
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			int currentMoney = 0;
			try
			{
				conn = connect();
				System.out.println("업데이트 시작");
				System.out.println("currnet money = " + currentMoney);
				psmt = conn.prepareStatement("select money from buyer where id = ?");
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				System.out.println("currnet money = " + currentMoney);
				while(rs.next())
				{
					currentMoney = rs.getInt(1);
				}
				System.out.println("currnet money = " + currentMoney);
				psmt = conn.prepareStatement("update buyer set money = ? where id = ?");
				//id pwd money appleCount applePrice
				psmt.setInt(1, currentMoney + money);
				psmt.setString(2, id);
				psmt.executeUpdate();
				System.out.println("업데이트 완료");
			}
			catch(Exception e)
			{
				System.out.println("update 오류 발생 : " + e);
			}
			
			finally
			{
				close(conn,psmt);
			}
		}
		public FruitBuyer fruitBuyerInformation(String id)
		{
			String pwd = null;
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			FruitBuyer Buyer = null;
			try
			{
				conn = connect();
				psmt = conn.prepareStatement("select * from buyer where id = ?");
				//id pwd money appleCount applePrice
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				while(rs.next())
				{
					System.out.println("db 추출 정보 1 : " + rs.getString(1));
					Buyer = new FruitBuyer(rs.getInt(3),rs.getInt(4));
				}
			}
			catch(Exception e)
			{
				System.out.println("look 오류 발생 : " + e);
			}
			
			finally
			{
				close(conn,psmt);
			}
			return Buyer;
		}
		
		public boolean BuyerBuyFruit(String sellerId,String buyerId, int appleCount)
		{
			Connection conn_1 = null; //seller
			//Connection conn_2 = null; //buyer
			PreparedStatement psmt_1 = null;
			PreparedStatement psmt_2 = null;
			ResultSet rs_1 = null;
			ResultSet rs_2 = null;
			FruitSeller seller = null;
			FruitBuyer buyer = null;
			int totalMoney;
			boolean state = false;
			try
			{
				if(appleCount < 0)
				{
					return state;
				}
				 conn_1 = connect(); //seller
				 //conn_2 = connect(); //buyer
				 psmt_1 = conn_1.prepareStatement("select * from seller where id = ?");
				 psmt_1.setString(1,sellerId);
				 psmt_2 = conn_1.prepareStatement("select * from buyer where id = ?");
				 psmt_2.setString(1,buyerId);
				 rs_1 = psmt_1.executeQuery();
				 rs_2 = psmt_2.executeQuery();
				 while(rs_1.next())
				 {
					 seller = new FruitSeller(rs_1.getString(1),rs_1.getString(2),rs_1.getInt(3),rs_1.getInt(4),rs_1.getInt(5));
				 }
				 while(rs_2.next())
				 {
					 buyer = new FruitBuyer(rs_2.getString(1),rs_2.getString(2),rs_2.getInt(3),rs_2.getInt(4));
				 }
				 totalMoney = appleCount * seller.getApplePrice();
				 if(buyer.getMoney() >= totalMoney && seller.getAppleCount() >= appleCount)
				 {
					 buyer.buyFruit(seller, totalMoney);
					 Update.Update(buyer);
					 Update.Update(seller);
					 state = true;
				 }
				 
			}
			catch(Exception e)
			{
				
			}
			finally
			{
				close(conn_1,psmt_1);
				close(conn_1,psmt_2);
			}
			return state;
		}
}
