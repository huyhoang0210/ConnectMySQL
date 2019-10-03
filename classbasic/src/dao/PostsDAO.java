package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Posts;

public class PostsDAO extends CommonDAO implements IPostsDAO {

	@Override
	public List<Posts> all() {
		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "SELECT idPosts,idUsers,content FROM posts";
			PreparedStatement ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Posts> list = new ArrayList<Posts>();
			while (rs.next()) {
				int idPosts = rs.getInt("idPosts");
				int idUsers = rs.getInt("idUsers");
				String content = rs.getString("content");
				Posts post = new Posts(idPosts,idUsers,content);
				list.add(post);
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
	public Posts find(int idPosts) {

		ResultSet rs = null;
		try {
			Connection connection = connect();
			String sql = "select idPosts,idUsers,content from posts where idPosts=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, idPosts);
			rs = ps.executeQuery();
			while(rs.next())
			{
				int post_id = rs.getInt("idPosts");
				int  idUsers = rs.getInt("idUsers");
				String content = rs.getString("content");
				Posts post = new Posts(idPosts,idUsers,content);
				System.out.println(post);
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
	public void create(Posts post) {
		try {
			Connection connection = connect();
			String sql = "INSERT INTO posts(idUsers,content) VALUES (?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, post.getIdUsers());
			ps.setString(2, post.getContent());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Posts post) {
		// TODO Auto-generated method stub
		try {
			Connection connection = connect();
			String sql ="update posts set idUsers = ?, content= ? where idPosts = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(3,post.getIdPosts());
			ps.setInt(1,post.getIdUsers());
			ps.setString(2,post.getContent());
			ps.execute();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public void delete(int idPosts) {
		// TODO Auto-generated method stub
		try {
			Connection connection = connect();
			String sql = "Delete from posts where idPosts=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,idPosts);
			ps.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	}

}
