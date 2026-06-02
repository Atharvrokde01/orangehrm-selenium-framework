package action;

import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ActionDriver extends BaseClass {

	// Fetch Page Title
	public static String fetchTitle() {

		if (driver != null) {
			return driver.getTitle();
		}

		return null;
	}

	// Fetch Element Text
	public static String fetchText(WebElement ele) {

		try {

			if (ele != null && ele.isDisplayed()) {
				return ele.getText();
			}

		} catch (Exception e) {

			System.out.println("Unable to fetch text : " + e.getMessage());
		}

		return null;
	}

	// Enter Data
	public static boolean enterData(WebElement ele, String data) {

		try {

			if (ele != null && ele.isDisplayed() && ele.isEnabled()) {

				ele.clear();
				ele.sendKeys(data);

				return true;
			}

		} catch (Exception e) {

			System.out.println("Unable to enter data : " + e.getMessage());
		}

		return false;
	}

	// Button Action
	public static boolean buttonAction(WebElement ele) {

		try {

			if (ele != null && ele.isDisplayed() && ele.isEnabled()) {

				String type = ele.getAttribute("type");

				if (type != null && type.equalsIgnoreCase("submit")) {

					ele.submit();
				}

				else {

					ele.click();
				}

				return true;
			}

		} catch (Exception e) {

			System.out.println("Unable to perform button action : " + e.getMessage());
		}

		return false;
	}
}