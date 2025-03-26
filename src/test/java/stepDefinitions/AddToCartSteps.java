package stepDefinitions;

import org.openqa.selenium.WebDriver;

import basePackage.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddToCartPage;
import runnerPackage.TestRunner;

public class AddToCartSteps {
	String browser=TestRunner.browserName.get();
	AddToCartPage atc;
	BaseTest base=new BaseTest();
	@Given("user on home page")
	public void user_on_home_page() {
		
		try {
			base.browserSetup(browser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriver driver=base.getDriver();
		atc=new AddToCartPage(driver);
		}

	@When("^user searches\"(.*)\"$")
	public void user_searches_computer(String product) {
		atc.searchProduct(product);
	}

	@When("user clicks on a product of choice")
	public void user_clicks_on_a_product_of_choice() {
		atc.clickProduct();
	}

	@When("user clicks add to cart button")
	public void user_clicks_add_to_cart_button() {
		atc.clickAddToCart();
	}

	@Then("Product is added to cart")
	public void product_is_added_to_cart() {
		atc.validateAdd();
		base.teardown();
	}

}
