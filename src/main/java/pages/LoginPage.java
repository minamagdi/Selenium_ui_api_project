package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	private final By emailField = By.cssSelector("[name='email']");
	private final By passwordField = By.xpath("//input[@data-testid='password']");
	private final By loginBtn = By.cssSelector("[name='submit']");

	public void login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginBtn).click();
	}

	public void assertLoginSuccessfully() {
		String expectedUrl = "https://qacart-todo.herokuapp.com/todo";
		String actualUrl = driver.getCurrentUrl();
	}

	public void assertLoginIsNotSuccessfully() {
		String expectedUrl = "https://qacart-todo.herokuapp.com/";
		String actualUrl = driver.getCurrentUrl();
	}
}
