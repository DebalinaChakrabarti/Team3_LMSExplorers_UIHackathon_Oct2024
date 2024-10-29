package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
 
	WebDriver driver;
	
	private By logout = By.xpath("//span[text()='Logout']");
	
	public LogoutPage(WebDriver driver){
		this.driver = driver;
		}
	
public void clickLogoutBtn() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	// Wait for Logout link element to be clickable, then click
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(logout)));					
}

public void clickBack() {
	// Navigate to the previous page
	driver.navigate().back();
}

}
