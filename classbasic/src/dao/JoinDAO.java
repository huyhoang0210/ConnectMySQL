package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Users;
import entity.Posts;

public class JoinDAO extends CommonDAO{
	
	public void  join()
	{
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql ="select a.name, a.email from users a inner join posts b on a.idUsers = b.idUsers group by a.name";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				System.out.println("Name: "+name+ "---- Email: "+email);
			}
			} 
			catch(Exception e)
				{
					e.printStackTrace();
				}
		finally {
			if(rs!=null)
			{
				try {
					rs.close();
				}
				catch(SQLException e) {
				e.printStackTrace();
				}
				}
			}
	}
	public void sub()
	{
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql ="select idUsers from users where idUsers in (select idUsers from posts)";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("idUsers");
				System.out.println( "ID: "+id);
			}
		}	catch(Exception e)
		{
			e.printStackTrace();
		}
			finally {
				if(rs!=null)
				{
					try {
						rs.close();
					}
					catch(SQLException e) {
						e.printStackTrace();
				}
			}
    	}
	}
	
	public void CountPost()
	{
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql ="select c.idUsers,c.name,amount from users c inner join (select a.idUsers, count(a.idPosts) as amount from posts a group by a.idUsers) b on c.idUsers = b.idUsers ";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("idUsers");
				String name = rs.getString("name");
				int amount = rs.getInt("amount");
				System.out.println( "ID: "+id+"----Name: "+name+"----numberPost: "+amount);
			}
		}	catch(Exception e)
		{
			e.printStackTrace();
		}
			finally {
				if(rs!=null)
				{
					try {
						rs.close();
					}
					catch(SQLException e) {
						e.printStackTrace();
				}
			}
    	}
		
		
	}
}