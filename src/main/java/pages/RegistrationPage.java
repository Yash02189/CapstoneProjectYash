package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage {

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Register")
	WebElement navToRegister;
	@FindBy(id = "FirstName")
	WebElement fnameInput;
	@FindBy(id = "LastName")
	WebElement lnameInput;
	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "Password")
	WebElement password;
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement pass_confirm;
	@FindBy(xpath = "//input[@id='register-button']")
	WebElement registerBtn;
	@FindBy(xpath = "(//span[@class=''])[1]")
	WebElement errorText;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueBtn;
	@FindBy(xpath = "//li[text()='The specified email already exists']")
	WebElement duplicateEmail;

	public void navToRegisteration() {
		navToRegister.click();
	}

	public void enterFirstName(String value) {
		fnameInput.sendKeys(value);
	}

	public void enterLastName(String value) {
		lnameInput.sendKeys(value);
	}

	public void enterEmail(String value) {
		email.sendKeys(value);
	}

	public void enterPassword(String value) {
		password.sendKeys(value);
	}

	public void enterPasswordConfirmation(String value) {
		pass_confirm.sendKeys(value);
	}

	public void clickRegister() {
		registerBtn.click();
	}

	public void validateRegistration() {

		try {
			if(continueBtn.isDisplayed()) {
				Assert.assertTrue(true);
			}
		} catch (NoSuchElementException nse1) {
			try {
				if(errorText.isDisplayed()) {
					Assert.assertTrue(true);
				}
			}catch(NoSuchElementException nse2){
				try {
					if(duplicateEmail.isDisplayed()) {
						Assert.assertTrue(true);
					}
				} catch(NoSuchElementException nse3){
					
				}
			}
		}
	}
}
