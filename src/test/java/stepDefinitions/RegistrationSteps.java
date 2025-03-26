package stepDefinitions;

import org.openqa.selenium.WebDriver; 

import basePackage.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import runnerPackage.TestRunner;

public class RegistrationSteps {

	BaseTest base = new BaseTest();
	String browser = TestRunner.browserName.get();

	RegistrationPage rp;
	WebDriver driver;

	@Given("User is on Demo Shop Home Page")
	public void user_is_on_demo_shop_home_page() {
		try {
			base.browserSetup(browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = base.getDriver();
		rp=new RegistrationPage(driver);
	}

	@When("user enters the registeration page")
	public void user_enters_the_registeration_page() {
		rp.navToRegisteration();
	}

	@When("^user enters fname(.*)$")
	public void user_enters_fname(String value) {
		rp.enterFirstName(value);
	}

	@When("^user enters lname(.*)$")
	public void user_enters_lname(String value) {
		rp.enterLastName(value);
	}
	@When("^user enters Email(.*)$")
	public void user_enters_email(String value) {
		rp.enterEmail(value);
	}
	@When("^user enters Pass(.*)$")
	public void user_enters_pass(String value) {
		rp.enterPassword(value);
	}

	@When("^user enters pass Confirmation(.*)$")
	public void user_enters_pass2(String value) {
		rp.enterPasswordConfirmation(value);
	}

	@Then("user clicks register button")
	public void user_clicks_register_button() {
		rp.clickRegister();
		rp.validateRegistration();
		base.teardown();
	}

	@When("^user enters invalid fname(.*)$")
	public void user_enters_invalid_fname(String value) {
		rp.enterFirstName(value);
	}

	@When("^user enters invalid lname(.*)$")
	public void user_enters_invalid_lname(String value) {
		rp.enterLastName(value);
	}

	@When("^user enters invalid Email(.*)$")
	public void user_enters_invalid_email(String value) {
		rp.enterEmail(value);
	}

	@When("^user enters invalid Pass(.*)$")
	public void user_enters_invalid_pass(String value) {
		rp.enterPassword(value);
	}
	

	@When("^user enters invalid pass Confirmation(.*)$")
	public void user_enters_invalid_pass2(String value) {
		rp.enterPasswordConfirmation(value);

	}
	
	@Then("user tries to register")
	public void user_tries_to_register() {
		rp.clickRegister();
		rp.validateRegistration();
		base.teardown();
	}

}
