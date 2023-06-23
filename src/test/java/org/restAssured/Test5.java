package org.restAssured;
import static io.restassured.RestAssured.*;

public class Test5 {

	public static void main(String[] args) {
		
		// path parameter value as Argument to http method
		given().baseUri("https://jsonplaceholder.typicode.com")// server address 
				.basePath("posts") // path parameter
			.when()
				.get("100")
			.then()
				.log().all();
		// we have correct name of path parameter
				given().baseUri("https://jsonplaceholder.typicode.com")// server address 
						.basePath("posts") // path parameter
						.pathParam("id", "100")
					.when()
						.get()
					.then()
						.log().all();
	}

}
