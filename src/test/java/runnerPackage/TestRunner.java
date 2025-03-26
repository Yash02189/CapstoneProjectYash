package runnerPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions",
				plugin = {"pretty","html:target/HtmlReport.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
	public static ThreadLocal<String> browserName = new ThreadLocal<String>();

	@BeforeClass
	@Parameters("browser")
	public void assignBrowser(String browser) {
		browserName.set(browser);
	}
}
