package api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EmployeeAPITest {

	@Test 
	public static String validateAPI(){

		Response response =

				RestAssured
				.given()
				.baseUri("https://reqres.in/api")
				.get("/users/2");

		System.out.println(response.getBody().asPrettyString());

		return response.jsonPath()
				.getString("data.first_name");
	}

}
