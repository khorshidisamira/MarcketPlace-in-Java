// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

public class ProductModel {
	// Ryan: Please provide useful comments in each file.
	//fixed: I added new comments
	private String name;
	private double price;
	private String description;
	public int quantity;
	private String productStatus;// active is available in the system, deactive means has been removed

	public ProductModel(String newName, double newPrice, String newDescription, int newQuantity) {
		name = newName;
		price = newPrice;
		description = newDescription;
		quantity = newQuantity;
		productStatus = "active";
	}
	
	/**
	 * Getter(return the name of a product)
	 * 
	 * @return String format of product's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter of a product's price
	 * 
	 * @return product's price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * getter of a product's Description
	 * 
	 * @return product's Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * getter of a product's Quantity
	 * 
	 * @return product's Quantity
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * getter of a product's details 
	 * 
	 * @return a string formate of product's details
	 */
	public String getDetails() {

		return String.format("Name: %s \n Price: %d \n  Description: %s \n Quantity: %d", name, price, description,
				quantity);
	}

	// a mothod that will be used when admin wants to update the product's details
	public void updateDetails(String newName, double newPrice, String newDescription, int newQuantity) {
		name = newName;
		price = newPrice;
		description = newDescription;
		quantity = newQuantity;
	}

	/**
	 * Responsible for deleting a product from the system by admin
	 * 
	 */
	public void deactivate() {
		productStatus = "deactive";
	}
}