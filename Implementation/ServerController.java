// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.io.Serializable;

// Ryan: Why would a Controller need to be serialized?
//Fixed: because this controller has all products and users of the system which I want to make them serialized, when I use database, I will unserialize this controller

public class ServerController implements Serializable{
	private Application app;
    private GUIFactory factory;
		
	public ServerController() {
	}
	
	/* The following two methods are testing the concurrency and synchronizion*/
	
	public void concurrencyTestSync(String host){
		try{
		System.out.println(host + "synchronized concurrencyTest call....");
		
		  Thread.sleep(6000);
		System.out.println( host + "synchronized concurrencyTest finish....");	
		} catch(Exception e){
		System.out.println("Exception is :" + e.getMessage());
			
		}
	}
	
	public void concurrencyTest(String host){
		try{
			
			System.out.println( host + " concurrencyTest call....");
			
			  Thread.sleep(6000);
			
			System.out.println( host + "concurrencyTest finish....");	
		} catch(Exception e){
			System.out.println("Exception is :" + e.getMessage());
			
		}
	}
	public SessionController processLogin(String username, String password, String userType){
		if(userType.equalsIgnoreCase("customer")){
			System.out.println("Customer Login");
			factory = new CustomerFactory(username, password);		
		} else {
			System.out.println("Admin Login");
			factory = new AdministratorFactory(username, password);	
		}
				
		app = new Application(factory); 
		
		LoginUser loginUserOrder = new LoginUser(app);

		Invoker invoker = new Invoker();
		invoker.takeOrder(loginUserOrder);

		invoker.placeOrders(); 
		
		SessionController session = new SessionController(username, password, userType);
		if(app.getLoginStatus()){
			return session;
		}else {
			return null;
		}
	} 
	
	/*
	 * Administrator functions with User starts
	 */

	public String createCustomer(String username, String password) {
		
		System.out.println("Add Product");
		return app.addCustomer(username,password);
	}

	public String createAdministrator(String username, String password) {
		
		System.out.println("Add Product");
		return app.addAdmin(username,password);
	}

	/*
	 * User functions
	 */
	
	public void logoutAdmin(SessionController session/*AdministratorController admin*/) {
		System.out.println("Admin logout");
		
		//admin.logout();
	}
	public void logoutCustomer(SessionController session/*CustomerController customer*/) {
		System.out.println("Customer logout");
		//customer.logout();
	}
	
	public void updateCustomer(SessionController session, int customerIndex, String newPassword) {
		System.out.println("update Customer");
	}
	
	public void updateAdmin(SessionController session, int adminIndex, String newPassword) {
		System.out.println("update Customer");
	}
	
	/*
	 * Client specific functionalities with products
	 */
	public String showProductList(SessionController session) {
		String list = app.showProductList();
		return list;
	}

	public String selectProduct(SessionController session, int productIndex) {
		
		System.out.println("Select Product");
		return app.selectProduct(productIndex);
	}

	public String showProductDetails(SessionController session, int productIndex) {
		return "Show Product Details";
	}

	/*
	 * Admin specific functionalities with products
	 */
	public String addProduct(SessionController session, String name, float price, String description, int quantity)
			throws RemoteException {
			String addState = null;
		try{
			System.out.println("Add Product");
			addState = app.addProduct(name, price, description, quantity);
			
		}catch(Exception e){
			System.out.println("Exception is :" + e.getMessage());
		}
		return addState;
	
	}

	public String removeProduct(SessionController session, int productIndex) {
		System.out.println("remove Product");
		return app.removeProduct(productIndex);
	}

	public String updateProduct(SessionController session, int productIndex, String newName, float newPrice, String newDescription,
			int newQuantity) {
		System.out.println("update Product");
		return app.updateProduct(productIndex, newName, newPrice, newDescription, newQuantity);
	}
	/*
	 * Cart functions
	 */

	public String addToCart(SessionController session, int productIndex, int quantity) {
		
		System.out.println("Add Product to cart");
		String user = session.getUsername();
		return app.addToCart(user, productIndex, quantity);
	}

	public void showCartDetails(SessionController session, int cartIndex) { 
		System.out.println("Show Cart Details");
	}
	
    
}
