// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

public class ProductModel {

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

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public double getQuantity() {
		return quantity;
	}

	public String getDetails() {

		return String.format("Name: %s \n Price: %d \n  Description: %s \n Quantity: %d", name, price, description,
				quantity);
	}

	public void updateDetails(String newName, double newPrice, String newDescription, int newQuantity) {
		name = newName;
		price = newPrice;
		description = newDescription;
		quantity = newQuantity;
	}

	public void deactivate() {
		productStatus = "deactive";
	}
}