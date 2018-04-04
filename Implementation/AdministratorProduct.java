/**
 * All products families have the same varieties (Administrator/Customer).
 * 
 * This is a MacOS variant of a button.
 */

import java.io.Serializable;
import java.sql.ResultSet;

public class AdministratorProduct implements ProductInterface, Serializable { 

	private ProductModel model;
	private databaseManager dbManager= new databaseManager();
	// private ArrayList<ProductModel> productList = new ArrayList<>(); //Holds
	// system's products

	/**
	* @return list of products
	*/
	@Override
	public String showProductList(){
		StringBuilder str = new StringBuilder();
		str.append("");
		try{
			ResultSet rs = dbManager.executeMyQuery("SELECT * FROM `product` WHERE `status` = 'active'");
			
			while (rs.next())  {
				int id = rs.getInt("productId");
				String productName = rs.getString("name"); 
				str.append(id);
				str.append(" ");
				str.append(productName);
				str.append("\n");
				System.out.println("ID: " + id + "\t" + "Name: " + productName);				
			}
			
		}catch(Exception e){
			System.out.println("Database Exception" + e.getMessage());
		}
		return str.toString();		
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
	public String addProduct(String name, float price, String description, int quantity) {
		String commandStatus = null;
		try{
			String stm = String.format("INSERT INTO product(name, description, quantity, price, status) VALUES (' %s','%s',%s,%s,'active');",name,description,quantity,price);
			System.out.println(stm);
			dbManager.updateMyRecord(stm);
			commandStatus = "Product has been added successfully!";
		}catch(Exception e){
			commandStatus = "Please try again later!";
			System.out.println("Database Exception" + e.getMessage());
		}
		
		return commandStatus;
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
	public String deactivate() {
		model.deactivate();
		return "removed";
	}
}