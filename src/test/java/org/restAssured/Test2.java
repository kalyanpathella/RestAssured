package org.restAssured;
import static io.restassured.RestAssured.*;

public class Test2 {

	public static void main(String[] args) {
		
		// BDD


		given().baseUri("https://jsonplaceholder.typicode.com/posts")
			.when()
				.get()


			.then()
				.log().all();
	}


}
