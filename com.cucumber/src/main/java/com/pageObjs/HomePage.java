package com.pageObjs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.CommonUtility;
import com.utilities.GetterSetter;

public class HomePage {

	GetterSetter getSet = new GetterSetter();
	WebDriver homePageDriver;
	String a;

	public HomePage() {
		this.homePageDriver = getSet.getDriver();
	}

	/**
	 * This method is to read all the links
	 * 
	 * @author 91822
	 */

	public void readQuickLinks() {
		List<WebElement> quickLinks = homePageDriver
				.findElements(By.xpath("(//div[@class='view-content'])[1]//div[@class='field--item']"));
		for (WebElement xyz : quickLinks) {
			System.out.println(xyz.getText());
			CommonUtility.addInfo(xyz.getText());

			if (xyz.getText().equalsIgnoreCase("e- Verify Return")) {
				CommonUtility.reportPass("Link name is matching with e- Verify Return.");
			} else {
				CommonUtility.reportFail("Link name is not matching with e- Verify Return.");
			}

			CommonUtility.failTestCase("e- Verify Return", xyz.getText());
		}

		System.out.println("*****");
		for (int i = 1; i <= quickLinks.size(); i++) {
			WebElement quickLink = homePageDriver
					.findElement(By.xpath("((//div[@class='view-content'])[1]//div[@class='field--item'])[" + i + "]"));
			System.out.println(quickLink.getText());
		}
	}

	public void clickLoginBtn() {
		WebElement loginBtn = homePageDriver.findElement(By.xpath("(//a[contains(text(),'Login')])[1]"));
		System.out.println("Link/Button name is: " + loginBtn.getText());
		CommonUtility.clickGivenElement(loginBtn);
		System.out.println("User clicked Login button/link.");
		CommonUtility.takeScreenshot("LoginPage");
	}

}
