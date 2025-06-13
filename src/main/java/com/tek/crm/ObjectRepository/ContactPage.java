package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement plusIconContact;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTF;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveButton;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement OrgnizationAddIcon;
	
	@FindBy(id = "search_txt")
	private WebElement orgSearchTF;
	
	@FindBy(name = "search")
	private WebElement orgSearchNowButton;
	
	@FindBy(name = "support_start_date")
	private WebElement startDateTF;
	
	@FindBy(name = "support_end_date")
	private WebElement endDateTF;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getPlusIconContact() {
		return plusIconContact;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOrgnizationAddIcon() {
		return OrgnizationAddIcon;
	}

	public WebElement getOrgSearchTF() {
		return orgSearchTF;
	}

	public WebElement getOrgSearchNowButton() {
		return orgSearchNowButton;
	}

	public WebElement getStartDateTF() {
		return startDateTF;
	}

	public WebElement getEndDateTF() {
		return endDateTF;
	}
	
	
}
