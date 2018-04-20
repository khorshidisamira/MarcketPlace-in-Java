# csci50700_spring2018_marketplace
In this code we are using database, so before all please edit makefile and change "/home/sakhors/OnlineMarket_2_4/mysql-connector.jar" with the address of your mysql connector, then:

To run the application successfully, follow the following steps:

	1. Go to Implementation directory
	2. run following commands:
		2.1. make
		2.2. make registry
	3. Run the server one command window: make server
	4. Run the Client in another window: make client 
	5. In Client there is 2 option for Administrator and Customer  

ps 1: rmiregistry  is using 60000 as its port, if you get error on make registry command, please find the PID of the rmiregistry with this port using "ps -ax|grep rmiregistry" and kill that process  

ps 2: The following are valid functionalities:
	• Customer/Administrators Login & Registration
	• Browsing Items
	• Updating Items
	• Removing Items
	• Adding Items
	• Purchasing Items 

ps 3: You can use the following are valid username/password for users:
	Admin: username: admin, password: admin
	Customer: username: customer, password:customer

ps 5: Please run the server on in-csci-rrpc01.cs.iupui.edu machine  

ps 6: Please before purchase, select a product

outlines of the files:  

UserModel.java: The Model of users  
UserInterface.java: The InterFace of users that is going to be implemented by AdministratorUser and CustomerUser  
AdministratorUser.java: The implementation of UserInterface for Administrator users   
CustomerUser.java: The implementation of UserInterface for Customer users  
  
ProductModel.java: The Model of product  
ProductInterface.java: The InterFace of Product that is going to be implemented by AdministratorProductInterface and CustomerProduct  
AdministratorProduct.java: The implementation of ProductInterface for Administrator users   
CustomerProduct.java: The implementation of ProductInterface for Customer users  
  
GUIFactory.java: The abstraction of GUI for 2 type users  
AdministratorFactory.java: The implementation of GUIFactory for Administrator users with their valid functionalities  
CustomerFactory.java: The implementation of GUIFactory for Customer users with their valid functionalities  
Application.java: The concrete class which gives a proper GUI to the client   
  
ServerController.java: A class that is the controller of server sid and provides services to the RMI interface  
ServerInterface.java: the Interface of RMI server side  
MarketPlaceServer.java: the Implementation of ServerInterface  
MarketPlaceClient.java: The Client side of RMI framework  
  
Order.java: This is acting as a command  
Invoker.java: Uses command pattern to identify which object will execute   
LoginUser.java: Implements Order interface and will do actual command processing, request is user and command is login action  
  
FrontController.java: Single handler for all kinds of requests coming to the application  
Dispatcher.java: Front Controller uses dispatcher object which can dispatch the request to corresponding specific controller/view  
AdminView.java: Plays view rule for administrator users  
CustomerView.java: Plays view rule for customer users  