package in.selva.dao;

import java.util.ArrayList;
import java.util.List;

import in.selva.model.Order;

public class OrderDao 
{

	/**
	 * Store Ordered  Details
	 */
	
	private static final List<Order> orders = new ArrayList<>();

	/**
	 * Add Order Details
	 * 
	 * @param breedType
	 * @param count
	 * @param cost
	 */
	
	public void addCart(String breedType, int count, double cost) 
	{

		orders.add(new Order(breedType, count, cost));
	}

	/**
	 * Get Ordered List.
	 * 
	 * @return
	 */
	
	public static List<Order> getOrder()
	{
		return orders;
	}

}