// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi

/**
 * All products families have the same varieties (Administrator/Customer).
 */
 
import java.io.Serializable;
import java.sql.ResultSet;

public class CustomerProduct  implements ProductInterface, Serializable { 

	private ProductModel model;
	private databaseManager dbManager = new databaseManager();
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
			System.out.println("Database Exception:" + e.getMessage());
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
		String commandStatus = null;
		try{
			String product_stm = String.format("UPDATE product SET quantity = (quantity - %s) WHERE productId = %s",quantity,productId);
			dbManager.updateMyRecord(product_stm);
			
			String cart_stm = String.format("INSERT INTO cart(username, productId, quantity) VALUES ('%s',%s,%s)", user, quantity,productId);
			dbManager.updateMyRecord(cart_stm);
			commandStatus = "Product has been added to your cart successfully!";
		}catch(Exception e){
			commandStatus = "Please try again later!";
			System.out.println("Database Exception" + e.getMessage());
		}
		
		return commandStatus;
	}
	
	

	/**
	 * Responsible for removing product
	 * 
	 * @param
	 */
	@Override
	public String deactivate() {
		return null;
	}
}