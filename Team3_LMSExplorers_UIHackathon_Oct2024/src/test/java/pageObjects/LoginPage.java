package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constants;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By login = By.xpath("//button[@id='login']");

	//	private By username = By.xpath("//input[@id='username']");
//	private By password = By.xpath("//input[@id='password']");
//	private By login = By.xpath("//button[@id='login']");
	private By logoutHeader=By.xpath("//span[text()='Logout']");





	public LoginPage(WebDriver driver){
		this.driver = driver;
	}

	public void getloginUrl() {
		System.out.println("============baseURL================ "+Constants.baseURL);
		driver.get(Constants.baseURL);
	}
	public void EnterUserName(String Uname) throws InterruptedException {
		WebElement Username = driver.findElement(username);
		Actions action = new Actions(driver);
		action.sendKeys(Username, Uname).build().perform();
	}

	public void EnterPassword(String Pwd) throws InterruptedException {
		WebElement pwd = driver.findElement(password);
		Actions action = new Actions(driver);
		action.sendKeys(pwd, Pwd).build().perform();
	}


	public void clickOnloginButton() {
		driver.findElement(login).click();
	}

	public boolean isLoggedIn() {
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(1000));
			wait.until(ExpectedConditions.presenceOfElementLocated(logoutHeader));
			return driver.findElement(logoutHeader).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void enterCredentials() {
		driver.findElement(username).sendKeys("Sdet@gmail.com");
		driver.findElement(password).sendKeys("LmsHackathon@2024");
		driver.findElement(login).click();
	}
}