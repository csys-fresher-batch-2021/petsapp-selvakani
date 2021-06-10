package in.selva.service;

import java.sql.SQLException;
import java.util.Map;

import in.selva.dao.UserDao;
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
	 * @param confrimPassword
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public boolean addDetails(String name, String email, Long mobileNum, String address, String password)
			throws Exception {
		
		boolean registerd = false;
		
		User regObj = new User(name, email, mobileNum, address, password);
		boolean nameValid = validatorObj.isNameValid(name);
		boolean mobileValid = validatorObj.isMobileNumberValid(mobileNum);
		boolean emailValid = validatorObj.isEmailValid(email);
		boolean addressValid = validatorObj.isAddressValid(address);
		boolean passwordValid = validatorObj.isPasswordValid(password);
		
		if (nameValid && mobileValid && emailValid && addressValid && passwordValid)
		{
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
     * @throws Exception
     */
	public static boolean isValidUser(String uemail, String userPassCode) throws Exception {
           boolean valid = false;	
		   Map<String,String> loginDetails = UserDao.checkUser(uemail, userPassCode);

		   for (String email : loginDetails.keySet()) {
				String password = loginDetails.get(email);
				if(password.matches(userPassCode) && email.matches(uemail)) {
					valid = true;
				}
			}
		   return valid;
	}
	
	/**
	 * Check Whether the admin is valid.
	 * @param name
	 * @param password
	 * @return
	 * @throws Exception
	 */
	
    public static boolean isValidAdmin(String name,String password) throws Exception{
		boolean valid = false;
		Map<String,String> AdminLoginDetails = UserDao.checkAdmin(name, password);
		for (String name1 : AdminLoginDetails.keySet())
		{
			String password1 = AdminLoginDetails.get(name1);
			if(password1.matches(password) && name1.matches(name)) 
			{
				valid = true;
			}
		}
    	return valid;	
    }
}