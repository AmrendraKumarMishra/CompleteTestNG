package com.tek.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement opportunitiesPlusIcon;
	
	@FindBy(name = "potentialname")
	private WebElement OpportunityNameTF;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement relatedToPlusIcon;
	
	@FindBy(id = "search_txt")
	private WebElement OrgsearchTF;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchNowButton;
	
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[2]")
	private WebElement saveButton;
	
//	@FindBy(id = "search_txt")
//	private WebElement ContactsearchTF;
	
	@FindBy(id = "related_to_type")
	private WebElement relatedToDD;
	
	
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunitiesPlusIcon() {
		return opportunitiesPlusIcon;
	}

	public WebElement getOpportunityNameTF() {
		return OpportunityNameTF;
	}

	public WebElement getRelatedToPlusIcon() {
		return relatedToPlusIcon;
	}

	public WebElement getOrgsearchTF() {
		return OrgsearchTF;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getRelatedToDD() {
		return relatedToDD;
	}
	
	
	
	
	

}
