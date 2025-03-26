package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CouponCodePage {

	public CouponCodePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(partialLinkText  = "Computers")
	WebElement categoryBtn;
	@FindBy(partialLinkText = "Accessories")
	WebElement subCategoryBtn;
	@FindBy(xpath = "(//input[@value='Add to cart'])[2]")
	WebElement addToCartBtn;
	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement goToCart;
	@FindBy(xpath = "//input[@class='discount-coupon-code']")
	WebElement codeField;
	@FindBy(xpath = "//input[@name='applydiscountcouponcode']")
	WebElement applyBtn;
	@FindBy(xpath = "//div[@class='message']")
	WebElement errorMessage;
	
	public void addProductToCart() {
		categoryBtn.click();
		subCategoryBtn.click();
		addToCartBtn.click();
		goToCart.click();
	}

	public void enterCode(String couponCode) {
		codeField.sendKeys(couponCode);
		applyBtn.click();
	}

	public void validateError() {
		Assert.assertTrue(errorMessage.isDisplayed());
	}
	
	

}
