package com.demo.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.demo.pom.LoginPage;
import com.demo.pom.TaskListPage;

public class BaseClass
{
	public static WebDriver driver;
	public static WebDriverUtility utility;
	public static FileLib library;

	@BeforeTest
	public void openBrowser() throws Exception
	{
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		library = new FileLib();

		String url = library.getPropertiesFileData("URL");
		driver.get(url);
	}

	@BeforeMethod
	public void login() throws Exception
	{
		utility = new WebDriverUtility();

		utility.verifyTitle("Login");

		LoginPage lp = new LoginPage(driver);

		String un = library.getPropertiesFileData("Username");
		String pw = library.getPropertiesFileData("Password");

		lp.setLogin(un, pw);

		Reporter.log("Logging in to the ActiTIME website.", true);
	}

	@AfterMethod
	public void logout()
	{
		TaskListPage tlp = new TaskListPage(driver);
		tlp.setLogout();

		Reporter.log("Logging out of the ActiTIME website.\n", true);
	}

	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}