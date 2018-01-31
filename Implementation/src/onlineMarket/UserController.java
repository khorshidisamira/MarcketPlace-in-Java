package onlineMarket;

public class UserController {
	private UserModel model;

	// Model-View Glue
	public UserController(UserModel newModel) {
		this.model = newModel;
	}

	public UserModel getUser() {
		return model;
	}

	/**
	 * Responsible for login user
	 * 
	 * @return user's type: admin or customer
	 */
	public String login() {
		model.setLoginStatus(true);
		return model.getType();
	}

	/**
	 * Responsible for logout the User
	 * 
	 * @return Success message
	 */
	public String logout() {
		model.setLoginStatus(false);
		return "Logout successfully";
	}

	public void deactivateAccount() {
		model.deactivate();
	}

	/**
	 * Responsible for updating user profile
	 * 
	 * @param user
	 * @return
	 */
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
	public boolean hasAccess(UserModel user, String right, String resource) {
		boolean access = true;
		return access;
	}

}
