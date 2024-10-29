package pageObjects;

import java.util.List;
import org.openqa.selenium.Keys;

import javax.net.ssl.HttpsURLConnection;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
import utilities.Constants;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.awt.Color;
import java.io.File;

public class LoginPage extends Constants {
	WebDriver driver;
	WebDriverWait wait;
	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By login = By.xpath("//button[@id='login']");
	private By lmsimage = By.xpath("//img[@src='assets/img/LMS-logo.jpg']");
	private By signincontent = By.xpath("//p[contains(text(), 'Please login to LMS application')]");
	private By usertext	= By.xpath("//span[text()='User']");
	private By passwordtext = By.xpath("//span[text()='Password']");
	private By userastrik = By.xpath("//span[text()=' *']");
	private By passwordastrik = By.xpath("//span[text()=' *']");
	private By logo = By.className("image-container");
	private By inputallignment = By.className("mat-card-content");
	private By dashboardpg = By.xpath("/html/body/app-root/app-header/mat-toolbar");
	private By errormsg = By.xpath("//*[contains(text(),'Invalid username and password Please try again ')]");
	private By errornulluser = By.xpath("//*[contains(text(),' Please enter your user name')]");
	private By spelltextchk = By.tagName("body");
	private By logoutHeader=By.xpath("//span[text()='Logout']");
	
			
	public LoginPage(WebDriver driver){
			this.driver = driver;
		}
	
	public void getloginUrl() {
		System.out.println("============baseURL================ "+Constants.baseURL);
		driver.get(Constants.baseURL);
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}


	public void getinvalidloginurl() {
		driver.get(Constants.InvalidbaseUrl);
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
	
	// Entering valid Username and Password
	public void enterUserName (String Uname ) {
		WebElement Username = driver.findElement(username);
		Actions action = new Actions(driver);
		action.sendKeys(Username ,Uname).build().perform();
	}
	
	public void enterPassword (String Password ) {
		WebElement passwrd = driver.findElement(password);
		Actions action = new Actions(driver);
		action.sendKeys(passwrd ,Password).build().perform();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	 // Method to get all anchor tags on the page
    public List<WebElement> getAllLinks() {
        return driver.findElements(By.tagName("a"));
    }

    // Method to check for broken links
    public void checkForBrokenLinks() throws IOException {
        List<WebElement> links = getAllLinks();

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                checkLink(url);
            }
        }
    }

    // Private method to check a single link
    private void checkLink(String url) throws IOException {
        @SuppressWarnings("deprecation")
		HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        httpURLConnection.setRequestMethod("HEAD");
        httpURLConnection.connect();

        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 400) {
            System.out.println("Broken link: " + url + " - Response Code: " + responseCode);
        } else {
            System.out.println("Valid link: " + url + " - Response Code: " + responseCode);
        }
    }

    public boolean checkImageAlignment() {
    	  WebElement imagelogo =  driver.findElement(lmsimage);
    	int logoLeftX = imagelogo.getLocation().getX();
    	if(logoLeftX <= 100) {
    		
    	System.out.println("Logo is on the left side of the page.");
    	return true;
    	}
    	else {
    		System.out.println("Logo is not on the left side of the page.");
    		return false;
    	}
    		
    	}
    	
    public void spellcheck() throws IOException{
    	WebElement spelltext = driver.findElement(spelltextchk);
    	String pageText = spelltext.getText();
    	System.out.println(pageText);
    	JLanguageTool languageTool = new JLanguageTool (new AmericanEnglish());
    	try {
    		List<RuleMatch> errors =languageTool.check(pageText);
    		if (errors.isEmpty()) {
    			System.out.println("No spelling mistakes found");
    		} else {
    			System.out.println("Spelling mistakes found");
    			for (RuleMatch error :errors) {
    				System.out.println("Potential typo at line" +error.getLine() +", column" + error.getColumn() + ":" + error.getMessage());
    				System.out.println("Context:" + error.getShortMessage());
    				System.out.println("Suggested correction:" + error.getSuggestedReplacements());
    				System.out.println("----");
    			}
    		}
    	
    	}	catch (IOException e) {
    			// Handle IO exceptions
    			e.printStackTrace();
    		}
    }

    public String getLogo() {
    	WebElement e =driver.findElement(logo);
    	String logoImage = e.getAttribute("src");
    	return logoImage;
    }
    
    public boolean getApplicationName() {
    	return driver.findElement(lmsimage).isDisplayed();
    }
    	
    public boolean getCompanyName() {
    	return driver.findElement(lmsimage).isDisplayed();
    }
    	
    	
   public String signInContentText() {
	   return driver.findElement(signincontent).getText();
   }
    
   public List<WebElement> txtField() {
       return driver.findElements(By.xpath("//div[@class='signin-content']//input"));
   }
   
   public boolean checkfirsttxt() {
	   return driver.findElement(usertext).isDisplayed();
	   
   }
      
   public String checkuserastrik() {
	   return driver.findElement(userastrik).getText();
			   }
    
   public boolean checksecondtxt() {
	   return driver.findElement(passwordtext).isDisplayed();
   }

   public String checkpasswordastrik() {
	   return driver.findElement(passwordastrik).getText();
	 }
   
   public String checkinputallignment() {
	   WebElement textFieldAllign = driver.findElement(inputallignment);
	   String elementPosition = textFieldAllign.getCssValue("text-align");
	   return elementPosition;
   }
   
	public boolean usernamefield() {
		return driver.findElement(username).isDisplayed();
	}

	public boolean passwordfield() {
		return driver.findElement(password).isDisplayed();
	}
	
	public boolean loginbtn() {
		return driver.findElement(login).isDisplayed();
	}
	
	public void clickLoginBtn() {
		driver.findElement(login).click();
	}
	
	
	public String checkLoginAllignment() {
		WebElement loginAllignment = driver.findElement(inputallignment);
		String lgnAllign = loginAllignment.getCssValue("text-align");
		return lgnAllign;
	}

	public String checkUserTxtColor() {
		WebElement usercolorTxt = driver.findElement(usertext);
		String textColor = usercolorTxt.getCssValue("color");
		System.out.println("User Text Color is "  + textColor +  " --> Gray color");
		return textColor;
		
	}
	
	public String checkPasswordTxtColor() {
		WebElement passwordcolorTxt = driver.findElement(passwordtext);
		String passtextColor = passwordcolorTxt.getCssValue("color");
		System.out.println("Password Text Color is " + passtextColor + " --> Gray color");
		return passtextColor;
		
	}
	
	public boolean lmslogo() {
		return driver.findElement(lmsimage).isDisplayed();
	}
	
	
	public boolean getPasswordastrik() {
		return driver.findElement(passwordastrik).isDisplayed();
	}

	public boolean getDashboardPage() {
		return driver.findElement(dashboardpg).isDisplayed();
	}

	public void clearUserNamePasswordTextBox() throws InterruptedException {
		  driver.findElement(username).clear();
		  Thread.sleep(1000);
		  driver.findElement(password).clear();
		  
		 }
	
//	public String getErrorMsg() {
//		return driver.findElement(errormsg).getText();
//		
//	}
	public void checkLogin(String sheetname, String scenarioName) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		
		// the column index we want to filter by (e.g., column 1)(0-based)
        int filterColumnIndex = 0;  
       System.out.println(sheetname);
       System.out.println(scenarioName);
       
      
       String Username = null;
       String Password = null;
       clearUserNamePasswordTextBox();
       //  status = rowData.get(3);
       
       if(scenarioName.equalsIgnoreCase("LoginWithInvalidCredentials")) {
    	  
           Username = xlutils.getCellData(sheetname, 2, 1);
           Password = xlutils.getCellData(sheetname, 2, 2);
    	   
           System.out.println("==================Username===== "+Username);
           System.out.println("==================Password===== "+Password);
           
           
    	   Thread.sleep(1000);
    	   driver.findElement(username).sendKeys(Username);
    	   Thread.sleep(1000);
    	   driver.findElement(password).sendKeys(Password);
    	   
    	   driver.findElement(login).click();
    	   Thread.sleep(1000);
    	   
    	  Assert.assertTrue(driver.findElement(errormsg).getText().contains("Invalid username and password Please try again"), "Invalid username and password Please try again");
    	  
    	   
       }else if(scenarioName.equalsIgnoreCase("LoginWithNullAdminname")) {

    	   
    	   Password = xlutils.getCellData(sheetname, 3, 2);
    	   
    	   
    	   driver.findElement(username).click();
    	   Thread.sleep(1000);
    	   
    	   driver.findElement(password).sendKeys(Password);
    	   
    	   
    	   driver.findElement(login).click();
    	   Thread.sleep(2000);
    	   
    	   Assert.assertTrue(driver.findElement(errornulluser).getText().contains("Please enter your user name"), "Please enter your user name");
    	   
       }else if(scenarioName.equalsIgnoreCase("LoginWithNullPassword")) {
    	   
    	  
    	   Username = xlutils.getCellData(sheetname, 4, 1);
    	   Thread.sleep(1000);
    	   driver.findElement(username).sendKeys(Username);
    	 
    	   
    	   driver.findElement(login).click();
    	   
       }     

    	   
    	 
    	  }
	
	public void checkvalidlogin(String sheetname, String scenarioName) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		System.out.println(sheetname);
	       System.out.println(scenarioName);
	       
	       String Username = null;
	       String Password = null;
	       
	       Username = xlutils.getCellData(sheetname, 1, 1);
           Password = xlutils.getCellData(sheetname, 1, 2);
           System.out.println("==================Username===== "+Username);
           System.out.println("==================Password===== "+Password);
	
           Thread.sleep(1000);
    	   driver.findElement(username).sendKeys(Username);
    	   Thread.sleep(1000);
    	   driver.findElement(password).sendKeys(Password);
    	   
    	   driver.findElement(login).click();
    	   Thread.sleep(1000);
	
	}
		
	
	
public  void keyboardEnter() throws InterruptedException {
	Actions actions = new Actions(driver);
	WebElement loginKeyboard = driver.findElement(login);
	actions.click(loginKeyboard).sendKeys(Keys.ENTER).perform();
	 Thread.sleep(2000);
	
	 try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}
public void mouseActionClick() throws InterruptedException {
	Actions actions = new Actions(driver);
	WebElement loginMouseAction = driver.findElement(login);
	 actions.moveToElement(loginMouseAction).click().perform();
	 Thread.sleep(2000);
	 try {
           Thread.sleep(2000); // Wait for 2 seconds
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

}


}