/**
 * 
 */
package in.selva.service;

import java.util.ArrayList;


/**
 * @author selv2619
 *
 */
public class DisplayBreedTypes {

	/**
	 * Hash Map to store breed type with its price
	 */
	
	public static ArrayList<BreedTypes> breedTypes = new ArrayList<BreedTypes>();
	
	public static void addBreedType(BreedTypes breedType) 
	{
		breedTypes.add(breedType);
	}
	
	
	public static ArrayList<BreedTypes> addBreedTypesDetails()
	{
		BreedTypes breedType1=new BreedTypes();
		breedType1.breedType="Pug";
		breedType1.price=20000;
		addBreedType(breedType1);
		
		BreedTypes breedType2=new BreedTypes();
		breedType2.breedType="Shihtzu";
		breedType2.price=35000;
		addBreedType(breedType2);
		
		BreedTypes breedType3=new BreedTypes();
		breedType3.breedType="Doberman";
		breedType3.price=17000;
		addBreedType(breedType3);
		
		BreedTypes breedType4=new BreedTypes();
		breedType4.breedType="Pomeranian";
		breedType4.price=10000;
		addBreedType(breedType4);
		
		BreedTypes breedType5=new BreedTypes();
		breedType5.breedType="Golden Retreiver";
		breedType5.price=25000;
		addBreedType(breedType5);
		
		BreedTypes breedType6=new BreedTypes();
		breedType6.breedType="German Shepherd";
		breedType6.price=15000;
		addBreedType(breedType6);
		
		return breedTypes;
		
		
	}public static void displayBreedTypes()
	{
		
		System.out.println("****** Breed Types In Pets Paw ****** ");
		int i=1;
		for(BreedTypes breedType : breedTypes)
		{
			System.out.println(i+". BreedType : " +breedType.breedType+ "          Price/Dog : "+breedType.price +" Rs");
			i++;
		}
		System.out.println("*************************************");
		
	}
	
	
}
