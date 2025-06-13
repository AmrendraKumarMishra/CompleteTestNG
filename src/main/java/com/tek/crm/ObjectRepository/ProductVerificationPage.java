package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductVerificationPage {

	@FindBy(id = "mouseArea_Product Name")
	private WebElement verifyProductName;

	@FindBy(id = "mouseArea_Sales Start Date")
	private WebElement VerifysalesStartDate;
	
	@FindBy(id="mouseArea_Sales End Date")
	private WebElement VerifySalesEndDate;

	public ProductVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVerifyProductName() {
		return verifyProductName;
	}

	public WebElement getVerifysalesStartDate() {
		return VerifysalesStartDate;
	}

	public WebElement getVerifySalesEndDate() {
		return VerifySalesEndDate;
	}

}
