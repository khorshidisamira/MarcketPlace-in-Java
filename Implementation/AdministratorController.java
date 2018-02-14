// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

public class AdministratorController extends UserController {
	static UserModel adminModel;

	public AdministratorController(UserModel newModel) {
		super(newModel);
//		adminModel = getUser();
//		adminModel.setType("admin");
	}

	/**
	 * Responsible for creating new administrator user
	 * 
	 * @param newModel
	 * @return
	 */
	public AdministratorController addAdmin(UserModel newModel) {
		return new AdministratorController(newModel);
	}

	/**
	 * Responsible for removing Administrator account
	 * 
	 * @param administrator
	 */
	public void removeAdmin(AdministratorController administrator) {
		administrator.deactivateAccount();
	}

	/**
	 * Responsible for creating new Customer account
	 * 
	 * @param newModel
	 * @return Customer' User
	 */
	public CustomerController addCustomer(UserModel newModel) {
		CustomerController customerUser = new CustomerController(newModel);
//		UserModel customerModel = getUser();
//		customerModel.setType("customer");
		return customerUser;
	}

	/**
	 * Deactivate customer account
	 * 
	 * @param customer
	 */
	public void removeCustomer(CustomerController customer) {
		customer.deactivateAccount();
	}

}
