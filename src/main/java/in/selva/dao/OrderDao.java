package in.selva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.selva.exception.CannotGetDetailsException;
import in.selva.exception.NotAbleToDeleteException;
import in.selva.model.Order;
import in.selva.util.ConnectionUtil;

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


	/**
	 * List to store confrim order.
	 */
	
	private static final List<Order> confirmOrders = new ArrayList<>();

	/**
	 * Save ordered details into database.
	 * 
	 * @param order
	 * @throws Exception
	 */
	
	public static void saveOrder(Order order) throws Exception
	{
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
			// Step 2: Prepare data
			String sql = "insert into orderList(breedName,count,cost) values ( ?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, order.getBreedType());
			pst.setInt(2, order.getCount());
			pst.setDouble(3, order.getCost());
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Unable to add");
		}
		finally
		{
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * save the ordered details.
	 * 
	 * @param orders
	 * @throws Exception
	 */
	
	public static void save(List<Order> orders) throws Exception 
	{
		for (Order order : orders) 
		{
			saveOrder(order);
		}
	}

	/**
	 * Get ordered details.
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public static List<Order> getOrderDetails() throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		try {

			String url = "select * from orderList";
			con = ConnectionUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
			while (rs.next()) 
			{
				String breedname = rs.getString("breedName");
				int count = rs.getInt("count");
				double cost = rs.getDouble("cost");
				confirmOrders.add(new Order(breedname, count, cost));
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			ConnectionUtil.close(pst, con);
		}
		return confirmOrders;
	}

	/**
	 *  Delete order from database.
	 *  
	 * @param breedName
	 * @return
	 * @throws Exception
	 */
	
	public static boolean deleteOrders(String breedName) throws Exception
	{
		boolean isDelete = false;
		Connection con = null;
		PreparedStatement pst = null;

		try 
		{
			con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM orderList WHERE breedName=?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, breedName);

			int rs = pst.executeUpdate();

			if (rs == 1)
			{
				isDelete = true;
			} 
			else 
			{
				throw new NotAbleToDeleteException("Cannot Delete");
			}
		} 
		catch (SQLException e) 
		{
			throw new CannotGetDetailsException(e.getMessage());
		} 
		finally 
		{
			ConnectionUtil.close(pst, con);
		}

		return isDelete;
	}

	/**
	 * Update no of breeds from database.
	 * 
	 * @param breedName
	 * @param count
	 * @return
	 * @throws Exception
	 */
	
	public static boolean updateBreeds(String breedName, int count) throws Exception
	{
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isDeleted = false;
		try 
		{
			connection = ConnectionUtil.getConnection();

			String str = "update breedList set count = '" + count + "' where breedName='" + breedName + "'";

			pst = connection.prepareStatement(str);
			pst.executeUpdate();
			isDeleted = true;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			ConnectionUtil.close(pst, connection);
		}
		return isDeleted;

	}

	/**
	 * Get breed count  ordered.
	 * 
	 * @param breedName
	 * @return
	 * @throws Exception
	 */
	
	public static int getCount(String breedName) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;

		int count = 0;
		try 
		{
			connection = ConnectionUtil.getConnection();

			String str = "select count from orderList where breedName='" + breedName + "'";

			pst = connection.prepareStatement(str);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) 
			{
				count = rs.getInt("count");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			ConnectionUtil.close(pst, connection);
		}
		return count;
	}
	
	public static void confirmOrder(Order order) throws Exception
	{
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try
		{
			con = ConnectionUtil.getConnection();
			
			// Step 2: Prepare data
			
			String sql = "insert into confirmOrderList(breedName,count,cost) values ( ?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, order.getBreedType());
			pst.setInt(2, order.getCount());
			pst.setDouble(3, order.getCost());
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			throw new RuntimeException("Unable to add");
		} 
		finally
		{
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * save the ordered details.
	 * 
	 * @param orders
	 * @throws Exception
	 */
	
	public static void saveConfirmOrder(List<Order> orders) throws Exception 
	{
		for (Order order : orders) 
		{
			confirmOrder(order);
		}
	}
	
	/**
	 * Get the breed details from Data Base.
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public static List<Order> getConfirmDetails() throws Exception 
	{
		Connection con = null;
		PreparedStatement pst = null;
		try {
			//confrimOrders.removeAll(confrimOrders);
			String url = "select * from confirmOrderList";
			con = ConnectionUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
			while (rs.next()) {
				String breedname = rs.getString("breedName");
				int count = rs.getInt("count");
				double cost = rs.getDouble("cost");
				
				confirmOrders.add(new Order(breedname,count, cost));
			}

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			ConnectionUtil.close(pst, con);
		}
		return confirmOrders;
	}

	public static boolean deleteConfrimOrders(String breedName) throws Exception 
	{
		boolean isDelete = false;
		Connection con = null;
		PreparedStatement pst = null;

		try
		{
			con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM confirmOrderList WHERE breedName=?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, breedName);

			int rs = pst.executeUpdate();

			if (rs == 1)
			{
				isDelete = true;
			}
			else 
			{
				throw new NotAbleToDeleteException("Cannot Delete");
			}
		}
		catch (SQLException e) 
		{
			throw new CannotGetDetailsException(e.getMessage());
		}
		finally 
		{
			ConnectionUtil.close(pst, con);
		}
		return isDelete;
	}
}