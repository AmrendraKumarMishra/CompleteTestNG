package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesVerificationPage {
	@FindBy(id = "mouseArea_Opportunity Name")
	private WebElement opportunityNameWithOrgVerify;
	
	public OpportunitiesVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityNameWithOrgVerify() {
		return opportunityNameWithOrgVerify;
	}
	

}
