package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Constants;

public class DriverFactory extends Constants {

	public final static int TIMEOUT = 50;
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	

	/**
	 * This method is used to initialize the threadlocal driver on the basis of given browser
	 * 
	 * @param browser
	 * @return this will return driver
	 */

	// Singleton method to get the WebDriver instance
    public WebDriver getDriver() {
        if (driver.get() == null) {
            // Get the browser name from properties file
            String browser = configProp.getString("browser");
    		System.out.println("browser value is:"+browser);
            switch (browser) {
                case "firefox":
                	driver.set(new FirefoxDriver());
                    break;
                case "edge":
                	driver.set(new EdgeDriver());
                    break;
                case "chrome":
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.addArguments("--headless"); // Run Chrome in headless mode
                    chromeOptions.addArguments("--disable-popup-blocking"); // Disable popup blocking
                    chromeOptions.addArguments("--disable-notifications"); // Disable popup blocking
                    chromeOptions.addArguments("--disable-extensions"); // Disable popup blocking
                    chromeOptions.addArguments("--blink-settings=imagesEnabled=false");
                    driver.set(new ChromeDriver(chromeOptions));
                    break;
            }
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));

            driver.get().manage().deleteAllCookies();
            driver.get().manage().window().maximize();
           
        }
        return driver.get();
    }
}
 
