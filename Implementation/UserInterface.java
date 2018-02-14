// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

public interface UserInterface {
	
	public abstract UserModel getUser();

	/**
	 * Responsible for login user
	 * 
	 * @return user's type: admin or customer
	 */
	public abstract String login();

	/**
	 * Responsible for logout the User
	 * 
	 * @return Success message
	 */
	public abstract String logout();

	public abstract String deactivateAccount();
	
	public abstract void setInfo(String username, String password);
	/**
	 * Responsible for updating user profile
	 * 
	 * @param user
	 * @return
	 */
	public abstract String updateProfile(String newPassword);

	/**
	 * Responsible for checking accessRight of user, resource is a action like
	 * addProduct
	 * 
	 * @param user
	 * @param right
	 * @return accessRight
	 */
	public abstract boolean hasAccess(UserModel user, String right, String resource);

	/**
	 * Responsible for creating new administrator user
	 * 
	 * @param newModel
	 * @return
	 */
	public abstract void addAdmin(UserModel newModel);

	/**
	 * Responsible for removing Administrator account
	 * 
	 * @param administrator
	 */
	public abstract void removeAdmin(AdministratorController administrator);

	/**
	 * Responsible for creating new Customer account
	 * 
	 * @param newModel
	 * @return Customer' User
	 */
	public abstract void addCustomer(UserModel newModel);

	/**
	 * Deactivate customer account
	 * 
	 * @param customer
	 */
	public abstract void removeCustomer(CustomerController customer);
}
