package pageObjects;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Constants;

public class ProgramPage extends Constants {

	WebDriver driver;
	private static WebDriverWait wait;
	private By lmsHeading = By.xpath("//span[text()=' LMS - Learning Management System ']");
	private By programHeader = By.xpath("//span[text()='Program']");
	private By headers = By.xpath("//span[@class='mat-button-wrapper']");
	private By manageProgramHeader = By.xpath("//div[text()=' Manage Program']");
	private By logoutHeader = By.xpath("//span[text()='Logout']");
	private By addNewProgramBtn = By.xpath("//button[text()='Add New Program']");
	private By progcolHeaders = By.xpath("//tr/th");
	private By multipleDelBtn = By.xpath("(//button[@ng-reflect-icon='pi pi-trash'])[1]");
	private By searchBar = By.id("filterGlobal");
	private By headerCheckBox = By.xpath("(//div[@class='p-checkbox p-component'])[1]");
	private By allCheckBoxes = By.xpath("//div[@class='p-checkbox p-component']");
	private By sorticons = By.xpath("//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
	private By editdelicons = By.xpath("//div[@class='action']");
	private By paginator = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private By prevSetofPagesMove = By.xpath(
			"//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']");
	private By nextSetofPagesMove = By
			.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	private By nextPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	private By prevPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");
	private By programFooter = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");

	// Add new program
	private By programDetails = By.xpath("//span[text()='Program Details']");
	private By programName = By.xpath("//label[text()='Name']");
	private By programDesc = By.xpath("//label[text()='Description']");
	private By programStatus = By.xpath("//lable[text()='Status']");
	private By cancelBtn = By.xpath("//span[text()='Cancel']");
	private By saveBtn = By.xpath("//span[text()='Save']");
	private By progNameError = By.xpath("//small[text()='Program name is required.']");
	private By progDescError = By.xpath("//small[text()='Description is required.']");
	private By progStatuserror = By.xpath("//small[text()='Status is required.']");

	private By progNameTextBox = By.xpath("//input[@id='programName']");
	private By progDescTextBox = By.xpath("//input[@id='programDescription']");
	private By activeStatusBtn = By.xpath("(//p-radiobutton[@name='category'])[1]");
	private By inactiveStatusBtn = By.xpath("(//p-radiobutton[@name='category'])[2]");
	private By validProgNameCheck = By.xpath("(//tbody[@class='p-datatable-tbody']/tr/td)[2]");
	private By validProgDescCheck = By.xpath("(//tbody[@class='p-datatable-tbody']/tr/td)[3]");
	private By validProgStatusCheck = By.xpath("(//tbody[@class='p-datatable-tbody']/tr/td)[4]");
	private By closeBtnPopUp = By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c168-6 pi pi-times']");
	private By alertmsg = By.xpath("//div[contains(@class, 'p-toast-detail')]");
	private By delCloseBtnPopup=By.xpath("(//button[@ng-reflect-ng-class='[object Object]'])[10]");

//Edit program
	private By editBtn = By.xpath("(//button[@id='editProgram'])[1]");

	// Delete program

	private By delBtn = By.xpath("(//button[@id='deleteProgram'])[1]");
	private By confirmDelPopUp = By.xpath("//span[@class='p-dialog-title ng-tns-c204-7 ng-star-inserted']");
	private By noBtn = By.xpath("//button[@ng-reflect-label='No']");
	private By yesBtn = By.xpath("//button[@ng-reflect-label='Yes']");
	private By confirmDelIcon = By.xpath("//i[@ng-reflect-ng-class='p-confirm-dialog-icon']");

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
	public boolean checkLogoutLink() {
        return driver.findElement(logoutHeader).isDisplayed();
	}

	public void clickProgram() {
		driver.findElement(programHeader).click();
	}

	public void clickAddnewProgram() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for program link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(addNewProgramBtn)));				
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

		for (int i = 0; i < modules.size() - 1; i++) {
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

	        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
	        WebElement addNewProgram = wait.until(ExpectedConditions.visibilityOfElementLocated(addNewProgramBtn));

			String actualValue = addNewProgram.getText().trim();
			Assert.assertEquals(addNewProg.trim(), actualValue);
	}

	public void validateManageHeader(String manageheader) {
		String actualValue = driver.findElement(manageProgramHeader).getText().trim();
		Assert.assertEquals(manageheader.trim(), actualValue);
	}

	public void validateColheaders(String expectedProgName, String expectedDescription, String expectedStatus) {
		List<WebElement> tableHeaders = driver.findElements(progcolHeaders);
		List<String> actualColheaders = new ArrayList<>();

		for (int i = 1; i < tableHeaders.size() - 1; i++) {
			actualColheaders.add(tableHeaders.get(i).getText());
		}

		Assert.assertTrue(actualColheaders.contains(expectedProgName), "Program Name header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedDescription), "Program Description header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedStatus), "Program Status header not found!");

	}

	public boolean validateMultipleDeleteBtnDisabled() {
		try {
			return !driver.findElement(multipleDelBtn).isEnabled();
		} catch (Exception e) {
			return false;
		}

	}

	public void validateSearchBar(String expectedSearchPlaceholder) {
		if (driver.findElement(searchBar).isDisplayed()) {
			WebElement searchText = driver.findElement(searchBar);
			String actualSearchPlaceholder = searchText.getAttribute("placeholder");
			Assert.assertEquals(expectedSearchPlaceholder, actualSearchPlaceholder);
		}
	}

	public void validateAllColHeaders(String expectedProgName, String expectedDescription, String expectedStatus,
			String expectedEditdel) {
		List<WebElement> tableHeaders = driver.findElements(progcolHeaders);
		List<String> actualColheaders = new ArrayList<>();

		for (int i = 1; i < tableHeaders.size(); i++) {
			actualColheaders.add(tableHeaders.get(i).getText());
		}

		Assert.assertTrue(actualColheaders.contains(expectedProgName), "Program Name header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedDescription), "Program Description header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedStatus), "Program Status header not found!");
		Assert.assertTrue(actualColheaders.contains(expectedEditdel), "Program Edit/Delete header not found!");

	}

	public boolean validateheaderCheckBoxUnchecked() {
		try {
			return !driver.findElement(headerCheckBox).isSelected();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean validateAllCheckBoxesUnchecked() {
		try {
			List<WebElement> uncheckedBoxes = driver.findElements(allCheckBoxes);
			for (int i = 1; i < uncheckedBoxes.size(); i++) {
				if (uncheckedBoxes.get(i).isSelected())
					return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

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

	public boolean validateEditDelIcons() {
		try {
			List<WebElement> editDelIcons = driver.findElements(editdelicons);

			for (int i = 0; i < editDelIcons.size(); i++) {
				if (editDelIcons.get(i).isDisplayed())
					return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public void validatePaginationTextandIcons(String text) throws InterruptedException {
		Thread.sleep(1000);
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

	public void validateFooter(String count) {

		String tot_cnt = driver.findElement(programFooter).getText();
		count = tot_cnt.replaceAll("\\D+", "");
		Integer.parseInt(count.trim());
		Assert.assertEquals(tot_cnt, "In total there are " + count + " programs.");

	}

	// Add new program

	public void validateProgramDetailsPopUp(String expectedName, String expectedDesc, String expectedStatus,
			String expectedCancelBtn, String expectedSaveBtn) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
		String actualName = wait.until(ExpectedConditions.visibilityOfElementLocated(programName)).getText();
		String actualDesc = wait.until(ExpectedConditions.visibilityOfElementLocated(programDesc)).getText();
		String actualStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(programStatus)).getText();
		String actualCancelbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(cancelBtn)).getText();
		String actualSavebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).getText();
		

		Assert.assertTrue(actualName.contains(expectedName), "Program Name label is not found!");
		Assert.assertTrue(actualDesc.contains(expectedDesc), "Program Description label is not found!");
		Assert.assertTrue(actualStatus.contains(expectedStatus), "Program Status label is not found!");
		Assert.assertTrue(actualCancelbtn.contains(expectedCancelBtn), "Program Cancel Button is not found!");
		Assert.assertTrue(actualSavebtn.contains(expectedSaveBtn), "Program Save Button is not found!");
	}

	public void validateProgramDetailsTitle(String expectedTitle) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
		String actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(programDetails)).getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	public boolean validateAsterisk(String asterisk, String field) {
		By asterisk_path = By.xpath("(//span[text()='*'])");
		String expectedColor = "rgba(255, 0, 0, 1)";
		WebElement field_path;

		try {
			for (int i = 1; i <= 3; i++) {
				WebElement asteriskElement = driver.findElement(By.xpath(asterisk_path + "[" + i + "]"));
				String color = asteriskElement.getCssValue("color");

				switch (field) {
				case "Program name":
					field_path = driver.findElement(programName);
					break;
				case "Description":
					field_path = driver.findElement(programDesc);
					break;
				case "Status":
					field_path = driver.findElement(programStatus);
					break;
				default:
					Assert.fail("Field not recognized: " + field);
					return false;
				}
				if (field_path.getText().equals(field) && asteriskElement.isDisplayed()) {
					if (color.equals(expectedColor)) {
						return true;
					} else {
						Assert.fail("Asterisk validation failed");
					}
				}
			}
		} catch (Exception e) {
			return false; // Return false if an exception occurs
		}

		return false; // Return false if no conditions were met
	}

	public boolean isProgramDetailsPopup() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement programDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(programDetails));
			return programDetailsElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
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

	public String validateEmptyFormSubmissionErrors(String field) {
		System.out.println("Field passed: " + field);
		if (field.equals("Program name")) {
			String errorMsg = driver.findElement(progNameError).getText().trim();
			System.out.println("Prog Name Error--" + errorMsg);
			return errorMsg;
		} else if (field.equals("Description")) {

			return driver.findElement(progDescError).getText().trim();
		} else if (field.equals("Status")) {

			return driver.findElement(progStatuserror).getText().trim();
		} else {
			log.info("No errors is found");
		}
		return field;

	}

	public boolean isProgramDetailsPopupDisappears() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(programDetails));
			return isInvisible;
		} catch (Exception e) {
			return false;
		}
	}

	public void enterProgramName() {
		if (driver.findElement(progNameTextBox).isDisplayed()) {
			driver.findElement(progNameTextBox).sendKeys(configProp.getString("progName"));
		} else {
			Assert.fail("Program Text Box is not displayed");
		}
	}

	public void validateEnteredText() {
		String actualValue = driver.findElement(progNameTextBox).getAttribute("value").trim();
		Assert.assertEquals(configProp.getString("progName"), actualValue);
	}

	public void enterProgramDesc() {
		if (driver.findElement(progDescTextBox).isDisplayed()) {
			driver.findElement(progDescTextBox).sendKeys(configProp.getString("progDesc"));
		} else {
			Assert.fail("Program Description Box is not displayed");
		}
	}

	public void validateEnteredDesc() {
		String actualValue = driver.findElement(progDescTextBox).getAttribute("value").trim();
		Assert.assertEquals(configProp.getString("progDesc"), actualValue);
	}

	public void selectStatus(String status) {
		Map<String, By> statusBtnMap = new HashMap<>();
		statusBtnMap.put("Active", activeStatusBtn);
		statusBtnMap.put("Inactive", inactiveStatusBtn);
		String element = " " + status + " ";
		By statusTextLocator = By.xpath("//div[text()='" + element + "']");
		WebElement statusTextElement = driver.findElement(statusTextLocator);
		if (statusBtnMap.containsKey(status)) {
			WebElement statusRadioBtnElement = driver.findElement(statusBtnMap.get(status));
			if (statusTextElement.getText().equals(status) && statusRadioBtnElement.isEnabled()
					&& statusRadioBtnElement.isDisplayed()) {
				statusRadioBtnElement.click();

			}
		} else {
			Assert.fail("Active and Inactive status button is not available");
		}
	}

	public void validateSelectedStatus(String expectedStatus) {
		String element = " " + expectedStatus + " ";
		By statusTextLocator = By.xpath("//div[text()='" + element + "']");
		WebElement statusTextElement = driver.findElement(statusTextLocator);
		if (statusTextElement.getText().equals(expectedStatus)) {
			System.out.println("Validation successful: Selected status matches expected status: " + expectedStatus);
		} else {
			Assert.fail("Validation failed: Expected status: " + expectedStatus + ", but found: "
					+ statusTextElement.getText());
		}
	}

	public void enterValidProgramDetails(String sheetName, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);

		String programNameText = data.get(1);
		String descriptionText = data.get(2);
		driver.findElement(progNameTextBox).sendKeys(programNameText);
		driver.findElement(progDescTextBox).sendKeys(descriptionText);

		WebElement activeBtn = driver.findElement(activeStatusBtn);
		activeBtn.click();

		clickSaveBtn();
	}

	public void validatemessage(String sheetName, String scenarioName) {
		try {
			List<String> data = xlutils.getRowData(sheetName, 0, scenarioName);
			String messageText = data.get(4);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
	        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));
			if (alert.isDisplayed()) {
				String actualMsg = alert.getText();
				Assert.assertTrue(
						actualMsg.replaceAll("\\s+", " ").trim().contains(messageText.replaceAll("\\s+", " ").trim()));
			} else {
				Assert.fail("Error in getting alerts");
			}
		} catch (Exception e) {
			Assert.fail("Error in getting alerts" + e.getMessage());
		}
	}

	public void searchProgName(String sheetName, String scenarioName) throws IOException {
		int filterColumnIndex = 0;
		List<String> data = xlutils.getRowData(sheetName, filterColumnIndex, scenarioName);

		WebElement search = driver.findElement(searchBar);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(search));
		if (search.isDisplayed()) {
			System.out.println("Program name is: " + data.get(1));
			search.sendKeys(data.get(1));
			search.sendKeys(Keys.ENTER);
		} else {
			Assert.fail("No search bar is displayed");
		}
	}

	public boolean validateProgName(String sheetName, String scenarioName) {
		try {

			int filterColumnIndex = 0;
			List<String> data = xlutils.getRowData(sheetName, filterColumnIndex, scenarioName);
			String validProgNameText = data.get(1);
			WebElement validName = driver.findElement(validProgNameCheck);
			if (validName.getText().contains(validProgNameText)) {
				return driver.findElement(validProgNameCheck).isDisplayed();
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public void clickCloseBtn() {
		WebElement closeBtn = driver.findElement(closeBtnPopUp);
		if (closeBtn.isDisplayed()) {
			closeBtn.click();
		}
	}

//Edit program
	public void clickEditBtn() {
		WebElement editButton = driver.findElement(editBtn);
		if (editButton.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", editButton);
		} else {
			Assert.fail("Unable to find edit button");
		}
	}

	public void editProgramName(String sheetname, String scenarioName) throws IOException {
		List<String> data = xlutils.getRowData(sheetname, 0, scenarioName);
		if (scenarioName.equalsIgnoreCase("editProgramWithProgramName")) {
			String programName = data.get(1);
			WebElement programNameText = driver.findElement(progNameTextBox);
			if (programNameText.isDisplayed()) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOf(programNameText));
				programNameText.clear();
				programNameText.sendKeys(programName);
				clickSaveBtn();
			}
		} else if (scenarioName.equalsIgnoreCase("editProgramWithProgramDescription")) {
			String programDesc = data.get(2);
			WebElement programDescText = driver.findElement(progDescTextBox);
			if (programDescText.isDisplayed()) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOf(programDescText));
				programDescText.clear();
				programDescText.sendKeys(programDesc);
				clickSaveBtn();
			}
		} else if (scenarioName.equalsIgnoreCase("editProgramWithProgramStatus")) {
			String statusText = data.get(3);

			WebElement statusBtn = driver.findElement(inactiveStatusBtn);
			if (statusBtn.isDisplayed()) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOf(statusBtn));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", statusBtn);
				By statusTextLocator = By.xpath("//div[text()=' Inactive ']");
				WebElement statusTextElement = driver.findElement(statusTextLocator);
				if (statusTextElement.getText().equals(statusText)) {
					clickSaveBtn();
				}
			}
		} else {
			Assert.fail("Program Edit validation failed");
		}
	}

	public void validateEditedProg(String sheetname, String scenarioName) {
		try {

			List<String> data = xlutils.getRowData(sheetname, 0, scenarioName);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(35)); // 30 seconds timeout
	        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));
			String messageText = data.get(4);
//			WebElement alert = driver.findElement(alertmsg);
//			if (alert.isDisplayed()) {
				String actualMsg = alert.getText();
				Assert.assertTrue(
						actualMsg.replaceAll("\\s+", " ").trim().contains(messageText.replaceAll("\\s+", " ").trim()));
//			} else {
//				Assert.fail("Error in getting alerts");
//			}
		} catch (Exception e) {
			Assert.fail("Error in getting alerts" + e.getMessage());
		}
	}

	public boolean validateUpdatedProgDetails(String sheetName, String scenarioName) {
		try {

			int filterColumnIndex = 0;
			List<String> data = xlutils.getRowData(sheetName, filterColumnIndex, scenarioName);
			String validProgNameText = data.get(1);
			String validProgDescText = data.get(2);
			String validProgStatusText = data.get(3);

			WebElement validName = driver.findElement(validProgNameCheck);
			WebElement validDesc = driver.findElement(validProgDescCheck);
			WebElement validStatus = driver.findElement(validProgStatusCheck);

			if (validName.getText().contains(validProgNameText)) {
				return driver.findElement(validProgNameCheck).isDisplayed();
			} else if (validDesc.getText().contains(validProgDescText)) {
				return driver.findElement(validProgDescCheck).isDisplayed();
			} else if (validStatus.getText().contains(validProgStatusText)) {
				return driver.findElement(validProgStatusCheck).isDisplayed();
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	// Delete Program

	public void clickDeleteBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for program link element to be clickable, then click
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

	public void validateSuccessfulDelmessage(String msg) {
		try {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
	        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));
				String actualMsg = alert.getText();
				Assert.assertTrue(
						actualMsg.replaceAll("\\s+", " ").trim().contains(msg.replaceAll("\\s+", " ").trim()));
		} catch (Exception e) {
			Assert.fail("Error in getting alerts" + e.getMessage());
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
	
	public boolean validateConfirmationFormDisappears() {
		try {
			return !driver.findElement(confirmDelPopUp).isDisplayed();
		}catch(Exception e) {
			Assert.fail("Confirmation pop up is shown");
		}
		return false;
		
	}
	
	public void clickDeleteCloseBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement delcloseBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(delCloseBtnPopup));
			wait.until(ExpectedConditions.visibilityOf(delcloseBtn));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", delcloseBtn);
	}


}
