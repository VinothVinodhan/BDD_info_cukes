package com.pageObjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.utilities.BasicsDriver;
import com.utilities.CommonUtility;
import com.utilities.GetterSetter;

public class LoginPage extends BasicsDriver {
	WebDriver loginPagedriver;
	GetterSetter getSet = new GetterSetter();

	String userIdXpath = "//input[@id='panAdhaarUserId' and @name='panAdhaarUserId']";
	String loginBtnXpath = "(//a[contains(text(),'Logi')])[1]";

	public LoginPage() {
		this.loginPagedriver = getSet.getDriver();
	}

	public void enterUserId(String userName) {
		loginPagedriver.findElement(By.xpath(userIdXpath)).click();
		loginPagedriver.findElement(By.xpath(userIdXpath)).sendKeys(userName);
		loginPagedriver.findElement(By.xpath(userIdXpath)).click();
		loginPagedriver.findElement(By.xpath(userIdXpath)).sendKeys(userName);
		loginPagedriver.findElement(By.xpath(userIdXpath)).click();

		click_Element(loginPagedriver.findElement(By.xpath(userIdXpath)));

		Reporter.addScenarioLog("User entered User ID in text field.");

		CommonUtility.addInfo("User entered User ID in text field.");
//		Take screenshot

		CommonUtility.addScreenshotToReport("EnteredUaerIDToBeAdded");
		

	}

	public void clickLoginButtons() {
		Reporter.addScenarioLog(
				"Button to get login steps is: " + loginPagedriver.findElement(By.xpath(loginBtnXpath)).getText());
		CommonUtility.addInfo(
				"Button to get login steps is: " + loginPagedriver.findElement(By.xpath(loginBtnXpath)).getText());
		CommonUtility.addScreenshotToReport("LoginButton");
		loginPagedriver.findElement(By.xpath(loginBtnXpath)).click();

	}
}
