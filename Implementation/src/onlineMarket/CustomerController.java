package onlineMarket;

public class CustomerController extends UserController {
	static UserModel customerModel;

	public CustomerController(UserModel newModel) {
		super(newModel);
//		customerModel = getUser();
//		customerModel.setType("customer");
	}
}