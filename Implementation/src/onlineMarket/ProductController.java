// Ryan: Missing Honor Pledge & Digital Signature.
package onlineMarket;
/**
 *
 * @author Samira
 */
public class ProductController {

	private ProductModel model;
	// private ArrayList<ProductModel> productList = new ArrayList<>(); //Holds
	// system's products

	// Model-View Glue
	public ProductController(ProductModel newModel) {
		model = newModel;

		// //initialize Products
		// String[] names = new String[5];
		// String[] descriptions = new String[5];
		// names[0] = "Shoe";
		// names[1] = "TV";
		// names[2] = "Cellphone";
		// names[3] = "Shoe 2";
		// names[4] = "Shoe 3";
		//
		// descriptions[0] = "Red Shoe";
		// descriptions[1] = "Smart TV";
		// descriptions[2] = "Iphone Cellphone";
		// descriptions[3] = "Pink Shoe 2";
		// descriptions[4] = "Blue Shoe 3";
		//
		// for(int i=0; i<5; i++) {
		// ProductModel product = new ProductModel(names[i], 12.99, descriptions[i], 3);
		// this.productList.add(product);
		// }

	}

	/**
	 * @return name of the product
	 */
	public String getName() {
		return model.getName();
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
	public ProductController addAdmin(ProductModel newModel) {
		return new ProductController(newModel);
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