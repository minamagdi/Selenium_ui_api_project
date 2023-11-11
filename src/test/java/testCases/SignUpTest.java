package testCases;

import base.BaseTest;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

	@Test
	public void signUpWithValidData() {
		homePage
				.signUp("adhm","mohamed","adhmed@test.com","Adham123456");
	}
}
