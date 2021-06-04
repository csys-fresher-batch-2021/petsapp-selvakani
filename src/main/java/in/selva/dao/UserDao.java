package in.selva.dao;
import java.util.ArrayList;
import java.util.List;
import in.selva.model.User;
public class UserDao {
	private final static List<User> userReg = new ArrayList<>();
	
	public void addUser(User regObj)
	{
		userReg.add(regObj);		
	}
	
	
	public static List<User> getUser() 
	{
		return userReg;
	}
	
}