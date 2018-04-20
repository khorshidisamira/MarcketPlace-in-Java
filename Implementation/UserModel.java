// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
import java.sql.ResultSet;
public class UserModel {

	private double userId;
	private String firstName;
	private String lastName;
	protected String username;
	protected String password;
	private String phone;
	private String email;
	private String type; // admin, customer
	private String accountStatus; // active, deactive
	private boolean loginStatus;
	private databaseManager dbManager = new databaseManager();

	public UserModel(String newUsername, String newPassword, String newType) {
		username = newPassword;
		password = newUsername;
		type = newType;
		loginStatus = true;
		accountStatus = "active";
	}

	/**
	 * Responsible to login and logout the user
	 * 
	 * @param status
	 */
	public boolean setLoginStatus(boolean status) {
		boolean commandStatus = false;
		try{
			String stm = String.format("SELECT * FROM `user` WHERE `accountStatus` = 'active' AND type= '%s' AND username='%s' AND password= '%s'",type, username,password);
			ResultSet rs = dbManager.executeMyQuery(stm);
			while (rs.next()) {
				userId = rs.getInt("userId");
				
				String product_stm = String.format("UPDATE user SET login = 1 WHERE userId = %s",userId);
				int result = dbManager.updateMyRecord(product_stm);
				System.out.println(result);
				if(result>0){ 
					String userUsername = rs.getString("username");
					System.out.println("ID: " + userId + "\t" + "Name: " + userUsername);	
					loginStatus = status;
					commandStatus = true;
				}
			}
			
		}catch(Exception e){
			System.out.println("Database Exception:" + e.getMessage());
		}
		
		return true; 
	}

	public boolean getLoginStatus(){
		boolean userLoginStatus = false;
		try{
			String stm = String.format("SELECT userId, login FROM `user` WHERE accountStatus = 'active' AND login=1 AND username = '%s' AND password = '%s'",username, password);
			ResultSet rs = dbManager.executeMyQuery(stm);
			while (rs.next()) {
				userLoginStatus = rs.getBoolean("login");
				return userLoginStatus;
			}
			
		}catch(Exception e){
			System.out.println("Database Exception:" + e.getMessage());
		}
		return userLoginStatus;
	}
	/**
	 * @return user type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of user, admin or customer
	 * 
	 * @param newType
	 */
	public void setType(String newType) {
		type = newType;
	}

	/**
	 * Responsible to deactivate user account to be removed
	 */
	public void deactivate() {
		accountStatus = "deactive";
	}

	public String addUser(String newUsername, String newPassword, String newType){
		
		String commandStatus = null;
		try{
			String stm = String.format("INSERT INTO user(username, password, type, accountStatus) VALUES (' %s','%s','%s','active');",newUsername,newPassword, newType);
			System.out.println(stm);
			int result = dbManager.updateMyRecord(stm);
			if(result>0)
				commandStatus = "User has been added successfully!";
			else
				commandStatus = "Please try again later!";
				
		}catch(Exception e){
			commandStatus = "Please try again later!";
			System.out.println("Database Exception" + e.getMessage());
		}
		
		return commandStatus;
	}
	
}