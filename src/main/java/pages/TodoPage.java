package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage extends BasePage{

	private final By addNewTaskBtn = By.cssSelector("[data-testid='add']");
	private final By newTodoField = By.cssSelector("[data-testid='new-todo']");
	private final By createNewTodoBtn = By.cssSelector("[data-testid='submit-newTask']");
	private final By markAsCompletedCheckBtn = By.cssSelector("[data-testid='complete-task']");
	private final By deleteTaskBtn = By.cssSelector("[data-testid='delete']");
	public TodoPage(WebDriver driver) {
		super(driver);
	}

	private By deleteTaskBtnLocator (String taskName) {
		String xpathExpression = "//div[@class='sc-bjUoiL sKzpc']//h2[text()= '%s']//following::button";
		String deleteIcon = String.format(xpathExpression, taskName);
		return By.xpath(deleteIcon);
	}
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
	public void deleteSpecificTask(String name) {
		driver.findElement(deleteTaskBtnLocator(name)).click();
	}
}
