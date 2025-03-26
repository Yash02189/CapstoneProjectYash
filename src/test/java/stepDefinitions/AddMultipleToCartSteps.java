package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import basePackage.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddMultipleToCartPage;
import runnerPackage.TestRunner;

public class AddMultipleToCartSteps {
	
	BaseTest base = new BaseTest();
	String browser = TestRunner.browserName.get();
	WebDriver driver;
	AddMultipleToCartPage atc;
	
	@Given("user is on home page")
	public void user_is_on_home_page() {
		try {
			base.browserSetup(browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = base.getDriver();
		atc=new AddMultipleToCartPage(driver); 
	}



	@When("User adds given products to the cart.")
	public void user_adds_given_products_to_the_cart(DataTable productTable) {
		List<String> products=productTable.asList();
		for (String product : products) {
			atc.addToCart(product);
		}
		
	}

	@Then("user verifies total")
	public void user_verifies_total() {
		atc.validateCartTotal();
		base.teardown();
	}

}
