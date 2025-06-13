package VtigerAllModule_Script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tek.crm.ObjectRepository.HomePage;
import com.tek.crm.ObjectRepository.ProductPage;
import com.tek.crm.ObjectRepository.ProductVerificationPage;
import com.tekPyramid.crm.BaseClassTest.BaseClass;

@Listeners(com.tekPyramid.crm.ListenerUtility.ListenerImplementationClass.class)
public class CreateProduct_Test extends BaseClass {
	@Test(groups = "SmokeTesting", retryAnalyzer = com.tekPyramid.crm.ListenerUtility.RetryListenerImplementation.class)
	public void createProduct_Test() throws IOException {

		HomePage hp = new HomePage(driver);
		hp.getProductModule().click();

		ProductPage pp = new ProductPage(driver);
		pp.getProductPlusIcon().click();
		String productName = eutil.getDataFromExcel("sheet3", 5, 2) + jUtil.getDataFromJavaUtility("randomNumber");
		pp.getProductNameTF().sendKeys(productName);
		pp.getSaveButton().click();

		ProductVerificationPage pvp = new ProductVerificationPage(driver);
		String actProductName = pvp.getVerifyProductName().getText();

		// Soft assert in string format
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actProductName.trim(), productName);
		soft.assertAll();

	}

	@Test(groups = "RegressionTesting")
	public void createProductWithSalesStartDate_Test() throws IOException {

		HomePage hp = new HomePage(driver);
		hp.getProductModule().click();

		ProductPage pp = new ProductPage(driver);
		pp.getProductPlusIcon().click();
		String productName = eutil.getDataFromExcel("sheet3", 5, 2) + jUtil.getDataFromJavaUtility("randomNumber");
		pp.getProductNameTF().sendKeys(productName);
		String currentDate = jUtil.getSystemDateYYYYDDMM();
		pp.getSalesStartDateTF().sendKeys(currentDate);
		String salesEndDate = jUtil.getRequiredDateYYYYDDMM(60);
		pp.getSalesEndDateTF().sendKeys(salesEndDate);
		pp.getSaveButton().click();

		ProductVerificationPage pvp = new ProductVerificationPage(driver);
		String actProductName = pvp.getVerifyProductName().getText();

		// Hard Assert
		Assert.assertEquals(actProductName.trim(), productName);

		String actSalesStartDate = pvp.getVerifysalesStartDate().getText();

		// Soft assert with log message
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actSalesStartDate.trim(), currentDate, currentDate + " is created successfully==== PASS");
		soft.assertAll();

		String actSalesEndDate = pvp.getVerifySalesEndDate().getText();

		// soft assert in boolean form
		boolean salesEndDateVerify = actSalesEndDate.contains(salesEndDate);
		soft.assertEquals(salesEndDateVerify, true);
		soft.assertAll();
	}
}
