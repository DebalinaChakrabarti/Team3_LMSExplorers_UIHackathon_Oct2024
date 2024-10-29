package pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utilities.Constants;

public class DashboardPage  {

	WebDriver driver;
	private By learningManagementSystem = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	private By programbutton = By.xpath("//span[normalize-space()='Program']");
	private By batchbutton = By.xpath("//span[normalize-space()='Batch']");
	private By classbutton = By.xpath("//span[normalize-space()='Class']");
	private By logoutbutton = By.xpath("//span[normalize-space()='Logout']");
	private By dashboardpg = By.xpath("/html/body/app-root/app-header/mat-toolbar");
	private By lmsspace =  By.xpath("//span[@class='fill-remaining-space']");
	
	
	
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}


	public String getLearningManagementSystemTitle() {

		return driver.findElement(learningManagementSystem).getText().trim();
	}

	public String getProgrambuttonlink() {

		return driver.findElement(programbutton).getText().trim();
	}

	public String getbatchbuttonlink() {

		return driver.findElement(batchbutton).getText().trim();
	}

	public String getclassbuttonlink() {

		return driver.findElement(classbutton).getText().trim();
	}

	public String getlogoutbuttonlink() {

		return driver.findElement(logoutbutton).getText().trim();
	}

	

	@SuppressWarnings("null")
	public long navigation_Time() {
		
		long start = System.currentTimeMillis();
		start = (int) (start / 1000) % 60;
		long totalTime;
		WebElement ele = driver.findElement(dashboardpg);
		if (ele.isDisplayed()) {
			long finish = System.currentTimeMillis();
			finish = (int) (finish / 1000) % 60;
			totalTime = finish -start;
			return totalTime;
		} else {
		
		    return totalTime = (Long) null;
		}
	}
		
	public String getLMSTitleposition() {
		WebElement e = driver.findElement(learningManagementSystem);
		String elementLocation = e.getCssValue("text-align");
		return elementLocation;
			
	}

	public boolean titleSpellCheckSpaceCheck() {
		WebElement lmsSpellSpace = driver.findElement(lmsspace);
		WebElement lmsTitle = driver.findElement(learningManagementSystem);
		if (lmsSpellSpace.isDisplayed()) {
			Assert.assertEquals("LMS - Learning Management System",lmsTitle.getText() );
			return true;
		
		}
		return false;
	}


	public boolean checkLMSAlignment() {
  	  WebElement lmsAllign =  driver.findElement(learningManagementSystem);
  	int logoLeftX = lmsAllign.getLocation().getX();
  	if(logoLeftX <= 100) {
  		
  	System.out.println("LMS Title is on the left side of the page.");
  	return true;
  	}
  	else {
  		System.out.println("LMS Title is not on the left side of the page.");
  		return false;
  	}
  		
  	}


	@SuppressWarnings("deprecation")
	public void verifyLink() throws Throwable {
		try {
			URL link = new URL(Constants.baseURL);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			int responseCode = httpURLConnection.getResponseCode();
			if (httpURLConnection.getResponseCode() >= 400) {
				System.out.println("Broken link: " + link + " - Response Code: " + responseCode);
	        } else {
	            System.out.println("Valid link: " + link + " - Response Code: " + responseCode);
			}
		} catch (IOException e) {
			System.out.println("Error connecting to the URL");
			e.printStackTrace();
		}
		
	}

	
	public String lmsNavigationBarValidation() {
    return driver.findElement(dashboardpg).getText();

}

}
