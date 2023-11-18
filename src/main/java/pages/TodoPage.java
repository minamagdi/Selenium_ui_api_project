package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TodoPage extends BasePage{

	private final By addNewTaskBtn = By.cssSelector("[data-testid='add']");
	private final By newTodoField = By.cssSelector("[data-testid='new-todo']");
	private final By createNewTodoBtn = By.cssSelector("[data-testid='submit-newTask']");
	private final By markAsCompletedCheckBtn = By.cssSelector("[data-testid='complete-task']");
	private final By taskName = By.xpath("[data-testid='delete']");
	public TodoPage(WebDriver driver) {
		super(driver);
	}
	private By welcomeMessageLocator(String userName) {
		String expectedWelcome = "//h2[contains(text(),'%s')]";
		String welcomeMessage = String.format(expectedWelcome,userName);
		return By.xpath(welcomeMessage);
	}
	private By deleteTaskBtnLocator (String taskName) {
		String xpathExpression = "//div[@class='sc-bjUoiL sKzpc']//h2[text()= '%s']//following::button";
		String deleteIcon = String.format(xpathExpression, taskName);
		return By.xpath(deleteIcon);
	}
	private final By taskNameLocator (String taskName) {
		String xpathExpression = "//div[@class='sc-bjUoiL sKzpc']//h2[text()= '%s']";
		String task = String.format(xpathExpression, taskName);
		return By.xpath(task);
	}
	private final By noTodos = By.cssSelector("[data-testid='no-todos']");

	public TodoPage addNewTask(String name) {
		driver.findElement(addNewTaskBtn).click();
		driver.findElement(newTodoField).sendKeys(name);
		driver.findElement(createNewTodoBtn).click();
		return this;
	}
	public TodoPage makeTaskAsCompleted() {
		driver.findElement(markAsCompletedCheckBtn).click();
		return this;
	}
	public TodoPage deleteSpecificTask(String name) {
		driver.findElement(deleteTaskBtnLocator(name)).click();
		return this;
	}

	public String getWelcomeMessage(String userName) {
		return driver.findElement(welcomeMessageLocator(userName)).getText();
	}
	public String getActualUrl() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://qacart-todo.herokuapp.com/todo"));
		return driver.getCurrentUrl();
	}
	public String getExpectedUrlWithInvalidData() {
		return  "https://qacart-todo.herokuapp.com/";
	}
	public String getExpectedURL() {
		return  "https://qacart-todo.herokuapp.com/todo";
	}

	public String getTaskName(String taskName) {
		return driver.findElement(taskNameLocator(taskName)).getText();
	}

	public boolean getNoTodoMessage() {
		return driver.findElement(noTodos).isDisplayed();
	}

	public TodoPage load() {
		driver.get("https://qacart-todo.herokuapp.com/todo");
		return this;
	}
}
