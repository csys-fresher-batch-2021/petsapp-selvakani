package in.selva.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import in.selva.dao.UserDao;
import in.selva.exception.CannotGetDetailsException;
import in.selva.exception.DBException;
import in.selva.model.User;
import in.selva.validator.UserValidator;

public class UserService {

	public UserService() {

	}

	/**
	 * Object created for DAO and Validator class.
	 */
	

	private UserValidator validatorObj = new UserValidator();

	/**
	 * Add User details into list.
	 * 
	 * @param name
	 * @param email
	 * @param mobileNum
	 * @param address
	 * @param password
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public boolean addDetails(String name, String email, Long mobileNum, String address, String password)
			throws CannotGetDetailsException, ClassNotFoundException, DBException {
		boolean registerd = false;
		User regObj = new User(name, email, mobileNum, address, password);
		boolean nameValid = validatorObj.isNameValid(name);
		boolean mobileValid = validatorObj.isMobileNumberValid(mobileNum);
		boolean emailValid = validatorObj.isEmailValid(email);
		boolean addressValid = validatorObj.isAddressValid(address);
		boolean passwordValid = validatorObj.isPasswordValid(password);
		
		if (nameValid && mobileValid && emailValid && addressValid && passwordValid) {
            	UserDao.save(regObj);
    			registerd = true;
         }

		return registerd;
	}

    /**
     * Find whether the user is valid.
     * @param uemail
     * @param userPassCode
     * @return
     * @throws DBException 
     * @throws Exception
     */
	
	public static boolean isValidUser(String uemail, String userPassCode) throws CannotGetDetailsException, ClassNotFoundException, DBException {
        boolean valid = false;	
		   List<User> loginDetails = UserDao.checkUser();
		   for (User user : loginDetails) {
			   if (user.getEmail().equals(uemail) && user.getPassword().equals(userPassCode) )
			   {
					   valid = true;
					   break;   
			   }
		}
		   return valid;
	}
	
	/**
	 * Check Whether the admin is valid.
	 * @param name
	 * @param password
	 * @return
	 * @throws DBException 
	 * @throws Exception
	 */
	
    public static boolean isValidAdmin(String name,String password) throws CannotGetDetailsException, ClassNotFoundException, DBException{
		boolean valid = false;
		Map<String,String> adminLoginDetails = UserDao.checkAdmin();
		for (String name1 : adminLoginDetails.keySet()) {
			String password1 = adminLoginDetails.get(name1);
			if(password1.equals(password) && name1.equals(name)) 
			{
				valid = true;
				break;
			}
		}
    	return valid;
    }
}