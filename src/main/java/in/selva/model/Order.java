package in.selva.model;

public class Order {
	/**
	 * Declaring Required Variables.
	 */
	private String breedType;
	private int count;
	private double cost;

	public String getBreedType() 
	{
		return breedType;
	}

	public int getCount() 
	{
		return count;
	}

	public double getCost() 
	{
		return cost;
	}
	

	public Order(String breedType, int count, double cost) {
		super();
		this.breedType = breedType;
		this.count = count;
		this.cost = cost;
	}

	@Override
	public String toString() 
	{
		return "Order [BreedType : " + breedType + ", Count : " + count + ", Cost : " + cost + "]";
	}

}