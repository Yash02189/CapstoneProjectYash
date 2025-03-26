package stepDefinitions;

import org.openqa.selenium.WebDriver;

import basePackage.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CouponCodePage;
import runnerPackage.TestRunner;

public class CouponCodeSteps {
	BaseTest base=new BaseTest();
	String browser=TestRunner.browserName.get();
	CouponCodePage cp;
	@Given("user is on demo web shop home page")
	public void user_is_on_demo_web_shop_home_page() {
		try {
			base.browserSetup(browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		WebDriver driver=base.getDriver();
		cp=new CouponCodePage(driver);
	}
	

	@When("user adds a product to cart")
	public void user_adds_a_product_to_cart() {
		cp.addProductToCart();
	}
	

	@When("^user enters code in cart\"(.*)\"$")
	public void user_enters_code_in_cart_discount10(String couponCode) {
		cp.enterCode(couponCode);
	}

	@Then("error message is displayed")
	public void error_message_is_displayed() {
		cp.validateError();
		base.teardown();
	}

}
