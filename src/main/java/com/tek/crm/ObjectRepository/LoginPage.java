package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameTextField;

	@FindBy(name = "user_password")
	private WebElement passwordTextField;

	@FindBy(id = "submitButton")
	private WebElement loginButton;

	
	public WebElement getUsername() {
		return getUsername();
	}

	public WebElement getPassword() {
		return getPassword();
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginToApp(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

}
