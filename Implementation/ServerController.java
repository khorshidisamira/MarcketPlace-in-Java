// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.io.Serializable;

// Ryan: Why would a Controller need to be serialized?
public class ServerController implements Serializable{
	private ArrayList<CustomerController> customerList = new ArrayList<>();// Holds all customers 
	private ArrayList<AdministratorController> adminList = new ArrayList<>();// Holds all Admins 
	private ArrayList<ProductController> productList = new ArrayList<>(); // Holds system's products
	private ArrayList<CartController> cartList = new ArrayList<>(); // Holds system's carts per user
	private Application app;
    private GUIFactory factory;
		
	public ServerController() {
		// initialize Systems's Products
				String[] names = new String[5];
				String[] descriptions = new String[5];
				names[0] = "Shoe";
				names[1] = "TV";
				names[2] = "Cellphone";
				names[3] = "Shoe 2";
				names[4] = "Shoe 3";

				descriptions[0] = "Red Shoe";
				descriptions[1] = "Smart TV";
				descriptions[2] = "Iphone Cellphone";
				descriptions[3] = "Pink Shoe 2";
				descriptions[4] = "Blue Shoe 3";

				for (int i = 0; i < 5; i++) {
					ProductModel product = new ProductModel(names[i], 12.99, descriptions[i], 3);
					this.productList.add(new ProductController(product));
				}

				// initialize System's Users
				UserModel adminUser = new UserModel("root", "root", "admin");
				UserModel customer = new UserModel("customer", "customer", "customer");
				this.adminList.add(new AdministratorController(adminUser));
				this.customerList.add(new CustomerController(customer));

				// initialize User's Cart
				CartModel customerCart = new CartModel("customer");
				this.cartList.add(new CartController(customerCart));
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
		//SellStock sellStockOrder = new SellStock(abcStock);

		Invoker invoker = new Invoker();
		invoker.takeOrder(loginUserOrder);

		invoker.placeOrders(); 
		
		SessionController session = new SessionController(userType);
		return session;
	} 
	
	/*
	 * Administrator functions with User starts
	 */

	public CustomerController createCustomer(SessionController session, String username, String password) {

		UserModel customerModel = new UserModel(username, password, "customer");

		return new CustomerController(customerModel);
	}

	public AdministratorController createAdministrator(SessionController session, String username, String password) {

		UserModel adminModel = new UserModel(username, password, "customer");

		return new AdministratorController(adminModel);
	}
	
	public void removeCustomer(SessionController session, AdministratorController admin, int customerIndex) {
		System.out.println("remove Customer");
		CustomerController customerObj = customerList.get(customerIndex);
		admin.removeCustomer(customerObj);
		this.customerList.remove(customerIndex);
	}

	public void removeAdministrator(SessionController session, AdministratorController admin, int adminIndex) {
		System.out.println("remove Admin user");
		AdministratorController adminObj = adminList.get(adminIndex);
		admin.removeAdmin(adminObj);
		this.adminList.remove(adminIndex);
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
		CustomerController selectedCustomer = this.customerList.get(customerIndex);
		
		selectedCustomer.updateProfile(newPassword);
		this.customerList.set(customerIndex, selectedCustomer);
	}
	
	public void updateAdmin(SessionController session, int adminIndex, String newPassword) {
		System.out.println("update Customer");
		AdministratorController selectedAdmin = this.adminList.get(adminIndex);
		
		selectedAdmin.updateProfile(newPassword);
		this.adminList.set(adminIndex, selectedAdmin);
	}
	
	/*
	 * Client specific functionalities with products
	 */
	public String showProductList(SessionController session) {
		StringBuilder str = new StringBuilder();
		str.append("");
	
		for (int i = 0; i < this.productList.size(); i++) {
			str.append(i+1);
			str.append(" ");
			str.append(this.productList.get(i).getName());
			str.append("\n");
		}
		
		return str.toString();
	}

	public String selectProduct(SessionController session, int productIndex) {
		System.out.println("Select Product");
		ProductController selectedProduct = this.productList.get(productIndex);
		return selectedProduct.getName();
	}

	public String showProductDetails(SessionController session, int productIndex) {
		System.out.println("Show Product Details");

		ProductController selectedProduct;
		selectedProduct = this.productList.get(productIndex);
		return selectedProduct.getDetails();
	}

	/*
	 * Admin specific functionalities with products
	 */
	public ProductController addProduct(SessionController session, String name, double price, String description, int quantity)
			throws RemoteException {
		System.out.println("Add Product");

		ProductModel productModel = new ProductModel(name, price, description, quantity);
		ProductController productObject = new ProductController(productModel);
		this.productList.add(productObject);
		return productObject;
	}

	public void removeProduct(SessionController session, int productIndex) {
		System.out.println("remove Product");
		ProductController productObj = productList.get(productIndex);
		productObj.deactivate();
		this.productList.remove(productIndex);
	}

	public  void updateProduct(SessionController session, int productIndex, String newName, double newPrice, String newDescription,
			int newQuantity) {
		System.out.println("update Product");
		ProductController selectedProduct = this.productList.get(productIndex);
		selectedProduct.updateDetails(newName, newPrice, newDescription, newQuantity);
		this.productList.set(productIndex, selectedProduct);
	}
	/*
	 * Cart functions
	 */

	public void addToCart(SessionController session, String username, int productIndex, int quantity) {
		
		System.out.println("Add to Cart");
	}

	public void showCartDetails(SessionController session, int cartIndex) { 
		System.out.println("Show Cart Details");
	}
	
	public void checkoutCart(SessionController session, CartController cart) {
		System.out.println("Checkout Cart");
		cart.checkoutCart();
	}
    
}
