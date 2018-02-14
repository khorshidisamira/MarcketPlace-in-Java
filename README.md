# csci50700_spring2018_marketplace

To run the application successfully, follow the following steps:

	1. Go to Implementation directory
	2. run following commands:
		2.1. make
		2.2. make registry
	3. Run the server one command window: make server
	4. Run the Client in another window: make client 
	5. In Client there is 2 option for Administrator and Customer

ps 1: rmiregistry  is using 1099 as its port, if you get error on make registry command, please find the PID of the rmiregistry with this port using "ps -ax|grep rmiregistry" and kill that process 
ps 2: The only valid functionality is login, other functions in serverController are not valid
ps 3: Uou can use any username or password to login