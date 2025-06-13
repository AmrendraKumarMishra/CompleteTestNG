package com.tekPyramid.crm.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tek.crm.genericUtility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("===OnStart get implemented===");
		// Spark report configuration
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report" + time + ".html");
		spark.config().setDocumentTitle("CRM Test suite result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);

		// add environment information and create Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating system", "Window-10");
		report.setSystemInfo("Browser", "Chrome-100");

	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath, TestName + "_" + time);
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "===Failed===");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===" + result.getMethod().getMethodName() + "===START===");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + "===STARTED===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===" + result.getMethod().getMethodName() + "===END===");
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName());
	}

}
