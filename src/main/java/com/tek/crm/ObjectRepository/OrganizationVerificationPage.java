package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationVerificationPage {

	@FindBy(id = "dtlview_Organization Name")
	private WebElement VerifyOrgName;

	@FindBy(id = "dtlview_Industry")
	private WebElement industryVerify;

	@FindBy(id = "dtlview_Type")
	private WebElement typeVerify;
	
	@FindBy(id = "mouseArea_Phone")
	private WebElement phoneNumberVerify;

	public OrganizationVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVerifyOrgName() {
		return VerifyOrgName;

	}

	public WebElement getIndustryVerify() {
		return industryVerify;
	}

	public WebElement getTypeVerify() {
		return typeVerify;
	}
	
	public WebElement getPhoneNumberVerify() {
		return phoneNumberVerify;
	}

}
