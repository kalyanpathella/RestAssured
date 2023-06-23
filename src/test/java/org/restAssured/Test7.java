package org.restAssured;
import static io.restassured.RestAssured.*;



public class Test7 {

	public static void main(String[] args) {
		
		
		given().baseUri("https://www.google.com")// server address 
				.basePath("Search") // path parameter
				.queryParam("q","what is gold rate in india?")
			.when()
				.get()
			.then()
				.log().all();
	}

}
