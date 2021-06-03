package in.selva.service;
import java.util.List;

import in.selva.dao.UserDao;
import in.selva.model.User;
import in.selva.validator.UserValidator;
public class UserService 
{
     private UserDao userObj = new UserDao();
     private UserValidator validatorObj = new UserValidator();
    
     public boolean addDetails(String name,String email,Long mobileNum,String address,String password) 
     {
 		boolean registerd = false;
    	User regObj = new User(name, email, mobileNum, address, password);
 		boolean nameValid = validatorObj.isNameValid(name);
 		boolean mobileValid = validatorObj.isMobileNumberValid(mobileNum);
 		boolean emailValid  = validatorObj.isEmailValid(email);
 		boolean addressValid = validatorObj.isAddressValid(address);
 		boolean passwordValid =validatorObj.isPasswordValid(password);
 		if(nameValid && mobileValid && emailValid && addressValid && passwordValid) 
 		{
 				userObj.addUser(regObj);
 	 			registerd = true;
 		}
 			
 		else 
 		{
 			System.out.println("Invalid details");
 			registerd = false;
 		}
 		return registerd;
 	}
     
     /**
      * To check is the user registerd or not.
      * @param userName
      * @param userPassCode
      * @return
      */
 	public boolean checkUser(String userName, String userPassCode)
 	{
 		boolean isValidUser = false;
    	 List<User> users = UserDao.getUser();
 		for (User userDetails : users) 
 		{
 			if(userDetails.getName().equals(userName) && userDetails.getPassword().equals(userPassCode)) {
 				isValidUser = true;
 		}
 			
 		}
    	 return isValidUser;
 	}
}