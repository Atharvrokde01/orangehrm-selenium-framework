package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.ActionDriver;
import base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//h5")
	WebElement titletext;

	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;

	// Constructor
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	// Title Verify
	public boolean titleverify(String expTitle)
	{
		return expTitle.equals(ActionDriver.fetchTitle());
	}

	// Text Verify
	public boolean textverify(String expText)
	{
		String actualText = ActionDriver.fetchText(titletext);

		System.out.println(actualText);

		return expText.equals(actualText);
	}

	// Login Function
	public DashboardPage loginfunction(String userid, String pass)
	{
		boolean status1 = ActionDriver.enterData(username, userid);

		boolean status2 = ActionDriver.enterData(password, pass);

		if(status1 && status2)
		{
			ActionDriver.buttonaction(login);

			return new DashboardPage();
		}

		else
		{
			return null;
		}
	}
}