package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.Constants;

public class Program extends Constants {

	WebDriver driver;
	private By programLink = By.id("program");
    private By programHeaderName = By.xpath("//*[contains(text(),'Manage Program')]");
	private By logoutLink = By.id("logout");
	
//Searchbar elements
	
	private By searchTextBox = By.id("filterGlobal");
    private By programNameFirstRecord=By.xpath("//tr[1]/td[2]");
    private By programDescFirstRecord=By.xpath("//tr[1]/td[3]");
    private By programStatusFirstRecord=By.xpath("//tr[1]/td[4]");
    private By paginationTextwithZeroRecord=By.xpath("//*[contains(text(),'Showing 0 to 0 of 0 entries')]");
//	private By batchLink = By.xpath("//*[text()='Batch']");

//Multi Delete Program elements
    
  private By programFirstRecordChk=By.xpath("//table[1]/tbody[1]/tr[1]/td[1]//div[1]/div[2]");
//  private By programFirstRecordChk=By.xpath("//tr[1]/td[1]");
  private By programSecondRecordChk=By.xpath("//tr[2]/td[1]/p-tablecheckbox/div/div[2]");
//  private By programSecondRecordChk=By.xpath("//tr[2]/td[1]");
  private By commonDeleteButton=By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
  private By confirmFormText=By.xpath("//span[contains(@class, 'p-dialog-title')]");
  private By programNameSecondRecord=By.xpath("//tr[2]/td[2]");
  private By programNameList = By.xpath("//tr/td[2]");
  private By yesButton = By.xpath("//*[text()='Yes']");
  private By toastMsgElement = By.xpath("//div[contains(@class, 'p-toast-detail')]");
  private By noButton = By.xpath("//*[text()='No']");
  private By XcloseButtonConfirmForm = By.xpath("//button[contains(@class, 'p-dialog-header-close')]");

  private static List<String> targetedDeleteProgramNames = new ArrayList<String>();
  
//Sorting Program Element

	private By programNameColumnHeader = By.xpath("//tr/th[2]");
//	private By programNameList = By.xpath("//tr/td[2]");
	private By programDescColumnHeader = By.xpath("//tr/th[3]");
	private By programDescList = By.xpath("//tr/td[3]");
	private By programStatuscColumnHeader = By.xpath("//tr/th[4]");
	private By programStatusList = By.xpath("//tr/td[4]");

//Pagination elements
	
	private By nextBtn = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	private By lastBtn = By.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	private By prevBtn = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple']");
	private By firstBtn = By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']");
	private By firstPageButton = By.xpath("//button[text()='1']");

	
  public Program(WebDriver driver){
		this.driver = driver;
	}
	public String getProgramPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getProgramHeaderName() {
		return driver.findElement(programHeaderName).getText();
	}
	
	public void clickProgramLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for program link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(programLink)));				
	}
	public boolean checkLogoutLink() {
        return driver.findElement(logoutLink).isDisplayed();
	}
	public void clearSearchBox() {
		driver.findElement(searchTextBox).clear();;
	}
	
	///////////////////////////////Multiple Delete Feature methods///////////////////////////////
	
	public void selectMultipleProgramChk() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for program link element to be clickable, then click
//		WebElement programLinkElement = wait.until(ExpectedConditions.elementToBeClickable(programLink));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(programLink)));				

		// Wait for first record checkbox element to be clickable, then click
//		WebElement programFirstRecordChkElement = wait.until(ExpectedConditions.elementToBeClickable(programFirstRecordChk));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(programFirstRecordChk)));		

		// Wait for second record checkbox element to be clickable, then click
		WebElement programSecondRecordChkElement = wait.until(ExpectedConditions.elementToBeClickable(programSecondRecordChk));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", programSecondRecordChkElement);		
	}

	public boolean isSelectedMultipleProgramChk() {
		boolean isSelected = false;
        String isSelectedProgramFirstRecordChk = driver.findElement(programFirstRecordChk).getAttribute("aria-checked");
        String isSelectedProgramSecondRecordChk = driver.findElement(programSecondRecordChk).getAttribute("aria-checked");
        System.out.println("Is checkbox selected? " + isSelectedProgramFirstRecordChk + " " +isSelectedProgramSecondRecordChk);
        if (isSelectedProgramFirstRecordChk.equalsIgnoreCase("true") && isSelectedProgramSecondRecordChk.equalsIgnoreCase("true"))
        	isSelected = true;
        return isSelected;
	}

	public boolean isEnabledCommonDeleteBtn() {
        boolean isEnabled = driver.findElement(commonDeleteButton).isEnabled();
        System.out.println("isEnabledCommonDeleteBtn? " + isEnabled);
        return isEnabled;
	}
	public void clickCommonDeleteButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement commonDeleteButtonElement = wait.until(ExpectedConditions.elementToBeClickable(commonDeleteButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", commonDeleteButtonElement);
//		commonDeleteButtonElement.click();
	}
	
	public boolean isCommonDeleteConfirmForm() {
		boolean isCommonDeleteConfirmForm = driver.getPageSource().contains("Confirm");
        System.out.println("isCommonDeleteConfirmForm? " + isCommonDeleteConfirmForm);
        return isCommonDeleteConfirmForm;
	}

	//List of program name of one page
	public List<String> getOriginalProgramNameList() {
		  //capture all the web elements into list
		  List<WebElement> elementsList = driver.findElements(programNameList);
		  
		  //capture text of all elements into new(original) list
		  List<String> originalList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		  System.out.println("originalList "+originalList);
			  
		  return originalList;
	}

	public boolean commonDeleteMultipleAlertConfirmYes() throws InterruptedException {
		
		//adding targeted multiple selected programs to be deleted in a list
//		targetedDeleteProgramNames = new ArrayList<String>();
//		targetedDeleteProgramNames.add(driver.findElement(programNameFirstRecord).getText().trim());
//		targetedDeleteProgramNames.add(driver.findElement(programNameSecondRecord).getText().trim());
		targetedDeleteProgramNames.add(driver.findElement(programNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteProgramNames.add(driver.findElement(programNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("=======targetedDeleteProgramNames======= "+targetedDeleteProgramNames);
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    driver.findElement(yesButton).click();
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
		
		Thread.sleep(1000);
				
		//check if selected programs are deleted from the data table
		List<String> originalProgramNameList = getOriginalProgramNameList();
		System.out.println("commonDeleteMultipleAlertConfirmYes getOriginalProgramNameList "+originalProgramNameList);

		boolean isDeleted = !originalProgramNameList.containsAll(targetedDeleteProgramNames);
		System.out.println("Selected programs are Deleted "+isDeleted);
		
		return isDeleted;
	}
	
	public String getToastMessage() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10) ); // Wait for up to 10 seconds
		WebElement toastMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toastMsgElement));

		String toastMessage = toastMessageElement.getText();
		System.out.println("Toast message: " + toastMessage);
		
		return toastMessage;
		
	}
	
	public void searchMultipleDeletedProgram() throws InterruptedException {
		
		//Searching by Deleted Program Name
		System.out.println("=======targetedDeleteProgramNames======= "+targetedDeleteProgramNames);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	 // Search for the first program name
	    driver.findElement(searchTextBox).sendKeys(targetedDeleteProgramNames.get(0));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));
//		Assert.assertTrue(driver.findElement(searchTextBox).getText().trim().equalsIgnoreCase(driver.findElement(programNameFirstRecord).getText().trim()),"1st Selection for Delete is not present");
	    wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
//		Assert.assertTrue(driver.findElement(searchTextBox).getText().toLowerCase().trim().equalsIgnoreCase(driver.findElement(programNameFirstRecord).getText().toLowerCase().trim()),"1st Selection for Delete is not present");
		Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"),"Showing 0 to 0 of 0 entries");
		clearSearchBox();
		
		// Search for the second program name
		driver.findElement(searchTextBox).sendKeys(targetedDeleteProgramNames.get(1));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));
//		Assert.assertTrue(driver.findElement(searchTextBox).getText().trim().equalsIgnoreCase(driver.findElement(programNameSecondRecord).getText().trim()),"1st Selection for Delete is not present");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
		Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"),"Showing 0 to 0 of 0 entries");
		clearSearchBox();
		driver.findElement(searchTextBox).sendKeys(" ");
		Thread.sleep(2000);
//	    wait.until(ExpectedConditions.textToBePresentInElementLocated(searchTextBox, " "));
	}

	public boolean commonDeleteMultipleAlertConfirmNo() throws InterruptedException {

		//adding targeted multiple selected programs to be deleted in a list
		targetedDeleteProgramNames = new ArrayList<String>();
//		targetedDeleteProgramNames.add(driver.findElement(programNameFirstRecord).getText().trim());
//		targetedDeleteProgramNames.add(driver.findElement(programNameSecondRecord).getText().trim());
		targetedDeleteProgramNames.add(driver.findElement(programNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteProgramNames.add(driver.findElement(programNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("targetedDeleteProgramNames "+targetedDeleteProgramNames);
		
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    driver.findElement(noButton).click();
		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
        
		Thread.sleep(1000);
		
		//check if selected programs are deleted from the data table
		List<String> originalProgramNameList = getOriginalProgramNameList();
		System.out.println("commonDeleteMultipleAlertConfirmNo getOriginalProgramNameList "+originalProgramNameList);

		boolean isNotDeleted = originalProgramNameList.containsAll(targetedDeleteProgramNames);
		System.out.println("Selected programs are Deleted "+isNotDeleted);
//		selectMultipleProgramChk();//to uncheck the selected check boxes
		
		return isNotDeleted;
	}

	public boolean clickXbuttonCofirmForm() throws InterruptedException {

		//adding targeted multiple selected programs to be deleted in a list
		targetedDeleteProgramNames = new ArrayList<String>();
		targetedDeleteProgramNames.add(driver.findElement(programNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteProgramNames.add(driver.findElement(programNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("targetedDeleteProgramNames "+targetedDeleteProgramNames);
		
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    driver.findElement(XcloseButtonConfirmForm).click();
		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
        
		Thread.sleep(1000);
		
		//check if selected programs are deleted from the data table
		List<String> originalProgramNameList = getOriginalProgramNameList();
		System.out.println("commonDeleteMultipleAlertConfirmNo getOriginalProgramNameList "+originalProgramNameList);

		boolean isNotDeleted = originalProgramNameList.containsAll(targetedDeleteProgramNames);
		System.out.println("Selected programs are Deleted "+isNotDeleted);
//		selectMultipleProgramChk();//to uncheck the selected check boxes
		
		return isNotDeleted;
	}

	////////////////////Program SearchBar Feature Scenarios method////////////////////////////
	
	public void searchProgram(String sheetname,String scenarioName) throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String programName = null;
		String programDesc = null;
		String status = null;
        // the column index we want to filter by (e.g., column 1)(0-based)
        int filterColumnIndex = 0;  
		
        List<String> rowData = xlutils.getRowData(sheetname, filterColumnIndex, scenarioName);
        programName = rowData.get(1);
		programDesc = rowData.get(2);
		status = rowData.get(3);
		System.out.println("==================programName===== "+programName);
		System.out.println("==================programDesc===== "+programDesc);
		System.out.println("==================status===== "+status);
 		
		clearSearchBox();
		
		if(scenarioName.equalsIgnoreCase("searchWithValidProgramName")) {
			
			driver.findElement(searchTextBox).sendKeys(programName);
//		    wait.until(ExpectedConditions.visibilityOfElementLocated(programNameFirstRecord));
			Thread.sleep(2000);

			Assert.assertTrue(programName.equalsIgnoreCase(driver.findElement(programNameFirstRecord).getText().trim()));
			Assert.assertTrue(programDesc.equalsIgnoreCase(driver.findElement(programDescFirstRecord).getText().trim()));
			Assert.assertTrue(status.equalsIgnoreCase(driver.findElement(programStatusFirstRecord).getText().trim()));
		}
		else if(scenarioName.equalsIgnoreCase("searchWithValidProgramDesc")) {
			driver.findElement(searchTextBox).sendKeys(programDesc);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(programNameFirstRecord));
	        Thread.sleep(2000);

			Assert.assertTrue(programName.trim().equalsIgnoreCase(driver.findElement(programNameFirstRecord).getText().trim()));
			Assert.assertTrue(programDesc.trim().equalsIgnoreCase(driver.findElement(programDescFirstRecord).getText().trim()));
			Assert.assertTrue(status.trim().equalsIgnoreCase(driver.findElement(programStatusFirstRecord).getText().trim()));
		}
		else if(scenarioName.equalsIgnoreCase("searchWithInvalidProgramName")) {
			driver.findElement(searchTextBox).sendKeys(programName);
	        wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
//			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"));
		}
		else if(scenarioName.equalsIgnoreCase("searchWithPartialProgramName")) {
			driver.findElement(searchTextBox).sendKeys(programName);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(programNameFirstRecord));
//			Thread.sleep(3000);

			Assert.assertTrue(driver.findElement(programNameFirstRecord).getText().trim().contains(programName.trim()));
			Assert.assertTrue(programDesc.trim().equalsIgnoreCase(driver.findElement(programDescFirstRecord).getText().trim()));
			Assert.assertTrue(status.trim().equalsIgnoreCase(driver.findElement(programStatusFirstRecord).getText().trim()));
			clearSearchBox();
			Thread.sleep(1000);
			driver.findElement(searchTextBox).sendKeys(" ");

		}
	}
///////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////Program Sorting Feature Methods/////////////////////////////////////////////////
	
	public void clickProgramNameColumnHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement programNameColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(programNameColumnHeader));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", programNameColumnHeaderElement);
//        driver.findElement(programNameColumnHeader).click();
	}
	public List<String> getSortedProgramNameListAsc() {
		
		  //sort on the original list  ->sorted list in Ascending order
		  List<String> sortedlList = getOriginalProgramNameList().stream().sorted().collect(Collectors.toList());
		  System.out.println("sortedlList "+sortedlList);

		  return sortedlList;

	}
		
	public List<String> getSortedProgramNameListDesc() {
		
		  //sort on the original list  ->sorted list in Descending order
		  List<String> sortedlListdesc = getOriginalProgramNameList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//		  System.out.println("getOriginalProgramNameList() "+getOriginalProgramNameList());
		  System.out.println("sortedlList desc "+sortedlListdesc);

		  return sortedlListdesc;

	}
	public void clickProgramDescColumnHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement programDescColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(programDescColumnHeader));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", programDescColumnHeaderElement);
//        driver.findElement(programDescColumnHeader).click();
	}
	
	public List<String> getOriginalProgramDescList() {
	  //capture all the web elements into list
	  List<WebElement> elementsList = driver.findElements(programDescList);
	  
	  //capture text of all elements into new(original) list
	  List<String> originalProgramDescriptionList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
	  System.out.println("originalProgramDescList "+originalProgramDescriptionList);
	  return originalProgramDescriptionList;
}

	public List<String> getSortedProgramDescriptionListAsc() {
		
		  //sort on the original list ->sorted list in Ascending order
		  List<String> desiredlList = getOriginalProgramDescList();
	        // Sort the list
	        Collections.sort(desiredlList);
	        
	        System.out.println("getSortedProgramDescriptionListAsc "+desiredlList);  

		  return desiredlList;

	}

	public List<String> getSortedProgramDescriptionListDesc() {
		
		  //sort on the original list ->sorted list in Descending order
		  List<String> sortedlListdesc = getOriginalProgramDescList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		  System.out.println("getSortedProgramDescriptionListDesc sortedlList desc "+sortedlListdesc);

		  return sortedlListdesc;

	}
	public void clickProgramStatusColumnHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement programStatusColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(programStatuscColumnHeader));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", programStatusColumnHeaderElement);
//        driver.findElement(programStatuscColumnHeader).click();
	}
	
	public List<String> getOriginalProgramStatusList() {
		  //capture all the web elements into list
		  List<WebElement> elementsList = driver.findElements(programStatusList);
		  
		  //capture text of all elements into new(original) list
		  List<String> originalProgramStatusList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		  System.out.println("originalProgramStatusList "+originalProgramStatusList);
		  return originalProgramStatusList;
	}

		public List<String> getSortedProgramStatusListAsc() {
			
			  //sort on the original list->sorted list in Ascending order
			  List<String> desiredlList = getOriginalProgramStatusList();
		        // Sort the list
		        Collections.sort(desiredlList);
		        
		        System.out.println("getSortedProgramStatusListAsc "+desiredlList);  

			  return desiredlList;

		}

		public List<String> getSortedProgramStatusListDesc() {
			
			  //sort on the original list->sorted list in Descending order
			  List<String> sortedlListdesc = getOriginalProgramStatusList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			  System.out.println("getSortedProgramDescriptionListDesc sortedlList desc "+sortedlListdesc);

			  return sortedlListdesc;

		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////Pagination features methods //////////////////////////////////////////////////
		
		public void clickNextLink()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement nextBtnElement = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextBtnElement);
//			driver.findElement(nextBtn).click();
		}

		public boolean isActiveNextLink()
		{
	        // Wait for the table to reload with the next page records
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

	        boolean isNextEnabled ;
	        List<WebElement> elements = driver.findElements(nextBtn);
	        if (!elements.isEmpty()) {
	            WebElement button = elements.get(0);
	            isNextEnabled = button.isEnabled();
	            // Perform actions on the button
	        } else {
	        	
	            // Element not found, 
	        	isNextEnabled = false;
	        }

	        return isNextEnabled;

		}
		
		public void clickLastLink()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement lastBtnElement = wait.until(ExpectedConditions.elementToBeClickable(lastBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastBtnElement);
//			driver.findElement(lastBtn).click();
		}

		public boolean isActiveLastLink()
		{
	        // Wait for the table to reload with the Last page records
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

			
			// Check if the last button is enabled

	        boolean isLastEnabled;
	        List<WebElement> elements = driver.findElements(lastBtn);
//	        List<WebElement> data = driver.findElements(tableDataRecord);
	        if (!elements.isEmpty()) {
	            WebElement button = elements.get(0);
	            isLastEnabled = button.isEnabled();
	            // Perform actions on the button
	        } else {
	        	
	            // Element not found, 
	        	isLastEnabled = false;
	        }
	        System.out.println("isLastEnabled "+isLastEnabled);  
//	        System.out.println("data "+data.getText());  

	        return isLastEnabled;

		
		}
		
		public void clickFirstLink()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement firstBtnElement = wait.until(ExpectedConditions.elementToBeClickable(firstBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstBtnElement);
//			driver.findElement(firstBtn).click();
		}
		
		public void clickPreviousLink()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement prevBtnElement = wait.until(ExpectedConditions.elementToBeClickable(prevBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", prevBtnElement);
//			driver.findElement(prevBtn).click();
		}
		
		public boolean isActivePreviousLink()
		{
	        // Wait for the table to reload with the Previous page records
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

	        boolean isPrevEnabled;
	        List<WebElement> elements = driver.findElements(prevBtn);
	        if (!elements.isEmpty()) {
	            WebElement button = elements.get(0);
	            isPrevEnabled = button.isEnabled();
	            // Perform actions on the button
	        } else {
	        	
	            // Element not found, handle accordingly
	        	isPrevEnabled = false;
	        }
	        System.out.println("isPrevEnabled "+isPrevEnabled);  

	        return isPrevEnabled;
		
		}

		public boolean isFirstPage()
		{
	        // Wait for the table to reload with the First page records
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(1000));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

	        boolean isOneButtonHighlighted  = driver.findElement(By.xpath("//span[@class='p-paginator-current ng-star-inserted']")).getText().contains("1");
	        System.out.println("isOneButtonHighlighted "+isOneButtonHighlighted);  

	        boolean isFirstPage;
	        if(isOneButtonHighlighted && getOriginalProgramNameList().size()>0)
	        {
	        	isFirstPage = true;
	        }
	        else
	        	isFirstPage = false;
	        
	        return isFirstPage;
		
		}

}
