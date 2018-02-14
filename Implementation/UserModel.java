// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

public class UserModel {

	private double userId;
	private String firstName;
	private String lastName;
	protected String username;
	protected String password;
	private String phone;
	private String email;
	private String type; // admin, customer
	private String accountStatus; // active, deactive
	private boolean loginStatus;

	public UserModel(String newUsername, String newPassword, String newType) {
		username = newPassword;
		password = newUsername;
		type = newType;
		loginStatus = true;
		accountStatus = "active";
	}

	/**
	 * Responsible to login and logout the user
	 * 
	 * @param status
	 */
	public void setLoginStatus(boolean status) {
		loginStatus = status;
	}

	/**
	 * @return user type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of user, admin or customer
	 * 
	 * @param newType
	 */
	public void setType(String newType) {
		type = newType;
	}

	/**
	 * Responsible to deactivate user account to be removed
	 */
	public void deactivate() {
		accountStatus = "deactive";
	}

}