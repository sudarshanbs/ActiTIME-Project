package com.demo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	@FindBy(xpath = "//a[contains(.,'TASKS')]")
	private WebElement taskTab;


	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setTask()
	{
		taskTab.click();
	}
}
