package in.selva.model;
import java.time.LocalDate;


public class Order {

	/**
	 * Declaring Required Variables.
	 */
	
    private int id;
   

	private int userId;
	private String userName;
	private String breedName;
	private int count;
	private double cost;
	
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private String status;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBreedName() {
		return breedName;
	}

	public int getCount() {
		return count;
	}

	public double getCost() {
		return cost;
	}

	public Order(String breedName, int count, double cost) {
		super();
		this.breedName = breedName;
		this.count = count;
		this.cost = cost;
	}



	public Order(int id,int userId,String breedname2, int count2, double cost2, String status) {
		
		this.userId = userId;
		this.id = id;
		this.breedName = breedname2;
		this.count = count2;
		this.cost = cost2;
		this.status = status;
	
		
	}

	public Order(int id2, String breedname2, int count2, double cost2, String status2) {
		super();
		
		this.id = id2;
		this.breedName = breedname2;
		this.count = count2;
		this.cost = cost2;
		this.status = status2;
	}
	
	 public Order(int id, int userId, String userName, String breedName, int count, double cost,
				LocalDate orderDate, LocalDate deliveryDate, String status) {
			super();
			this.id = id;
			this.userId = userId;
			this.userName = userName;
			this.breedName = breedName;
			this.count = count;
			this.cost = cost;
			this.orderDate = orderDate;
			this.deliveryDate = deliveryDate;
			this.status = status;
		}

	@Override
	public String toString() {
		return "Order [Id : " + id + ", UserId : " + userId + ", UserName : " + userName + ", BreedName : " + breedName
				+  ", Count : " + count + ", Cost : " + cost + ", OrderDate : " + orderDate
				+ ", DeliveryDate : " + deliveryDate + ", Status : " + status + "]";
	}

	
	

}