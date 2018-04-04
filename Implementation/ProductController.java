// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

/**
 *
 * @author Samira
 */
 
import java.io.Serializable;
public class ProductController implements Serializable{

	private ProductModel model;
	// private ArrayList<ProductModel> productList = new ArrayList<>(); //Holds
	// system's products

	// Model-View Glue
	public ProductController(ProductModel newModel) {
		model = newModel;
	}

	/**
	 * @return name of the product
	 */
	public String getName() {
		return model.getName();
	}

	/**
	 * @return quantity of the product
	 */
	public int getQuantity() {
		return model.getQuantity();
	}
	/**
	 * Responsible for returning details of a product
	 * 
	 * @return String format of product details
	 */
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
	public void updateDetails(String newName, double newPrice, String newDescription, int newQuantity) {
		model.updateDetails(newName, newPrice, newDescription, newQuantity);
	}

	/**
	 * Responsible for creating new product
	 * 
	 * @param newModel
	 * @return product object
	 */
	public void add() {
		this.model.add();
	}

	/**
	 * Responsible for removing product
	 * 
	 * @param
	 */
	public void deactivate() {
		model.deactivate();
	}

}