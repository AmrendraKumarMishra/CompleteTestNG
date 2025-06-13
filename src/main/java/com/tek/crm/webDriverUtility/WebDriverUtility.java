package com.tek.crm.webDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void switchNewBrowserTab(WebDriver driver, String partialURL) {
		Set<String> Set = driver.getWindowHandles();
		Iterator<String> it = Set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actURL = driver.getCurrentUrl();

			if (actURL.contains(partialURL)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> Set = driver.getWindowHandles();
		Iterator<String> it = Set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getCurrentUrl();

			if (actTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebDriver driver, WebElement Frameelement) {
		driver.switchTo().frame(Frameelement);
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

//	Actions act;
//	
//	public WebDriverUtility() {
//		act = new Actions(null);
//	}

	public void mouseHover(WebDriver driver, WebElement element) {
	      Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	public void doubleClick(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void moveToElement(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void selectDropDownByIndex(WebElement DropDownelement, int index) {
		Select sc = new Select(DropDownelement);
		sc.selectByIndex(index);
	}

	public void selectDropDownByText(WebElement DropDownelement, String text) {
		Select sc = new Select(DropDownelement);
		sc.selectByVisibleText(text);
	}

	public void selectDropDownByValue(WebElement DropDownelement, String value) {
		Select sc = new Select(DropDownelement);
		sc.selectByValue(value);
	}

}