package stepDefinitions;


import org.testng.Assert;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

import pageObjects.BatchPageValidations;
import utilities.Context;

public class BatchPageNavigationSteps {

    Context context;
   
    BatchPageValidations bp;
    

    public BatchPageNavigationSteps(Context context) {
        this.context = context;
        bp = context.getBatchPageValidation();
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

}