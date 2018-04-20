// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

/**
 * All products families have the same varieties (Administrator/Customer).
 */
 
//import java.io.Serializable;
import java.sql.ResultSet;

public class CustomerProduct  implements ProductInterface { 

	private ProductModel model = new ProductModel();
	private databaseManager dbManager = new databaseManager();
	// private ArrayList<ProductModel> productList = new ArrayList<>(); //Holds
	// system's products
 

	/**
	* @return list of products
	*/
	@Override
	public String showProductList(){
		System.out.println("customeeeers");
		String products = model.showProductList();
		return products;
	}
	
	/**
	 * @return name of the product
	 */
	@Override 
	public String getName() {
		return model.getName();
	}
	
	/**
	 * Responsible for selecting a product
	 * 
	 * @param product productId
	 * @return a string
	 */
	@Override
	public String selectProduct(int productId){
		return model.selectProduct(productId);
	}

	/**
	 * Responsible for returning details of a product
	 * 
	 * @return String format of product details
	 */
	@Override 
	public String getDetails() {
		return model.getDetails();
	}

	/**
	 * Responsible for updating a product
	 * 
	 * @param newName
	 * @param newPrice
	 * @param newDescription
	 * @param newQuantity
	 */
	@Override 
	public String updateProduct(int productIndex, String newName, float newPrice, String newDescription, int newQuantity){
		return null;
	}

	
	/**
	 * Responsible for creating new product
	 * 
	 * @param newModel
	 * @return string
	 */
	public String addProduct(String name, float price, String description, int quantity){
		return null;
	}

	
	/**
	 * Responsible for purchasing a product
	 * 
	 * @param newModel
	 * @return a string
	 */
	@Override
	public String addToCart(String user, int productId, int quantity) {
		return model.addToCart(user, productId, quantity);
	}
	
	

	/**
	 * Responsible for removing product
	 * 
	 * @param
	 */
	@Override
	public String deactivate(int productId) {
		return null;
	}
}