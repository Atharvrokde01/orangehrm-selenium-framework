package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
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
	public void start(@Optional("chrome") String browser) {

		setup(browser);

		lp = new LoginPage();
	}

	// Title Verification
	@Test(priority = 1)
	public void verifyTitle() {

		Assert.assertTrue(
				lp.verifyTitle(ConstantValues.LOGIN_PAGE_TITLE),
				"Title not matched");
	}

	// Login Text Verification
	@Test(priority = 2, dependsOnMethods = {"verifyTitle"})
	public void verifyLoginText() {

		Assert.assertTrue(
				lp.verifyText(ConstantValues.LOGIN_TEXT),
				"Text not matched");
	}

	// Login Functionality
	@Test(priority = 3, dependsOnMethods = {"verifyLoginText"})
	public void verifyLogin() {

		dp = lp.loginFunction(
				ConstantValues.USERNAME,
				ConstantValues.PASSWORD);

		Assert.assertNotNull(dp, "Login failed");

		Assert.assertTrue(
				dp.dashboardVerify(),
				"Dashboard not matched");
	}

	// Logout Functionality
	@Test(priority = 4, dependsOnMethods = {"verifyLogin"})
	public void verifyLogout() {

		Assert.assertTrue(
				dp.logoutFunction(),
				"Logout Failed");
	}

	// Browser Close
	@AfterClass
	public void close() {

		teardown();
	}
}