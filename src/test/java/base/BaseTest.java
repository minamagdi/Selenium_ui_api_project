package base;

import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.TodoPage;
import utils.PropertiesUtils;

import java.time.Duration;

public class BaseTest {
	protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected TodoPage todoPage;
	@BeforeMethod
	public void setUp() {
		String pathName = "src/test/java/config/baseUrl.properties";

		driver = DriverFactory.driverInit();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get(PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		todoPage = new TodoPage(driver);
	}
}
