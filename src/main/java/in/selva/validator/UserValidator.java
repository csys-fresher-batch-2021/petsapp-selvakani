package in.selva.validator;

public class UserValidator {
	/**
	 * Check whether name is valid
	 * Name must contain character.
	 * Numbers special characters are not accepted
	 * @param name
	 * @return
	 */
	public boolean isNameValid(String name) {
		boolean valid = false;
		String regex = "[a-zA-Z_ ]+\\.?";
		if (name.matches(regex)) {
			valid = true;
		}
		else {
			valid = false;
			System.out.println("Invalid User Name");
			
		}
		return valid;
	}
	/**
	 * Validating email id.
	 * The email id must start with character.
	 * The email id can have number in between.
	 * The email id must contain @ in between.
	 * After @ symbol email id must contain some character.
	 * After that email id must have . symbol.
	 * After . symbol it must have character with the length of 2-7.
	 * @param email
	 * @return
	 */
	public boolean isEmailValid(String email) {
		boolean valid = false;
		
		  String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.+[a-zA-Z0-9_+&*-]+)*@" +
		  "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		 
   	 if(email.matches(regex)) {
   		 valid = true;
   	 }
   	else {
		valid = false;
		System.out.println("Invalid Email");
	}
   	   return valid;
	}
	/**
     * Validating mobile number.
     * The mobile number length should be 10.
     * The mobile number not a zero.
     * @param mobileNumber
     * @return
     */
	public boolean isMobileNumberValid(long mobile) {
		String number = String.valueOf(mobile);
		boolean valid = false;
		 if(number.length()==10) {
			 valid = true;
		 }
		 else {
				valid = false;
				System.out.println("Invalid mobile number");
			}
		return valid;
	}
	/**
	 * Check whether address is valid
	 * Address may contain number and characters.
	 * @param name
	 * @return
	 */
	public boolean isAddressValid(String address) {
		boolean valid = false;
		String regex = "[a-zA-Z0-9_ ]+\\.?";
		if (address.trim().matches(regex)) {
			valid = true;
		}
		else {
			valid = false;
			System.out.println("Invalid Address");
			
		}
		return valid;
	}
	
	/**
	 * Validate password.
	 * Password must contain Upper case,special character and number.
	 * @param pass
	 * @return
	 */
	public boolean isPasswordValid(String pass) {
		boolean valid = false;
		
		  String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
		  + "(?=\\S+$).{8,20}$";
		 
		 if(pass!=null && pass.matches(regex)) {
			 valid = true;
		 }
		 else {
				valid = false;
				System.out.println("Invalid Password");
			}
		
		return valid;
	}
}