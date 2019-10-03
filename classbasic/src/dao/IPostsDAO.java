package dao;

import java.util.List;

import entity.Posts;

public interface IPostsDAO {
	public List<Posts> all();

	public Posts find(int idPosts );

	public void create(Posts post);

	public void update(Posts post);

	public void delete(int idPosts);
}