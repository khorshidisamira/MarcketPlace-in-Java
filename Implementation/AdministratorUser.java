// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

/**
 * All products families have the same varieties (Administrator/Customer).
 * 
 * This is another variant of a checkbox.
 */
public class AdministratorUser implements UserInterface {

    private UserModel model;

	// Model-View Glue
	public AdministratorUser(String username, String password) {
		//this.model = newModel;
		this.model = new UserModel(username,password, "admin");
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
		//model.setLoginStatus(true);
		return "admin logged in";
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
	
	/**
	 * Responsible for creating new administrator user
	 * 
	 * @param newModel
	 * @return
	 */
	@Override
	public void addAdmin(UserModel newModel) {
		//return new AdministratorController(newModel);
	}

	/**
	 * Responsible for removing Administrator account
	 * 
	 * @param administrator
	 */
	@Override
	public void removeAdmin(AdministratorController administrator) {
		administrator.deactivateAccount();
	}

	/**
	 * Responsible for creating new Customer account
	 * 
	 * @param newModel
	 * @return Customer' User
	 */
	@Override
	public void addCustomer(UserModel newModel) {
		CustomerController customerUser = new CustomerController(newModel);
//		UserModel customerModel = getUser();
//		customerModel.setType("customer");
		//return customerUser;
	}

	/**
	 * Deactivate customer account
	 * 
	 * @param customer
	 */
	@Override
	public void removeCustomer(CustomerController customer) {
		customer.deactivateAccount();
	}
}