package org.restAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test9 
{
	public static void main(String[] args) {
		
		// Create a HTTP Request with all details
        RestAssured.urlEncodingEnabled = false;
        RequestSpecification req = RestAssured.given();
        req.baseUri("https://petstore.swagger.io");
        req.basePath("v2/pet/findByStatus;matrixParam=test;");
        req.queryParam("offset","0");
        req.queryParam("PageSize","20");
        System.out.println("Request");
        System.out.println("-----------------------");
        req.given().log().all();
        // submit request
        Response res = req.get();
        // get and Display response
        System.out.println("Response");
        System.out.println("-----------------------");
        res.then().log().all();
	}

}
