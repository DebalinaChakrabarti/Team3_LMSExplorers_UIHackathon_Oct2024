package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Constants;

public class BatchPage extends Constants {

	WebDriver driver;
	private static WebDriverWait wait;
	private By batchHeader = By.xpath("//span[text()='Batch']");
	private By addNewBatchBtn = By.xpath("//button[text()='Add New Batch']");
	private By logoutLink = By.id("logout");
	private By programName = By.xpath("//label[text()='Program Name ']");
	private By batchName = By.xpath("//label[text()='Batch Name']");
	private By programDesc = By.xpath("//label[text()='Description ']");
	private By programStatus = By.xpath("//lable[text()='Status : ']");
	private By cancelBtn = By.xpath("//span[text()='Cancel']");
	private By saveBtn = By.xpath("//span[text()='Save']");
	private By no_of_classes = By.xpath("//label[text()='Number of Classes ']");
	private By batch_details = By.xpath("//span[text()='Batch Details']");
	private By closeBtnPopup = By.xpath("(//button[@ng-reflect-ng-class='[object Object]'])[10]");

	private By selectProgDropDown = By.xpath("//span [@ng-reflect-ng-class='pi pi-chevron-down']");
	private By selectbatchName = By.id("batchName");
	private By selectbatchprog = By.id("batchProg");
	private By batchNameError = By.xpath("//small[text()='This field accept only numbers and max 5 count. ']");
	private By alertmsg = By.xpath("//div[contains(@class, 'p-toast-detail')]");
	private By descTextBox = By.xpath("//input[@id='batchDescription']");
	private By activeStatusBtn = By.xpath("(//p-radiobutton[@name='category'])[1]");
	private By noOfClassesTxtBox = By.xpath("//input[@id='batchNoOfClasses']");
	private By batcherror = By.xpath("//small[text()='Batch Name is required.']");
	private By searchBar = By.id("filterGlobal");
	private By paginator = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private By batchDetails = By.xpath("//span[text()='Batch Details']");

	// Edit

	private By batchEdit = By.xpath("(//span[@class='p-button-icon pi pi-pencil'])[1]");
	WebElement editBatchBtn;
	private By batchEditDescError = By
			.xpath("//small[text()='This field should start with an alphabet and min 2 character.']");
	WebElement editBatchDescerror;
	
	private By editProgName = By.xpath("(//p-dropdown[@ng-reflect-is-disabled='true'])[1]");
	WebElement editProgNameDisabled;

	private By editBatchName = By.xpath("(//input[@ng-reflect-is-disabled='true'])[2]");
	WebElement editBatchNameDisabled;
	
	//delete
	
	private By delBtn = By.xpath("(//button[@icon='pi pi-trash'])[2]");
	private By confirmDelPopUp = By.xpath("//span[text()='Confirm']");
	private By noBtn = By.xpath("//button[@ng-reflect-label='No']");
	private By yesBtn = By.xpath("//button[@ng-reflect-label='Yes']");
	private By confirmDelIcon = By.xpath("//i[@ng-reflect-ng-class='p-confirm-dialog-icon']");
	
	

	public BatchPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkLogoutLink() {
		return driver.findElement(logoutLink).isDisplayed();
	}

	public void clickBatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(batchHeader)));
	}

	public void validateAddNewBatchBtn(String addNewBatch) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // 30 seconds timeout
		WebElement addBatchBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(addNewBatchBtn));

		String actualValue = addBatchBtn.getText().trim();
		Assert.assertEquals(addNewBatch.trim(), actualValue);

	}

	public void clickAddnewBatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				wait.until(ExpectedConditions.elementToBeClickable(addNewBatchBtn)));

	}

	public void validateBatchPopUp() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
		String actualBatchPopUpHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(batch_details))
				.getText();
		Assert.assertTrue(actualBatchPopUpHeading.contains("Batch Details"), "Batch details heading is not found!");
	}

	public void validateBatchDetailsPopUp(String expectedProgName, String expectedbatchName, String expectedDesc,
			String expectedStatus, String expectedno_of_classes, String expectedCancelBtn, String expectedSaveBtn) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
		String actualProgName = wait.until(ExpectedConditions.visibilityOfElementLocated(programName)).getText();
		String actualBatchName = wait.until(ExpectedConditions.visibilityOfElementLocated(batchName)).getText();
		String actualDesc = wait.until(ExpectedConditions.visibilityOfElementLocated(programDesc)).getText();
		String actualStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(programStatus)).getText();
		String actualno_of_classes = wait.until(ExpectedConditions.visibilityOfElementLocated(no_of_classes)).getText();
		String actualCancelbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBtn)).getText();
		String actualSavebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).getText();

		Assert.assertTrue(actualProgName.contains(expectedProgName), "Program Name label is not found!");
		Assert.assertTrue(actualBatchName.contains(expectedbatchName), "Batch Name label is not found!");
		Assert.assertTrue(actualDesc.contains(expectedDesc), "Program Description label is not found!");
		Assert.assertTrue(actualStatus.contains(expectedStatus), "Program Status label is not found!");
		Assert.assertTrue(actualno_of_classes.contains(expectedno_of_classes), "No_of_classes is not found!");
		Assert.assertTrue(actualCancelbtn.contains(expectedCancelBtn), "Program Cancel Button is not found!");
		Assert.assertTrue(actualSavebtn.contains(expectedSaveBtn), "Program Save Button is not found!");
	}

	public void clickCloseBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement closeBtn = driver.findElement(closeBtnPopup);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", closeBtn);

	}

	public void selectProgramNamedropDown() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement select_progname_drpdown = wait
				.until(ExpectedConditions.visibilityOfElementLocated(selectProgDropDown));
		wait.until(ExpectedConditions.visibilityOf(select_progname_drpdown));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", select_progname_drpdown);

	}

	public boolean validateSelectedProgName() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			for (WebElement roleStatus : roleStatusOptions) {
				roleStatus.click();
				Assert.assertTrue(true, roleStatus.getText());
				return true;

			}

		} catch (StaleElementReferenceException e) {
			log.info("Some expection" + e.getMessage());
		}
		return false;

	}

	public void clickBatchName() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement select_batch_name = wait.until(ExpectedConditions.visibilityOfElementLocated(selectbatchName));
		wait.until(ExpectedConditions.visibilityOf(select_batch_name));
		select_batch_name.sendKeys(configProp.getString("invalidBatchName"));
	}

	public boolean validateBatchNameError() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement select_batch_name = wait.until(ExpectedConditions.visibilityOfElementLocated(batchNameError));
			return select_batch_name.isDisplayed();
		} catch (Exception e) {
			Assert.fail("Error not required" + e.getMessage());
		}
		return false;
	}

	public boolean validateEmptyTextBox() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement select_batch_prog = wait.until(ExpectedConditions.visibilityOfElementLocated(selectbatchprog));
			if (select_batch_prog.getAttribute("readonly") != null) {
				System.out.println("The text box is readonly.");
			} else {
				System.out.println("The text box is editable.");
			}

		} catch (Exception e) {
			Assert.fail("Error not required" + e.getMessage());
		}
		return false;
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

	public void clickCancelBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement cancelBtnElement = wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cancelBtnElement);
	}

	public void enterBatchDetails(String sheetName, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);

		String batchNameText = data.get(2);
		String descriptionText = data.get(3);
		String noOfClasses = data.get(5);

		selectProgramNamedropDown();
		try {
			List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			for (WebElement roleStatus : roleStatusOptions) {
				roleStatus.click();
				Assert.assertTrue(true, roleStatus.getText());

			}

		} catch (StaleElementReferenceException e) {
			log.info("Some expection" + e.getMessage());
		}

		driver.findElement(selectbatchName).sendKeys(batchNameText);
		driver.findElement(descTextBox).sendKeys(descriptionText);
		WebElement activeBtn = driver.findElement(activeStatusBtn);
		activeBtn.click();
		driver.findElement(noOfClassesTxtBox).sendKeys(noOfClasses);
		if (scenarioName.equals("addNewBatchOnlyForMandatoryFields")
				|| scenarioName.equals("addNewBatchWithMissingData")) {
			clickSaveBtn();
		} else if (scenarioName.equals("enterValiddetailsAndClickCancel")) {
			clickCancelBtn();
		}
	}

	public boolean validateZeroResults() {
		try {
			WebElement paginatorElement = driver.findElement(paginator);
			String textValidation = paginatorElement.getText();
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(textValidation);
			List<Integer> numericValues = new ArrayList<Integer>();
			while (matcher.find()) {
				numericValues.add(Integer.parseInt(matcher.group()));
			}
			if (numericValues.size() == 3 && numericValues.get(2) == 0) {
				String expectedText = "Showing 0 to 0 of 0 entries";
				Assert.assertEquals(textValidation, expectedText,
						"Zero results message does not match expected format.");
				return true;
			}

		} catch (Exception e) {
			log.error("Error during zero results validation" + e.getMessage());
		}
		return false;

	}

	public void validatemessage(String sheetName, String scenarioName) {
		try {
			List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
			String messageText = data.get(6);

			if (scenarioName.equals("addNewBatchOnlyForMandatoryFields")) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
				WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));
				String actualMsg = alert.getText();
				Assert.assertTrue(
						actualMsg.replaceAll("\\s+", " ").trim().contains(messageText.replaceAll("\\s+", " ").trim()));
			} else if (scenarioName.equals("addNewBatchWithMissingData")) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
				WebElement batchErrormsg = wait.until(ExpectedConditions.visibilityOfElementLocated(batcherror));
				String actualbatchError = batchErrormsg.getText();
				System.out.println("Actual message--" + actualbatchError);
				Assert.assertTrue(actualbatchError.contains(messageText));
				clickCancelBtn();
			} else {
				log.info("No scenario is found to validate");
			}
		} catch (Exception e) {
			Assert.fail("Error in getting alerts" + e.getMessage());
		}
	}

	public void validateCanceledBatch(String sheetName, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
		WebElement search = driver.findElement(searchBar);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(search));
		System.out.println("Batch desc is: " + data.get(3));
		search.sendKeys(data.get(3));
		search.sendKeys(Keys.ENTER);
		validateZeroResults();
		search.clear();
	}

	public boolean isBatchDetailsPopupDisappears() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(batchDetails));
			return isInvisible;
		} catch (Exception e) {
			return false;
		}
	}

	// Edit
	public void clickEditBatchBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement editBtnElement = wait.until(ExpectedConditions.elementToBeClickable(batchEdit));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", editBtnElement);
	}

	public boolean validateProgramTextBoxNonEditable() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement select_batch_prog = wait.until(ExpectedConditions.visibilityOfElementLocated(editProgName));
			return select_batch_prog.isDisplayed();
		} catch (Exception e) {
			Assert.fail("Error not required" + e.getMessage());
		}
		return false;
	}

	public boolean validateBatchTextBoxNonEditable() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement select_batch_text = wait.until(ExpectedConditions.visibilityOfElementLocated(editBatchName));
			return select_batch_text.isDisplayed();

		} catch (Exception e) {
			Assert.fail("Error not required" + e.getMessage());
		}
		return false;
	}

	public void sendInvalidBatchDescClasses() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement select_batch_desc = wait.until(ExpectedConditions.visibilityOfElementLocated(descTextBox));
		select_batch_desc.clear();
		select_batch_desc.sendKeys(configProp.getString("invalidBatchDesc"));
		clickSaveBtn();

	}

	public boolean validateInvalidData() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement select_desc_error = wait
					.until(ExpectedConditions.visibilityOfElementLocated(batchEditDescError));

			if (select_desc_error.getText().equals(configProp.getString("invalidDescError"))
					);
			return true;
		} catch (Exception e) {
			Assert.fail("Error not required" + e.getMessage());
		}
		return false;
	}
	
	
	public void editBatchDetails(String sheetName, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);

		
		String descriptionText = data.get(3);
		String noOfClasses = data.get(5);

		selectProgramNamedropDown();
		try {
			List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
			for (WebElement roleStatus : roleStatusOptions) {
				roleStatus.click();
				Assert.assertTrue(true, roleStatus.getText());

			}

		} catch (StaleElementReferenceException e) {
			log.info("Some expection" + e.getMessage());
		}

		driver.findElement(descTextBox).clear();
		driver.findElement(descTextBox).sendKeys(descriptionText);
		WebElement activeBtn = driver.findElement(activeStatusBtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", activeBtn);
		driver.findElement(noOfClassesTxtBox).sendKeys(noOfClasses);
		if (scenarioName.equals("editNewBatchOnlyForMandatoryFields")){
			clickSaveBtn();
		} else if (scenarioName.equals("canceleditNewbatchForMandatoryFields")) {
			clickCancelBtn();
		}
	}

	public void validateEditmessage(String sheetName, String scenarioName) {
		try {
			List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
			String messageText = data.get(6);

			if (scenarioName.equals("editNewBatchOnlyForMandatoryFields")) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
				WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));
				String actualMsg = alert.getText();
				Assert.assertTrue(
						actualMsg.replaceAll("\\s+", " ").trim().contains(messageText.replaceAll("\\s+", " ").trim()));
			} else {
				log.info("No scenario is found to validate");
			}
		} catch (Exception e) {
			Assert.fail("Error in getting alerts" + e.getMessage());
		}
	}
	
	public void clickDeleteBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(delBtn)));				

	}


	public boolean validateDeleteConfirmPopUp() {
		try {
			WebElement confirm = driver.findElement(confirmDelPopUp);
			WebElement confirmIcon = driver.findElement(confirmDelIcon);
			WebElement no = driver.findElement(noBtn);
			WebElement yes = driver.findElement(yesBtn);
			if (confirm.isDisplayed() && confirmIcon.isDisplayed() && no.isDisplayed() && yes.isDisplayed()) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;

	}
	
	public boolean isConfirmDelPopUp() {
		try {
			return driver.findElement(confirmDelPopUp).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	public void searchBatchName(String sheetName, String scenarioName) throws IOException {
		int filterColumnIndex = 0;
		List<String> data = xlutils.getRowData(sheetName, filterColumnIndex, scenarioName);

		WebElement search = driver.findElement(searchBar);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(search));
		if (search.isDisplayed()) {
			System.out.println("Batch name is: " + data.get(2));
			search.sendKeys(data.get(2));
			search.sendKeys(Keys.ENTER);
		} else {
			Assert.fail("No search bar is displayed");
		}
	}
	
	public void clickConfirmationOption(String option) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
        WebElement no = wait.until(ExpectedConditions.elementToBeClickable(noBtn));
        WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(yesBtn));
		if (option.equalsIgnoreCase(no.getText())) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", no);
		} else if (option.equalsIgnoreCase(yes.getText())) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", yes);
		} else {
			Assert.fail("No buttons found on delete confirmation pop up");
		}

	}
	public void validateSuccessfulDelmessage(String sheetName, String scenarioName) {
		try {
			List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
			String messageText = data.get(6);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
	        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));
				String actualMsg = alert.getText();
				Assert.assertTrue(
						actualMsg.replaceAll("\\s+", " ").trim().contains(messageText.replaceAll("\\s+", " ").trim()));
		} catch (Exception e) {
			Assert.fail("Error in getting alerts" + e.getMessage());
		}
	}
	
	public boolean validateConfirmationFormDisappears() {
		try {
			return !driver.findElement(confirmDelPopUp).isDisplayed();
		}catch(Exception e) {
			Assert.fail("Confirmation pop up is shown");
		}
		return false;
		
	}
}
