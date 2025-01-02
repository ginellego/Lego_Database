.PHONY := build


legoQueries.class: legoQueries.java 
	javac legoQueries.java

build: legoQueries.class

clean:
	rm legoQueries.class
	rm MyDatabase.class

run: build
	java -cp .:mssql-jdbc-12.4.2.jre8.jar legoQueries