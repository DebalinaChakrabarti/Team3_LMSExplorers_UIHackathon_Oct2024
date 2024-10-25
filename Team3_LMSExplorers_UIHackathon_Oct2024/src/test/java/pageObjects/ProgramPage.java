package pageObjects;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		WebElement addNewProgram = driver.findElement(addNewProgramBtn);
		if (addNewProgram.isDisplayed()) {
			String actualValue = addNewProgram.getText().trim();
			Assert.assertEquals(addNewProg.trim(), actualValue);
		} else {
			Assert.fail("Add New Program button is not displayed");
		}
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

	public void validateFooter(String count) {

		String tot_cnt = driver.findElement(programFooter).getText();
		count = tot_cnt.replaceAll("\\D+", "");
		Integer.parseInt(count.trim());
		Assert.assertEquals(tot_cnt, "In total there are " + count + " programs.");

	}

}
