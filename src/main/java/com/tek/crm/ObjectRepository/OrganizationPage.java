package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement plusIconOrg;

	@FindBy(name = "accountname")
	private WebElement orgNameTF;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(name = "accounttype")
	private WebElement TypeDD;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberTF;

	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeIcon;

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPlusIconOrg() {
		return plusIconOrg;
	}

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return TypeDD;
	}
	
	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}
	
	public WebElement getHomeIcon() {
		return homeIcon;
	}

	public void CreateOrg(String orgName) {
		plusIconOrg.click();
		orgNameTF.sendKeys(orgName);
		saveButton.click();

	}

}
