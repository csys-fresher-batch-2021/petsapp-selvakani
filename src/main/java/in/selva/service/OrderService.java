package in.selva.service;

import java.util.List;

import in.selva.dao.OrderDao;
import in.selva.model.Order;

public class OrderService 
{

	private OrderService() 
	{

	}

	private static OrderDao orderDao = new OrderDao();

	/**
	 * Add Breed Details
	 * 
	 * @param breedType
	 * @param count
	 * @param cost
	 * @return
	 */
	
	public static boolean addOrder(String breedType, int count, double cost) 
	{
		boolean isAdded = false;
		boolean present = OrderService.isPresent(breedType);

		if (!present) 
		{
			isAdded = true;
			orderDao.addCart(breedType, count, cost);
		}

		return isAdded;
	}

	/**
	 * Search Breed Type is present or not.
	 * 
	 * @param breedType
	 * @return
	 */
	
	public static boolean isPresent(String breedType) 
	{
		boolean present = false;
		List<Order> orders = OrderDao.getOrder();
		for (Order orderDetails : orders) 
		{
			if (orderDetails.getBreedType().equalsIgnoreCase(breedType)) 
			{
				present = true;
			}

		}
		return present;

	}

	/**
	 * Delete Breed from the list.
	 * 
	 * @param breedType
	 * @return
	 */
	
	public static boolean deleteBreed(String breedType) 
	{
		boolean isDeleted = false;
		Order searchBreed = null;
		List<Order> books = OrderDao.getOrder();
		for (Order order : books) 
		{
			if (order.getBreedType().equalsIgnoreCase(breedType))
			{
				searchBreed = order;
				break;
			}
		}

		if (searchBreed != null) 
		{
			books.remove(searchBreed);
			isDeleted = true;

		}
		return isDeleted;
	}

	public static boolean checkValidCount(String breedType, int count) 
	{
		boolean present = OrderService.isPresent(breedType);
		boolean validBreed = false;
		if(present) 
		{
			List<Order> breeds = OrderDao.getOrder();
			for (Order order : breeds)
			{
				if (order.getCount()>=count) {
					validBreed = true;
					
				}
			}
		}
		return validBreed;
	}

}