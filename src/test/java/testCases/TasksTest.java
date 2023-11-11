package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.LoginProperties;

public class TasksTest extends BaseTest {

	@Test
	public void addTask() {
		loginPage.login(LoginProperties.readData().getProperty("email"),
				LoginProperties.readData().getProperty("password"))
				.addNewTask("Learn Appium")
				.makeTaskAsCompleted();
	}

	@Test
	public void deleteTask() {
		loginPage.login(LoginProperties.readData().getProperty("email"),
						LoginProperties.readData().getProperty("password"))
				.addNewTask("Learn Cypress")
				.makeTaskAsCompleted()
				.addNewTask("Learn PlayRight")
				.makeTaskAsCompleted()
				.deleteSpecificTask("Learn Cypress");
	}
}
