package testRunner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, features = "Features", monochrome = true, tags = {
				"@TC1" }, glue = { "com.stepDef" })
public class TestRunner {
	public static WebDriver driver;
	private TestNGCucumberRunner testRunner;

	@BeforeClass
	public void setUP() {
		testRunner = new TestNGCucumberRunner(TestRunner.class);
	}

	@Test(description = "BDD.Cucumber", dataProvider = "features")
	public void CucumberTest(CucumberFeatureWrapper cFeature) {
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}

	@DataProvider(name = "features")
	public Object[][] getFeatures() {
		return testRunner.provideFeatures();
	}

	@AfterClass
	public void tearDown() {
		testRunner.finish();
	}
}
