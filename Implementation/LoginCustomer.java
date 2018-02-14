public class LoginCustomer implements Order {
   private AdministratorUser customer;

   public LoginCustomer(String username, String password){
		customer.setInfo(username, password);
   }

   public void execute() {
      customer.login();
   }
}