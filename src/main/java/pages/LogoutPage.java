package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogoutPage{

	public LogoutPage(WebDriver driver) {
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
	@FindBy(linkText = "Log out")
	WebElement logoutBtn;
	
	
	public void enterEmail(String value) {
		goToLoginPage.click();
		emailInput.sendKeys(value);
	}
	
	public void enterPass(String value) {
		passInput.sendKeys(value);
		loginBtn.click();
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}
	
	public void validateLogout() {
		Assert.assertTrue(goToLoginPage.isDisplayed());
	}
	
	
	
	
	
	
	
}
