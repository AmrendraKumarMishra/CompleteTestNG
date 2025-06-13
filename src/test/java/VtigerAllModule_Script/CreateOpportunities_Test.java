package VtigerAllModule_Script;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tek.crm.ObjectRepository.ContactPage;
import com.tek.crm.ObjectRepository.ContactVerificationPage;
import com.tek.crm.ObjectRepository.HomePage;
import com.tek.crm.ObjectRepository.OpportunitiesPage;
import com.tek.crm.ObjectRepository.OpportunitiesVerificationPage;
import com.tek.crm.ObjectRepository.OrganizationPage;
import com.tek.crm.ObjectRepository.OrganizationVerificationPage;
import com.tekPyramid.crm.BaseClassTest.BaseClass;

@Listeners(com.tekPyramid.crm.ListenerUtility.ListenerImplementationClass.class)
public class CreateOpportunities_Test extends BaseClass{
	@Test (groups = "SmokeTesting")
	public void createOpportunitiesWithContact_Test() throws IOException, InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.getContactModule().click();
		ContactPage cp = new ContactPage(driver);
		cp.getPlusIconContact().click();
		String lastName = eutil.getDataFromExcel("Sheet3", 3, 2) + jUtil.getDataFromJavaUtility("randomNumber");
		cp.getLastNameTF().sendKeys(lastName);
		cp.getSaveButton().click();

		ContactVerificationPage cvp = new ContactVerificationPage(driver);
		String actualContactWithLastName = cvp.getContactWithLastNameVerify().getText();
		
		Assert.assertEquals(actualContactWithLastName.trim(), lastName);

		hp.getOpportunitiesModule().click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.getOpportunitiesPlusIcon().click();
		String opportunityName = eutil.getDataFromExcel("Sheet3", 7, 2) + jUtil.getDataFromJavaUtility("randomNumber");
		op.getOpportunityNameTF().sendKeys(opportunityName);
		WebElement RelatedToDD = op.getRelatedToDD();
		wUtil.selectDropDownByIndex(RelatedToDD, 1);
		op.getRelatedToPlusIcon().click();

		wUtil.switchNewBrowserTab(driver,
				"http://49.249.28.218:8888/index.php?module=Accounts&action=Popup&html=Popup_picker&form=vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=");

		op.getOrgsearchTF().sendKeys(lastName);
		op.getSearchNowButton().click();

		driver.findElement(By.linkText(lastName)).click();
		wUtil.switchToTabOnTitle(driver, fUtil.getDataFromFileUtility("url"));
		op.getSaveButton().click();

		OpportunitiesVerificationPage opvp = new OpportunitiesVerificationPage(driver);
		String actualOpportunityName = opvp.getOpportunityNameWithOrgVerify().getText();
		Assert.assertEquals(actualOpportunityName.trim(), opportunityName);

	}
	
	@Test (groups = "RegressionTesting")
	public void createOpportunitiesWithOrgName_Test() throws IOException, InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.getOrganization().click();
		OrganizationPage org = new OrganizationPage(driver);
		org.getPlusIconOrg().click();
		String orgName = eutil.getDataFromExcel("Sheet3", 1, 2) + jUtil.getDataFromJavaUtility("randomNumber");
		org.getOrgNameTF().sendKeys(orgName);
		org.getSaveButton().click();
		OrganizationVerificationPage ovp = new OrganizationVerificationPage(driver);
		String actualOrgName = ovp.getVerifyOrgName().getText();
		Assert.assertEquals(actualOrgName, orgName);

		hp.getOpportunitiesModule().click();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.getOpportunitiesPlusIcon().click();
		String opportunityName = eutil.getDataFromExcel("Sheet3", 7, 2) + jUtil.getDataFromJavaUtility("randomNumber");
		op.getOpportunityNameTF().sendKeys(opportunityName);
		op.getRelatedToPlusIcon().click();

		wUtil.switchNewBrowserTab(driver,
				"http://49.249.28.218:8888/index.php?module=Accounts&action=Popup&html=Popup_picker&form=vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=");

		op.getOrgsearchTF().sendKeys(orgName);
		op.getSearchNowButton().click();

		driver.findElement(By.linkText(orgName)).click();
		wUtil.switchToTabOnTitle(driver, fUtil.getDataFromFileUtility("url"));
		op.getSaveButton().click();

		OpportunitiesVerificationPage opvp = new OpportunitiesVerificationPage(driver);
		String actualOpportunityName = opvp.getOpportunityNameWithOrgVerify().getText();
		Assert.assertEquals(actualOpportunityName.trim(), opportunityName);
	}
}
