package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;

	// Browser Setup
	public static void setup(String browser) {

		if (browser == null) {

			throw new RuntimeException("Browser value is null");
		}

		switch (browser.toLowerCase()) {

		case "chrome":

			driver = new ChromeDriver();
			break;

		case "edge":

			driver = new EdgeDriver();
			break;

		case "firefox":

			driver = new FirefoxDriver();
			break;

		default:

			throw new RuntimeException("Invalid Browser Name : " + browser);
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(ConstantValues.URL);
	}

	// Browser Close
	public static void teardown() {

		if (driver != null) {

			driver.quit();

			driver = null;
		}
	}
}