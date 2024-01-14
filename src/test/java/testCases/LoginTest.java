package testCases;

import apiRequests.RegisterApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.LoginPojo;
import utils.PropertiesUtils;

import java.io.File;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseTest {
	private final String pathName = "src/test/java/config/login.properties";
	@Test
	public void userShouldBeAbleToLoginWithValidCredential() {
		loginPage.login(PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("email"),
				PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("password"));

		Assert.assertEquals(todoPage.getActualUrl(),todoPage.getExpectedURL());
	}
	@Test(dataProvider = "loginData")
	public void userShouldBeNotAbleToLoginWithINValidCredential(String email, String password) {
		loginPage.login(email, password);
		Assert.assertEquals(loginPage.getActualUrl(),todoPage.getExpectedUrlWithInvalidData());
	}
	@DataProvider
	public Object[][] loginData () {

		String[][] data = new String[3][2];
		data[0][0] = PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("wrongEmail");
		data[0][1] = PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("password");
		data[1][0] = PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("email");
		data[1][1] = PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("wrongPassword");
		data[2][0] = PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("wrongEmail");
		data[2][1] = PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("wrongPassword");
		return data;
	}
	@Test
	public void userShouldBeAbleToLoginWithValidCredential_api() {
		File loginBody = new File("src/main/resources/login.json");
		given()
				.baseUri("https://qacart-todo.herokuapp.com")
				.body(loginBody)
				.header("Content-Type","application/json")
				.when()
				.post("/api/v1/users/login")
				.then()
				.log().all();
	}

	@Test
	public void userShouldBeAbleToLoginWithValidCredential_api_extract_jsonFile() {
		File loginBody = new File("src/main/resources/login.json");
		Response response = given()
				.baseUri("https://qacart-todo.herokuapp.com")
				.body(loginBody)
				.header("Content-Type","application/json")
				.when()
				.post("/api/v1/users/login")
				.then()
				.extract().response();
		System.out.println("your body   " +response.prettyPrint());
		System.out.println("your status code   " +response.statusCode());
		String userID = response.path("userID"); // use path() to access any value inside body [preview] in the console
		System.out.println(userID);
	}

	@Test
	public void userShouldBeAbleToLoginWithValidCredential_api_pojoClass() {
		//LoginPojo loginBody = new LoginPojo("mina@test.com","Mina123456");// you will need jackson data bind to
		LoginPojo loginBody = LoginPojo.builder().email("mina@test.com").password("Mina123456").build();
		// serialize from java object to json
		given()
				.baseUri("https://qacart-todo.herokuapp.com")
				.body(loginBody)
				.header("Content-Type","application/json")
				.when()
				.post("/api/v1/users/login")
				.then()
				.log().all();
	}
}
