/**
 * 
 */

package in.selva.model;

/**
 * @author selv2619
 *
 */
public class BreedTypes {

	public String breedType;
	public int price;
	
	public BreedTypes(String breedType, int price) 
	{
		// TODO Auto-generated constructor stub
		this.breedType = breedType;
		this.price= price;
	}
	
	public String getBreedType() 
	{
		return breedType;
	}
	
	public int getBreedPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "BreedType [ BreedType=" + breedType +  ", Price="+ price + "]";
	}
	
}
