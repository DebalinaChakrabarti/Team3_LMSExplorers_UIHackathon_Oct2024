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

public class Batch extends Constants {

	WebDriver driver;
	private By batchLink = By.xpath("//*[text()='Batch']");
    private By batchHeaderName = By.xpath("//*[contains(text(),'Manage Batch')]");
	private By logoutLink = By.id("logout");
	
//Searchbar elements
	
	private By searchTextBox = By.id("filterGlobal");
    private By batchNameFirstRecord=By.xpath("//tr[1]/td[2]");
    private By batchDescFirstRecord=By.xpath("//tr[1]/td[3]");
    private By batchStatusFirstRecord=By.xpath("//tr[1]/td[4]");
    private By paginationTextwithZeroRecord=By.xpath("//*[contains(text(),'Showing 0 to 0 of 0 entries')]");

//Multi Delete Batch elements
    
  private By batchFirstRecordChk=By.xpath("//table[1]/tbody[1]/tr[1]/td[1]//div[1]/div[2]");
  private By batchSecondRecordChk=By.xpath("//tr[2]/td[1]/p-tablecheckbox/div/div[2]");
  private By commonDeleteButton=By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
  private By confirmFormText=By.xpath("//span[contains(@class, 'p-dialog-title')]");
  private By batchNameSecondRecord=By.xpath("//tr[2]/td[2]");
  private By batchNameList = By.xpath("//tr/td[2]");
  private By yesButton = By.xpath("//*[text()='Yes']");
  private By toastMsgElement = By.xpath("//div[contains(@class, 'p-toast-detail')]");
  private By noButton = By.xpath("//*[text()='No']");
  private By XcloseButtonConfirmForm = By.xpath("//button[contains(@class, 'p-dialog-header-close')]");

  private static List<String> targetedDeleteBatchNames = new ArrayList<String>();
  
//Sorting Program Element

	private By batchNameColumnHeader = By.xpath("//tr/th[2]");
	private By batchDescColumnHeader = By.xpath("//tr/th[3]");
	private By batchDescList = By.xpath("//tr/td[3]");
	private By batchStatuscColumnHeader = By.xpath("//tr/th[4]");
	private By batchStatusList = By.xpath("//tr/td[4]");

//Pagination elements
	
	private By nextBtn = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	private By lastBtn = By.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	private By prevBtn = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple']");
	private By firstBtn = By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']");
	private By firstPageButton = By.xpath("//button[text()='1']");

	
  public Batch(WebDriver driver){
		this.driver = driver;
	}
	public String getBatchPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getBatchHeaderName() {
		return driver.findElement(batchHeaderName).getText();
	}
	
	public void clickBatchLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for program link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(batchLink)));				
	}
	public boolean checkLogoutLink() {
        return driver.findElement(logoutLink).isDisplayed();
	}
	public void clearSearchBox() {
		driver.findElement(searchTextBox).clear();;
	}
	
	///////////////////////////////Multiple Delete Feature methods///////////////////////////////
	
	public void selectOneBatchChk() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for program link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(batchFirstRecordChk)));				
	}

	public String isSelectedBatchChk() {
        String isSelected = driver.findElement(batchFirstRecordChk).getAttribute("aria-checked");
        System.out.println("Is checkbox selected? " + isSelected);
        return isSelected;
	}

	public void selectMultipleBatchChk() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for program link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(batchLink)));				

		// Wait for first record checkbox element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(batchFirstRecordChk)));		

		// Wait for second record checkbox element to be clickable, then click
		WebElement batchSecondRecordChkElement = wait.until(ExpectedConditions.elementToBeClickable(batchSecondRecordChk));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", batchSecondRecordChkElement);		
	}

	public boolean isSelectedMultipleBatchChk() {
		boolean isSelected = false;
        String isSelectedBatchFirstRecordChk = driver.findElement(batchFirstRecordChk).getAttribute("aria-checked");
        String isSelectedBatchSecondRecordChk = driver.findElement(batchSecondRecordChk).getAttribute("aria-checked");
        System.out.println("Is checkbox selected? " + isSelectedBatchFirstRecordChk + " " +isSelectedBatchSecondRecordChk);
        if (isSelectedBatchFirstRecordChk.equalsIgnoreCase("true") && isSelectedBatchSecondRecordChk.equalsIgnoreCase("true"))
        	isSelected = true;
        return isSelected;
	}

	public boolean isEnabledCommonDeleteBtn() {
      boolean isEnabled = driver.findElement(commonDeleteButton).isEnabled();
      System.out.println("isEnabledCommonDeleteBtn? " + isEnabled);
      return isEnabled;
	}
	
	public String isDisabledCommonDeleteBtn() {
		WebElement deleteButton = driver.findElement(commonDeleteButton);
		String isDisabled = deleteButton.getAttribute("disabled");

		if (isDisabled == null) {
		    System.out.println("The button is enabled." +isDisabled);
		} else {
		    System.out.println("The button is disabled." +isDisabled);
		}	
		return isDisabled;
	}

	
	public void clickCommonDeleteButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement commonDeleteButtonElement = wait.until(ExpectedConditions.elementToBeClickable(commonDeleteButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", commonDeleteButtonElement);
	}
	
	public boolean isCommonDeleteConfirmForm() {
		boolean isCommonDeleteConfirmForm = driver.getPageSource().contains("Confirm");
        System.out.println("isCommonDeleteConfirmForm? " + isCommonDeleteConfirmForm);
        return isCommonDeleteConfirmForm;
	}

	//List of batch name of one page
	public List<String> getOriginalBatchNameList() {
		  //capture all the web elements into list
		  List<WebElement> elementsList = driver.findElements(batchNameList);
		  
		  //capture text of all elements into new(original) list
		  List<String> originalList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		  System.out.println("originalList "+originalList);
			  
		  return originalList;
	}

	public boolean commonDeleteAlertConfirmYes() throws InterruptedException {
		
		//storing selected batch to be deleted in a string
		String targetedDeleteBatchName = driver.findElement(batchNameFirstRecord).getText().toLowerCase().trim();
		System.out.println("targetedDeleteProgramName "+targetedDeleteBatchName);
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			// Wait for batch link element to be clickable, then click
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(yesButton)));				
		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
		
		Thread.sleep(1000);
		
		//check selected program is deleted from the data table
		List<String> originalBatchNameList = getOriginalBatchNameList();
		System.out.println("commonDeleteAlertConfirmYes getOriginalBatchNameList "+originalBatchNameList);

		boolean isDeleted = !originalBatchNameList.contains(targetedDeleteBatchName);
		System.out.println("isDeleted "+isDeleted);
		
		return isDeleted;
	}
	public boolean commonDeleteMultipleAlertConfirmYes() throws InterruptedException {
		
		//adding targeted multiple selected programs to be deleted in a list
		targetedDeleteBatchNames.add(driver.findElement(batchNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteBatchNames.add(driver.findElement(batchNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("=======targetedDeleteProgramNames======= "+targetedDeleteBatchNames);
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();
		Thread.sleep(1000);

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    driver.findElement(yesButton).click();
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
		
		Thread.sleep(1000);
				
		//check if selected batches are deleted from the data table
		List<String> originalBatchNameList = getOriginalBatchNameList();
		System.out.println("commonDeleteMultipleAlertConfirmYes getOriginalBatchNameList "+originalBatchNameList);

		boolean isDeleted = !originalBatchNameList.containsAll(targetedDeleteBatchNames);
		System.out.println("Selected batches are Deleted "+isDeleted);
		
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
		
		//Searching by Deleted Batch Name
		System.out.println("=======targetedDeleteProgramNames======= "+targetedDeleteBatchNames);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	 // Search for the first program name
	    driver.findElement(searchTextBox).sendKeys(targetedDeleteBatchNames.get(0));
	    wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
		Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"),"Showing 0 to 0 of 0 entries");
		clearSearchBox();
		
		// Search for the second program name
		driver.findElement(searchTextBox).sendKeys(targetedDeleteBatchNames.get(1));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
		Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"),"Showing 0 to 0 of 0 entries");
		clearSearchBox();
		driver.findElement(searchTextBox).sendKeys(" ");
		Thread.sleep(2000);
	}

	public boolean commonDeleteMultipleAlertConfirmNo() throws InterruptedException {

		//adding targeted multiple selected programs to be deleted in a list
		targetedDeleteBatchNames = new ArrayList<String>();
		targetedDeleteBatchNames.add(driver.findElement(batchNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteBatchNames.add(driver.findElement(batchNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("targetedDeleteBatchNames "+targetedDeleteBatchNames);
		
		
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
		List<String> originalBatchNameList = getOriginalBatchNameList();
		System.out.println("commonDeleteMultipleAlertConfirmNo getOriginalBatchNameList "+originalBatchNameList);

		boolean isNotDeleted = originalBatchNameList.containsAll(targetedDeleteBatchNames);
		System.out.println("Selected batches are Deleted "+isNotDeleted);
//		selectMultipleProgramChk();//to uncheck the selected check boxes
		
		return isNotDeleted;
	}

	public boolean clickXbuttonCofirmForm() throws InterruptedException {

		//adding targeted multiple selected programs to be deleted in a list
		targetedDeleteBatchNames = new ArrayList<String>();
		targetedDeleteBatchNames.add(driver.findElement(batchNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteBatchNames.add(driver.findElement(batchNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("targetedDeleteBatchNames "+targetedDeleteBatchNames);
		
		
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
		
		//check if selected batches are deleted from the data table
		List<String> originalBatchNameList = getOriginalBatchNameList();
		System.out.println("commonDeleteMultipleAlertConfirmNo getOriginalProgramNameList "+originalBatchNameList);

		boolean isNotDeleted = originalBatchNameList.containsAll(targetedDeleteBatchNames);
		System.out.println("Selected programs are Deleted "+isNotDeleted);
//		selectMultipleProgramChk();//to uncheck the selected check boxes
		
		return isNotDeleted;
	}

	////////////////////Batch SearchBar Feature Scenarios method////////////////////////////
	
	public void searchBatch(String sheetname,String scenarioName) throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String batchName = null;
		String batchDesc = null;
		String status = null;
        // the column index we want to filter by (e.g., column 1)(0-based)
        int filterColumnIndex = 0;  
		
        List<String> rowData = xlutils.getRowData(sheetname, filterColumnIndex, scenarioName);
        batchName = rowData.get(1);
		batchDesc = rowData.get(2);
		status = rowData.get(3);
		System.out.println("==================batchName===== "+batchName);
		System.out.println("==================batchDesc===== "+batchDesc);
		System.out.println("==================status===== "+status);
 		
		clearSearchBox();
		
		if(scenarioName.equalsIgnoreCase("searchWithValidBatchName")) {
			
			driver.findElement(searchTextBox).sendKeys(batchName);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(batchNameFirstRecord));
			Thread.sleep(2000);

			Assert.assertTrue(batchName.equalsIgnoreCase(driver.findElement(batchNameFirstRecord).getText().trim()));
			Assert.assertTrue(batchDesc.equalsIgnoreCase(driver.findElement(batchDescFirstRecord).getText().trim()));
			Assert.assertTrue(status.equalsIgnoreCase(driver.findElement(batchStatusFirstRecord).getText().trim()));
		}
		else if(scenarioName.equalsIgnoreCase("searchWithValidBatchDesc")) {
			driver.findElement(searchTextBox).sendKeys(batchDesc);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(batchNameFirstRecord));
	        Thread.sleep(2000);

			Assert.assertTrue(batchName.trim().equalsIgnoreCase(driver.findElement(batchNameFirstRecord).getText().trim()));
			Assert.assertTrue(batchDesc.trim().equalsIgnoreCase(driver.findElement(batchDescFirstRecord).getText().trim()));
			Assert.assertTrue(status.trim().equalsIgnoreCase(driver.findElement(batchStatusFirstRecord).getText().trim()));
		}
		else if(scenarioName.equalsIgnoreCase("searchWithInvalidBatchName")) {
			driver.findElement(searchTextBox).sendKeys(batchName);
	        wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
			Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"));
		}
		else if(scenarioName.equalsIgnoreCase("searchWithPartialBatchName")) {
			driver.findElement(searchTextBox).sendKeys(batchName);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(batchNameFirstRecord));

			Assert.assertTrue(driver.findElement(batchNameFirstRecord).getText().trim().contains(batchName.trim()));
			Assert.assertTrue(batchDesc.trim().equalsIgnoreCase(driver.findElement(batchDescFirstRecord).getText().trim()));
			Assert.assertTrue(status.trim().equalsIgnoreCase(driver.findElement(batchStatusFirstRecord).getText().trim()));
			clearSearchBox();
			Thread.sleep(1000);
			driver.findElement(searchTextBox).sendKeys(" ");

		}
	}
///////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////Batch Sorting Feature Methods/////////////////////////////////////////////////
	
	public void clickBatchNameColumnHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement programNameColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(batchNameColumnHeader));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", programNameColumnHeaderElement);
	}
	public List<String> getSortedBatchNameListAsc() {
		
		  //sort on the original list  ->sorted list in Ascending order
		  List<String> sortedlList = getOriginalBatchNameList().stream().sorted().collect(Collectors.toList());
		  System.out.println("sortedlList "+sortedlList);

		  return sortedlList;

	}
		
	public List<String> getSortedBatchNameListDesc() {
		
		  //sort on the original list  ->sorted list in Descending order
		  List<String> sortedlListdesc = getOriginalBatchNameList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		  System.out.println("sortedlList desc "+sortedlListdesc);

		  return sortedlListdesc;

	}
	public void clickBatchDescColumnHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement batchDescColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(batchDescColumnHeader));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", batchDescColumnHeaderElement);
	}
	
	public List<String> getOriginalBatchDescList() {
	  //capture all the web elements into list
	  List<WebElement> elementsList = driver.findElements(batchDescList);
	  
	  //capture text of all elements into new(original) list
	  List<String> originalBatchDescriptionList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
	  System.out.println("originalBatchDescList "+originalBatchDescriptionList);
	  return originalBatchDescriptionList;
}

	public List<String> getSortedBatchDescriptionListAsc() {
		
		  //sort on the original list ->sorted list in Ascending order
		  List<String> desiredlList = getOriginalBatchDescList();
	        // Sort the list
	        Collections.sort(desiredlList);
	        
	        System.out.println("getSortedBatchDescriptionListAsc "+desiredlList);  

		  return desiredlList;

	}

	public List<String> getSortedBatchDescriptionListDesc() {
		
		  //sort on the original list ->sorted list in Descending order
		  List<String> sortedlListdesc = getOriginalBatchDescList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		  System.out.println("getSortedBatchDescriptionListDesc sortedlList desc "+sortedlListdesc);

		  return sortedlListdesc;

	}
	public void clickBatchStatusColumnHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement batchStatusColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(batchStatuscColumnHeader));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", batchStatusColumnHeaderElement);
	}
	
	public List<String> getOriginalBatchStatusList() {
		  //capture all the web elements into list
		  List<WebElement> elementsList = driver.findElements(batchStatusList);
		  
		  //capture text of all elements into new(original) list
		  List<String> originalBatchStatusList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		  System.out.println("originalBatchStatusList "+originalBatchStatusList);
		  return originalBatchStatusList;
	}

		public List<String> getSortedBatchStatusListAsc() {
			
			  //sort on the original list->sorted list in Ascending order
			  List<String> desiredlList = getOriginalBatchStatusList();
		        // Sort the list
		        Collections.sort(desiredlList);
		        
		        System.out.println("getSortedBatchStatusListAsc "+desiredlList);  

			  return desiredlList;

		}

		public List<String> getSortedBatchStatusListDesc() {
			
			  //sort on the original list->sorted list in Descending order
			  List<String> sortedlListdesc = getOriginalBatchStatusList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			  System.out.println("getSortedBatchDescriptionListDesc sortedlList desc "+sortedlListdesc);

			  return sortedlListdesc;

		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////Pagination features methods //////////////////////////////////////////////////
		
		public void clickNextLink()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement nextBtnElement = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextBtnElement);
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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement lastBtnElement = wait.until(ExpectedConditions.elementToBeClickable(lastBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastBtnElement);
		}

		public boolean isActiveLastLink()
		{
	        // Wait for the table to reload with the Last page records
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']")));

			
			// Check if the last button is enabled

	        boolean isLastEnabled;
	        List<WebElement> elements = driver.findElements(lastBtn);
	        if (!elements.isEmpty()) {
	            WebElement button = elements.get(0);
	            isLastEnabled = button.isEnabled();
	            // Perform actions on the button
	        } else {
	        	
	            // Element not found, 
	        	isLastEnabled = false;
	        }
	        System.out.println("isLastEnabled "+isLastEnabled);  

	        return isLastEnabled;

		
		}
		
		public void clickFirstLink()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement firstBtnElement = wait.until(ExpectedConditions.elementToBeClickable(firstBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstBtnElement);
		}
		
		public void clickPreviousLink()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement prevBtnElement = wait.until(ExpectedConditions.elementToBeClickable(prevBtn));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", prevBtnElement);
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
	        if(isOneButtonHighlighted && getOriginalBatchNameList().size()>0)
	        {
	        	isFirstPage = true;
	        }
	        else
	        	isFirstPage = false;
	        
	        return isFirstPage;
		
		}

}
