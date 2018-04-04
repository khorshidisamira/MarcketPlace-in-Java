// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
public interface ProductInterface {  
	
	/**
	 * @return name of the product
	 */
	public String showProductList();
	
	/**
	 * @return name of the product
	 */
	public String getName();

	/**
	 * Responsible for returning details of a product
	 * 
	 * @return String format of product details
	 */
	public String getDetails();

	/**
	 * Responsible for updating a product
	 * 
	 * @param newName
	 * @param newPrice
	 * @param newDescription
	 * @param newQuantity
	 */
	public String updateDetails(String newName, double newPrice, String newDescription, int newQuantity);

	/**
	 * Responsible for creating new product
	 * 
	 * @param newModel
	 * @return string
	 */
	public String addProduct(String name, float price, String description, int quantity);

	
	/**
	 * Responsible for purchasing a product
	 * 
	 * @return a string
	 */
	public String addToCart(String user, int productId, int quantity);
	
	
	/**
	 * Responsible for removing product
	 * 
	 * @param
	 */
	public String deactivate();
}