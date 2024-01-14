package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

	public static WebDriver driverInit() {
		String browser = "chrome";		// System.getProperty("browser");
		return switch (browser.toLowerCase()) {
			case "chrome" -> new ChromeDriver();
			case "firefox" -> new FirefoxDriver();
			case "edge" -> new EdgeDriver();
			default -> throw new RuntimeException("invalid browser");
		};
	}
}
