package base;

import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.driverInit();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://qacart-todo.herokuapp.com/");
	}
}
