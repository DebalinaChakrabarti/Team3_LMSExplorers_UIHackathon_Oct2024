package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By login = By.xpath("//button[@id='login']");

	public LoginPage(WebDriver driver){
			this.driver = driver;
		}
	
	public void getloginUrl() {
		System.out.println("============baseURL================ "+Constants.baseURL);
		driver.get(Constants.baseURL);
	}
	
}