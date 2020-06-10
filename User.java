
package control;
/**
 * 
 * @author Sara Ibrahim
 *
 */
public class User {
	protected String name;
	protected int id;
	protected String email;
	protected String password;
	protected String phone;
	protected String location;
	public void editUserInfo() {}
	/**
	 * default constructor
	 */
	public User() {}
	//parameterized constructor for user 
	/**
	 * Parameterized Constructor
	 * @param name
	 * @param id
	 * @param email
	 * @param password
	 * @param phone
	 * @param location
	 */
	public User(String name,int id,String email,String password,String phone,String location) {
		this.name=name;
		this.id=id;
		this.password=password;
		this.email=email;
		this.phone=phone;
		this.location=location;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * 
	 * @param id
	 */
	public void setID(int id) {
		this.id=id;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password=password;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email=email;
	}
	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone=phone;
	}
	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location=location;
	}
	/**
	 * 
	 * @return string representing user's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return an integer representing user's id
	 */
	public int getID() {
		return id;
	}
	/**
	 * 
	 * @return a string representing user's password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @return a string representing user's email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @return string representing user's phone number
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 
	 * @return string representing user's location
	 */
	public String getLocation() {
		return location;
	}

}

