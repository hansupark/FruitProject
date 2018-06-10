package com.fruit.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.fruit.vo.FruitBuyer;
import com.fruit.vo.FruitSeller;

public class Update {

	public static Connection connect()
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
	public static void close(Connection conn, PreparedStatement ps)
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
	public static void Update(FruitSeller s)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		try 
		{
			conn = connect();
			psmt = conn.prepareStatement("update seller set appleCount = ?, money = ? where id = ?");
			psmt.setInt(1, s.getAppleCount());
			psmt.setInt(2, s.getMoney());
			psmt.setString(3, s.getId());
			psmt.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			close(conn,psmt);
		}
	}
		public static void Update(FruitBuyer b)
		{
			Connection conn = null;
			PreparedStatement psmt = null;
			try 
			{
				conn = connect();
				psmt = conn.prepareStatement("update buyer set appleCount = ?, money = ? where id = ?");
				psmt.setInt(1, b.getAppleCount());
				psmt.setInt(2, b.getMoney());
				psmt.setString(3, b.getId());
				psmt.executeUpdate();
			}
			catch(Exception e)
			{
				
			}
			finally
			{
				close(conn,psmt);
			}
	}
}
