package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicsDriver {
	static WebDriver driver;
	static ReadProFile read = new ReadProFile();
	static GetterSetter getSet = new GetterSetter();

	public static WebDriver launchDriver() {

		System.out.println("Browser name is: " + read.browserName());
		System.out.println("Driver Path is: " + read.getDriverPath());

		if (read.browserName().equalsIgnoreCase("Edge")) {
//			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + read.getDriverPath());
			driver = new EdgeDriver();
		} else if (read.browserName().equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();

		getSet.setDriver(driver);

		return driver;
	}

	public void click_Element(WebElement ele) {
		ele.click();
	}

	public static void navigateToUrl() {
		System.out.println("Entire driver path: " + System.getProperty("user.dir") + read.getDriverPath());
		getSet.getDriver().get(read.getUrl());
	}
}
