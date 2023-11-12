package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoginProperties;

public class TasksTest extends BaseTest {

	@Test
	public void addTask() {
		String expectedResult = "Learn js";
		loginPage.login(LoginProperties.readData().getProperty("email"),
				LoginProperties.readData().getProperty("password"))
				.addNewTask("Learn js")
				.makeTaskAsCompleted();
		Assert.assertEquals(todoPage.getTaskName("Learn js"),expectedResult);
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

		Assert.assertTrue(todoPage.getNoTodoMessage());
	}
}
