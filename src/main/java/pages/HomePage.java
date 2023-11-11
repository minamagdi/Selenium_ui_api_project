package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	private final By signUpBtn = By.xpath("//div[@class='sc-ezWOiH iOQdwL']//a[3]");
	private final By firstNameField = By.cssSelector("[data-testid='first-name']");
	private final By lastNameField = By.cssSelector("[data-testid='last-name']");
	private final By emailField = By.cssSelector("[data-testid='email']");
	private final By passwordField = By.cssSelector("[data-testid='password']");
	private final By confirmPasswordField = By.cssSelector("[data-testid='confirm-password']");
	private final By submitBtn = By.cssSelector("[data-testid='submit']");
	public void signUp(String fName,String lName,String email,String password) {
		driver.findElement(signUpBtn).click();
		driver.findElement(firstNameField).sendKeys(fName);
		driver.findElement(lastNameField).sendKeys(lName);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(confirmPasswordField).sendKeys(password);
		driver.findElement(submitBtn).click();
	}
}
