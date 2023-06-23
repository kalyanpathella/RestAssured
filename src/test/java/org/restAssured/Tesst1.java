package org.restAssured;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class Tesst1 {

	public static void main(String[] args)throws Exception 
	{
		// Non BDD
		// Generate HTTP Request 
		RestAssured.baseURI="http://jasonplaceholder.typicode.com/posts";
		// submit that Request via HTTP method to get response 
		Response res = RestAssured.get();
		Thread.sleep(5000);
		// Analyze response 
		System.out.println("Status-line is:");
		String x = res.getStatusLine();
		System.out.println(x);
		Headers y = res.headers();
		System.out.println("Headers are:");
		for(Header h:y)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
		System.out.println("Body is:");
		String z= res.getBody().asString();
		System.out.println(z);
				

	}

}
