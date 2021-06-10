package in.selva.service;

import java.util.List;

import in.selva.dao.BreedDao;
import in.selva.model.BreedTypes;

public class BreedService 
{

	private BreedService() 
	{

	}

	private static BreedDao breedDao = new BreedDao();

	/**
	 * Add Breed Details
	 * 
	 * @param breedType
	 * @param count
	 * @param cost
	 * @return
	 */
	
	public static boolean addBreed(String breedType, int count, double cost)
	{
		boolean isAdded = false;
		boolean present = BreedService.isPresent(breedType);

		if (!present) 
		{
			isAdded = true;
			breedDao.addBreed(breedType, count, cost);
		}

		return isAdded;
	}

	/**
	 * Delete Breed Type from breed details.
	 * 
	 * @param breedType
	 * @return
	 */
	
	public static boolean deleteBreed(String breedType) 
	{
		boolean isDeleted = false;
		BreedTypes searchbreed = null;
		List<BreedTypes> breeds = BreedDao.getBreed();
		for (BreedTypes breed : breeds) 
		{
			if (breed.getBreedType().equalsIgnoreCase(breedType))
			{
				searchbreed = breed;
				break;
			}
		}

		if (searchbreed != null) 
		{
			breeds.remove(searchbreed);
			isDeleted = true;
			System.out.println("Deleted");
		}
		return isDeleted;
	}

	/**
	 *  Find the breed present in the list or not.
	 *  
	 * @param breedType
	 * @return
	 */
	
	public static boolean isPresent(String breedType) 
	{
		boolean present = false;
		List<BreedTypes> breeds = BreedDao.getBreed();
		for (BreedTypes breedDetail : breeds) {
			if (breedDetail.getBreedType().equalsIgnoreCase(breedType)) 
			{
				present = true;
			}

		}
		return present;

	}

	/**
	 * Get Breed Count using breed name.
	 * 
	 * @param breedType
	 * @return
	 */
	
	public static int getCount(String breedType)
	{
		int count = 0;
		List<BreedTypes> breeds = BreedDao.getBreed();
		for (BreedTypes breedDetails : breeds) 
		{
			if (breedDetails.getBreedType().equalsIgnoreCase(breedType)) 
			{
				count = breedDetails.getCount();
			}

		}
		return count;

	}

	/**
	 * Get cost using breed name.
	 * 
	 * @param breedType
	 * @return
	 */
	
	public static double getCost(String breedType) 
	{
		double cost = 0;
		List<BreedTypes> breeds = BreedDao.getBreed();
		for (BreedTypes breedDetails : breeds)
		{
			if (breedDetails.getBreedType().equalsIgnoreCase(breedType))
			{
				cost = breedDetails.getCost();
			}

		}
		return cost;

	}
	
	/**
	 * Add search breed details.
	 * 
	 * @param breedType
	 * @return
	 */
	
	public static boolean searchBreedByCost(int breedType)
	{
		boolean isAdd = false;
		List<BreedTypes> costDetails = BreedDao.getSearch();
		costDetails.removeAll(costDetails);
		if (breedType == 1) 
		{
			for (BreedTypes breed : BreedDao.getBreed()) 
			{
				if (breed.getCost() <= 10000) {
					costDetails.add(breed);
					isAdd = true;
				}
			}
		} 
		
		else if (breedType == 2) 
		{
			for (BreedTypes breed : BreedDao.getBreed()) {
				if (breed.getCost() <= 15000) 
				{
					costDetails.add(breed);
					isAdd = true;
				}
			}
		}
		
		else if (breedType == 3) 
		{
			for (BreedTypes breed : BreedDao.getBreed()) {
				if (breed.getCost() <= 25000) 
				{
					costDetails.add(breed);
					isAdd = true;
				}
			}
		}
		
		else if (breedType == 4) 
		{
			for (BreedTypes breed : BreedDao.getBreed()) {
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
	 * Add confirm ordered details.
	 * 
	 * @param breedType
	 * @return
	 */
	
	public static boolean confirmOrder(String breedType) 
	{
		boolean isAdd = false;
		List<BreedTypes> costDetails = BreedDao.getSearch();
		costDetails.removeAll(costDetails);
		for (BreedTypes breed : BreedDao.getBreed()) 
		{
			if (breed.getBreedType().equalsIgnoreCase(breedType)) 
			{
				costDetails.add(breed);
				isAdd = true;
			}
		}
		return isAdd;
	}

	/**
	 * Get breed details from database.
	 * @return
	 * @throws Exception
	 */
	
	public static List<BreedTypes> getBreedDetails() throws Exception
	{
		List<BreedTypes> breeds = BreedDao.getBreedDetails();
		breeds.removeAll(breeds);
		List<BreedTypes> breed = BreedDao.getBreedDetails();
		return breed;	
	}

}