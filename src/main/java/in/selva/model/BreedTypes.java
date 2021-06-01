package in.selva.model;

/**
 * @author selv2619
 *
 */
public class BreedTypes 
{

	public String breedType;
	public int count;
	public double price;
	
	public BreedTypes(String breedType, int count, double price) 
	{
		
		this.breedType = breedType;
		this.count=count;
		this.price= price;
	}
	
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
		return price;
	}
	
	@Override
	public String toString() 
	{
		return "BreedType [ BreedType : " + breedType + "Count : "+count+ ", Price : "+ price + "]";
	}
	
}
