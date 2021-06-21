package in.selva.service;

import java.time.LocalDate;
import java.util.List;

import in.selva.dao.OrderDao;
import in.selva.dao.UserDao;
import in.selva.exception.CannotGetDetailsException;
import in.selva.exception.DBException;
import in.selva.exception.NotAbleToDeleteException;
import in.selva.model.Order;

public class OrderService {

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
	
	public static boolean addOrder(String breedName, int count, double cost) {
		boolean isAdded = false;
		List<Order> breed = OrderDao.getOrder();
		breed.clear();
		orderDao.addCart(breedName, count, cost);
		isAdded = true;

		

		return isAdded;
	}

	/**
	 * Search Breed name is present or not.
	 * 
	 * @param breedName
	 * @return
	 */
	
	public static boolean isPresent(String breedName) {
		boolean present = false;
		List<Order> orders = OrderDao.getOrder();
		for (Order orderDetails : orders) {
			if (orderDetails.getBreedName().equalsIgnoreCase(breedName)) {
				present = true;
			}

		}
		return present;

	}

	/**
	 * Delete Breed from the list.
	 * 
	 * @param breedName
	 * @return
	 */
	
	public static boolean deleteBreed(String breedName) {
		boolean isDeleted = false;
		Order searchbreed = null;
		List<Order> breeds = OrderDao.getOrder();
		for (Order order : breeds) {
			if (order.getBreedName().equalsIgnoreCase(breedName)) {
				searchbreed = order;
				break;
			}
		}

		if (searchbreed != null) {
			breeds.remove(searchbreed);
			isDeleted = true;

		}
		return isDeleted;
	}

	/**
	 *  Check breed count valid or not.
	 *  
	 * @param breedName
	 * @param count
	 * @return
	 */
	
	public static boolean checkValidCount(String breedName, int count) {
		boolean present = OrderService.isPresent(breedName);
		boolean validCount = false;
		if (present) {
			List<Order> breeds = OrderDao.getOrder();
			for (Order order : breeds) {
				if (order.getCount() >= count) {
					validCount = true;

				}
			}
		}
		return validCount;
	}

	/**
	 * Add ordered details
	 * 
	 * @param userName
	 * @param breedName
	 * @param count
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static boolean addConfirmOrder(String userName,String breedName, int count) throws CannotGetDetailsException, ClassNotFoundException, DBException  {
		boolean isAdd = false;
		boolean present = OrderService.isPresent(breedName);
		
		int user = UserDao.getId(userName);
		
		
		
		for (Order order : OrderDao.getOrder()) {
			if (present) {
				
				int id = order.getId();
				
				double cost = order.getCost();
				String status = order.getStatus();
				
				LocalDate orderDate = LocalDate.now();
				
				LocalDate deliveryDate = orderDate.plusDays(6);
				Order orderObj = new Order(id,user,userName,breedName, count, cost,orderDate,deliveryDate,status);
				
				OrderDao.saveOrder(orderObj);
				

				OrderDao.addConfirmCart(breedName, count, cost);
				 
				isAdd = true;

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
	
	public static boolean validCount(String breedName, int count) {
		boolean valid = false;
		boolean present = OrderService.isPresent(breedName);
		if (present) {
			List<Order> breeds = OrderDao.getOrder();
			for (Order order : breeds) {
				if (order.getCount() >= count) {

					valid = true;
					break;

				}
			}

		}
		return valid;
	}

	/**
	 * Delete ordered breed from cart.
	 * @param breedName
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws NotAbleToDeleteException
	 * @throws DBException
	 */
	
	public static boolean deleteCart(String breedName) throws CannotGetDetailsException, ClassNotFoundException, NotAbleToDeleteException, DBException {

		return OrderDao.deleteOrders(breedName.trim());
	}

	/**
	 * Calculate bill for items in cart.
	 * 
	 * @return
	 */
	
	public static double billCalculation()  {
		double total = 0;
		
		List<Order> breeds = OrderDao.getConfirmOrder();
		
		for (Order breed : breeds) {
			total = total + breed.getCount() * breed.getCost();
		}
	
		
        breeds.clear();
        
		return total;
	}

	/**
	 * Check whether the ordered book is present in particular arraylist.
	 * 
	 * @param breedName
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static boolean isPresentOrder(String breedName) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		boolean present = false;
		List<Order> orders = OrderService.getOrderDetails();
		for (Order orderDetails : orders) {
			if (orderDetails.getBreedName().equalsIgnoreCase(breedName)) {
				present = true;
			}

		}
		return present;

	}

	/**
	 * Get order details.
	 * 
	 * @return
	 * @throws CannotGetDetailsException 
	 * @throws ClassNotFoundException 
	 * @throws DBException 
	 * @throws Exception
	 */
	
	public static List<Order> getOrderDetails() throws ClassNotFoundException, CannotGetDetailsException, DBException  {
		List<Order> orders = OrderDao.getOrderDetails();
		orders.clear();
		List<Order> order = OrderDao.getOrderDetails();
		return order;

	}

    /**
     * Get breed count for update.
     * 
     * @param breedName
     * @return
     */
	
	public static int getUpdatedBreeds(String breedName) {
		int count1 = 0;
		List<Order> orders = OrderDao.getOrder();
		for (Order orderDetails : orders) {
			if (orderDetails.getBreedName().equalsIgnoreCase(breedName)) {
				count1 = orderDetails.getCount();

			}

		}
		return count1;
	}
	
     
     public static boolean updateRejectStatus(int orderId) throws ClassNotFoundException, CannotGetDetailsException, DBException  {
		
		return OrderDao.updateRejectStatus(orderId);
	}
	
	public static boolean updateStatus(int orderId) throws ClassNotFoundException, CannotGetDetailsException, DBException  {
		
		return OrderDao.updateStatus(orderId);
	}

}