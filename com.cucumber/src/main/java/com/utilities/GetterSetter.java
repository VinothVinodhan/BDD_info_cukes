package com.utilities;

import org.openqa.selenium.WebDriver;

public class GetterSetter {
	static WebDriver driver = null;

	public void setDriver(WebDriver driver) {
		GetterSetter.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
}
