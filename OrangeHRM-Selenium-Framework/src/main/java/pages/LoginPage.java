package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.ActionDriver;
import base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//h5[text()='Login']")
	WebElement titleText;

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;

	// Constructor
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	// Verify Page Title
	public boolean verifyTitle(String expTitle) {

		String actualTitle = ActionDriver.fetchTitle();

		return expTitle.equals(actualTitle);
	}

	// Verify Login Text
	public boolean verifyText(String expText) {

		String actualText = ActionDriver.fetchText(titleText);

		System.out.println(actualText);

		return expText.equals(actualText);
	}

	// Login Function
	public DashboardPage loginFunction(String userid, String pass) {

		boolean status1 = ActionDriver.enterData(username, userid);

		boolean status2 = ActionDriver.enterData(password, pass);

		if (status1 && status2) {

			ActionDriver.buttonAction(login);

			return new DashboardPage();
		}

		return null;
	}
}