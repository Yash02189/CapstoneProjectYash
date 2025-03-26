package basePackage;

import java.time.Duration ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	public  ThreadLocal<String> username=new ThreadLocal<String>();
	public  ThreadLocal<String> password=new ThreadLocal<String>();


	public void browserSetup(String browser) throws Exception {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			username.set(ConfigReader.getCredentials("Username1"));
			password.set(ConfigReader.getCredentials("Pass1"));
			driver.set(new ChromeDriver()); 
			
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			username.set(ConfigReader.getCredentials("Username2"));
			password.set(ConfigReader.getCredentials("Pass2"));
			driver.set(new EdgeDriver());
		} else {
			throw new Exception("Invalid Browser name");
		}
	}

	public WebDriver getDriver() {
		driver.get().get(ConfigReader.getWebsite("url"));
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(21));
		return driver.get();
	}

	public void teardown() {
		driver.get().quit();
	}
}
