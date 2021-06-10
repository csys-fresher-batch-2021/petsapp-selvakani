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
import in.selva.model.BreedTypes;
import in.selva.util.ConnectionUtil;

public class BreedDao 
{
	/**
	 * ArrayList to store Breed Details.
	 */
	
	private static final List<BreedTypes> breeds = new ArrayList<>();
	 
	
	/**
	 * ArrayList to store search breeds.
	 */
	
	
	private static final List<BreedTypes> type = new ArrayList<>();

	/**
	 * Add Breed Details
	 * 
	 * @param breedType
	 * @param count
	 * @param cost
	 */
	
	public void addBreed(String breedType, int count, double cost)
	{

		breeds.add(new BreedTypes(breedType, count, cost));
	}
	
	
	/**
	 * Get Breed Details.
	 * 
	 * @return
	 */
	
	public static List<BreedTypes> getBreed() 
	{
		return breeds;
	}

	/**
	 * Add search details
	 * 
	 * @param breedType
	 * @param count
	 * @param cost
	 */

	public void addSearch(String breedType, int count, double cost) 
	{
		type.add(new BreedTypes(breedType, count, cost));
	}

	/**
	 * Get Search Breed Details.
	 * 
	 * @return
	 */
	
	public static List<BreedTypes> getSearch() 
	
	{
		return type;
	}
	

	/**
	 * Insert breed details into DataBase.
	 * 
	 * @param breed
	 * @throws Exception
	 */
	
	public static void saveBreed(BreedTypes breed) throws Exception 
	{
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try 
		{
			con = ConnectionUtil.getConnection();
			
			// Step 2: Prepare data
			
			String sql = "insert into breedList(breedName,count,cost) values ( ?,?,?,?)";
			pst = con.prepareStatement(sql);

			pst.setString(1, breed.getBreedType());
			pst.setInt(2, breed.getCount());
			pst.setDouble(3, breed.getCost());
			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted :" + rows);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("Unable to add user");
		} 
		finally 
		{
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * Add breed details 
	 * 
	 * @param breeds
	 * @throws Exception
	 */
	
	public static void save(List<BreedTypes> breeds) throws Exception {
		for (BreedTypes breed : breeds) 
		{
			saveBreed(breed);
		}
	}

	/**
	 * Get the breed details from Data Base
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public static List<BreedTypes> getBreedDetails() throws Exception 
	{
		Connection con = null;
		PreparedStatement pst = null;
		try {
            breeds.removeAll(breeds);
			String url = "select * from breedList where count>0";
			con = ConnectionUtil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
			while (rs.next())
			{
				String breedname = rs.getString("breedName");
				int count = rs.getInt("count");
				double cost = rs.getDouble("cost");
				
				breeds.add(new BreedTypes(breedname, count, cost));
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
		return breeds;
	}

	/**
	 * Delete Breed from Database.
	 * 
	 * @param breedName
	 * @return
	 * @throws Exception
	 */
	
	public static boolean deleteBreeds(String breedName) throws Exception {

		boolean isDelete = false;
		Connection con = null;
		PreparedStatement pst = null;

		try 
		{
			con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM breedList WHERE breedName=?;";
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