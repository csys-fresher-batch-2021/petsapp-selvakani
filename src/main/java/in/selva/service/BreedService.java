package in.selva.service;

import java.util.List;

import in.selva.dao.BreedDao;
import in.selva.exception.CannotGetDetailsException;
import in.selva.exception.DBException;
import in.selva.exception.NotAbleToDeleteException;
import in.selva.model.BreedTypes;
import in.selva.validator.BreedValidator;

public class BreedService {

	
	private BreedService() {

	}

	
	/**
	 * Add Breed Details.
	 * 
	 * @param breedName
	 * @param count
	 * @param cost
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static boolean addBreed(String breedName, int count, double cost) throws CannotGetDetailsException, ClassNotFoundException, DBException  {
		boolean isAdded = false;
		boolean present = BreedService.isPresent(breedName);
		boolean isValidName = BreedValidator.isBreedNameValid(breedName);
		boolean validCount = BreedValidator.isValidNumber(count);
		boolean validCost = BreedValidator.isCostValid(cost);
        BreedTypes breedObj = new BreedTypes(breedName, count, cost);
		if (isValidName && validCount && validCost && !present) 
		{
			isAdded = true;
			BreedDao.saveBreed(breedObj);
		}

		return isAdded;
	}

	/**
	 * Delete Breed from arraylist.
	 * 
	 * @param breedName
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws NotAbleToDeleteException
	 * @throws DBException
	 */
	
	public static boolean deleteBreed(String breedName) throws CannotGetDetailsException, ClassNotFoundException, NotAbleToDeleteException, DBException {
		
		boolean deleted = false;
		if(BreedValidator.isBreedNameValid(breedName)) {
			deleted =  BreedDao.deleteBreeds(breedName.trim());
		}
		return deleted;
		
	}

	
	/**
	 * Find the breed present in the list or not.
	 * 
	 * @param breedName
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static boolean isPresent(String breedName) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		boolean present = false;
		List<BreedTypes> breeds = BreedDao.getBreedDetails();
		for (BreedTypes breedDetails : breeds) {
			if (breedDetails.getBreedName().equalsIgnoreCase(breedName)) {
				present = true;
				break;
			}

		}
		return present;

	}

	/**
	 * Get breed count using breed name.
	 * 
	 * @param breedName
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static int getCount(String breedName) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		int count = 0;
		List<BreedTypes> breeds = BreedDao.getBreedDetails();
		for (BreedTypes breedDetails : breeds) {
			if (breedDetails.getBreedName().equalsIgnoreCase(breedName)) {
				count = breedDetails.getCount();
			}

		}
		return count;

	}

	/**
	 * Get cost using breed name.
	 * 
	 * @param breedName
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static double getBreedCost(String breedName) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		double cost = 0;
		List<BreedTypes> breeds = BreedDao.getBreedDetails();
		for (BreedTypes breedDetails : breeds) {
			if (breedDetails.getBreedName().equalsIgnoreCase(breedName)) {
				cost = breedDetails.getCost();
			}

		}
		return cost;

	}

	/**
	 * Add search breed details using cost.
	 * 
	 * @param type
	 * @return
	 */
	
	public static boolean searchBreedByCost(int type) {
		boolean isAdd = false;
		List<BreedTypes> costDetails = BreedDao.getSearch();
		costDetails.clear();
		if (type == 1) 
		{
			for (BreedTypes breed : BreedDao.getBreed()) {
				if (breed.getCost() <= 10000)
				{
					costDetails.add(breed);
					isAdd = true;
				}
			}
		} 
		else if (type == 2) {
			for (BreedTypes breed : BreedDao.getBreed())
			{
				if (breed.getCost() <= 15000) 
				{
					costDetails.add(breed);
					isAdd = true;
				}
			}
		}
		else if (type == 3) {
			for (BreedTypes breed : BreedDao.getBreed())
			{
				if (breed.getCost() <= 25000) 
				{
					costDetails.add(breed);
					isAdd = true;
				}
			}
		}
		else if (type == 4) {
			for (BreedTypes breed : BreedDao.getBreed())
			{
				if (breed.getCost() >= 25000) 
				{
					costDetails.add(breed);
					isAdd = true;
				}
			}
		}
		
		return isAdd;
	}


	/**
	 * Add confirm Ordered breed details.
	 * 
	 * @param breedName
	 * @return
	 */
	
	public static boolean confirmOrder(String breedName)
	{
		boolean isAdd = false;
		List<BreedTypes> costDetails = BreedDao.getSearch();
		costDetails.clear();
		for (BreedTypes breed : BreedDao.getBreed()) 
		{
			if (breed.getBreedName().equalsIgnoreCase(breedName)) {
				costDetails.add(breed);
				isAdd = true;
			}
		}
		return isAdd;
	}

    /**
     * Get the breed details.
     * @return
     */
	
	public static List<BreedTypes> getBreedDetails() 
	{
		return BreedDao.getBreed();
	}

}