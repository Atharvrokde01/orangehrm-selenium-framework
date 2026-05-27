package action;

import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ActionDriver extends BaseClass {

	// Fetch Page Title
	public static String fetchTitle()
	{
		if(driver != null)
		{
			return driver.getTitle();
		}

		else
		{
			return null;
		}
	}

	// Fetch Text
	public static String fetchText(WebElement ele)
	{
		if(ele != null)
		{
			return ele.getText();
		}

		else
		{
			return null;
		}
	}

	// Enter Data
	public static boolean enterData(WebElement ele, String data)
	{
		if(ele != null)
		{
			if(ele.isDisplayed() && ele.isEnabled())
			{
				ele.sendKeys(data);
				return true;
			}
		}

		return false;
	}

	// Button Action
	public static boolean buttonaction(WebElement ele)
	{
		if(ele != null)
		{
			String type = ele.getAttribute("type");

			if(type != null && type.equals("submit"))
			{
				ele.submit();
				return true;
			}

			else
			{
				ele.click();
				return true;
			}
		}

		else
		{
			return false;
		}
	}
}