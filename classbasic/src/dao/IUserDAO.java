package dao;

import java.util.List;

import entity.Users;

public interface IUserDAO {
	public List<Users> all();

	public Users find(int idUsers );

	public void create(Users user);

	public void update(Users user);

	public void delete(int id);
}