package in.selva.model;

public class BreedTypes {

	/**
	 * Declaring variables required for Pet shop.
	 */
     
	private String breedName;
	private int count;
	private double cost;

	public String getBreedName()
	{
		return breedName;
	}

	public int getCount()
	{
		return count;
	}

	public double getCost() 
	{
		return cost;
	}

	public BreedTypes(String breedName, int count, double cost) {
		super();
		this.breedName = breedName;
		this.count = count;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "BreedType [BreedName : " + breedName +", Count : " + count + ", Cost : " + cost
				+ "]";
	}

}