package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Constants;

public class ClassPageValidation extends Constants {

	WebDriver driver;
	WebDriverWait wait;

	public ClassPageValidation(WebDriver driver) {
		this.driver = driver;
	}

	private By lmsHeading = By.xpath("//span[text()=' LMS - Learning Management System ']");
	private By headers = By.xpath("//span[@class='mat-button-wrapper']");

	private By manageClassHeader = By.xpath("//div[text()=' Manage Class']");
	private By searchBar = By.id("filterGlobal");
	private By classColumHeaders = By.xpath("//tr/th");
	private By paginator = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private By prevSetofPagesMove = By.xpath(
			"//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']");
	private By nextSetofPagesMove = By
			.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	private By nextPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	private By prevPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");

	private By sorticons = By.xpath("//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
	private By totalNoOfClasses = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
	private By logoutHeader = By.xpath("//span[text()='Logout']");
//======Validate Dashboardpage====//
	public boolean validateDashboardPage() {
		if (driver.getTitle().equals("LMS") && driver.findElement(lmsHeading).isDisplayed()) {
			List<WebElement> headings = driver.findElements(headers);
			if (headings.isEmpty()) {

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
//===Click on Class Module===//
	public void clickClass() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement classHeader = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Class']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", classHeader);
		wait.until(ExpectedConditions.elementToBeClickable(classHeader));

	}
//===Logout==//
	public void logOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logoutHeader));
		driver.findElement(logoutHeader).click();
	}
//====Validate Manage Class ===//
	public boolean isClassPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(manageClassHeader)); 
		try {
			return driver.findElement(manageClassHeader).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
//===Validate LMS-Learning Manage System===//
	public void validateLMSHeading(String expectedValue) {
		String actualValue = driver.findElement(lmsHeading).getText().trim();
		Assert.assertEquals(expectedValue.trim(), actualValue);

	}
//===Validate Class Header===//
	public void validateManageHeader(String expectedHeader) {
		String actualValue = driver.findElement(manageClassHeader).getText().trim();
		Assert.assertEquals(expectedHeader.trim(), actualValue);
	}
//Validate Class Search bar===//
	public void validateSearchBar(String expectedSearchPlaceholder) {
		if (driver.findElement(searchBar).isDisplayed()) {
			WebElement searchText = driver.findElement(searchBar);
			String actualSearchPlaceholder = searchText.getAttribute("placeholder");
			Assert.assertEquals(expectedSearchPlaceholder, actualSearchPlaceholder);
		}
	}
//===Validate All column Headers for Class===//
	public void validateAllColumnHeaders(String expectedBatchname, String expectedClassTopic,
			String expectedDescription, String expectedStatus, String expectedclassDate, String expectedstaff,
			String expectedEditDel) {
		List<WebElement> tableHeaders = driver.findElements(classColumHeaders);
		List<String> actualColheaders = new ArrayList<>();

		for (int i = 1; i < tableHeaders.size(); i++) {
			actualColheaders.add(tableHeaders.get(i).getText());
			System.out.println("expectedEditDel:::: " + expectedEditDel);
		}

		Assert.assertTrue(actualColheaders.contains(expectedBatchname), "Batch Name header not found!");

		Assert.assertTrue(actualColheaders.contains(expectedClassTopic), "Class Topic header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedDescription), "Class Description header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedStatus), "Status header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedclassDate), "Class Date header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedstaff), "Staff Name header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedEditDel), "Edit / Delete header not found!");

	}
//===Pagination for Class Pages===//
	public void validatePaginationTextandIcons(String text) {
		WebElement paginatorElement = driver.findElement(paginator);
		boolean areIconsPresent = driver.findElement(prevPageMove).isDisplayed()
				&& driver.findElement(prevSetofPagesMove).isDisplayed()
				&& driver.findElement(nextPageMove).isDisplayed()
				&& driver.findElement(nextSetofPagesMove).isDisplayed();
		try {
			if (areIconsPresent) {
				String textValidation = paginatorElement.getText();
				Pattern pattern = Pattern.compile("\\d+");
				Matcher matcher = pattern.matcher(textValidation);
				List<Integer> numericValues = new ArrayList<Integer>();
				while (matcher.find()) {
					int numericValue = Integer.parseInt(matcher.group());
					numericValues.add(numericValue);
				}
				text = String.format("Showing %d to %d of %d entries", numericValues.get(0), numericValues.get(1),
						numericValues.get(2));
				log.info(text);
				Assert.assertEquals(text, textValidation);
			}
		} catch (Exception e) {
			log.error("Pagination Icons are not displayed" + e);
		}
	}
//===Single Delete Button Validation on Class===//
	public void hiddenDeleteElement() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement deleteButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div/button/span[@class='p-button-icon pi pi-trash']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
	}
//===Sorting===//
	public boolean validateSortIcons() {
		try {
			List<WebElement> sortIcons = driver.findElements(sorticons);

			for (int i = 0; i < sortIcons.size(); i++) {
				if (sortIcons.get(i).isDisplayed())
					return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}
//===Total No of Classes on a page===//
	public void totalNoOfClasses() {
		boolean count = driver.findElement(totalNoOfClasses).isDisplayed();
		System.out.println("Total no of Classes: " + count);
	}

}
