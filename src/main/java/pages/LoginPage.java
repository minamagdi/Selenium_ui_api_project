package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	private final By emailField = By.cssSelector("[name='email']");
	private final By passwordField = By.xpath("//input[@data-testid='password']");
	private final By loginBtn = By.cssSelector("[name='submit']");

	public TodoPage login(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginBtn).click();
		return new TodoPage(driver);
	}
	public String getActualUrl() {
		return driver.getCurrentUrl();
	}
}
