// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
/**
 * All products families have the same varieties (Administrator/Customer).
 *
 */
public class AdministratorProduct implements ProductInterface { 

	private ProductModel model = new ProductModel();
	// private ArrayList<ProductModel> productList = new ArrayList<>(); //Holds
	// system's products

	/**
	* @return list of products
	*/
	@Override
	public String showProductList(){
		return model.showProductList();
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
	 * @return name of the product
	 */
	@Override 
	public String getName() {
		return model.getName();
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
		return model.updateProduct(productIndex, newName, newPrice, newDescription, newQuantity);
	}
	/**
	 * Responsible for creating new product
	 * 
	 * @param newModel
	 * @return product object
	 */
	@Override
	public String addProduct(String name, float price, String description, int quantity) {
		String state = model.addProduct(name, price, description, quantity);
		return state;
	}

	/**
	 * Responsible for purchasing a product
	 * 
	 * @param newModel
	 * @return a string
	 */
	@Override
	public String addToCart(String user, int productId, int quantity){
		return null;
	}
	
	
	/**
	 * Responsible for removing product
	 * 
	 * @param
	 */
	@Override
	public String deactivate(int productId) {
		String removeStatus = model.deactivate(productId);
		return removeStatus;
	}
}