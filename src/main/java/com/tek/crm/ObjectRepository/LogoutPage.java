package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement logoutButton;

	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutIcon() {
		return logoutIcon;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

}
