package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import base.ConstantValues;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage lp;

	DashboardPage dp;

	// Browser Setup
	@BeforeClass
	@Parameters({"browser"})
	public void start(String browser)
	{
		setup(browser);

		lp = new LoginPage();
	}

	// Title Verification
	@Test(priority = 1)
	public void titleCheck()
	{
		Assert.assertTrue(
				lp.titleverify(ConstantValues.loginPageTitle),
				"Title not matched"
				);
	}

	// Login Text Verification
	@Test(priority = 2,
	dependsOnMethods = {"titleCheck"})
	public void textCheck()
	{
		Assert.assertTrue(
				lp.textverify(ConstantValues.loginText),
				"Text not matched"
				);
	}

	// Login Functionality
	@Test(priority = 3,
	dependsOnMethods = {"textCheck"})
	public void loginCheck()
	{
		dp = lp.loginfunction(
				ConstantValues.username,
				ConstantValues.password
				);

		Assert.assertTrue(
				dp.dashboardVerify(),
				"Dashboard not matched"
				);
	}

	// Logout Functionality
	@Test(priority = 4,
	dependsOnMethods = {"loginCheck"})
	public void logoutCheck()
	{
		Assert.assertTrue(
				dp.logoutFunction(),
				"Logout Failed"
				);
	}

	// Browser Close
	@AfterClass
	public void close()
	{
		teardown();
	}
}