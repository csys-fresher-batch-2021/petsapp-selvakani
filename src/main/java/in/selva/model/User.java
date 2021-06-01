package in.selva.model;

public class User 
{
    private String name;
    private String email;
    private Long mobile;
    private String address;
    private String password;
    
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public Long getMobile() 
	{
		return mobile;
	}
	
	public void setMobile(Long mobile)
	{
		this.mobile = mobile;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	@Override
	public String toString() 
	{
		return "User [name=" + name + ", email=" + email + ", mobile=" + mobile + ", address=" + address + ","
				+ " password=" + password + "]";
	}
	
	public User(String name2, String email2, Long mobile2, String address2, String password2) 
	{
		this.name = name2;
		this.email = email2;
		this.mobile = mobile2;
		this.address = address2;
		this.password = password2;
	}
}
