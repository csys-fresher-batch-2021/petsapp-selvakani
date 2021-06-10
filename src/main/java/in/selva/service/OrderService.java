package in.selva.service;

import java.util.List;

import in.selva.dao.OrderDao;
import in.selva.model.Order;

public class OrderService
{

	private OrderService() {

	}

	private static OrderDao orderDao = new OrderDao();

	/**
	 * Add Breed Details.
	 * 
	 * @param breedName
	 * @param count
	 * @param cost
	 * @return
	 */
	
	public static boolean addOrder(String breedName, int count, double cost) 
	{
		boolean isAdded = false;
		boolean present = OrderService.isPresent(breedName);
		List<Order> breed = OrderDao.getOrder();
		breed.removeAll(breed);
		if (!present || present) {
			isAdded = true;
			orderDao.addCart(breedName, count, cost);
		}

		return isAdded;
	}

	/**
	 * Search Breed name is present or not.
	 * 
	 * @param breedName
	 * @return
	 */
	
	public static boolean isPresent(String breedName) 
	{
		boolean present = false;
		List<Order> orders = OrderDao.getOrder();
		for (Order orderDetails : orders) 
		{
			if (orderDetails.getBreedType().equalsIgnoreCase(breedName))
			{
				present = true;
			}

		}
		return present;

	}

	/**
	 * Delete Breed from the list
	 * 
	 * @param breedName
	 * @return
	 */
	
	public static boolean deleteBreed(String breedName) 
	{
		boolean isDeleted = false;
		Order searchbreed = null;
		List<Order> breeds = OrderDao.getOrder();
		for (Order order : breeds) 
		{
			if (order.getBreedType().equalsIgnoreCase(breedName)) 
			{
				searchbreed = order;
				break;
			}
		}

		if (searchbreed != null)
		{
			breeds.remove(searchbreed);
			isDeleted = true;
		}
		return isDeleted;
	}

	/**
	 * Check breed count valid.
	 *  
	 * @param breedName
	 * @param count
	 * @return
	 */
	
	public static boolean checkValidNoOfBooks(String breedName, int count) {
		boolean present = OrderService.isPresent(breedName);
		boolean validBreed = false;
		if (present) 
		{
			List<Order> breeds = OrderDao.getOrder();
			for (Order order : breeds) {
				if (order.getCount() >= count) {
					validBreed = true;

				}
			}
		}
		return validBreed;
	}

	/**
	 * Add Breed
	 * 
	 * @param breedName
	 * @param count
	 * @return
	 * @throws Exception
	 */
	
	public static boolean addConfirmOrder(String breedName, int count) throws Exception 
	{
		boolean isAdd = false;
		boolean present = OrderService.isPresent(breedName);
		for (Order order : OrderDao.getOrder()) 
		{
			if (present) 
			{
				double cost = order.getCost();
				Order orderObj = new Order(breedName, count, cost);
				OrderDao.saveOrder(orderObj);
				isAdd = true;
				break;
			}
		}
		return isAdd;
	}

	/**
	 * validate breed count
	 * 
	 * @param breedName
	 * @param count
	 * @return
	 */
	
	public static boolean validCount(String breedName, int count) 
	{
		boolean valid = false;
		boolean present = OrderService.isPresent(breedName);
		if (present)
		{
			List<Order> breeds = OrderDao.getOrder();
			for (Order order : breeds) 
			{
				if (order.getCount() >= count)
				{
					valid = true;
					break;
				}
			}
		}
		return valid;
	}

	/**
	 * Delete breed from cart.
	 * 
	 * @param breedName
	 * @return
	 * @throws Exception
	 */
	
	public static boolean deleteCart(String breedName) throws Exception 
	{
		return OrderDao.deleteOrders(breedName.trim());
	}

	/**
	 * Calculate bill for cart.
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public static double billCalculation() throws Exception 
	{
		double total = 0;
		List<Order> breeds = OrderService.getOrderDetails();
		for (Order breed : breeds) 
		{
			total = total + breed.getCount() * breed.getCost();
		}

		return total;
	}

	/**
	 * Check whether the ordered breed is present in particular arraylist.
	 * 
	 * @param breedName
	 * @return
	 * @throws Exception
	 */
	
	public static boolean isPresentOrder(String breedName) throws Exception 
	{
		boolean present = false;
		List<Order> orders = OrderService.getOrderDetails();
		for (Order orderDetails : orders) 
		{
			if (orderDetails.getBreedType().equalsIgnoreCase(breedName))
			{
				present = true;
			}
		}
		return present;
	}

	/**
	 * Get order details.
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public static List<Order> getOrderDetails() throws Exception 
	{
		List<Order> orders = OrderDao.getOrderDetails();
		orders.removeAll(orders);
		List<Order> order = OrderDao.getOrderDetails();
		return order;

	}

	/**
	 * Delete Breed Type from Order List.
	 * 
	 * @param breedName
	 * @return
	 */
	
	public static boolean deleteBreedOrder(String breedName)
	{
		boolean isDeleted = false;
		Order searchbreed = null;
		List<Order> breeds = OrderDao.getOrder();
		for (Order order : breeds) 
		{
			if (order.getBreedType().equalsIgnoreCase(breedName)) {
				searchbreed = order;
				break;
			}
		}

		if (searchbreed != null)
		{
			breeds.remove(searchbreed);
			isDeleted = true;
		}
		return isDeleted;
	}

	/**
	 *  Get breed count for update.
	 *  
	 * @param breedName
	 * @return
	 */
	
	public static int getUpdatedBreed(String breedName) {
		int count1 = 0;
		List<Order> orders = OrderDao.getOrder();
		for (Order orderDetails : orders) 
		{
			if (orderDetails.getBreedType().equalsIgnoreCase(breedName))
			{
				count1 = orderDetails.getCount();
			}
		}
		return count1;
	}
}