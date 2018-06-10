package com.fruit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fruit.vo.FruitBuyer;
import com.fruit.vo.FruitSeller;

public class FruitSellerDAO {

	private static FruitSellerDAO dao = new FruitSellerDAO();
	
	public static FruitSellerDAO getInstance() //static FruitSellerDAO를 반환
	{
		return dao;
	}
	
	private FruitSellerDAO() {};
	
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
	public void SellerInsert(FruitSeller seller)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("insert into seller (id,pwd) values(?,?) ");
			//id pwd money appleCount applePrice
			psmt.setString(1,seller.getId());
			psmt.setString(2,seller.getPwd());
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("insert 오류 발생 : " + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
	}
	
	public String fruitSellerLogin(String id)
	{
		String pwd = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("select pwd from seller where id = ?");
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
	
	public void fruitSellerRegister(String id, int appleCount, int applePrice)
	{
		String pwd = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FruitSeller seller = null;
		int CurrentAppleCount = 0;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("select appleCount from seller where id = ?");
			psmt.setString(1,id);
			rs = psmt.executeQuery();
			System.out.println("더한전 사과갯수 : " + CurrentAppleCount);
			while(rs.next())
			{
				CurrentAppleCount = rs.getInt(1);
			}
			CurrentAppleCount += appleCount;
			System.out.println("더한후 사과갯수 : " + CurrentAppleCount);
			System.out.println("업데이트 시작");
			psmt = conn.prepareStatement("update seller set appleCount = ?, applePrice = ? where id = ?");
			//id pwd money appleCount applePrice
			psmt.setInt(1, CurrentAppleCount);
			psmt.setInt(2, applePrice);
			psmt.setString(3, id);
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
	
	public FruitSeller fruitSellerInformation(String id)
	{
		String pwd = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FruitSeller seller = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("select * from seller where id = ?");
			//id pwd money appleCount applePrice
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				System.out.println("db 추출 정보 1 : " + rs.getString(1));
				seller = new FruitSeller(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
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
		return seller;
	}
	
	public ArrayList<FruitSeller> fruitSellerList()
	{
		String pwd = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ArrayList<FruitSeller> list = new ArrayList<FruitSeller>();
		FruitSeller seller = null;
		try
		{
			conn = connect();
			psmt = conn.prepareStatement("select * from seller");
			//id pwd money appleCount applePrice
			rs = psmt.executeQuery();
			while(rs.next())
			{
				seller = new FruitSeller(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			/*	System.out.println("회원 출력 시작");
				System.out.println("seller ID : " + seller.getId());*/
				list.add(seller);
			}
		}
		catch(Exception e)
		{
			System.out.println("List 오류 발생 : " + e);
		}
		
		finally
		{
			close(conn,psmt);
		}
		return list;
	}
}
