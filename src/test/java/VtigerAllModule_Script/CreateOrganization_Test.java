package VtigerAllModule_Script;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tek.crm.ObjectRepository.HomePage;
import com.tek.crm.ObjectRepository.OrganizationPage;
import com.tek.crm.ObjectRepository.OrganizationVerificationPage;
import com.tekPyramid.crm.BaseClassTest.BaseClass;

@Listeners(com.tekPyramid.crm.ListenerUtility.ListenerImplementationClass.class)
public class CreateOrganization_Test extends BaseClass {
	@Test (groups = "SmokeTesting")
	public void orgainzation_Test() throws FileNotFoundException, IOException, ParseException {

		int randomNumber = jUtil.getDataFromJavaUtility("randomNumber");
		String orgName = eutil.getDataFromExcel("Sheet3", 1, 2) + randomNumber;

		HomePage hp = new HomePage(driver);
		hp.getOrganization().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.CreateOrg(orgName);

		// Verify organization
		OrganizationVerificationPage ovp = new OrganizationVerificationPage(driver);
		String actualOrgName = ovp.getVerifyOrgName().getText();
		// String actualOrgName = driver.findElement(By.id("dtlview_Organization
		// Name")).getText();
		
		Assert.assertEquals(actualOrgName, orgName);
//		if (actualOrgName.equals(orgName)) {
//			System.out.println(orgName + " is created successfully==== PASS");
//		} else {
//			System.out.println(orgName + " is not created successfully==== Fail");
//		}

	}

	@Test(groups = "RegressionTesting")
	public void orgWith_IndustryAdType_Test() throws FileNotFoundException, IOException, ParseException {

		int randomNumber = jUtil.getDataFromJavaUtility("randomNumber");
		String orgName = eutil.getDataFromExcel("Sheet3", 1, 2) + randomNumber;
		String industry = eutil.getDataFromExcel("Sheet3", 1, 3).toString();
		String type = eutil.getDataFromExcel("Sheet3", 1, 4).toString();

		HomePage hp = new HomePage(driver);
		hp.getOrganization().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getPlusIconOrg().click();
		op.getOrgNameTF().sendKeys(orgName);
		//wUtil.switchToAlertAndAccept(driver);
		WebElement industrySel = op.getIndustryDD();
		WebElement typeSel = op.getTypeDD();

		wUtil.selectDropDownByValue(industrySel, industry);
		wUtil.selectDropDownByValue(typeSel, type);
		op.getSaveButton().click();
		

		OrganizationVerificationPage ovp = new OrganizationVerificationPage(driver);
		
		// Verifying with Hard assert in Boolean form
		String actualIndustryName = ovp.getIndustryVerify().getText();
		boolean industryVerify = actualIndustryName.contains(industry);
		Assert.assertEquals(industryVerify, true);
		
		String actualType = ovp.getTypeVerify().getText();
		boolean TypeVerify = actualType.contains(type);
		Assert.assertEquals(TypeVerify, true);
		
		

//		if (actualIndustryName.equals(industry)) {
//			System.out.println(industry + " is Selected successfully==== PASS");
//		} else {
//			System.out.println(industry + " is not selected successfully==== Fail");
//		}
//
//		if (actualType.equals(type)) {
//			System.out.println(type + " is Selected successfully==== PASS");
//		} else {
//			System.out.println(type + " is not selected successfully==== Fail;");
//		}
	}

	@Test(groups = "RegressionTesting")
	public void orgWithNumber_Test() throws FileNotFoundException, IOException, ParseException {

		int randomNumber = jUtil.getDataFromJavaUtility("randomNumber");
		String orgName = eutil.getDataFromExcel("Sheet3", 1, 2) + randomNumber;
		String number = eutil.getDataFromExcel("Sheet3", 1, 5).toString();

		HomePage hp = new HomePage(driver);
		hp.getOrganization().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getPlusIconOrg().click();
		op.getOrgNameTF().sendKeys(orgName);

		// Enter mobile number
		op.getPhoneNumberTF().sendKeys(number);
		op.getSaveButton().click();
		System.out.println(number);
		
		OrganizationVerificationPage ovp = new OrganizationVerificationPage(driver);
		String actualNumber = ovp.getPhoneNumberVerify().getText();
		//System.out.println(actualNumber);
		Reporter.log(actualNumber, true);
		
		Assert.assertEquals(actualNumber.trim(), number);

//		if (number.equals(actualNumber.trim())) {
//			System.out.println(number + " is added successfully==== PASS");
//		} else
//			System.out.println(number + " not added=== fail");

	}

}
