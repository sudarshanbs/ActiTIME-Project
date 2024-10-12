package com.demo.testscript;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.generic.BaseClass;
import com.demo.pom.HomePage;
import com.demo.pom.TaskListPage;

@Listeners (com.demo.generic.ListenersImplementation.class)
public class CustomerModule extends BaseClass
{
	@Test
	public void createCustomer() throws Exception
	{
		String expectedCustomerName = library.getExcelFileData("Create Customer", 1, 2);

		String customerDescription = library.getExcelFileData("Create Customer", 1, 3);
		Thread.sleep(1000);

		utility.verifyTitle("Enter Time-Track");

		HomePage hp = new HomePage(driver);
		Thread.sleep(1000);

		hp.setTask();

		utility.verifyTitle("Task List");
		Thread.sleep(1000);

		TaskListPage tlp = new TaskListPage(driver);

		tlp.getAddNewButton().click();
		Thread.sleep(1000);

		tlp.getNewCustomerButton().click();
		Thread.sleep(1000);

		tlp.getCustomerNameTextField().sendKeys(expectedCustomerName);
		Thread.sleep(1000);

		tlp.getCustomerDescriptionTextArea().sendKeys(customerDescription);
		Thread.sleep(1000);

		tlp.getCompanyDropdown().click();
		Thread.sleep(1000);

		tlp.getOurCompanyOption().click();
		Thread.sleep(1000);

		tlp.getCreateCustomerButton().click();
		Thread.sleep(1000);

		String actualCustomerName = tlp.getCreatedCustomerName().getText();
		Thread.sleep(1000);

		Assert.assertEquals(actualCustomerName, expectedCustomerName);
	}
}
