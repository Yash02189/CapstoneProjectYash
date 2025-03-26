package stepDefinitions;

import org.openqa.selenium.WebDriver;

import basePackage.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogoutPage;
import runnerPackage.TestRunner;

public class LogoutSteps {
	String browser = TestRunner.browserName.get();
	BaseTest base = new BaseTest();
	LogoutPage logout;
	WebDriver driver;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		try {
			base.browserSetup(browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = base.getDriver();
		logout=new LogoutPage(driver);
	}

	@When("^user enters valid email(.*)$")
	public void user_entersvoroh47402_isorax_com(String value) {
		logout.enterEmail(value);
	}

	@When("^user enters valid pass(.*)$")
	public void user_enters_welcome_demo(String value) {
		logout.enterPass(value);
	}

	@When("user clicks on logout button")
	public void user_clicks_on_logout_button() {
		logout.clickLogout();
	}

	@Then("user is logged out")
	public void user_is_logged_out() {
		logout.validateLogout();
		base.teardown();
	}

}
