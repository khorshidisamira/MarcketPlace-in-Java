/**
 * All products families have the same varieties (Administrator/Customer).
 * 
 * This is another variant of a checkbox.
 */
public class CustomerUser implements UserInterface {

    private UserModel model;

	// Model-View Glue
	public CustomerUser(String username, String password) {
		//this.model = newModel;
		this.model = new UserModel(username,password, "customer");
	}

	@Override
	public UserModel getUser() {
		return model;
	}

	@Override
	public void setInfo(String username, String password) {
		model.username = username;
		model.password = password;
	}
	/**
	 * Responsible for login user
	 * 
	 * @return user's type: admin or customer
	 */
	@Override 
	public String login() {
		model.setLoginStatus(true);
		return model.getType();
	}

	/**
	 * Responsible for logout the User
	 * 
	 * @return Success message
	 */
	@Override
	public String logout() {
		model.setLoginStatus(false);
		return "Logout successfully";
	}

	@Override
	public String deactivateAccount() {
		return null;
	}

	/**
	 * Responsible for updating user profile
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public String updateProfile(String newPassword) {
		
		return "profile updated Successfully!";
	}

	/**
	 * Responsible for checking accessRight of user, resource is a action like
	 * addProduct
	 * 
	 * @param user
	 * @param right
	 * @return accessRight
	 */
	@Override
	public boolean hasAccess(UserModel user, String right, String resource) {
		boolean access = true;
		return access;
	}
	
	public void addAdmin(UserModel newModel){}

	/**
	 * Responsible for removing Administrator account
	 * 
	 * @param administrator
	 */
	public void removeAdmin(AdministratorController administrator){}

	/**
	 * Responsible for creating new Customer account
	 * 
	 * @param newModel
	 * @return Customer' User
	 */
	public void addCustomer(UserModel newModel){
		
	}

	/**
	 * Deactivate customer account
	 * 
	 * @param customer
	 */
	public void removeCustomer(CustomerController customer){
		
	}
}