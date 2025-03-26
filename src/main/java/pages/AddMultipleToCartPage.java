package pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddMultipleToCartPage {
	WebDriver driver;
	double expectedPrice;

	public AddMultipleToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(partialLinkText ="Apparel & Shoes")
	WebElement categoryBtn;
	@FindBy(xpath = "//span[@itemprop='price']")
	WebElement itemPrice;
	@FindBy(xpath = "//input[contains(@id,'add-to-cart-button')]")
	WebElement addToCartBtn;
	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement goToCart;
	@FindBy(xpath = "(//span[@class='product-price'])[1]")
	WebElement actualTotal;
	



	public void addToCart(String product) {
		categoryBtn.click();
		driver.findElement(By.partialLinkText(product)).click();
		expectedPrice+=Double.parseDouble(itemPrice.getText());
		addToCartBtn.click();
	}

	public void validateCartTotal() {
		goToCart.click();
		double actutalTotal=Double.parseDouble(actualTotal.getText());
		Assert.assertEquals(actutalTotal, expectedPrice);
	}

}
