package onlineMarket;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MarketPlaceServer extends UnicastRemoteObject implements ServerInterface {

	private ArrayList<CustomerController> customerList = new ArrayList<>();// Holds all customers 
	private ArrayList<AdministratorController> adminList = new ArrayList<>();// Holds all Admins 
	private ArrayList<ProductController> productList = new ArrayList<>(); // Holds system's products
	private ArrayList<CartController> cartList = new ArrayList<>(); // Holds system's carts per user

	public MarketPlaceServer() throws RemoteException, MalformedURLException, NotBoundException {
		super();
		try {
			LocateRegistry.getRegistry(1099).list();
		} catch (RemoteException e) {
			LocateRegistry.createRegistry(1099);
		}
		Naming.rebind("rmi://localhost:1099/market", this);

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

	public synchronized CustomerController createCustomer(String username, String password) throws RemoteException {

		UserModel customerModel = new UserModel(username, password, "customer");

		return new CustomerController(customerModel);
	}

	public synchronized AdministratorController createAdministrator(String username, String password) throws RemoteException {

		UserModel adminModel = new UserModel(username, password, "customer");

		return new AdministratorController(adminModel);
	}
	
	public synchronized void removeCustomer(AdministratorController admin, int customerIndex) throws RemoteException {
		System.out.println("remove Customer");
		CustomerController customerObj = customerList.get(customerIndex);
		admin.removeCustomer(customerObj);
		this.customerList.remove(customerIndex);
	}

	public synchronized void removeAdministrator(AdministratorController admin, int adminIndex) throws RemoteException {
		System.out.println("remove Admin user");
		AdministratorController adminObj = adminList.get(adminIndex);
		admin.removeAdmin(adminObj);
		this.adminList.remove(adminIndex);
	}

	/*
	 * User functions
	 */
	public synchronized void loginAdmin(AdministratorController admin) throws RemoteException {
		System.out.println("Admin Login");
		
		admin.login();
	}
	public synchronized void loginCustomer(CustomerController customer) throws RemoteException {
		System.out.println("Customer Login");
		customer.login();
	}
	
	public synchronized void logoutAdmin(AdministratorController admin) throws RemoteException {
		System.out.println("Admin logout");
		
		admin.logout();
	}
	public synchronized void logoutCustomer(CustomerController customer) throws RemoteException {
		System.out.println("Customer logout");
		customer.logout();
	}
	
	public synchronized void updateCustomer(int customerIndex, String newPassword) throws RemoteException {
		System.out.println("update Customer");
		CustomerController selectedCustomer = this.customerList.get(customerIndex);
		
		selectedCustomer.updateProfile(newPassword);
		this.customerList.set(customerIndex, selectedCustomer);
	}
	
	public synchronized void updateAdmin(int adminIndex, String newPassword) throws RemoteException {
		System.out.println("update Customer");
		AdministratorController selectedAdmin = this.adminList.get(adminIndex);
		
		selectedAdmin.updateProfile(newPassword);
		this.adminList.set(adminIndex, selectedAdmin);
	}
	
	/*
	 * Client specific functionalities with products
	 */
	public synchronized void showProductList() throws RemoteException {
		System.out.println("Here is all our products");
		for (int i = 0; i < this.productList.size(); i++) {
			System.out.printf("%d\t%s\n", i + 1, this.productList.get(i).getName());

		}
	}

	public synchronized String selectProduct(int productIndex) throws RemoteException {
		System.out.println("Select Product");
		ProductController selectedProduct = this.productList.get(productIndex);
		return selectedProduct.getName();
	}

	public synchronized String showProductDetails(int productIndex) throws RemoteException {
		System.out.println("Show Product Details");

		ProductController selectedProduct;
		selectedProduct = this.productList.get(productIndex);
		return selectedProduct.getDetails();
	}

	/*
	 * Admin specific functionalities with products
	 */
	public synchronized ProductController addProduct(String name, double price, String description, int quantity)
			throws RemoteException {
		System.out.println("Add Product");

		ProductModel productModel = new ProductModel(name, price, description, quantity);
		ProductController productObject = new ProductController(productModel);
		this.productList.add(productObject);
		return productObject;
	}

	public synchronized void removeProduct(int productIndex) throws RemoteException {
		System.out.println("remove Product");
		ProductController productObj = productList.get(productIndex);
		productObj.deactivate();
		this.productList.remove(productIndex);
	}

	public synchronized void updateProduct(int productIndex, String newName, double newPrice, String newDescription,
			int newQuantity) throws RemoteException {
		System.out.println("update Product");
		ProductController selectedProduct = this.productList.get(productIndex);
		selectedProduct.updateDetails(newName, newPrice, newDescription, newQuantity);
		this.productList.set(productIndex, selectedProduct);
	}
	/*
	 * Cart functions
	 */

	public synchronized void addToCart(String username, int productIndex, int quantity) throws RemoteException {
		
		System.out.println("Add to Cart");
	}

	public synchronized void showCartDetails(int cartIndex) throws RemoteException { 
		System.out.println("Show Cart Details");
	}
	
	public synchronized void checkoutCart(CartController cart) throws RemoteException {
		System.out.println("Checkout Cart");
		cart.checkoutCart();
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