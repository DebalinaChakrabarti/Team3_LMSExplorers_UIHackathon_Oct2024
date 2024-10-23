package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;


public class ApplicationHooks {

	private static DriverFactory driverFactory;
	private static WebDriver driver;

	
	  public static Logger log = LogManager.getLogger();
	
	@BeforeAll
	public  static void launchBrowser()
	{
		System.out.println("=========launchBrowser=======================");
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();
	}
	
	
	@AfterAll(order = 0)
	public  static void quitBrowser() {
		System.out.println("=========quitBrowser=======================");		
		driver.quit();
	}
	
	@After(order = 1)
	public void screenShot(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ","_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			System.out.println("=========screenShot======================="+screenshotName);
			
		}
	}
}
