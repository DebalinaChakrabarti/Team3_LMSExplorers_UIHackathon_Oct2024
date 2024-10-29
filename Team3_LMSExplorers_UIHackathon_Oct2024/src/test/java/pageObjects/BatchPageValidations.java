
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BatchPageValidations  {

    public WebDriver driver;

    public BatchPageValidations(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locating Element

    private By header = By.xpath("//span[text()='Batch']");


    @FindBy(xpath = "//*[@id=\"mat-menu-panel-1\"]/div/button")
    WebElement addNewBatchButton;

    @FindBy(xpath = "//div[normalize-space()='Manage Batch']")
    WebElement titleofBatchPage;

    @FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
    WebElement titleofLMS;

    @FindBy(xpath = "//*[@class=\"mat-card-title\"]/child::div[2]//button")
    WebElement deleteIconManageBatch;

    @FindBy(xpath = "//p-paginator[@class='ng-star-inserted']")
    WebElement paginationControl;

    @FindBy(xpath = "//div[@class='action']//button[@icon='pi pi-pencil']")
    WebElement editIcon;

    @FindBy(xpath = "//div[@class='action']//button[@icon='pi pi-trash']")
    WebElement deleteIcon;

    @FindBy(xpath = "//tbody[@class='p-datatable-tbody']//div[@class='p-hidden-accessible']/input")
    WebElement checkboxRow;

    @FindBy(xpath = "//thead[@class='p-datatable-thead']//th")
    WebElement dataTableHeader;

    @FindBy(xpath = "//thead[@class='p-datatable-thead']//div[@class='p-hidden-accessible']")
    WebElement checkboxHeader;

    @FindBy(xpath = "//thead[@class='p-datatable-thead']//th/p-sorticon")
    WebElement sortIconHeader;

    @FindBy(xpath = "//input[@id='filterGlobal']")
    WebElement searchBox;

    // Action methods

    public void clickBatch() {
        driver.findElement(header).click();
    }
    public String getBatchTitle() {
        return titleofBatchPage.getText();
    }

    public String getLMSTitle() {
        return titleofLMS.getText();
    }

    public boolean clickDeleteIconManage() {
        return deleteIconManageBatch.isEnabled();
    }

    public boolean clickPaginationControl() {
        return paginationControl.isEnabled();
    }

    public int clickEditIcon() {
        List<WebElement> li = driver.findElements(By.xpath("//div[@class='action']//button[@icon='pi pi-pencil']"));
        return li.size();
    }

    public int clickDeleteIcon() {
        List<WebElement> li = driver.findElements(By.xpath("//div[@class='action']//button[@icon='pi pi-trash']"));
        return li.size();
    }

    public int clickCheckBoxRow() {
        List<WebElement> li = driver
                .findElements(By.xpath("//tbody[@class='p-datatable-tbody']//div[@class='p-hidden-accessible']/input"));
        return li.size();
    }

    public boolean clickCheckBoxHeader() {
        return checkboxHeader.isDisplayed();

    }

    public String verifyHeader() {
        List<WebElement> li = driver.findElements(By.xpath("//thead[@class='p-datatable-thead']//th"));
        String header = new String();
        for (int i = 1; i < li.size(); i++) {
            if (i == 1){
                header = li.get(i).getText();
            }else{
                header = header + "," + li.get(i).getText();
            }
        }
        return header;
    }

    public int seeSortIconHeader() {
        List<WebElement> li = driver.findElements(By.xpath("//thead[@class='p-datatable-thead']//th/p-sorticon"));
        return li.size();
    }




}