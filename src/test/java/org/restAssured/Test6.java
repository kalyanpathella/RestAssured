package org.restAssured;
import static io.restassured.RestAssured.*;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		
		// Data driven using keyboard 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter pathparameter value");
		String x = sc.nextLine();
		sc.close();
		
		given().baseUri("https://jsonplaceholder.typicode.com")// server address 
				.basePath("posts"+x) // path parameter
			.when()
				.get()
			.then()
				.log().all();
	}

}
