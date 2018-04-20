import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
public class databaseManager{
	/*This class is temporary, in next assignment, database will be managed*/
	//Database Connection
	private String hostname;
	private String dbName;
	private String url;
	private String username;
	private String password;
	private Connection conn;
	
	public databaseManager(){
		hostname = "localhost:3306";
		dbName = "sakhors_db";
		url = "jdbc:mysql://" + hostname + "/" + dbName;
		username = "sakhors";
		password = "sakhors";
		//System.out.println("Connecting database...");
		Connection conn = null; 
	}
	
	public ResultSet executeMyQuery(String query){
		ResultSet rs = null;
		try {
			conn = (Connection) 
			DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
			if(conn != null) {
				Statement stmt = null;
				
				try {
					stmt = (Statement) 
					conn.createStatement();
					try {
						rs = stmt.executeQuery( query );
						return rs; 
					} catch (SQLException e) {
						System.err.println("Unable execute query!");
						e.printStackTrace();
					}
					stmt.close();
				} catch (SQLException e1) {
					System.err.println("Unable to create SQL statement!");
					e1.printStackTrace();
				}
			}
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
		return rs; 
	}
	

	public int updateMyRecord(String query){
		ResultSet rs = null;
		try {
			conn = (Connection) 
			DriverManager.getConnection(url, username, password);
			if(conn != null) {
				Statement stmt = null;
				System.out.println("Database connected!");
				try {
					stmt = (Statement) 
					conn.createStatement();
					try {
						return stmt.executeUpdate( query );
					} catch (SQLException e) {
						System.err.println("Unable execute query!");
						e.printStackTrace();
					}
					stmt.close();
				} catch (SQLException e1) {
					System.err.println("Unable to create SQL statement!");
					
					e1.printStackTrace();
				}
			}
		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		
		} 
		return 1;
	}
	
}