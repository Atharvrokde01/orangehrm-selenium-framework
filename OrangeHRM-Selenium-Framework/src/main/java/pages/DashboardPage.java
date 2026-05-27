package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.ActionDriver;
import base.BaseClass;
import base.ConstantValues;

public class DashboardPage extends BaseClass {

	@FindBy(xpath = "//h6")
	WebElement dashboardText;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement profile;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	// Constructor
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}

	// Dashboard Verification
	public boolean dashboardVerify()
	{
		return ActionDriver.fetchText(dashboardText)
				.equals(ConstantValues.dashboardText);
	}

	// Logout Function
	public boolean logoutFunction()
	{
		boolean status1 = ActionDriver.buttonaction(profile);

		try {
			Thread.sleep(2000);
		}
		catch (Exception e) {

		}

		boolean status2 = ActionDriver.buttonaction(logout);

		return status1 && status2;
	}
}