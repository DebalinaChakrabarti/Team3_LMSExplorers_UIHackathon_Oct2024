package pageObjects;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Constants;

public class ProgramPage extends Constants {

	WebDriver driver;
	private By lmsHeading = By.xpath("//span[text()=' LMS - Learning Management System ']");
	private By programHeader = By.xpath("//span[text()='Program']");
	private By headers = By.xpath("//span[@class='mat-button-wrapper']");
	private By manageProgramHeader = By.xpath("//div[text()=' Manage Program']");
	private By logoutHeader = By.xpath("//span[text()='Logout']");
	private By addNewProgramBtn= By.xpath("//button[text()='Add New Program']");

	public ProgramPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validateDashboardPage() {
		if (driver.getTitle().equals("LMS") && driver.findElement(lmsHeading).isDisplayed()) {
			List<WebElement> headings = driver.findElements(headers);
			if (headings.isEmpty()) {
				System.out.println("No headings found on the page.");
				return false;
			}

			for (WebElement heading : headings) {
				String expectedText = heading.getText();
				if (heading.getText().equals(expectedText)) {
					Assert.assertTrue(true, "Heading validated: " + heading.getText());
				} else {
					Assert.fail("Unexpected heading text: " + heading.getText());
					return false;
				}
			}

			return true;
		}
		return false;
	}

	public void clickProgram() {
		driver.findElement(programHeader).click();
	}

	public boolean isProgramPage() {
		try {
			return driver.findElement(manageProgramHeader).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void validateLMSHeading(String expectedValue) {
		String actualValue = driver.findElement(lmsHeading).getText().trim();
		Assert.assertEquals(expectedValue.trim(), actualValue);

	}

	public void checkForBrokenLinks() throws Throwable {
		List<WebElement> links = driver.findElements(By.tagName("link"));
		List<WebElement> buttonsWithRouterLink = driver.findElements(By.xpath("//button[@routerlink]"));
		System.out.println("Total links found: " + links.size());
		System.out.println("Total buttons with routerLink found: " + buttonsWithRouterLink.size());
		for (WebElement linkElement : links) {
			String url = linkElement.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				verifyLink(url);
			} else {
				log.info("URL is not configured for link tag");
			}
		}

		for (WebElement buttonElement : buttonsWithRouterLink) {
			String routerLink = buttonElement.getAttribute("routerlink");
			if (routerLink != null && !routerLink.isEmpty()) {
				String fullUrl = configProp.getString("BaseUrl") + routerLink;
				verifyLink(fullUrl);
			} else {
				log.info("No routerLink configured for button element.");
			}
		}
	}

	public void verifyLink(String urllink) throws Throwable {

		try {
			URL link = new URL(urllink);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() >= 400) {
				log.info("Broken link found: " + link + " with response code: " + httpURLConnection.getResponseCode());

			} else {
				log.info("Valid link found: " + link);

			}
		} catch (IOException e) {
			log.info("Error connecting to the URL");
			e.printStackTrace();

		}

	}

	public void validateModuleNames(String expectedOrder) {

		List<WebElement> modules = driver.findElements(headers);
		List<String> actualOrder = new ArrayList<>();

		for (int i=0;i<modules.size()-1;i++) {
			actualOrder.add(modules.get(i).getText());
		}

		String[] expectedOrderArray = expectedOrder.split(" ");
		assertEquals(Arrays.asList(expectedOrderArray), actualOrder);

	}

	public void validateLogoutInMenubar(String logout) {
		String actualValue = driver.findElement(logoutHeader).getText().trim();
		Assert.assertEquals(logout.trim(), actualValue);
	}
	
	
	public void validateAddNewProgBtn(String addNewProg) {
		
		WebElement addNewProgram=driver.findElement(addNewProgramBtn);
		if (addNewProgram.isDisplayed()) {
	        String actualValue = addNewProgram.getText().trim();
	        Assert.assertEquals(addNewProg.trim(), actualValue);
	    } else {
	        Assert.fail("Add New Program button is not displayed");
	    }
	}
	
	
	

}
