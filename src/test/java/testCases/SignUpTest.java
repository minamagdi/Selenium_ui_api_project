package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

	@Test
	public void signUpWithValidData() {
		homePage
				.signUp("adhm","mohamed","adhmed2@test.com","Adham123456");

		Assert.assertEquals(todoPage.getWelcomeMessage("adhm"),"GOOD MORNING ADHM");
	}
}
