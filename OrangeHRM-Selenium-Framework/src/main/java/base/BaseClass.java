package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;

	public static void setup(String browser)
	{
		switch(browser.toLowerCase())
		{
		case "chrome" :

			driver = new ChromeDriver();
			break;

		case "edge" :

			driver = new EdgeDriver();
			break;

		case "firefox" :

			driver = new FirefoxDriver();
			break;

		default :

			System.out.println("Invalid Browser");
			break;
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public static void teardown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}
}