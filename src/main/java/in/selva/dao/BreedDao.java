package in.selva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.selva.exception.CannotGetDetailsException;
import in.selva.exception.DBException;
import in.selva.exception.NotAbleToDeleteException;
import in.selva.model.BreedTypes;
import in.selva.util.ConnectionUtil;

public class BreedDao {
	
	
	
	private static final String BREED_NAME = "breedName";
	private static final String COUNT = "count";
	private static final String COST = "cost";
	private static final String INSERT_BREED_QUERY = "insert into breedList(breedName,count,cost) values ( ?,?,?)";
	private static final String GET_BREEDS_QUERY = "select breedName,count,cost from breedList where count>0 ORDER BY breedName";
	private static final String DELETE_BREEDS_QUERY = "DELETE FROM breedList WHERE breedName=?";
	
	/**
	 * ArrayList to store Breed Types Details.
	 */
	
	private static final List<BreedTypes> breeds = new ArrayList<>();

	/**
	 * ArrayList to store search details.
	 */
	private static final List<BreedTypes> type = new ArrayList<>();

	/**
	 * Add Breed details.
	 * 
	 * @param breedName
	 * @param count
	 * @param cost
	 */
	
	public void addBreed(String breedName, int count, double cost) {

		breeds.add(new BreedTypes(breedName, count, cost));
	}

	/**
	 * Get Breed Details.
	 * 
	 * @return
	 */
	
	public static List<BreedTypes> getBreed() {
		return breeds;
	}

	/**
	 * Add Search details.
	 * 
	 * @param breedName
	 * @param count
	 * @param cost
	 */

	public void addSearch(String breedName, int count, double cost) {

		type.add(new BreedTypes(breedName, count, cost));

	}

	/**
	 * Get Search Breed Details.
	 * 
	 * @return
	 */
	
	public static List<BreedTypes> getSearch() {
		return type;
	}

	/**
	 * Insert breed details into DataBase.
	 * 
	 * @param breed
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static void saveBreed(BreedTypes breed) throws  CannotGetDetailsException, ClassNotFoundException, DBException {
		
		// Step 1: Get connection
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = ConnectionUtil.getConnection();
		
			String sql = INSERT_BREED_QUERY;
			pst = con.prepareStatement(sql);

			pst.setString(1, breed.getBreedName());
			pst.setInt(2, breed.getCount());
			pst.setDouble(3, breed.getCost());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new CannotGetDetailsException(e.getMessage());
		} finally {
			ConnectionUtil.close(pst, con);
		}
	}

	/**
	 * Add breed details 
	 * 
	 * @param breeds
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws DBException
	 */
	
	public static void save(List<BreedTypes> breeds) throws CannotGetDetailsException, ClassNotFoundException, DBException {
		for (BreedTypes breed : breeds) 
		{
			saveBreed(breed);
		}
	}

	/**
	 * Get the breed details from Data Base.
	 * 
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws DBException 
	 * @throws Exception
	 */
	
	public static List<BreedTypes> getBreedDetails() throws CannotGetDetailsException, ClassNotFoundException, DBException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
            breeds.clear();
			String url = GET_BREEDS_QUERY;
			con = ConnectionUtil.getConnection();
			
			pst = con.prepareStatement(url);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				String breedname = rs.getString(BREED_NAME);
				int count = rs.getInt(COUNT);
				double cost = rs.getDouble(COST);
				
				breeds.add(new BreedTypes(breedname, count, cost));
			}

		} catch (SQLException e) {
			throw new CannotGetDetailsException(e.getMessage());

		} finally {
			ConnectionUtil.close(pst, con);
		}
		return breeds;
	}

	/**
	 * Delete Breed detail from Database.
	 * 
	 * @param breedName
	 * @return
	 * @throws CannotGetDetailsException
	 * @throws ClassNotFoundException
	 * @throws NotAbleToDeleteException
	 * @throws DBException
	 */
	
	public static boolean deleteBreeds(String breedName) throws CannotGetDetailsException, ClassNotFoundException, NotAbleToDeleteException, DBException {

		boolean isDelete = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();
			String sql = DELETE_BREEDS_QUERY;
			pst = con.prepareStatement(sql);
			pst.setString(1, breedName);

			int rs = pst.executeUpdate();

			if (rs == 1) {
				isDelete = true;
			} else {
				throw new NotAbleToDeleteException("Cannot Delete");
			}
		} catch (SQLException e) {
			throw new CannotGetDetailsException(e.getMessage());
		} finally {
			ConnectionUtil.close(pst, con);
		}

		return isDelete;

	}
}