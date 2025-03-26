package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCartPage {

	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='small-searchterms']")
	WebElement searchBar;
	@FindBy(xpath = "//input[@value='Search']")
	WebElement searchBtn;
	@FindBy(linkText = "Simple Computer")
	WebElement product;
	@FindBy(xpath = "//input[@id='add-to-cart-button-75']")
	WebElement addToCartBtn;
	@FindBy(xpath = "//input[@name='product_attribute_75_5_31']")
	WebElement processorSlow;
	@FindBy(linkText = "shopping cart")
	WebElement validationBtn;

	public void searchProduct(String product) {
		searchBar.sendKeys(product);
		searchBtn.click();
	}

	public void clickProduct() {
		product.click();
		processorSlow.click();
	}

	public void clickAddToCart() {
		addToCartBtn.click();
	}

	public void validateAdd() {
		Assert.assertTrue(validationBtn.isDisplayed());
	}

}
