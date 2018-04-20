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

import java.io.Serializable;
public class AdministratorUser  implements Serializable, UserInterface {

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
		String loginStatus = null;
		try{
			if(model.setLoginStatus(true))
				loginStatus = "successfull";
			
		}catch(Exception e){
			System.out.println("Database Exception:" + e.getMessage());
		}
		
		return loginStatus;
	}
	
	/**
	 * Responsible for checking login status
	 * 
	 * @return user's status
	 */
	@Override 
	public boolean getLoginStatus() { 
		return model.getLoginStatus();
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
	 * Responsible for creating new Customer account
	 * 
	 * @param username, password
	 * @return Customer' User
	 */
	@Override
	public String addCustomer(String username, String password) {
		return model.addUser(username, password, "customer");
	}

	/**
	 * Responsible for creating new Admin account
	 * 
	 * @param username, password
	 * @return Admin' User
	 */
	@Override
	public String addAdmin(String username, String password) {
		String addStatus = model.addUser(username, password, "administrator");
		return addStatus;
	}
}