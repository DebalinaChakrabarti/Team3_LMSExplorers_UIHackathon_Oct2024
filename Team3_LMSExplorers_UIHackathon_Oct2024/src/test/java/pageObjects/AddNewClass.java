package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Constants;

public class AddNewClass extends Constants {

	WebDriver driver;
	WebDriverWait wait;

	public AddNewClass(WebDriver driver) {
		this.driver = driver;
	}

	private By cancelButton = By.xpath("//span[contains(text(),'Cancel')]");
	private By saveButton = By.xpath("//span[contains(text(),'Save')]");
	private By xButton = By.xpath("//span[@ng-reflect-ng-class='pi pi-times']");
	private By batchName = By.xpath("//label[text()='Batch Name']");
	private By batchNameCheckbox = By.xpath(" //input[@placeholder='Select a Batch Name']");
	private By classTopic = By.xpath("//label[contains(text(),'Class Topic ')]");
	private By classTopicCheckbox = By.xpath("//input[@id='classTopic']");
	private By classDescription = By.xpath("//label[contains(text(),'Class Description')]");
	private By classDescriptionCheckbox = By.xpath("//input[@id='classDescription']");
	private By selectClassDates = By.xpath("//label[contains(text(),' Select Class Dates ')]");
	private By selectClassDatesCheckbox = By.xpath("//input[@id='icon']");
	private By noOfClasses = By.xpath("//label[@for='classNo']");
	private By noOfClassesCheckbox = By.xpath("//input[@id='classNo']");
	private By staffName = By.xpath("//label[@for='staffId']");
	private By staffNameCheckBox = By.xpath("//input[@placeholder='Select a Staff Name']");
	private By status = By.xpath("//lable[contains(text(),'Status')]");
	private By comments = By.xpath("//label[@for='classComments']");
	private By commentsCheckbox = By.xpath("//input[@id='classComments']");
	private By notes = By.xpath("//label[@for='classNotes']");
	private By notesCheckbox = By.xpath("//input[@id='classNotes']");
	private By recordings = By.xpath("//label[@for='classRecording']");
	private By recordingsCheckbox = By.xpath("//input[@id='classRecordingPath']");

//==Dash board Menu bar Class==//

	public void manageClass() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement classHeader = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Class')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", classHeader);
		wait.until(ExpectedConditions.elementToBeClickable(classHeader));

	}

//==Click on Class==//
	public void addNewClass() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement AddNewClass = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add New Class')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddNewClass);

	}

//==cancel button==//
	public void cancelClass() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement cancelButtonElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(cancelButton));
		wait.until(ExpectedConditions.visibilityOf(cancelButtonElement));			
		boolean expected = true;
		Assert.assertEquals(expected, cancelButtonElement.isDisplayed());

	}

//==Save button==//
	public void saveClass() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement saveButtonElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
		wait.until(ExpectedConditions.visibilityOf(saveButtonElement));			
		boolean expected = true;
		Assert.assertEquals(expected, saveButtonElement.isDisplayed());

	}

//==Close Icon==//
	public void closeIcon() {
		boolean Xbutton = driver.findElement(xButton).isDisplayed();
		boolean expected = true;
		Assert.assertEquals(expected, Xbutton);
	}

//==All Input and check boxes visibility==//
	public void inputFields() throws InterruptedException {

		boolean expected = true;
		Thread.sleep(1000);

		boolean BatchName = driver.findElement(batchName).isDisplayed();
		Assert.assertEquals(expected, BatchName);
		boolean BatchNameCheckbox = driver.findElement(batchNameCheckbox).isDisplayed();
		Assert.assertEquals(expected, BatchNameCheckbox);
		Thread.sleep(1000);

		boolean ClassTopic = driver.findElement(classTopic).isDisplayed();
		Assert.assertEquals(expected, ClassTopic);
		boolean ClassTopicCheckbox = driver.findElement(classTopicCheckbox).isDisplayed();
		Assert.assertEquals(expected, ClassTopicCheckbox);
		Thread.sleep(1000);

		boolean ClassDescription = driver.findElement(classDescription).isDisplayed();
		Assert.assertEquals(expected, ClassDescription);
		boolean ClassDescriptionCheckbox = driver.findElement(classDescriptionCheckbox).isDisplayed();
		Assert.assertEquals(expected, ClassDescriptionCheckbox);
		Thread.sleep(1000);

		boolean SelectClassDates = driver.findElement(selectClassDates).isDisplayed();
		Assert.assertEquals(expected, SelectClassDates);
		boolean SelectClassDatesCheckbox = driver.findElement(selectClassDatesCheckbox).isDisplayed();
		Assert.assertEquals(expected, SelectClassDatesCheckbox);
		Thread.sleep(1000);

		boolean NoOfClasses = driver.findElement(noOfClasses).isDisplayed();
		Assert.assertEquals(expected, NoOfClasses);
		boolean NoOfClassesCheckbox = driver.findElement(noOfClassesCheckbox).isDisplayed();
		Assert.assertEquals(expected, NoOfClassesCheckbox);
		Thread.sleep(1000);

		boolean StaffName = driver.findElement(staffName).isDisplayed();
		Assert.assertEquals(expected, StaffName);
		boolean StaffNameCheckBox = driver.findElement(staffNameCheckBox).isDisplayed();
		Assert.assertEquals(expected, StaffNameCheckBox);
		Thread.sleep(1000);

		boolean Status = driver.findElement(status).isDisplayed();
		Assert.assertEquals(expected, Status);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement StatusActive = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='radio ng-star-inserted']/div[2]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", StatusActive);
		String expectedText = "Active"; 
        String actualText = StatusActive.getText();
        Assert.assertEquals(expectedText, actualText);
       
		
		WebElement StatusInActive = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='radio ng-star-inserted']/div[3]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", StatusInActive);
		String expectedText1 = "Inactive";
		 String actualText1 = StatusInActive.getText();
		Assert.assertEquals(expectedText1, actualText1);
		

		boolean Comments = driver.findElement(comments).isDisplayed();
		Assert.assertEquals(expected, Comments);
		boolean CommentsCheckbox = driver.findElement(commentsCheckbox).isDisplayed();
		Assert.assertEquals(expected, CommentsCheckbox);

		boolean NotesCheckbox = driver.findElement(notesCheckbox).isDisplayed();
		Assert.assertEquals(expected, NotesCheckbox);
		boolean Notes = driver.findElement(notes).isDisplayed();
		Assert.assertEquals(expected, Notes);

		boolean RecordingsCheckbox = driver.findElement(recordingsCheckbox).isDisplayed();
		Assert.assertEquals(expected, RecordingsCheckbox);
		boolean Recordings = driver.findElement(recordings).isDisplayed();
		Assert.assertEquals(expected, Recordings);
		

		// Wait for program link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cancelButton))));				


	}
}
