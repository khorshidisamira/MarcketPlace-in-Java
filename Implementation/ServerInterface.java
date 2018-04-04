// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote { 

	 @RequiresRole("administrator")
	 public String showAdminIsAuthenticated(SessionController session) throws RemoteException;

	 @RequiresRole("customer")
	 public String showCustomerIsAuthenticated(SessionController session) throws RemoteException;

	 public SessionController processLogin(String username, String password, String userType) throws RemoteException;

	
	
	/*
	 * Administrator functions with User starts
	 */

	@RequiresRole("administrator")
	public CustomerController createCustomer(SessionController session, String username, String password) throws RemoteException;

	@RequiresRole("administrator")
	public AdministratorController createAdministrator(SessionController session, String username, String password) throws RemoteException;

	@RequiresRole("administrator")
	public void removeCustomer(SessionController session, AdministratorController admin, int customerIndex) throws RemoteException;

	@RequiresRole("administrator")
	public void removeAdministrator(SessionController session, AdministratorController admin, int adminIndex) throws RemoteException;

	/*
	 * User functions
	 */
	@RequiresRole("administrator")
	public void logoutAdmin(SessionController session) throws RemoteException;

	@RequiresRole("customer")
	public void logoutCustomer(SessionController session) throws RemoteException;

	@RequiresRole("customer")
	public void updateCustomer(SessionController session, int customerIndex, String newPassword) throws RemoteException;

	@RequiresRole("administrator")
	public void updateAdmin(SessionController session, int adminIndex, String newPassword) throws RemoteException;

	/*
	 * Client specific functionalities with products
	 */
	 
	@RequiresRole("customer")
	public String showProductList(SessionController session) throws RemoteException;

	@RequiresRole("customer")
	public ProductController selectProduct(SessionController session, int productIndex) throws RemoteException;

	@RequiresRole("customer")
	public String showProductDetails(SessionController session, int productIndex) throws RemoteException;

	/*
	 * Admin specific functionalities with products
	 */
	@RequiresRole("administrator")
	public String addProduct(SessionController session, String name, float price, String description, int quantity)
			throws RemoteException;

	@RequiresRole("administrator")
	public void removeProduct(SessionController session, int productIndex) throws RemoteException;

	@RequiresRole("administrator")
	public void updateProduct(SessionController session, int productIndex, String newName, double newPrice, String newDescription, int newQuantity)
			throws RemoteException;
	/*
	 * Cart functions
	 */

	@RequiresRole("customer")
	public String addToCart(SessionController session, int productIndex, int quantity) throws RemoteException;

	@RequiresRole("customer")
	public void showCartDetails(SessionController session, int cartIndex) throws RemoteException;

	@RequiresRole("customer")
	public void checkoutCart(SessionController session, CartController cart) throws RemoteException;
	
	public void concurrencyTest() throws RemoteException;
	
	public void concurrencyTestSync() throws RemoteException ;

}