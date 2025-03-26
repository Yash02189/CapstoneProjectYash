package stepDefinitions;

import org.openqa.selenium.WebDriver;

import basePackage.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import runnerPackage.TestRunner;

public class LoginSteps {
	String browser = TestRunner.browserName.get();
	BaseTest base = new BaseTest();
	LoginPage login;
	WebDriver driver;

	@Given("user is on Demo Shop Home Page")
	public void User_is_on_demo_shop_home_page() {
		try {
			base.browserSetup(browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = base.getDriver();
		login = new LoginPage(driver);
		login.navigateToLoginPage();
	}

	@When("^user enters email(.*)$")
	public void user_enter_credentials(String email) {
		login.enterEmail(email);

	}

	@When("^user enters password(.*)$")
	public void user_enter_credentials2(String password) {
		login.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		login.clickLogin();
	}

	@Then("user logged in!")
	public void user_logged_in() {
		login.validateLogin(driver.getTitle());
		base.teardown();
	}

}
