package com.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.Reporter;

public class CommonUtility extends BasicsDriver {

//	to create HTML file
	static ExtentHtmlReporter htmlReporter;
//	to build ur Report
	static ExtentReports report = null;
//	to add ur information into the Report
	static ExtentTest logger = null;

//	obj is to store screenshot name
	static String fileNameToBeAdded = null;

	/**
	 * Method is to take screenshot. Please mention Screenshot name
	 * 
	 * @param screenshotName
	 * @author 91822
	 */
	public static String takeScreenshot(String screenshotName) {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + File.separator
					+ "\\Reports\\Screenshots\\" + screenshotName + ".png"));

			fileNameToBeAdded = System.getProperty("user.dir") + File.separator + "\\Reports\\Screenshots\\"
					+ screenshotName + ".png";

			System.out.println("Path of the screenshot: " + fileNameToBeAdded);

			fileNameToBeAdded = "./Screenshots/" + screenshotName + ".png";

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileNameToBeAdded;
	}
	
	public static String takeScreenshot_cucumberApi(String screenshotName) {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + File.separator
					+ "\\target\\cucumber-reports\\Screenshots\\" + screenshotName + ".png"));

			fileNameToBeAdded = System.getProperty("user.dir") + File.separator + "\\target\\cucumber-reports\\Screenshots\\"
					+ screenshotName + ".png";

			System.out.println("Path of the screenshot: " + fileNameToBeAdded);

			fileNameToBeAdded = "./Screenshots/" + screenshotName + ".png";
			
			Reporter.addScreenCaptureFromPath(fileNameToBeAdded);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileNameToBeAdded;
	}

	public static void generateExtentReports(String sName) {
		htmlReporter = new ExtentHtmlReporter("./Reports/HtmlReport.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		logger = report.createTest(sName);
//		report.flush();
	}

	public static void flushReport() {
		report.flush();
	}

	public static void addInfo(String message) {
		logger.info(message);
	}

	public static void reportPass(String message) {
		logger.log(Status.PASS, message);
	}

	public static void reportFail(String message) {
		logger.log(Status.FAIL, message);
	}

	public static void completeExtentReport() {
		report.flush();
	}

	public static void addScreenshotToReport(String screenShotName) {
		try {
			logger.addScreenCaptureFromPath(takeScreenshot(screenShotName));
			takeScreenshot_cucumberApi(screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void failTestCase(String expMsg, String actMsg) {

		if (expMsg.equalsIgnoreCase(actMsg)) {
			addInfo(actMsg);
		} else {
			reportFail("Failig the test case because of mismatch in the exp & act.");
			addScreenshotToReport("FailedScreenshot");
			Assert.fail("Failig the test case because of mismatch in the exp & act.");
		}

	}

	public static void clickGivenElement(WebElement ele) {
		addInfo("Given clickable element name is: " + ele.getText());
		ele.click();
		addInfo("Given Element is clicked.");
	}

	public static void closeDriver() {
		driver.close();
	}
}