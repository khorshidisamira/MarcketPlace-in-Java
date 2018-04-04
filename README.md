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

ps 2: The only valid functionality is login, browse products, add a new product and add a product to shopping cart(purchase) other functions in serverController are not valid  

ps 3: server.concurrencyTest(); is a function that has delay inside it and it is just a test function of concurrency

ps 4: You can use any username or password to login  

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
  
*the rest of the files are just part of the application that are going to be completed in future  







