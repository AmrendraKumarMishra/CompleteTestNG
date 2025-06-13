package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactVerificationPage {

	@FindBy(id = "mouseArea_Last Name")
	private WebElement ContactWithLastNameVerify;

	@FindBy(id = "mouseArea_Support Start Date")
	private WebElement SupportStartDateVerify;
	
	@FindBy(id = "mouseArea_Support End Date")
	private WebElement SupportEndDateVerify;

	public ContactVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactWithLastNameVerify() {
		return ContactWithLastNameVerify;
	}

	public WebElement getSupportStartDateVerify() {
		return SupportStartDateVerify;
	}

	public WebElement getSupportEndDateVerify() {
		return SupportEndDateVerify;
	}
	

}
