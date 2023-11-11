package testCases;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.LoginProperties;

public class LoginTest extends BaseTest {

	@Test
	public void userShouldBeAbleToLoginWithValidCredential() {
		loginPage.login(LoginProperties.readData().getProperty("email"),
				LoginProperties.readData().getProperty("password"));
	}
	@Test(dataProvider = "loginData")
	public void userShouldBeNotAbleToLoginWithINValidCredential(String email, String password) {
		loginPage.login(email, password);
	}
	@DataProvider
	public Object[][] loginData () {
		String[][] data = new String[3][2];
		data[0][0] = LoginProperties.readData().getProperty("wrongEmail");
		data[0][1] = LoginProperties.readData().getProperty("password");
		data[1][0] = LoginProperties.readData().getProperty("email");
		data[1][1] = LoginProperties.readData().getProperty("wrongPassword");
		data[2][0] = LoginProperties.readData().getProperty("wrongEmail");
		data[2][1] = LoginProperties.readData().getProperty("wrongPassword");
		return data;
	}
}
