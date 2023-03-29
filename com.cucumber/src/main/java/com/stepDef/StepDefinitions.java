package com.stepDef;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.pageObjs.LoginPage;
import com.utilities.BasicsDriver;
import com.utilities.CommonUtility;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinitions {
	WebDriver driver;

	LoginPage lPage = new LoginPage();

	@Given("^Navigate to URL given in property file$")
	public void navigate_to_url_given_in_property_file() {
		CommonUtility.addInfo("<b style='color:blue'>Step Name: Navigate to URL given in property file</b>");
		BasicsDriver.navigateToUrl();
	}

	@And("User clicks Login Button")
	public void user_clicks_login_button() {
		CommonUtility.addInfo("<b style='color:blue'>Step Name: User clicks Login Button</b>");
		lPage.clickLoginButtons();
	}

	@And("User login with credentials")
	public void user_login_with_credentials() {
		CommonUtility.addInfo("<b style='color:blue'>Step Name: User login with credentials</b>");
		lPage.enterUserId("abcd");
	}

	@Then("User takes values from Data Table")
	public void user_takes_values_from_Data_Table(DataTable arg1) {
		List<List<String>> creds = arg1.raw();
		System.out.println(creds.get(0).get(0));
		System.out.println(creds.get(0).get(1));
	}

	@Given("^User navigate to the URL$")
	public void user_navigate_to_the_URL() {
		System.out.println("User navigate to the URL");
	}

	@And("^User clicks Login Button$")
	public void user_clicks_Login_Button() {
		System.out.println("User clicks Login Button");
	}

}
