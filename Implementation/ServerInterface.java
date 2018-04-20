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
	public String createCustomer(SessionController session, String username, String password) throws RemoteException;

	@RequiresRole("administrator")
	public String createAdministrator(SessionController session, String username, String password) throws RemoteException;
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
	public String showProductList(SessionController session) throws RemoteException;

	@RequiresRole("customer")
	public String selectProduct(SessionController session, int productIndex) throws RemoteException;

	@RequiresRole("customer")
	public String showProductDetails(SessionController session, int productIndex) throws RemoteException;

	/*
	 * Admin specific functionalities with products
	 */
	@RequiresRole("administrator")
	public String addProduct(SessionController session, String name, float price, String description, int quantity)
			throws RemoteException;

	@RequiresRole("administrator")
	public String removeProduct(SessionController session, int productIndex) throws RemoteException;

	@RequiresRole("administrator")
	public String updateProduct(SessionController session, int productIndex, String newName, float newPrice, String newDescription, int newQuantity)
			throws RemoteException;
	/*
	 * Cart functions
	 */

	@RequiresRole("customer")
	public String addToCart(SessionController session, int productIndex, int quantity) throws RemoteException;

	@RequiresRole("customer")
	public void showCartDetails(SessionController session, int cartIndex) throws RemoteException;
	
	public void concurrencyTest() throws RemoteException;
	
	public void concurrencyTestSync() throws RemoteException ;

}