How to run:
First set the following environment variables related to a postgres database: (you'll find it in the email)
	DB_URL: jdbc url. 
	DB_PASSWORD=
	DB_USERNAME=
With Java 17 SE and maven run all pom install. 
Run DemoAplication you can find it in: \src\main\java\com\mutant\demo
You can find the endpoints on localhost:8080/api/v1/dna/mutant/ and localhost:8080/api/v1/dna/stats

Note:
The maximum size for the square size is 15x15 due to database limitations.