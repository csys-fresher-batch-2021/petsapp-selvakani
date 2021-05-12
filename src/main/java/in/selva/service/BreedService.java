package in.selva.service;
import java.awt.List;
import java.util.ArrayList;
import in.selva.model.*;
public class BreedService {
	private BreedService() {
		//private constructor to avoid object creation
	}
	private static final ArrayList<BreedTypes>  breedTypes = new ArrayList<>();
	/**
	 * method to display the products available
	 *
	 * @return
	 *
	 */
	public static ArrayList<BreedTypes> getBreedTypes() 
	{
		return breedTypes;
	}
	public static boolean addBreedType(String breedType, int price) {
		boolean isAdded = false;
		//TODO: call validation and check productName
		if(breedTypes.contains(breedType))
		{
			throw new RuntimeException("Breed Type already exists");
		}
		System.out.println("Successfully added " + breedType + price);
		int id = breedTypes.size() + 1; //11
		breedTypes.add(new BreedTypes(breedType,price));
		isAdded=true;
		return isAdded;
	}
	
}