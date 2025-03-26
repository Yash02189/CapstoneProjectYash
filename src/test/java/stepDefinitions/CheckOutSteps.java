package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import basePackage.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import runnerPackage.TestRunner;

public class CheckOutSteps {
	String browser = TestRunner.browserName.get();
	BaseTest base = new BaseTest();
	CheckOutPage cop;

	@Given("user is home page of demo web shop")
	public void user_is_home_page_of_demo_web_shop() {
		try {
			base.browserSetup(browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		WebDriver driver = base.getDriver();
		cop = new CheckOutPage(driver);
	}

	@When("user gives email")
	public void user_gives_email_voroh47402_isorax_com() {
		cop.enterEmail(base.username.get());
	}

	@When("user gives password")
	public void user_gives_password_welcome_demo() {
		cop.enterPass(base.password.get());
	}

	@When("user adds product to cart")
	public void user_adds_product_to_cart() {
		cop.addProductToCart();
	}

	@When("user checksout")
	public void user_checksout() {
		cop.checkOut();
	}

	@When("user enters invalid billing address")
	public void user_enters_invalid_billing_address(DataTable dataTable) {
		List<String> details = dataTable.asList();
		cop.enterBillingAddress(details);
	}

	@Then("error message is captured")
	public void error_message_is_captured() {
		cop.validateError();
		base.teardown();
	}

	@When("user enters valid billing address")
	public void user_enters_valid_billing_address(DataTable dataTable) {
		List<String> details = dataTable.asList();
		cop.entervalidBillingAddress(details);
	}

	@When("user clicks all the continue buttons")
	public void user_clicks_all_the_continue_buttons() {
		cop.clickOnContinue();
	}

	@Then("Confirmation Text visible")
	public void confirmation_text_visible() {
		cop.validateSuccess();
		base.teardown();
	}

}
