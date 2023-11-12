package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertiesUtils;

public class LoginTest extends BaseTest {
	private final String pathName = "src/test/java/config/login.properties";
	@Test
	public void userShouldBeAbleToLoginWithValidCredential() throws InterruptedException {
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
}
