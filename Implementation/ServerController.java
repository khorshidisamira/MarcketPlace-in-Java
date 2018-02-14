// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ServerController {
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
	
	/*
	 * Administrator functions with User starts
	 */

	public CustomerController createCustomer(String username, String password) {

		UserModel customerModel = new UserModel(username, password, "customer");

		return new CustomerController(customerModel);
	}

	public AdministratorController createAdministrator(String username, String password) {

		UserModel adminModel = new UserModel(username, password, "customer");

		return new AdministratorController(adminModel);
	}
	
	public void removeCustomer(AdministratorController admin, int customerIndex) {
		System.out.println("remove Customer");
		CustomerController customerObj = customerList.get(customerIndex);
		admin.removeCustomer(customerObj);
		this.customerList.remove(customerIndex);
	}

	public void removeAdministrator(AdministratorController admin, int adminIndex) {
		System.out.println("remove Admin user");
		AdministratorController adminObj = adminList.get(adminIndex);
		admin.removeAdmin(adminObj);
		this.adminList.remove(adminIndex);
	}

	/*
	 * User functions
	 */
	public String loginAdmin(String username, String password) { 
		System.out.println("Admin Login");
		
		factory = new AdministratorFactory(username, password);				
		app = new Application(factory); 
		
		LoginUser loginUserOrder = new LoginUser(app);
		//SellStock sellStockOrder = new SellStock(abcStock);

		Invoker invoker = new Invoker();
		invoker.takeOrder(loginUserOrder);
		//broker.takeOrder(sellStockOrder);

		invoker.placeOrders(); 
					
		return "logged in";
	}
	public String loginCustomer(String username, String password) {
		System.out.println("Customer Login");
		factory = new CustomerFactory(username, password);				
		app = new Application(factory); 
		
		LoginUser loginUserOrder = new LoginUser(app);
		//SellStock sellStockOrder = new SellStock(abcStock);

		Invoker invoker = new Invoker();
		invoker.takeOrder(loginUserOrder);
		//broker.takeOrder(sellStockOrder);

		invoker.placeOrders(); 
		return "logged in";
	}
	
	public void logoutAdmin(/*AdministratorController admin*/) {
		System.out.println("Admin logout");
		
		//admin.logout();
	}
	public void logoutCustomer(/*CustomerController customer*/) {
		System.out.println("Customer logout");
		//customer.logout();
	}
	
	public void updateCustomer(int customerIndex, String newPassword) {
		System.out.println("update Customer");
		CustomerController selectedCustomer = this.customerList.get(customerIndex);
		
		selectedCustomer.updateProfile(newPassword);
		this.customerList.set(customerIndex, selectedCustomer);
	}
	
	public void updateAdmin(int adminIndex, String newPassword) {
		System.out.println("update Customer");
		AdministratorController selectedAdmin = this.adminList.get(adminIndex);
		
		selectedAdmin.updateProfile(newPassword);
		this.adminList.set(adminIndex, selectedAdmin);
	}
	
	/*
	 * Client specific functionalities with products
	 */
	public void showProductList() {
		System.out.println("Here is all our products");
		for (int i = 0; i < this.productList.size(); i++) {
			System.out.printf("%d\t%s\n", i + 1, this.productList.get(i).getName());

		}
	}

	public String selectProduct(int productIndex) {
		System.out.println("Select Product");
		ProductController selectedProduct = this.productList.get(productIndex);
		return selectedProduct.getName();
	}

	public String showProductDetails(int productIndex) {
		System.out.println("Show Product Details");

		ProductController selectedProduct;
		selectedProduct = this.productList.get(productIndex);
		return selectedProduct.getDetails();
	}

	/*
	 * Admin specific functionalities with products
	 */
	public ProductController addProduct(String name, double price, String description, int quantity)
			throws RemoteException {
		System.out.println("Add Product");

		ProductModel productModel = new ProductModel(name, price, description, quantity);
		ProductController productObject = new ProductController(productModel);
		this.productList.add(productObject);
		return productObject;
	}

	public void removeProduct(int productIndex) {
		System.out.println("remove Product");
		ProductController productObj = productList.get(productIndex);
		productObj.deactivate();
		this.productList.remove(productIndex);
	}

	public  void updateProduct(int productIndex, String newName, double newPrice, String newDescription,
			int newQuantity) {
		System.out.println("update Product");
		ProductController selectedProduct = this.productList.get(productIndex);
		selectedProduct.updateDetails(newName, newPrice, newDescription, newQuantity);
		this.productList.set(productIndex, selectedProduct);
	}
	/*
	 * Cart functions
	 */

	public void addToCart(String username, int productIndex, int quantity) {
		
		System.out.println("Add to Cart");
	}

	public void showCartDetails(int cartIndex) { 
		System.out.println("Show Cart Details");
	}
	
	public void checkoutCart(CartController cart) {
		System.out.println("Checkout Cart");
		cart.checkoutCart();
	}
    
}
