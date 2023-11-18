package testCases;

import apiRequests.RegisterApi;
import base.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SignUpTest extends BaseTest {

	@Test
	public void signUpWithValidData() {
		homePage
				.signUp("adhm","mohamed","adhmed3@test.com","Adham123456");

		Assert.assertEquals(todoPage.getWelcomeMessage("adhm"),"GOOD MORNING ADHM");
	}
	@Test
	public void signUpWithValidData_api() {
		String body = "{" +
				"\"email\":\"marwa223@wed.com\"," +
				"\"password\":\"Mina123456\"," +
				"\"firstName\":\"marwa\"," +
				"\"lastName\":\"alaa\"" +
				"}";
		Map<String, String> body2 = new HashMap<>();
		body2.put("email","marwa232@wed.com");
		body2.put("password","Mina123456");
		body2.put("firstName","marwa");
		body2.put("lastName","alaa2");

		given()
				.baseUri("https://qacart-todo.herokuapp.com")
				.body(body)
				.header("Content-Type","application/json")
		.when()
				.post("/api/v1/users/register")
		.then()
				.log().all();
	}
	@Test
	public void signUpWithValidFakeData_api_inject() {
		RegisterApi registerApi = new RegisterApi();
		registerApi.register(); // register api with fake data
		// print data
		System.out.println(registerApi.getRestassuredCookies());
		System.out.println(registerApi.getAccess_token());
		System.out.println(registerApi.getFirstName());
		System.out.println(registerApi.getUserID());

		// selenium cookie
		Cookie access_token = new Cookie("access_token",registerApi.getAccess_token());
		Cookie firstName = new Cookie("firstName",registerApi.getFirstName());
		Cookie userId = new Cookie("userID",registerApi.getUserID());

		// inject to browser
		driver.manage().addCookie(access_token);
		driver.manage().addCookie(firstName);
		driver.manage().addCookie(userId);
		// reload page
		String pathName = "src/test/java/config/baseUrl.properties";
		driver.get(PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("url"));
	}
	@Test
	public void register_api_injectCookies() {
		RegisterApi registerApi = new RegisterApi();
		registerApi.register(); // register api with fake data
		// list of rest-assured cookies
		List<io.restassured.http.Cookie> restAssuredCookies = registerApi.getRestassuredCookies();

		// selenium cookie
		for (io.restassured.http.Cookie cookie : restAssuredCookies) {
			// selenium cookie
			Cookie seleniumCookie = new Cookie(cookie.getName(), cookie.getValue());
			// inject to browser
			driver.manage().addCookie(seleniumCookie);
		}
		// reload page
		reload();
	}

}
