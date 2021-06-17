package in.selva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.selva.exception.CannotGetDetailsException;
import in.selva.exception.DBException;
import in.selva.exception.NotAbleToDeleteException;
import in.selva.model.Order;
import in.selva.util.ConnectionUtil;

public class OrderDao {
	
	
	private static final String ORDER_ID = "id";
	private static final String USER_ID = "userid";
	private static final String USER_NAME = "username";
	private static final String BREED_NAME = "breedname";
	private static final String COUNT = "count";
	private static final String COST = "cost";
	private static final String ORDER_DATE = "order_date";
	private static final String DELIVERY_DATE = "delivery_date";
	private static final String ORDER_STATUS = "status";
	private static final String INSERT_ORDER_DATA_QUERY = "insert into orderList(userid,username,breedname,count,cost,order_date,delivery_date,status) values (?,?,?,?,?,?,?,'PENDING')";
	private static final String GET_ORDER_DETAILS_QUERY = "select id,userid,username,breedName,count,cost,order_date,delivery_date,status from orderList ORDER BY breedName";
	private static final String DELETE_ORDER_QUERY = "DELETE FROM orderList WHERE breedName=?";
	private static final String UPDATE_BREEDS_OUERY = "update breedList set count = ? where breedName=?";
	private static final String GET_TOTAL_BREEDS_QUERY = "select count from orderList where breedName=?";
	private static final String UPDATE_ORDER_STATUS_QUERY = "update orderList set status = 'DELIVERED' where id=?";
	private static final String UPDATE_REJECT_STATUS_QUERY =  "update orderList set status ='CANCELLED' where id=?";
	private static final String GET_ORDER_QUERY =  "select * from orderList where userid=?";
	
	/**
	 * Store Ordered Book Details
	 */
	private static final List<Order> orders = new ArrayList<>();

	/**
	 * Add Ordered details.
	 * 
	 * @param breedName
	 * @param count
	 * @param cost
	 */
	
	public void addCart(String breedName, int count, double cost) {

		orders.add(new Order(breedName, count, cost));
	}

	/**
	 * Get Ordered List.
	 * 
	 * @return
	 */
	public static List<Order> getOrder() {
		return orders;
	}

	/**
	 * List to store confirm order.
	 */
	private static final List<Order> confirmOrders = new ArrayList<>();
	private static final List<Order> userOrders = new ArrayList<>();

	private static final List<Order> orderDetails = new ArrayList<>();
	private static final List<Order> cartDetails = new ArrayList<>();

	public static void addConfirmCart(String breedName, int count, double cost) {

		orderDetails.add(new Order(breedName, count, cost));
	}

	public static List<Order> getConfirmOrder() {
		return orderDetails;
	}

	/**
	 * Save ordered details into database.
	 * 
	 * @param order
	 * @throws ClassNotFoundException
	 * @throws DBException 
	 * @throws Exception
	 */
	
	public static void saveOrder(Order order) throws CannotGetDetailsException,ClassNotFoundException, DBException {
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			// Step 2: Prepare data
			String sql = INSERT_ORDER_DATA_QUERY;
			pst = con.prepareStatement(sql);
			pst.setInt(1, order.getUserId());
			pst.setString(2, order.getUserName());
			pst.setString(3, order.getBreedName());
			pst.setInt(4, order.getCount());
			pst.setDouble(5, order.getCost());
			pst.setObject(6, order.getOrderDate());
			pst.setObject(7, order.getDeliveryDate());

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new CannotGetDetailsException("Unable to get details");
		} finally {
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * save the ordered details.
	 * 
	 * @param orders
	 * @throws DBException 
	 * @throws Exception
	 */
	
	public static void save(List<Order> orders) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		for (Order order : orders) {
			saveOrder(order);
		}
	}

	/**
	 * Get ordered details.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws DBException 
	 * @throws Exception
	 */
	public static List<Order> getOrderDetails() throws CannotGetDetailsException, ClassNotFoundException, DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			String sql = GET_ORDER_DETAILS_QUERY;
			con = ConnectionUtil.getConnection();

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			confirmOrders.clear();
			while (rs.next()) {
				int id1 = rs.getInt(ORDER_ID);
				int userId = rs.getInt(USER_ID);
				String userName = rs.getString(USER_NAME);
				String breedname = rs.getString(BREED_NAME);
				int count = rs.getInt(COUNT);
				double cost = rs.getDouble(COST);
				LocalDate orderDate = LocalDate.parse(rs.getString(ORDER_DATE));
				LocalDate deliveryDate = LocalDate.parse(rs.getString(DELIVERY_DATE));
				String status = rs.getString(ORDER_STATUS);
				confirmOrders.add(new Order(id1, userId, userName, breedname, count, cost, orderDate,
						deliveryDate, status));
			}

		} catch (SQLException e) {
			throw new CannotGetDetailsException("Unable select details");

		} finally {
			ConnectionUtil.close(pst, con);
		}

		return confirmOrders;
	}

	/**
	 * Delete order from database.
	 * 
	 * @param breedName
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws NotAbleToDeleteException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static boolean deleteOrders(String breedName)
			throws CannotGetDetailsException, NotAbleToDeleteException, ClassNotFoundException, DBException {
		boolean isDelete = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = DELETE_ORDER_QUERY;
			pst = con.prepareStatement(sql);
			pst.setString(1, breedName);

			int rs = pst.executeUpdate();

			if (rs == 1) {
				isDelete = true;
			} else {
				throw new NotAbleToDeleteException("Cannot Delete");
			}
		} catch (SQLException e) {
			throw new CannotGetDetailsException("Unable to get details to delete");
		} finally {
			ConnectionUtil.close(pst, con);
		}

		return isDelete;
	}

	/**
	 * Update breed count from database.
	 * 
	 * @param breedName
	 * @param count
	 * @return
	 * @throws DBException
	 * @throws ClassNotFoundException
	 */
	
	public static boolean updateBreeds(String breedName, int count) throws DBException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isUpdated = false;
		try {
			connection = ConnectionUtil.getConnection();

			String str = UPDATE_BREEDS_OUERY;

			pst = connection.prepareStatement(str);
			pst.setInt(1, count);
			pst.setString(2, breedName);
			pst.executeUpdate();
			isUpdated = true;

		} catch (SQLException e) {

			throw new DBException("Unable to get details to update");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isUpdated;

	}

	/**
	 * Get count ordered.
	 * 	
	 * @param breedName
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static int getCount(String breedName) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		Connection connection = null;
		PreparedStatement pst = null;

		int count = 0;
		try {
			connection = ConnectionUtil.getConnection();

			String str = GET_TOTAL_BREEDS_QUERY;

			pst = connection.prepareStatement(str);
			pst.setString(1, breedName);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				count = rs.getInt(COUNT);

			}

		} catch (SQLException e) {

			throw new CannotGetDetailsException("Unable to get Breed Count");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return count;

	}


	/**
	 * Add ordered Details.
	 * 
	 * @param breedName
	 * @param count
	 * @param cost
	 */
	
	public static void addOrders(String breedName, int count, double cost) {
		orderDetails.add(new Order(breedName, count, cost));

	}

	/**
	 * Add cart details.
	 * 
	 * @param breedName
	 * @param count
	 * @param cost
	 */
	
	public static void addCartDetails(String breedName, int count, double cost) {
		cartDetails.add(new Order(breedName, count, cost));

	}

	/**
	 * Get Cart Details.
	 * 
	 * @return
	 */
	
	public static List<Order> getCartDetails() {
		return cartDetails;
	}

	/**
	 * Update Order status.
	 * 
	 * @param orderId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws DBException 
	 * @throws Exception
	 */
	
	public static boolean updateStatus(int orderId) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isUpdated = false;
		try {

			connection = ConnectionUtil.getConnection();

			String str = UPDATE_ORDER_STATUS_QUERY;
			pst = connection.prepareStatement(str);
			pst.setInt(1, orderId);
			pst.executeUpdate();
			isUpdated = true;

		} catch (SQLException e) {

			throw new CannotGetDetailsException("Unable to update status");

		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isUpdated;

	}

	/**
	 * Update order Status.
	 * 
	 * @param orderId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws CannotGetDetailsException
	 * @throws DBException 
	 */
	
	public static boolean updateRejectStatus(int orderId) throws ClassNotFoundException, CannotGetDetailsException, DBException {
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isUpdated = false;
		try {

			connection = ConnectionUtil.getConnection();

			String str = UPDATE_REJECT_STATUS_QUERY;
			pst = connection.prepareStatement(str);

			pst.setInt(1, orderId);
			pst.executeUpdate();
			isUpdated = true;

		} catch (SQLException e) {

			throw new CannotGetDetailsException("Unable to update status details");

		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isUpdated;
	}

	/**
	 * Get User Order
	 * 
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws DBException 
	 * @throws Exception
	 */
	
	public static List<Order> getUserOrder(int id) throws CannotGetDetailsException, ClassNotFoundException, DBException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			String url = GET_ORDER_QUERY;
			con = ConnectionUtil.getConnection();

			pst = con.prepareStatement(url);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			userOrders.clear();
			while (rs.next()) {
				int id1 = rs.getInt(ORDER_ID);
				int userId = rs.getInt(USER_ID);
				String userName = rs.getString(USER_NAME);
				String breedname = rs.getString(BREED_NAME);
				int count = rs.getInt(COUNT);
				double cost = rs.getDouble(COST);
				LocalDate orderDate = LocalDate.parse(rs.getString(ORDER_DATE));
				LocalDate deliveryDate = LocalDate.parse(rs.getString(DELIVERY_DATE));
				String status = rs.getString(ORDER_STATUS);
				userOrders.add(new Order(id1, userId, userName, breedname, count, cost, orderDate,
						deliveryDate, status));
			}

		} catch (SQLException e) {
			throw new CannotGetDetailsException("Unable get user order");

		} finally {
			ConnectionUtil.close(pst, con);
		}

		return userOrders;
	}

	public static List<Order> saveUserOrder() {
		return userOrders;
	}
}