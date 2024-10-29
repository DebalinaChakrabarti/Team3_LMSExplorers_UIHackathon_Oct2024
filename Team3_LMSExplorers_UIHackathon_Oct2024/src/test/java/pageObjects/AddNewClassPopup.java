package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Constants;
import org.openqa.selenium.interactions.Actions;

public class AddNewClassPopup extends Constants {

	WebDriver driver;
	WebDriverWait wait;

	public AddNewClassPopup(WebDriver driver) {
		this.driver = driver;
	}

	private By classinMenubar = By.xpath("//span[text()='Class']");
	private By addNewClass = By.xpath("//button[contains(text(),'Add New Class')]");
	private By classTopicTextbox = By.xpath("//input[@id='classTopic']");
	private By classDescriptionTextbox = By.xpath("//input[@id='classDescription']");
	private By statuActive = By.xpath("//div[@class='radio ng-star-inserted']/div[2]");
	private By commentsTextbox = By.xpath("//input[@id='classComments']");
	private By recordingTextbox = By.xpath("//input[@id='classRecordingPath']");
	private By saveButton = By.xpath("//span[contains(text(),'Save')]");
	private By activeStatusBtn = By.xpath("(//p-radiobutton[@name='category'])[1]");
	private By notesTextbox = By.xpath("//input[@id='classNotes']");
	private By alertmsg = By.xpath("//div[contains(@class, 'p-toast-detail')]");
	private By saveBtn = By.xpath("//span[text()='Save']");

	public void addNewClass() {
		driver.findElement(classinMenubar).click();

		driver.findElement(addNewClass).click();

	}

	public boolean selectBatchnameDropdown() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		WebElement dropdownElement = driver
				.findElement(By.xpath("(//span [@ng-reflect-ng-class='pi pi-chevron-down'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)));
		try {
			List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			for (WebElement roleStatus : roleStatusOptions) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						wait.until(ExpectedConditions.elementToBeClickable(roleStatus)));
				System.out.println("Role status: " + roleStatus.getText());
				Assert.assertTrue(true, roleStatus.getText());
				return true;
			}
		} catch (StaleElementReferenceException e) {
			log.info("Some expection" + e.getMessage());
		}
		return false;
	}

	public void classTopic() throws InterruptedException {

		Thread.sleep(2000);

		driver.findElement(classTopicTextbox).sendKeys("Python");

	}

	public void selectClassDates() throws InterruptedException {


		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement datePicker = driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-calendar']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(datePicker)));
		WebElement dateToSelect = driver.findElement(By.xpath("//span[normalize-space()='31']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(dateToSelect)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(datePicker)));

	}

	public boolean selectStaffName() {
		WebElement select_staffName_drpdown = driver
				.findElement(By.xpath("(//span [@ng-reflect-ng-class='pi pi-chevron-down'])[2]"));
		select_staffName_drpdown.click();
		try {
			List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			for (WebElement roleStatus : roleStatusOptions) {
				roleStatus.click();
				System.out.println("Role status: " + roleStatus.getText());
				Assert.assertEquals(roleStatus.getText(), select_staffName_drpdown.getText());
				return true;
			}
		} catch (StaleElementReferenceException e) {
			log.info("Some expection" + e.getMessage());
		}
		return false;
	}

	public void statusActive() {

		driver.findElement(statuActive).click();
	}

	public void saveClass() {
		boolean Save = driver.findElement(saveButton).isDisplayed();
		boolean expected = true;
		Assert.assertEquals(expected, Save);

	}

	public void successAlert() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert text: " + alertText);
	}

	public void clickSaveBtn() {
		WebElement save = driver.findElement(saveBtn);
		if (save.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", save);
		} else {
			Assert.fail("Save Button is not displayed");
		}
	}

	public void enterMandatoryClassDetails(String sheetName, String scenarioName)
			throws IOException, InterruptedException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
		if (scenarioName.equals("addClassWithOnlyMandatoryFields")) {
			String classTopicText = data.get(2);

			selectBatchnameDropdown();

			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			driver.findElement(classTopicTextbox).sendKeys(classTopicText);

			selectClassDates();
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			selectStaffName();

			WebElement activeBtn = driver.findElement(activeStatusBtn);
			activeBtn.click();

			clickSaveBtn();
		} else if (scenarioName.equals("addClassWithAllFields")) {
			String classTopicText = data.get(2);
			String classDescText = data.get(3);
			String comments = data.get(5);
			String notes = data.get(6);
			String recording = data.get(7);

			selectBatchnameDropdown();

			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			driver.findElement(classTopicTextbox).sendKeys(classTopicText);

			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			driver.findElement(classDescriptionTextbox).sendKeys(classDescText);

			selectClassDates();
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			selectStaffName();

			WebElement activeBtn = driver.findElement(activeStatusBtn);
			activeBtn.click();

			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			driver.findElement(commentsTextbox).sendKeys(comments);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			driver.findElement(notesTextbox).sendKeys(notes);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			driver.findElement(recordingTextbox).sendKeys(recording);

			clickSaveBtn();

		}
	}

	public void validateSuccessClassCreated(String sheetName, String scenarioName) {
		try {
			List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
			String messageText = data.get(8);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
			WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));
			String actualMsg = alert.getText();
			Assert.assertTrue(
					actualMsg.replaceAll("\\s+", " ").trim().contains(messageText.replaceAll("\\s+", " ").trim()));
		} catch (Exception e) {
			Assert.fail("Error in getting alerts" + e.getMessage());
		}
	}
}