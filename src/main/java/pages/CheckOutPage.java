package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckOutPage {

	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log in")
	WebElement goToLoginPage;
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailInput;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passInput;
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginBtn;
	@FindBy(partialLinkText = "expensive computer")
	WebElement product;
	@FindBy(xpath = "//input[@value='Add to cart']")
	WebElement addToCart;
	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement goToCart;
	@FindBy(id = "termsofservice")
	WebElement checkBox;
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	@FindBy(id = "billing-address-select")
	WebElement savedAddresses;
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryDropDown;
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipCode;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	WebElement continueBtn1;
	@FindBy(xpath = "(//input[@value='Continue'])[2]")
	WebElement continueBtn2;
	@FindBy(xpath = "(//input[@value='Continue'])[3]")
	WebElement continueBtn3;
	@FindBy(xpath = "(//input[@value='Continue'])[4]")
	WebElement continueBtn4;
	@FindBy(xpath = "(//input[@value='Continue'])[5]")
	WebElement continueBtn5;
	@FindBy(xpath = "(//input[@value='Confirm'])")
	WebElement confirmBtn;
	@FindBy(xpath = "(//span[@class='field-validation-error'])[1]")
	WebElement errorMessage;
	@FindBy(partialLinkText = "order details")
	WebElement confirmationDetail;

	public void enterEmail(String email) {
		goToLoginPage.click();
		emailInput.sendKeys(email);
	}

	public void enterPass(String pass) {
		passInput.sendKeys(pass);
		loginBtn.click();
	}

	public void addProductToCart() {
		product.click();
		addToCart.click();
		goToCart.click();
	}

	public void checkOut() {
		checkBox.click();
		checkOutBtn.click();
	}

	public void enterBillingAddress(List<String> details) {
		Select sa = new Select(savedAddresses);
		sa.selectByVisibleText("New Address");
		Iterator<String> it = details.iterator();
		Select country = new Select(countryDropDown);
		country.selectByContainsVisibleText(it.next());
		city.sendKeys(it.next());
		address.sendKeys(it.next());
		it.next();
		phoneNumber.sendKeys(it.next());
		continueBtn1.click();

	}

	public void validateError() {
		Assert.assertTrue(errorMessage.isDisplayed());
	}

	public void entervalidBillingAddress(List<String> details) {
		Select sa = new Select(savedAddresses);
		sa.selectByVisibleText("New Address");
		Iterator<String> it = details.iterator();
		Select country = new Select(countryDropDown);
		country.selectByContainsVisibleText(it.next());
		city.sendKeys(it.next());
		address.sendKeys(it.next());
		zipCode.sendKeys(it.next());
		phoneNumber.sendKeys(it.next());
		continueBtn1.click();

	}

	public void clickOnContinue() {
		continueBtn2.click();
		continueBtn3.click();
		continueBtn4.click();
		continueBtn5.click();
		confirmBtn.click();

	}

	public void validateSuccess() {
		Assert.assertTrue(confirmationDetail.isDisplayed());
	}

}
