package com.demo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage
{
	@FindBy(className = "addNewButton")
	private WebElement addNewButton;

	@FindBy(xpath = "//div[text()='+ New Customer']")
	private WebElement newCustomerButton;

	@FindBy(id = "customerLightBox_nameField")
	private WebElement customerNameTextField;

	@FindBy(id = "customerLightBox_descriptionField")
	private WebElement customerDescriptionTextArea;

	@FindBy(xpath = "//button[contains(text(),'Select an active customer ')]")
	private WebElement companyDropdown;

	@FindBy(xpath = "//a[text()='Our Company']")
	private WebElement optionOurCompany;

	@FindBy(xpath = "//div[@id='customerLightBox_commitBtn']")
	private WebElement createCustomerButton;

	@FindBy(xpath = "//div[@class='tasksTable hasSelectedCustomer']/div[@class='header']/div[@class='title ellipsis']")
	private WebElement createdCustomerName;

	@FindBy(id = "logoutLink")
	private WebElement logoutButton;


	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setLogout()
	{
		logoutButton.click();
	}

	public WebElement getAddNewButton()
	{
		return addNewButton;
	}

	public WebElement getNewCustomerButton()
	{
		return newCustomerButton;
	}

	public WebElement getCustomerNameTextField()
	{
		return customerNameTextField;
	}

	public WebElement getCustomerDescriptionTextArea()
	{
		return customerDescriptionTextArea;
	}

	public WebElement getCompanyDropdown()
	{
		return companyDropdown;
	}

	public WebElement getOurCompanyOption()
	{
		return optionOurCompany;
	}

	public WebElement getCreateCustomerButton()
	{
		return createCustomerButton;
	}

	public WebElement getCreatedCustomerName()
	{
		return createdCustomerName;
	}
}
