package base;

import driverFactory.DriverFactory;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.TodoPage;
import utils.PropertiesUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
	private List<org.openqa.selenium.Cookie> convertRestAssuredToSeleniumCookie(List<Cookie> restAssuredCookies) {
		List<org.openqa.selenium.Cookie> seleniumCookies = new ArrayList<>() ;
		for (Cookie cookie: restAssuredCookies) {
			org.openqa.selenium.Cookie seleniumCookie =
					new org.openqa.selenium.Cookie(cookie.getName(), cookie.getValue());
			seleniumCookies.add(seleniumCookie);
		}
		return seleniumCookies;
	}
	public void injectCookiesToBrowser(List<Cookie> restAssuredCookies) {
		List<org.openqa.selenium.Cookie> seleniumCookie = convertRestAssuredToSeleniumCookie(restAssuredCookies);
		for (org.openqa.selenium.Cookie cookie: seleniumCookie) {
			driver.manage().addCookie(cookie);
		}
	}
	public void reload() {
		String pathName = "src/test/java/config/baseUrl.properties";
		String baseUrl = PropertiesUtils.readDataFromPropertyFile(pathName).getProperty("url");
		driver.get(baseUrl);
	}
}
