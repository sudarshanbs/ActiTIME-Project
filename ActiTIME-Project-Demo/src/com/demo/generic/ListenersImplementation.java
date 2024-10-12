package com.demo.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenersImplementation extends BaseClass implements ITestListener
{
	@Override
	public void onTestStart(ITestResult result)
	{

	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String name = result.getName();

		System.out.println("The test '" + name + "' has passed.");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		String name = result.getName();

		System.out.println("The test '" + name + "' has failed!");

		TakesScreenshot screenShot = (TakesScreenshot) driver;

		File source = screenShot.getScreenshotAs(OutputType.FILE);

		File destination = new File("./Screenshots/" + name + ".png");

		try
		{
			FileUtils.copyFile(source, destination);
		}

		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}

		System.out.println("The test failed, and the screenshot has been captured!");
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String name = result.getName();

		System.out.println("The test '" + name + "' has been skipped.\n");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{

	}

	@Override
	public void onStart(ITestContext context)
	{

	}

	@Override
	public void onFinish(ITestContext context)
	{

	}
}
