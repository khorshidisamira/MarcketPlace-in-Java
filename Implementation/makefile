default: 
		javac *.java
	
registry: 
	
	rmiregistry 1099&

server: 
	java -Djava.security.manager -Djava.security.policy=policy MarketPlaceServer &

client: 
	java -Djava.security.manager -Djava.security.policy=policy MarketPlaceClient
clean: 
	$(RM) *.class

