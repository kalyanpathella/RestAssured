package stripe.Api;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class StripeCom {
	
	public final String apikey ="sk_test_51Lb2R8SFkOmfReHPGtTV3XPbl6zX9oxlTQuzenDbn9hZhhL6PQjCg5CQ57Jgxx2hLF5jfezHLExfkId1TWKzqyoJ00iTnxb1Xp";
	public String customerId ;
	
	@Test(priority=0)
	public void createCustomer()
	{
		// create a HTTP request via All details 
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://api.stripe.com");
		request.basePath("v1/customers");
		request.header("Content-Type","application/x-www-form-urlencoded");
		request.header("Authorization","Bearer "+apikey);
		request.formParam("name", "kashiviswanadh324");
		request.formParam("email", "kashiviswanadh@gmail.com");
		request.formParam("description", "api testing batch263api");
		// submit request 
		Response response = request.post();
		// get and display response body
		 customerId = response.body().jsonPath().getString("id");
		 if(response.getStatusCode()==201 && customerId!=null)
		 {
			 Reporter.log("Succefull creation of new customer");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Reporter.log("Unsuccefull creation of new customer");
			 Assert.assertTrue(true);
		 }
		
		
	}
	@Test(priority=1, dependsOnMethods= {"createCustomer"})
	public void retriveCustomer()
	{
		// create a HTTP request via All details 
				RequestSpecification request = RestAssured.given();
				request.baseUri("https://api.stripe.com");
				request.basePath("v1/customers"+customerId);
				request.header("Authorization","Bearer "+apikey);
				// submit request 
				Response response = request.get();
				// get and display response body
				String retriveCustomerId = response.body().jsonPath().getString("id");
				String retrivename = response.body().jsonPath().getString("name");
				String retriveemail = response.body().jsonPath().getString("email");
				String retrivedesc = response.body().jsonPath().getString("description");
				 if(response.getStatusCode()==200 && retriveCustomerId.equals(customerId)
						                          && retrivename.equals("kashiviswanadh324")
						                          && retriveemail.equals("kashiviswanadh@gmail.com")
						                          && retrivedesc.equals("api testing batch263api"))
				 {
					 Reporter.log("Succefull retrieval of new customer");
					 Assert.assertTrue(true);
				 }
				 else
				 {
					 Reporter.log("Unsuccefull retrieval of new customer");
					 Assert.assertTrue(true);
				 }
	}
	@Test(priority=2,dependsOnMethods= {"createCustomer"})
	public void updateCustomer()
	{
		// create a HTTP request via All details 
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://api.stripe.com");
		request.basePath("v1/customers"+customerId);
		request.header("Authorization","Bearer "+apikey);
		request.header("Content-Type","application/x-www-form-urlencoded");
		request.formParam("email", "kashiviswandh324@gmail.com");
		// submit request 
		Response response = request.post();
		// get and display response body
		String updateEmailId = response.body().jsonPath().getString("email");
		
		 if(response.getStatusCode()==200 && updateEmailId.equals("kashiviswanadh324@gmail.com"))
		 {
			 Reporter.log("Succefull updated of new customer");
			 Assert.assertTrue(true);
		 }
		 else
		 {
			 Reporter.log("Unsuccefull updated of new customer");
			 Assert.assertTrue(true);
		 }
		
	}
	@Test(priority=3)
	public void getAllCustomers()
	{
		// create a HTTP request via All details 
				RequestSpecification request = RestAssured.given();
				request.baseUri("https://api.stripe.com");
				request.basePath("v1/customers");
				request.header("Authorization","Bearer "+apikey);
				// submit request 
				Response response = request.get();
				// get and display response body
				List<String> ids = response.body().jsonPath().getList("data.id");
				int flag =0;
				for(String id:ids)
				{
					if(id.equals(customerId))
					{
						flag=1;
						break;
					}
					
				}
				 if(flag==1)
				 {
					 Reporter.log("new customer found in existing customers list");
					 Assert.assertTrue(true);
				 }
				 else
				 {
					 Reporter.log("new customer not found in existing customers list");
					 Assert.assertTrue(false);
				 }
		
	}
	@Test(priority=4)
	public void getSpecificCustomer()
	{
		
	}
	@Test(priority=5)
	public void deleteCustomer()
	{
		// create a HTTP request via All details 
		RequestSpecification request = RestAssured.given();
		request.baseUri("https://api.stripe.com");
		request.basePath("v1/customers/"+customerId);
		request.header("Content-Type","application/json");
		request.header("Authorization","Bearer "+apikey);
		// submit request 
		Response response = request.delete();
		// get and display response body
		  response.body().jsonPath().getString("id");
		String deleteCustomerId = response.body().jsonPath().getString("id");
		if(response.getStatusCode()==200 && deleteCustomerId.equals(customerId))
		{
			Reporter.log("Successfull deletion of new customer");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("Unsuccessfull deletion of new customer");
			Assert.assertTrue(false);
		}
		
	}

}
