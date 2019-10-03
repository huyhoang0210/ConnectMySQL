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

public class UserDAO extends CommonDAO implements IUserDAO {

	@Override
	public List<Users> all() {
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "SELECT idUsers, name, email, birthday FROM users";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Users> list = new ArrayList<Users>();
			while (rs.next()) {
				int idUsers = rs.getInt("idUsers");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birthDay = rs.getDate("birthDay");
				Users user = new Users(idUsers, name, email, birthDay);
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Users find(int idUsers) {

		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "select idUsers,name,email,birthDay from users where idUsers=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idUsers);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int user_id = rs.getInt("idUsers");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birthDay = rs.getDate("birthDay");
				Users user = new Users(idUsers,name,email,birthDay);
				System.out.println(user);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null ;
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
		
		return null;
	}

	@Override
	public void create(Users user) {
		try {
			Connection connection = connect();
			String sql = "INSERT INTO users(name, email, birthDay) VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String stringDate = dateFormat.format(user.getBirthDay());
			ps.setDate(3, java.sql.Date.valueOf(stringDate));
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Users user) {
		// TODO Auto-generated method stub
		try {
			Connection connection = connect();
			String sql ="update users set name = ?,email = ?, birthDay= ? where idUsers = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(4,user.getId());
			ps.setString(1,user.getName());
			ps.setString(2,user.getEmail() );
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String stringDate = dateFormat.format(user.getBirthDay());
			ps.setDate(3, java.sql.Date.valueOf(stringDate));
			ps.execute();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public void delete(int idUsers) {
		// TODO Auto-generated method stub
		try {
			Connection connection = connect();
			String sql = "Delete from users where idUsers=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,idUsers);
			ps.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	}

}
