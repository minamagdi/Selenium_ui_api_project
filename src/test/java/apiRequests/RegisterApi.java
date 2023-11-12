package apiRequests;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import pojo.RegisterPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
	private List<Cookie> restassuredCookies;
	private String access_token;
	private String firstName;
	private String userID;

	public List<Cookie> getRestassuredCookies() {
		return restassuredCookies;
	}

	public String getAccess_token() {
		return access_token;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getUserID() {
		return userID;
	}

	public void register() {
		//File requestBody = new File("src/main/resources/register.json");     // read from json file
		RegisterPojo requestBody = new RegisterPojo();                        // read from pojo class
		Response response = given()
				.baseUri("https://qacart-todo.herokuapp.com")
				.body(requestBody)
				.header("Content-Type","application/json")
		.when()
				.post("/api/v1/users/register")
		.then().extract().response();

		restassuredCookies = response.detailedCookies().asList();
		access_token = response.path("access_token");
		firstName = response.path("firstName");
		userID = response.path("userID");
	}
}
