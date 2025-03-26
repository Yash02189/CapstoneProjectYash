package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	public LoginPage(WebDriver driver) {
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

	@FindBy(xpath = "//li[text()='No customer account found']")
	WebElement errorText;

	public void navigateToLoginPage() {
		goToLoginPage.click();
	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		passInput.sendKeys(password);
	}

	public void clickLogin() {
		loginBtn.click();
	}

	public void validateLogin(String title) {
		String expected = "Demo Web Shop";
		if (title.equalsIgnoreCase("Demo Web Shop. Login")) {
			Assert.assertTrue(errorText.isDisplayed());
		} else {
			Assert.assertEquals(title, expected);
		}
	}

}
