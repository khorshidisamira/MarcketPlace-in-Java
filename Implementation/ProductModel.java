// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

import java.sql.ResultSet;
public class ProductModel{
	
	private databaseManager dbManager = new databaseManager();
	private String name;
	private double price;
	private String description;
	public int quantity;
	private String productStatus;// active is available in the system, deactive means has been removed

	public ProductModel(){
		
	}
	
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
	 * Getter(return the quantity of a product)
	 * 
	 * @return the quantity of product
	 */
	public int getQuantity() {
		return quantity;
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
	 * getter of a product's details 
	 * 
	 * @return a string formate of product's details
	 */
	public String getDetails() {

		return String.format("Name: %s \n Price: %d \n  Description: %s \n Quantity: %d", name, price, description,
				quantity);
	}

	// a mothod that will be used when admin wants to update the product's details
	public String updateProduct(int productIndex, String newName, float newPrice, String newDescription, int newQuantity){
		String commandStatus = null;
		try{
			String product_stm = String.format("UPDATE product SET name = '%s', price=%s, description='%s', quantity = %s  WHERE productId = %s",newName, newPrice, newDescription, newQuantity, productIndex);
			int result = dbManager.updateMyRecord(product_stm);
			System.out.println(result);
			if(result>0){ 
				commandStatus = "Product has been updated successfully!";
			
			} else{
				commandStatus = "Please try again later!";
			}
			return commandStatus;
		}catch(Exception e){
			commandStatus = "Please try again later!";
			System.out.println("Database Exception" + e.getMessage());
		}
		
		return commandStatus;
	}

	/**
	 * Responsible for deleting a product from the system by admin
	 * 
	 */
	public String deactivate(int index) {
		String commandStatus = null;
		try{
			String product_stm = String.format("UPDATE product SET status = 'deactive' WHERE productId = %s",index);
			int result = dbManager.updateMyRecord(product_stm);
			System.out.println(result);
			if(result>0){ 
				commandStatus = "Product has been removed successfully!";
			
			} else{
				commandStatus = "Please try again later!";
			}
			return commandStatus;
		}catch(Exception e){
			commandStatus = "Please try again later!";
			System.out.println("Database Exception" + e.getMessage());
		}
		
		return commandStatus;
	}
	
	public String addProduct(String newName, float newPrice, String newDescription, int newQuantity){
		
		System.out.println("Here in model!");
		String commandStatus = null;
		try{
			String stm = String.format("INSERT INTO product(name, description, quantity, price, status) VALUES (' %s','%s',%s,%s,'active');",newName,newDescription, newQuantity, newPrice);
			
			System.out.println(stm);
			int result = dbManager.updateMyRecord(stm);
			if(result>0)
				commandStatus = "Product has been added successfully!";
			else
				commandStatus = "Please try again later!";
				
		}catch(Exception e){
			commandStatus = "Please try again later!";
			System.out.println("Database Exception" + e.getMessage());
		}
		
		return commandStatus;
	}
	
	public String selectProduct(int index){
		StringBuilder str = new StringBuilder();
		str.append("");
		try{
			String stm = String.format("SELECT * FROM `product` WHERE `status` = 'active' AND productId = %s",index);
			
			
			ResultSet rs = dbManager.executeMyQuery("stm");
			while (rs.next())  {
				int id = rs.getInt("productId");
				String productName = rs.getString("name"); 
				float productPrice = rs.getFloat("price");
				int productQuantity = rs.getInt("quantity");
				String productDescription = rs.getString("description");
				str.append(id);
				str.append(" Name: ");
				str.append(productName);
				str.append(" Price: ");
				str.append(productPrice);
				str.append(" Quantity: ");
				str.append(productQuantity);
				str.append(" Description: ");
				str.append(productDescription);
				str.append("\n");
				System.out.println("ID: " + id + "\t" + "Name: " + productName + "\t" + "Price: " + productPrice + "\t" + "Quantity: " + productQuantity + "\t" + "Description: " + productDescription);				
			}
			
		}catch(Exception e){
			System.out.println("Database Exception:" + e.getMessage());
		}
		return str.toString();		
	}	
	
	public String showProductList(){
		System.out.println("PRODUCT MODELLLLLLLLLLLLLLLS");
		StringBuilder str = new StringBuilder();
		str.append("");
		try{
			
			ResultSet rs = dbManager.executeMyQuery("SELECT * FROM `product` WHERE `status` = 'active'");
			while (rs.next())  {
				int id = rs.getInt("productId");
				String productName = rs.getString("name"); 
				float productPrice = rs.getFloat("price");
				int productQuantity = rs.getInt("quantity");
				String productDescription = rs.getString("description");
				str.append(id);
				str.append(" Name: ");
				str.append(productName);
				str.append(" Price: ");
				str.append(productPrice);
				str.append(" Quantity: ");
				str.append(productQuantity);
				str.append(" Description: ");
				str.append(productDescription);
				str.append("\n");
				System.out.println("ID: " + id + "\t" + "Name: " + productName + "\t" + "Price: " + productPrice + "\t" + "Quantity: " + productQuantity + "\t" + "Description: " + productDescription);				
			}
			
		}catch(Exception e){
			System.out.println("Database Exception:" + e.getMessage());
		}
		return str.toString();		
	}

	public String addToCart(String user, int productId, int quantity) {
		
		String commandStatus = null;
		try{
			String product_stm = String.format("UPDATE product SET quantity = GREATEST(0,(quantity - %s)) WHERE productId = %s AND ((quantity - %s) >0 OR (quantity - %s) = 0)",quantity,productId,quantity,quantity);
			int result = dbManager.updateMyRecord(product_stm);
			System.out.println(result);
			if(result>0){ 
				String cart_stm = String.format("INSERT INTO cart(username, productId, quantity) VALUES ('%s',%s,%s)", user, quantity,productId);
				int res = dbManager.updateMyRecord(cart_stm);
				if(res>0)
					commandStatus = "Product has been added to your cart successfully!";
				else 
					commandStatus = "Please try again later!";
			} else{
				commandStatus = "Please try again later!";
			}
			return commandStatus;
		}catch(Exception e){
			commandStatus = "Please try again later!";
			System.out.println("Database Exception" + e.getMessage());
		}
		
		return commandStatus;
	}
	
}