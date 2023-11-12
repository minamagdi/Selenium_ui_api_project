package testCases;

import apiRequests.RegisterApi;
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
	public void addTask_using_api() {
		RegisterApi registerApi = new RegisterApi();
		registerApi.register();
		injectCookiesToBrowser(registerApi.getRestassuredCookies());
		reload();
		String expectedResult = "Learn js";
		todoPage.addNewTask("Learn js")
				.makeTaskAsCompleted();
		Assert.assertEquals(todoPage.getTaskName("Learn js"),expectedResult);
	}
	@Test
	public void deleteTask_api() {
		loginPage.login(PropertiesUtils.readDataFromPropertyFile(loginPropertyPathName).getProperty("email"),
						PropertiesUtils.readDataFromPropertyFile(loginPropertyPathName).getProperty("password"))
				.addNewTask("Learn Cypress")
				.makeTaskAsCompleted()
				.addNewTask("Learn PlayRight")
				.makeTaskAsCompleted()
				.deleteSpecificTask("Learn Cypress");

		Assert.assertTrue(todoPage.getNoTodoMessage());
	}
	@Test
	public void deleteTask() {
		RegisterApi registerApi = new RegisterApi();
		registerApi.register();
		injectCookiesToBrowser(registerApi.getRestassuredCookies());
		reload();
		todoPage.addNewTask("Learn PlayRight")
				.makeTaskAsCompleted()
				.addNewTask("Learn Cypress")
				.deleteSpecificTask("Learn PlayRight")
				.makeTaskAsCompleted()
				.deleteSpecificTask("Learn Cypress");

		Assert.assertTrue(todoPage.getNoTodoMessage());
	}
}
