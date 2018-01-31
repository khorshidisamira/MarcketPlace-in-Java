package onlineMarket;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
	/*
	 * Administrator functions with User starts
	 */

	public CustomerController createCustomer(String username, String password) throws RemoteException;

	public AdministratorController createAdministrator(String username, String password) throws RemoteException;

	public void removeCustomer(AdministratorController admin, int customerIndex) throws RemoteException;

	public void removeAdministrator(AdministratorController admin, int adminIndex) throws RemoteException;

	/*
	 * User functions
	 */
	public void loginAdmin(AdministratorController admin) throws RemoteException;

	public void loginCustomer(CustomerController customer) throws RemoteException;

	public void logoutAdmin(AdministratorController admin) throws RemoteException;

	public void logoutCustomer(CustomerController customer) throws RemoteException;

	public void updateCustomer(int customerIndex, String newPassword) throws RemoteException;

	public void updateAdmin(int adminIndex, String newPassword) throws RemoteException;

	/*
	 * Client specific functionalities with products
	 */
	public void showProductList() throws RemoteException;

	public String selectProduct(int productIndex) throws RemoteException;

	public String showProductDetails(int productIndex) throws RemoteException;

	/*
	 * Admin specific functionalities with products
	 */
	public ProductController addProduct(String name, double price, String description, int quantity)
			throws RemoteException;

	public void removeProduct(int productIndex) throws RemoteException;

	public void updateProduct(int productIndex, String newName, double newPrice, String newDescription, int newQuantity)
			throws RemoteException;
	/*
	 * Cart functions
	 */

	public void addToCart(String username, int productIndex, int quantity) throws RemoteException;

	public void showCartDetails(int cartIndex) throws RemoteException;

	public void checkoutCart(CartController cart) throws RemoteException;

}