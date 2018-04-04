default: 
		javac -cp ".:/home/sakhors/OnlineMarket_2_4/mysql-connector.jar" *.java
	
registry: 
	
	rmiregistry 60000&

server: 
	java  -cp ".:/home/sakhors/OnlineMarket_2_4/mysql-connector.jar" -Djava.security.manager -Djava.security.policy=policy MarketPlaceServer &

client: 
	java  -cp ".:/home/sakhors/OnlineMarket_2_4/mysql-connector.jar" -Djava.security.manager -Djava.security.policy=policy MarketPlaceClient
clean: 
	$(RM) *.class

