package entity;

public class Posts {
	private int idPosts;
	private int idUsers;
	private String content ;
	
	public Posts() {
		// TODO Auto-generated constructor stub
	}

	public Posts(int idPosts, int idUsers, String content) {
		super();
		this.idPosts = idPosts;
		this.idUsers = idUsers;
		this.content = content;
	}

	public int getIdPosts() {
		return idPosts;
	}

	public void setIdPosts(int idPosts) {
		this.idPosts = idPosts;
	}

	public int getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String toString() {
		return "IdUsers: " + idUsers + " --- content: " + content;
	}
	
}
