package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesUtils;

public class TasksTest extends BaseTest {
	private final String loginPropertyPathName = "src/test/java/config/login.properties";
	@Test
	public void addTask() {
		String expectedResult = "Learn js";
		loginPage.login(PropertiesUtils.readDataFromPropertyFile(loginPropertyPathName).getProperty("email"),
				PropertiesUtils.readDataFromPropertyFile(loginPropertyPathName).getProperty("password"))
				.addNewTask("Learn js")
				.makeTaskAsCompleted();
		Assert.assertEquals(todoPage.getTaskName("Learn js"),expectedResult);
	}

	@Test
	public void deleteTask() {
		loginPage.login(PropertiesUtils.readDataFromPropertyFile(loginPropertyPathName).getProperty("email"),
						PropertiesUtils.readDataFromPropertyFile(loginPropertyPathName).getProperty("password"))
				.addNewTask("Learn Cypress")
				.makeTaskAsCompleted()
				.addNewTask("Learn PlayRight")
				.makeTaskAsCompleted()
				.deleteSpecificTask("Learn Cypress");

		Assert.assertTrue(todoPage.getNoTodoMessage());
	}
}
