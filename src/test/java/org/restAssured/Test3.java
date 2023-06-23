package org.restAssured;
import static io.restassured.RestAssured.*;

public class Test3 {

	public static void main(String[] args) {
		
		// BDD
		given().baseUri("https://petstore.swagger.io")// server address 
				.basePath("v2/pet/1") // path parameter
			.when()
				.get()
			.then()
				.log().all();
	}

}
