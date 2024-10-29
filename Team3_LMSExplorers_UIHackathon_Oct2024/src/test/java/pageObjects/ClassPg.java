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

public class ClassPg extends Constants {

	WebDriver driver;
	private By classLink = By.xpath("//*[text()='Class']");
    private By classHeaderName = By.xpath("//*[contains(text(),'Manage Class')]");
	private By logoutLink = By.id("logout");
	
//Searchbar elements
	
	private By searchTextBox = By.id("filterGlobal");
    private By classNameFirstRecord=By.xpath("//tr[1]/td[3]");
    private By classDescFirstRecord=By.xpath("//tr[1]/td[4]");
    private By classStatusFirstRecord=By.xpath("//tr[1]/td[5]");
    private By paginationTextwithZeroRecord=By.xpath("//*[contains(text(),'Showing 0 to 0 of 0 entries')]");

//Multi Delete Class elements
    
  private By classFirstRecordChk=By.xpath("//table[1]/tbody[1]/tr[1]/td[1]//div[1]/div[2]");
  private By classSecondRecordChk=By.xpath("//tr[2]/td[1]/p-tablecheckbox/div/div[2]");
//  private By programSecondRecordChk=By.xpath("//tr[2]/td[1]");
  private By commonDeleteButton=By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
  private By confirmFormText=By.xpath("//span[contains(@class, 'p-dialog-title')]");
  private By classNameSecondRecord=By.xpath("//tr[2]/td[3]");
  private By classNameList = By.xpath("//tr/td[3]");
  private By yesButton = By.xpath("//*[text()='Yes']");
  private By toastMsgElement = By.xpath("//div[contains(@class, 'p-toast-detail')]");
  private By noButton = By.xpath("//*[text()='No']");
  private By XcloseButtonConfirmForm = By.xpath("//button[contains(@class, 'p-dialog-header-close')]");

  private static List<String> targetedDeleteClassNames = new ArrayList<String>();
  
//Sorting Class Element

	private By batchNameColumnHeader = By.xpath("//tr/th[2]");
	private By classNameColumnHeader = By.xpath("//tr/th[3]");
	private By classDescColumnHeader = By.xpath("//tr/th[4]");
	private By classDescList = By.xpath("//tr/td[4]");
	private By classStatuscColumnHeader = By.xpath("//tr/th[5]");
	private By classDateColumnHeader = By.xpath("//tr/th[6]");
	private By staffNameColumnHeader = By.xpath("//tr/th[7]");
	private By classStatusList = By.xpath("//tr/td[5]");
	private By classDateList = By.xpath("//tr/td[6]");
	private By staffNameList = By.xpath("//tr/td[7]");

//Pagination elements
	
	private By nextBtn = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	private By lastBtn = By.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	private By prevBtn = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple']");
	private By firstBtn = By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']");
	private By firstPageButton = By.xpath("//button[text()='1']");

	
  public ClassPg(WebDriver driver){
		this.driver = driver;
	}
	public String getClassPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getClassHeaderName() {
		return driver.findElement(classHeaderName).getText();
	}
	
	public void clickClassLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Wait for class link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(classLink)));				
	}
	public boolean checkLogoutLink() {
        return driver.findElement(logoutLink).isDisplayed();
	}
	public void clearSearchBox() {
		driver.findElement(searchTextBox).clear();;
	}
	
	///////////////////////////////Multiple Delete Feature methods///////////////////////////////
	
	public void selectOneClassChk() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for program link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(classFirstRecordChk)));				

	}

	public String isSelectedClassChk() {
        String isSelected = driver.findElement(classFirstRecordChk).getAttribute("aria-checked");
        System.out.println("Is checkbox selected? " + isSelected);
        return isSelected;
	}

	public void selectMultipleClassChk() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for program link element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(classLink)));				

		// Wait for first record checkbox element to be clickable, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(classFirstRecordChk)));		

		// Wait for second record checkbox element to be clickable, then click
		WebElement classSecondRecordChkElement = wait.until(ExpectedConditions.elementToBeClickable(classSecondRecordChk));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", classSecondRecordChkElement);		
	}

	public boolean isSelectedMultipleClassChk() {
		boolean isSelected = false;
        String isSelectedClassFirstRecordChk = driver.findElement(classFirstRecordChk).getAttribute("aria-checked");
        String isSelectedClassSecondRecordChk = driver.findElement(classSecondRecordChk).getAttribute("aria-checked");
        System.out.println("Is checkbox selected? " + isSelectedClassFirstRecordChk + " " +isSelectedClassSecondRecordChk);
        if (isSelectedClassFirstRecordChk.equalsIgnoreCase("true") && isSelectedClassSecondRecordChk.equalsIgnoreCase("true"))
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

	//List of class name of one page
	public List<String> getOriginalClassNameList() {
		  //capture all the web elements into list
		  List<WebElement> elementsList = driver.findElements(classNameList);
		  
		  //capture text of all elements into new(original) list
		  List<String> originalList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		  System.out.println("originalList "+originalList);
			  
		  return originalList;
	}

	public boolean commonDeleteAlertConfirmYes() throws InterruptedException {
		
		//storing selected class to be deleted in a string
		String targetedDeleteClassName = driver.findElement(classNameFirstRecord).getText().toLowerCase().trim();
		System.out.println("targetedDeleteProgramName "+targetedDeleteClassName);
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(yesButton)));		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
		
		Thread.sleep(1000);
		
		//check selected Class is deleted from the data table
		List<String> originalClassNameList = getOriginalClassNameList();
		System.out.println("commonDeleteAlertConfirmYes getOriginalClassNameList "+originalClassNameList);

		boolean isDeleted = !originalClassNameList.contains(targetedDeleteClassName);
		System.out.println("isDeleted "+isDeleted);
		
		return isDeleted;
	}
	public boolean commonDeleteAlertConfirmNo() throws InterruptedException {

		//storing selected class to be deleted in a string
		String targetedDeleteClassName = driver.findElement(classNameFirstRecord).getText().toLowerCase().trim();
		System.out.println("targetedDeleteProgramName "+targetedDeleteClassName);

		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(noButton)));		    
		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
        
		Thread.sleep(1000);
		
		//check selected class is deleted from the data table
		List<String> originalClassNameList = getOriginalClassNameList();
		System.out.println("commonDeleteAlertConfirmNo getOriginalClassNameList "+originalClassNameList);

		boolean isNotDeleted = originalClassNameList.contains(targetedDeleteClassName);
		System.out.println("isNotDeleted "+isNotDeleted);
		//to uncheck the selected textbox
		selectOneClassChk();
		
		return isNotDeleted;
	}

	
	public boolean commonDeleteMultipleAlertConfirmYes() throws InterruptedException {
		Thread.sleep(1000);
		
		targetedDeleteClassNames.add(driver.findElement(classNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteClassNames.add(driver.findElement(classNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("=======targetedDeleteClassNames======= "+targetedDeleteClassNames);
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(yesButton)));		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
		
		Thread.sleep(1000);
				
		//check if selected classes are deleted from the data table
		List<String> originalClassNameList = getOriginalClassNameList();
		System.out.println("commonDeleteMultipleAlertConfirmYes getOriginalClassNameList "+originalClassNameList);

		boolean isDeleted = !originalClassNameList.containsAll(targetedDeleteClassNames);
		System.out.println("Selected classes are Deleted "+isDeleted);
		
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
		
		//Searching by Deleted Class Name
		System.out.println("=======targetedDeleteProgramNames======= "+targetedDeleteClassNames);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	 // Search for the first program name
	    driver.findElement(searchTextBox).sendKeys(targetedDeleteClassNames.get(0));
	    wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
		Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"),"Showing 0 to 0 of 0 entries");
		clearSearchBox();
		
		// Search for the second program name
		driver.findElement(searchTextBox).sendKeys(targetedDeleteClassNames.get(1));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
		Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"),"Showing 0 to 0 of 0 entries");
		clearSearchBox();
		driver.findElement(searchTextBox).sendKeys(" ");
		Thread.sleep(2000);
	}

	public boolean commonDeleteMultipleAlertConfirmNo() throws InterruptedException {

		//adding targeted multiple selected Classes to be deleted in a list
		targetedDeleteClassNames = new ArrayList<String>();
		targetedDeleteClassNames.add(driver.findElement(classNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteClassNames.add(driver.findElement(classNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("targetedDeleteClassNames "+targetedDeleteClassNames);
		
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(noButton)));		    
		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
        
		Thread.sleep(1000);
		
		//check if selected programs are deleted from the data table
		List<String> originalClassNameList = getOriginalClassNameList();
		System.out.println("commonDeleteMultipleAlertConfirmNo getOriginalClassNameList "+originalClassNameList);

		boolean isNotDeleted = originalClassNameList.containsAll(targetedDeleteClassNames);
		System.out.println("Selected classes are Deleted "+isNotDeleted);
		selectMultipleClassChk();//to uncheck the selected check boxes
		
		return isNotDeleted;
	}

	public boolean clickXbuttonCofirmForm() throws InterruptedException {

		//adding targeted multiple selected classes to be deleted in a list
		targetedDeleteClassNames = new ArrayList<String>();
		targetedDeleteClassNames.add(driver.findElement(classNameFirstRecord).getText().toLowerCase().trim());
		targetedDeleteClassNames.add(driver.findElement(classNameSecondRecord).getText().toLowerCase().trim());
		System.out.println("targetedDeleteClassNames "+targetedDeleteClassNames);
		
		
		// Get the current window handle
		String currentWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Iterate through all handles
		for (String handle : allWindowHandles) {
		    // Switch to the window
		    driver.switchTo().window(handle);
		    
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
					wait.until(ExpectedConditions.elementToBeClickable(XcloseButtonConfirmForm)));		    
		    
		}

		// Switch back to the original window
		driver.switchTo().window(currentWindowHandle);
        
		Thread.sleep(1000);
		
		//check if selected classes are deleted from the data table
		List<String> originalClassNameList = getOriginalClassNameList();
		System.out.println("commonDeleteMultipleAlertConfirmNo getOriginalProgramNameList "+originalClassNameList);

		boolean isNotDeleted = originalClassNameList.containsAll(targetedDeleteClassNames);
		System.out.println("Selected programs are Deleted "+isNotDeleted);
//		selectMultipleProgramChk();//to uncheck the selected check boxes
		
		return isNotDeleted;
	}

	////////////////////Class SearchBar Feature Scenarios method////////////////////////////
	
	public void searchClass(String sheetname,String scenarioName) throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String className = null;
		String classDesc = null;
		String status = null;
        // the column index we want to filter by (e.g., column 1)(0-based)
        int filterColumnIndex = 0;  
		
        List<String> rowData = xlutils.getRowData(sheetname, filterColumnIndex, scenarioName);
        className = rowData.get(1);
		classDesc = rowData.get(2);
		status = rowData.get(3);
		System.out.println("==================className===== "+className);
		System.out.println("==================classDesc===== "+classDesc);
		System.out.println("==================status===== "+status);
 		
		clearSearchBox();
		
		if(scenarioName.equalsIgnoreCase("searchWithValidClassName")) {
			
			driver.findElement(searchTextBox).sendKeys(className);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(classNameFirstRecord));
			Thread.sleep(2000);

			Assert.assertTrue(className.equalsIgnoreCase(driver.findElement(classNameFirstRecord).getText().trim()));
			Assert.assertTrue(classDesc.equalsIgnoreCase(driver.findElement(classDescFirstRecord).getText().trim()));
			Assert.assertTrue(status.equalsIgnoreCase(driver.findElement(classStatusFirstRecord).getText().trim()));
		}
		else if(scenarioName.equalsIgnoreCase("searchWithValidClassDesc")) {
			driver.findElement(searchTextBox).sendKeys(classDesc);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(classNameFirstRecord));
	        Thread.sleep(2000);

			Assert.assertTrue(className.trim().equalsIgnoreCase(driver.findElement(classNameFirstRecord).getText().trim()));
			Assert.assertTrue(classDesc.trim().equalsIgnoreCase(driver.findElement(classDescFirstRecord).getText().trim()));
			Assert.assertTrue(status.trim().equalsIgnoreCase(driver.findElement(classStatusFirstRecord).getText().trim()));
		}
		else if(scenarioName.equalsIgnoreCase("searchWithInvalidClassName")) {
			driver.findElement(searchTextBox).sendKeys(className);
	        wait.until(ExpectedConditions.textToBePresentInElementLocated(paginationTextwithZeroRecord, "Showing 0 to 0 of 0 entries"));
			Assert.assertTrue(driver.findElement(paginationTextwithZeroRecord).getText().trim().contains("Showing 0 to 0 of 0 entries"));
		}
		else if(scenarioName.equalsIgnoreCase("searchWithPartialClassName")) {
			driver.findElement(searchTextBox).sendKeys(className);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(classNameFirstRecord));

			Assert.assertTrue(driver.findElement(classNameFirstRecord).getText().trim().contains(className.trim()));
			Assert.assertTrue(classDesc.trim().equalsIgnoreCase(driver.findElement(classDescFirstRecord).getText().trim()));
			Assert.assertTrue(status.trim().equalsIgnoreCase(driver.findElement(classStatusFirstRecord).getText().trim()));
			clearSearchBox();
			Thread.sleep(1000);
			driver.findElement(searchTextBox).sendKeys(" ");

		}
	}
///////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////Class Sorting Feature Methods/////////////////////////////////////////////////
	
	public void clickClassNameColumnHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement classNameColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(classNameColumnHeader));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", classNameColumnHeaderElement);
	}
	public List<String> getSortedClassNameListAsc() {
		
		  //sort on the original list  ->sorted list in Ascending order
		  List<String> sortedlList = getOriginalClassNameList().stream().sorted().collect(Collectors.toList());
		  System.out.println("sortedlList "+sortedlList);

		  return sortedlList;

	}
		
	public List<String> getSortedClassNameListDesc() {
		
		  //sort on the original list  ->sorted list in Descending order
		  List<String> sortedlListdesc = getOriginalClassNameList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		  System.out.println("sortedlList desc "+sortedlListdesc);

		  return sortedlListdesc;

	}
	public void clickClassDescColumnHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement classDescColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(classDescColumnHeader));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", classDescColumnHeaderElement);
	}
	
	public List<String> getOriginalClassDescList() {
	  //capture all the web elements into list
	  List<WebElement> elementsList = driver.findElements(classDescList);
	  
	  //capture text of all elements into new(original) list
	  List<String> originalClassDescriptionList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
	  System.out.println("originalClassDescList "+originalClassDescriptionList);
	  return originalClassDescriptionList;
}

	public List<String> getSortedClassDescriptionListAsc() {
		
		  //sort on the original list ->sorted list in Ascending order
		  List<String> desiredlList = getOriginalClassDescList();
	        // Sort the list
	        Collections.sort(desiredlList);
	        
	        System.out.println("getSortedClassDescriptionListAsc "+desiredlList);  

		  return desiredlList;

	}

	public List<String> getSortedClassDescriptionListDesc() {
		
		  //sort on the original list ->sorted list in Descending order
		  List<String> sortedlListdesc = getOriginalClassDescList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		  System.out.println("getSortedClassDescriptionListDesc sortedlList desc "+sortedlListdesc);

		  return sortedlListdesc;

	}
	public void clickClassStatusColumnHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement classStatusColumnHeaderElement = wait.until(ExpectedConditions.elementToBeClickable(classStatuscColumnHeader));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", classStatusColumnHeaderElement);
	}
	
	public List<String> getOriginalClassStatusList() {
		  //capture all the web elements into list
		  List<WebElement> elementsList = driver.findElements(classStatusList);
		  
		  //capture text of all elements into new(original) list
		  List<String> originalClassStatusList = elementsList.stream().map(s->s.getText().toLowerCase().trim()).collect(Collectors.toList());
		  System.out.println("originalClassStatusList "+originalClassStatusList);
		  return originalClassStatusList;
	}

		public List<String> getSortedClassStatusListAsc() {
			
			  //sort on the original list->sorted list in Ascending order
			  List<String> desiredlList = getOriginalClassStatusList();
		        // Sort the list
		        Collections.sort(desiredlList);
		        
		        System.out.println("getSortedClassStatusListAsc "+desiredlList);  

			  return desiredlList;

		}

		public List<String> getSortedClassStatusListDesc() {
			
			  //sort on the original list->sorted list in Descending order
			  List<String> sortedlListdesc = getOriginalClassStatusList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			  System.out.println("getSortedClassDescriptionListDesc sortedlList desc "+sortedlListdesc);

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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	        if(isOneButtonHighlighted && getOriginalClassNameList().size()>0)
	        {
	        	isFirstPage = true;
	        }
	        else
	        	isFirstPage = false;
	        
	        return isFirstPage;
		
		}

}
