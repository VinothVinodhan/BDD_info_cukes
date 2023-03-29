package com.stepDef;

import com.utilities.BasicsDriver;
import com.utilities.CommonUtility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public static Scenario scenario;

	@Before
	public void beforeScenario(Scenario sc) {
		Hooks.scenario = sc;
		CommonUtility.generateExtentReports(sc.getName());
		CommonUtility.addInfo("I am Before steps from Hooks.");
		BasicsDriver.launchDriver();
	}

	@After
	public void afterSteps() {
		CommonUtility.closeDriver();
		CommonUtility.addInfo("I am After steps from Hooks.");
		CommonUtility.flushReport();
	}
}
