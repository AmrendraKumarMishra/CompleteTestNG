package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement productPlusIcon;

	@FindBy(name = "productname")
	private WebElement productNameTF;

	@FindBy(xpath = "(//input[@class='crmbutton small save'])[2]")
	private WebElement saveButton;

	@FindBy(name = "sales_start_date")
	private WebElement salesStartDateTF;
	
	@FindBy(name = "sales_end_date")
	private WebElement salesEndDateTF;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductPlusIcon() {
		return productPlusIcon;
	}

	public WebElement getProductNameTF() {
		return productNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSalesStartDateTF() {
		return salesStartDateTF;
	}

	public WebElement getSalesEndDateTF() {
		return salesEndDateTF;
	}
	

}
