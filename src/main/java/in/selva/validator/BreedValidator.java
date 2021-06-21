package in.selva.validator;

import java.util.List;

import in.selva.dao.BreedDao;
import in.selva.model.BreedTypes;

public class BreedValidator {

	private BreedValidator() {
		
	}
	
	/**
	 * Validate number.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isValidNumber(int number) {
		boolean valid = false;
		if (number > 0) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}
	
	/**
	 * Cost Validation
	 * @param number
	 * @return
	 */
    
	public static boolean isCostValid(double number) {
		boolean valid = false;
		if (number > 0) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}
	
   
	
	
	/**
	 * Validate book name Book name does not contain number.
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isBreedNameValid(String name) {
		boolean valid = true;
		String regex = "[a-zA-Z_ ]+\\.?";
		if (name.matches(regex)) {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}
	public static boolean isBreedPresent(String breedName)  {
		List<BreedTypes> breedDetails = BreedDao.getBreed();
		boolean exists = false;
		
		for (BreedTypes breed : breedDetails) {
			if(breed.getBreedName().equalsIgnoreCase(breedName)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
}