package Main;
import java.text.SimpleDateFormat;
import java.util.List;
import dao.UserDAO;
import dao.PostsDAO;
import dao.JoinDAO;
import entity.Users;
import entity.Posts;
public class TestMySQL {

	public static void main(String[] args) {
		try {
			UserDAO userDAO = new UserDAO();
			// --create 
		//	Users newUser = new Users();
		//	newUser.setId(3);
		//	newUser.setName("bao bao");
		//	newUser.setEmail("huynguyen@gmail.com");
		//SimpleDateFormat dateformat2 = new SimpleDateFormat("MM/dd/yyyy");
		//	newUser.setBirthDay(dateformat2.parse("1/1/1987"));
			//userDAO.create(newUser);
			//userDAO.update(newUser);
	// firnd
			//userDAO.find(5);
	// delete
			//userDAO.delete(5) ;	
			//List<Users> users = userDAO.all();
	//	for (Users user : users) {
		//	System.out.println(user);
	
		//	}
			//PostsDAO postDAO = new PostsDAO();
			// create 
			//Posts newPosts = new Posts();
		//	newPosts.setIdPosts(1);
		//	newPosts.setIdUsers(3);
		//	newPosts.setContent("bai hay tuyet");
			//postDAO.create(newPosts);
			//postDAO.delete(2);
		//	postDAO.update(newPosts);
			//List<Posts> posts = postDAO.all();
				//for (Posts post : posts) {
				//	System.out.println(post);
					
			//	}
			JoinDAO joinDAO = new JoinDAO();
			//joinDAO.join();
			//joinDAO.sub();
			joinDAO.CountPost();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}