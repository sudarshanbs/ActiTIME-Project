package com.demo.generic;

import org.testng.Assert;
import org.testng.Reporter;

public class WebDriverUtility extends BaseClass
{
	public void verifyTitle(String expectedTitle)
	{
		String actualTitle = driver.getTitle();

		boolean title = actualTitle.contains(expectedTitle);

		Assert.assertTrue(title, "The title does not match!");

		Reporter.log("\nThe '" + actualTitle + "' page is displayed.", true);
	}
}
