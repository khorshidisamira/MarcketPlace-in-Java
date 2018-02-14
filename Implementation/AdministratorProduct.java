/**
 * All products families have the same varieties (Administrator/Customer).
 * 
 * This is a MacOS variant of a button.
 */
public class AdministratorProduct implements ProductInterface { 

	private ProductModel model;
	// private ArrayList<ProductModel> productList = new ArrayList<>(); //Holds
	// system's products

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
	public String updateDetails(String newName, double newPrice, String newDescription, int newQuantity) {
		model.updateDetails(newName, newPrice, newDescription, newQuantity);
		return "updated";
	}

	/**
	 * Responsible for creating new product
	 * 
	 * @param newModel
	 * @return product object
	 */
	@Override
	public String addProduct(ProductModel newModel) {
		return "Add product";
	}

	/**
	 * Responsible for removing product
	 * 
	 * @param
	 */
	@Override
	public String deactivate() {
		model.deactivate();
		return "removed";
	}
}