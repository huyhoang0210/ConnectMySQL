package entity;

import java.util.Date;

public class Users {
	private int idUsers;
	private String name;
	private String email;
	private Date birthDay;
	
	public Users() {
		
	}

	public Users(int idUsers, String name, String email, Date birthDay) {
		super();
		this.idUsers = idUsers;
		this.name = name;
		this.email = email;
		this.birthDay = birthDay;
	}

	public int getId() {
		return idUsers;
	}

	public void setId(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String toString() {
		return "User: " + name + " --- Email: " + email + " --- Birthday: " + birthDay;
	}

}