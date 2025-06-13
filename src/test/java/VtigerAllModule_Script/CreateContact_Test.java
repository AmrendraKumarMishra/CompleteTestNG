package VtigerAllModule_Script;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tek.crm.ObjectRepository.ContactPage;
import com.tek.crm.ObjectRepository.ContactVerificationPage;
import com.tek.crm.ObjectRepository.HomePage;
import com.tek.crm.ObjectRepository.OrganizationPage;
import com.tek.crm.ObjectRepository.OrganizationVerificationPage;
import com.tekPyramid.crm.BaseClassTest.BaseClass;

@Listeners(com.tekPyramid.crm.ListenerUtility.ListenerImplementationClass.class)
public class CreateContact_Test extends BaseClass {
	@Test(groups = "SmokeTesting")
	public void createContact_Test() throws IOException, ParseException {

		int randomNumber = jUtil.getDataFromJavaUtility("randomNumber");
		String lastName = eutil.getDataFromExcel("Sheet3", 3, 2) + randomNumber;


		// create contact
		HomePage hp = new HomePage(driver);
		hp.getContactModule().click();
		ContactPage cp = new ContactPage(driver);
		cp.getPlusIconContact().click();
		cp.getLastNameTF().sendKeys(lastName);
		cp.getSaveButton().click();

		// verify created contact
		ContactVerificationPage cvp = new ContactVerificationPage(driver);
		String actualLastname = cvp.getContactWithLastNameVerify().getText();
		
		Assert.assertEquals(actualLastname.trim(), lastName);

	}

	@Test(groups = "RegressionTesting")
	public void selectOrgInContact_Test() throws IOException, ParseException {

		int randomNumber = jUtil.getDataFromJavaUtility("randomNumber");
		String lastName = eutil.getDataFromExcel("Sheet3", 3, 2) + randomNumber;
		String orgName = eutil.getDataFromExcel("Sheet3", 3, 3) + randomNumber;

		// create organization

		HomePage hp = new HomePage(driver);
		hp.getOrganization().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.CreateOrg(orgName);

		/* Verify organization */
		OrganizationVerificationPage ovp = new OrganizationVerificationPage(driver);
		String actualOrgName = ovp.getVerifyOrgName().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualOrgName, orgName);
		soft.assertAll();

		// Create contact and select orgainzation

		hp.getContactModule().click();

		String parentId = driver.getWindowHandle();
		ContactPage cp = new ContactPage(driver);
		cp.getPlusIconContact().click();
		cp.getLastNameTF().sendKeys(lastName);
		cp.getOrgnizationAddIcon().click();

		wUtil.switchNewBrowserTab(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popu");
		cp.getOrgSearchTF().sendKeys(orgName);
		cp.getOrgSearchNowButton().click();

		driver.findElement(By.linkText(orgName)).click();
		// Switch back to parent window
		wUtil.switchToTabOnTitle(driver, parentId);
 
		// save the contact

		cp.getSaveButton().click();
	}

	@Test(groups = "RegressionTesting")
	public void contactWithSupportDate_Test() throws EncryptedDocumentException, IOException, ParseException {

		String lastName = eutil.getDataFromExcel("Sheet3", 3, 2) + jUtil.getDataFromJavaUtility("randomNumber");
		String startDate = jUtil.getSystemDateYYYYDDMM();
		String endDate = jUtil.getRequiredDateYYYYDDMM(30);

		// create contact
		HomePage hp = new HomePage(driver);
		hp.getContactModule().click();
		ContactPage cp = new ContactPage(driver);
		cp.getPlusIconContact().click();
		cp.getLastNameTF().sendKeys(lastName);
		WebElement sdateEle = cp.getStartDateTF();
		WebElement EdateEle = cp.getEndDateTF();

		sdateEle.clear();
		sdateEle.sendKeys(startDate);
		EdateEle.clear();
		EdateEle.sendKeys(endDate);
		cp.getSaveButton().click();

		// verify create contact
		ContactVerificationPage cvp = new ContactVerificationPage(driver);
		String actualLastname = cvp.getContactWithLastNameVerify().getText();

		System.out.println(actualLastname);
		Assert.assertEquals(actualLastname.trim(), lastName);

		String actualStartDate = cvp.getSupportStartDateVerify().getText();
		String actualEndDate = cvp.getSupportEndDateVerify().getText();
		
		Assert.assertEquals(actualStartDate.trim(), startDate);
		Assert.assertEquals(actualEndDate.trim(), endDate);
	}

}
