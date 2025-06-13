package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Organizations")
	private WebElement organizationModule;

	@FindBy(linkText = "Contacts")
	private WebElement ContactModule;

	@FindBy(linkText = "Products")
	private WebElement productModule;

	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesModule;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganization() {
		return organizationModule;
	}

	public WebElement getContactModule() {
		return ContactModule;
	}

	public WebElement getProductModule() {
		return productModule;
	}

	public WebElement getOpportunitiesModule() {
		return OpportunitiesModule;
	}
}
