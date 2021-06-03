package in.selva.dao;

import java.util.ArrayList;
import java.util.List;
import in.selva.model.*;

public class BreedDao 
{
	/**
	 * ArrayList to store Breed Details.
	 */
	
	private static final List<BreedTypes> breeds = new ArrayList<>();
	 
	/**
	 * Store Breed Details.
	 */

	static 
	{
		breeds.add(new BreedTypes("Shihtzu", 4, 35000));
		breeds.add(new BreedTypes("Pomeranian", 5, 10000));
		breeds.add(new BreedTypes("German Shepherdd", 3, 15000));
		breeds.add(new BreedTypes("Doberman", 3, 17000));
	}
	
	/**
	 * ArrayList to store search breeds.
	 */
	
	private static final List<BreedTypes> type = new ArrayList<>();

	/**
	 * Add Breed Details
	 * 
	 * @param breedType
	 * @param count
	 * @param cost
	 */
	
	public void addBreed(String breedType, int count, double cost)
	{

		breeds.add(new BreedTypes(breedType, count, cost));
	}

	/**
	 * Get Breed Details.
	 * 
	 * @return
	 */
	
	public static List<BreedTypes> getBreed() 
	{
		return breeds;
	}

	/**
	 * 
	 * @param breedType
	 * @param count
	 * @param cost
	 */

	public void addSearch(String breedType, int count, double cost) 
	{

		type.add(new BreedTypes(breedType, count, cost));

	}

	/**
	 * Get Search Breed Details.
	 * 
	 * @return
	 */
	
	public static List<BreedTypes> getSearch() 
	{
		return type;
	}
 
}