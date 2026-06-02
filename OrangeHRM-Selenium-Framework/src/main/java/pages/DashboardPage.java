package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.ActionDriver;
import base.BaseClass;
import base.ConstantValues;

public class DashboardPage extends BaseClass {

	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement dashboardText;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement profile;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	// Constructor
	public DashboardPage() {

		PageFactory.initElements(driver, this);
	}

	// Dashboard Verification
	public boolean dashboardVerify() {

		String actualText = ActionDriver.fetchText(dashboardText);

		return actualText != null &&
				actualText.equals(ConstantValues.DASHBOARD_TEXT);
	}

	// Logout Function
	public boolean logoutFunction() {

		boolean status1 = ActionDriver.buttonAction(profile);

		try {

			Thread.sleep(2000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		boolean status2 = ActionDriver.buttonAction(logout);

		return status1 && status2;
	}
}