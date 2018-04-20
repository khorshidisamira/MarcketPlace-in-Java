// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

import java.net.MalformedURLException;
import java.rmi.Naming;

import java.lang.reflect.Proxy;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
 
public class MarketPlaceServer extends UnicastRemoteObject implements ServerInterface {

	private ServerController server;

	public MarketPlaceServer() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		
		this.server = new ServerController();
		
		/*
		try {
			LocateRegistry.getRegistry(1099).list();
		} catch (RemoteException e) {
			LocateRegistry.createRegistry(1099);
		}
		Naming.rebind("rmi://localhost:1099/market", this);
		*/
	}

	/*
	 * Administrator functions with User starts
	 */

	public synchronized String createCustomer(SessionController session, String username, String password) throws RemoteException {

	System.out.println("Creating new customer..." + username + password);
					
		return server.createCustomer(username, password);
	}

	public synchronized String createAdministrator(SessionController session, String username, String password)
			throws RemoteException {

		return server.createAdministrator(username, password);
	}

	/*
	 * User functions
	 */
	public synchronized void logoutAdmin(SessionController session) throws RemoteException {
		server.logoutAdmin(session);
	}

	public synchronized void logoutCustomer(SessionController session) throws RemoteException {
		server.logoutCustomer(session);
	}

	public synchronized void updateCustomer(SessionController session, int customerIndex, String newPassword) throws RemoteException {
		server.updateCustomer(session, customerIndex, newPassword);
	}

	public synchronized void updateAdmin(SessionController session, int adminIndex, String newPassword) throws RemoteException {
		server.updateAdmin(session, adminIndex, newPassword);
	}

	/*
	 * Client specific functionalities with products
	 */
	public synchronized String showProductList(SessionController session) throws RemoteException {
		return server.showProductList(session);
	}

	public synchronized String selectProduct(SessionController session, int productIndex) throws RemoteException {
		return server.selectProduct(session, productIndex);
	}

	public synchronized String showProductDetails(SessionController session, int productIndex) throws RemoteException {
		return server.showProductDetails(session, productIndex);
	}

	/*
	 * Admin specific functionalities with products
	 */
	public String addProduct(SessionController session, String name, float price, String description, int quantity) 
			throws RemoteException {

		return server.addProduct(session, name, price, description, quantity);
	}

	public synchronized String removeProduct(SessionController session, int productIndex) throws RemoteException {

		return server.removeProduct(session, productIndex);
	}

	public synchronized String updateProduct(SessionController session, int productIndex, String newName, float newPrice, String newDescription,
			int newQuantity) throws RemoteException {
		return server.updateProduct(session, productIndex, newName, newPrice, newDescription, newQuantity);
	}
	/*
	 * Cart functions
	 */

	public synchronized String addToCart(SessionController session, int productIndex, int quantity) throws RemoteException {
		return server.addToCart(session, productIndex, quantity);
	}

	public synchronized void showCartDetails(SessionController session, int cartIndex) throws RemoteException {
		System.out.println("Show Cart Details");
		server.showCartDetails(session, cartIndex);
	}

	public String showCustomerIsAuthenticated(SessionController session) throws RemoteException {
		return "Customer is Authenticated!!!";		
	}
	
	public String showAdminIsAuthenticated(SessionController session) throws RemoteException  {
		return "Administrator is Authenticated!!!";		
	}
	
	public SessionController processLogin(String username, String password, String userType) throws RemoteException {
		
		return server.processLogin(username, password, userType);
	}
	
	public void concurrencyTest() throws RemoteException {
		try{
			server.concurrencyTest(RemoteServer.getClientHost());
		
		} catch(Exception e){
		System.out.println("Exception is :" + e.getMessage());
			
		}
	}
	public synchronized void concurrencyTestSync() throws RemoteException {
		try{
		server.concurrencyTestSync(RemoteServer.getClientHost());
		} catch(Exception e){
		System.out.println("Exception is :" + e.getMessage());
			
		}
	}

	public static void main(String[] args) throws NotBoundException {
		
		// Set the RMI Security Manager...
		System.setSecurityManager(new SecurityManager());
		
		try {
			System.out.println("Creating a Server!");
			
			// Location of Server
			String name = "rmi://in-csci-rrpc01.cs.iupui.edu:60000/market";
			
			System.out.println("Server: Binding it to name: " + name);
			
			ServerInterface rmiServer = (ServerInterface) Proxy.newProxyInstance(ServerInterface.class.getClassLoader(),
	                new Class<?>[] {ServerInterface.class},
	                new AuthorizationInvocationHandler(new MarketPlaceServer()));
						
			// Binds the Server to the RMI Service.
			Naming.rebind(name, rmiServer);
			
			System.out.println("Market is Ready!");
		} catch (Exception e){
			System.out.println("Server Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}