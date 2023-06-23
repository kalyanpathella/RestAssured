package org.restAssured;
import static io.restassured.RestAssured.*;

public class Test4 {

	public static void main(String[] args) {
		
		// path parameter value in URI
		given().baseUri("https://jsonplaceholder.typicode.com")// server address 
				.basePath("posts/100") // path parameter
			.when()
				.get()
			.then()
				.log().all();
	}

}
