package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.ApplicationHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import pageObjects.BatchPage;
import utilities.Context;

public class BatchPageNavigationSteps {

    private final Context context;
    private final LoginPageSteps lps;
    private final BatchPage bp;
    WebDriver driver = ApplicationHooks.getDriver();

    public BatchPageNavigationSteps(Context context) {
        this.context = context;
        lps = new LoginPageSteps( context);
        bp = new BatchPage(driver);
    }

    @Given("Admin is on the Dashboard Page")
    public void is_on_the_dashboard_page() {
    }

    @When("Clicks on the Batch menu from the header")
    public void clicks_on_the_batch_menu_from_the_header() {
        bp.clickBatch();
    }

    @Then("Admin should be in the Manage Batch Page")
    public void admin_should_be_in_the_manage_batch_page() {
        String title = bp.getBatchTitle();
        Assert.assertEquals(title, "Manage Batch");
    }

//    @When("Clicks on the Add New Batch from the header")
//    public void clicks_on_the_add_new_batch_from_the_header() {
//        bp.clickAddNewBatch();
//    }

}