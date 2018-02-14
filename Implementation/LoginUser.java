// Honor Pledge:
//
// I pledge that I have neither given nor received any help on this assignment.
//
// Samira Khorshidi
public class LoginUser implements Order {
   private Application userApp; 

   public LoginUser(Application app){  
		userApp = app;
		
   }

   public void execute() {
      String loginStatus = userApp.login(); 
   }
}