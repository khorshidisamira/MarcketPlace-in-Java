// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class MarketPlaceServer extends UnicastRemoteObject implements ServerInterface {

	private ServerController server;

	public MarketPlaceServer() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		this.server = new ServerController();
		try {
			LocateRegistry.getRegistry(1099).list();
		} catch (RemoteException e) {
			LocateRegistry.createRegistry(1099);
		}
		Naming.rebind("rmi://localhost:1099/market", this);
	}

	/*
	 * Administrator functions with User starts
	 */

	public synchronized CustomerController createCustomer(String username, String password) throws RemoteException {

		return server.createCustomer(username, password);
	}

	public synchronized AdministratorController createAdministrator(String username, String password)
			throws RemoteException {

		return server.createAdministrator(username, password);
	}

	public synchronized void removeCustomer(AdministratorController admin, int customerIndex) throws RemoteException {
		server.removeCustomer(admin, customerIndex);
	}

	public synchronized void removeAdministrator(AdministratorController admin, int adminIndex) throws RemoteException {
		server.removeAdministrator(admin, adminIndex);
	}

	/*
	 * User functions
	 */
	public synchronized String loginAdmin(String username, String password) throws RemoteException {
		return server.loginAdmin(username, password);
	}

	public synchronized String loginCustomer(String username, String password) throws RemoteException {
		return server.loginCustomer(username, password);
	}

	public synchronized void logoutAdmin() throws RemoteException {
		server.logoutAdmin();
	}

	public synchronized void logoutCustomer() throws RemoteException {
		server.logoutCustomer();
	}

	public synchronized void updateCustomer(int customerIndex, String newPassword) throws RemoteException {
		server.updateCustomer(customerIndex, newPassword);
	}

	public synchronized void updateAdmin(int adminIndex, String newPassword) throws RemoteException {
		server.updateAdmin(adminIndex, newPassword);
	}

	/*
	 * Client specific functionalities with products
	 */
	public synchronized void showProductList() throws RemoteException {
		server.showProductList();
	}

	public synchronized String selectProduct(int productIndex) throws RemoteException {
		return server.selectProduct(productIndex);
	}

	public synchronized String showProductDetails(int productIndex) throws RemoteException {
		return server.showProductDetails(productIndex);
	}

	/*
	 * Admin specific functionalities with products
	 */
	public synchronized ProductController addProduct(String name, double price, String description, int quantity)
			throws RemoteException {

		return server.addProduct(name, price, description, quantity);
	}

	public synchronized void removeProduct(int productIndex) throws RemoteException {

		server.removeProduct(productIndex);
	}

	public synchronized void updateProduct(int productIndex, String newName, double newPrice, String newDescription,
			int newQuantity) throws RemoteException {

		server.updateProduct(productIndex, newName, newPrice, newDescription, newQuantity);
	}
	/*
	 * Cart functions
	 */

	public synchronized void addToCart(String username, int productIndex, int quantity) throws RemoteException {
		server.addToCart(username, productIndex, quantity);
	}

	public synchronized void showCartDetails(int cartIndex) throws RemoteException {
		System.out.println("Show Cart Details");
		server.showCartDetails(cartIndex);
	}

	public synchronized void checkoutCart(CartController cart) throws RemoteException {
		System.out.println("Checkout Cart");
		server.checkoutCart(cart);
	}

	public static void main(String[] args) throws NotBoundException {
		try {
			new MarketPlaceServer();
			System.out.println("Market is ready!");
		} catch (RemoteException re) {
			System.out.println(re);
			System.exit(1);
		} catch (MalformedURLException me) {
			System.out.println(me);
			System.exit(1);
		}
	}

}