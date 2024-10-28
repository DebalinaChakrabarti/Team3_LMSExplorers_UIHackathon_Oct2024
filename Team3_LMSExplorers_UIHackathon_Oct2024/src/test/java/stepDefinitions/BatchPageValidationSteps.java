package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.ApplicationHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import utilities.Context;

public class BatchPageValidationSteps {

    private final Context context;
    private final LoginPageSteps lps;
    private final BatchPage bp;
    WebDriver driver = ApplicationHooks.getDriver();

    public BatchPageValidationSteps(Context context) {
        this.context = context;
        lps = new LoginPageSteps( context);
        bp = new BatchPage(driver);
    }

    @When("Admin Clicks on the Batch menu from the header")
    public void admin_clicks_on_the_batch_menu_from_the_header() {
        bp.clickBatch();
    }

    @Then("Admin should see the LMS Title")
    public void admin_should_see_the_title() {
        Assert.assertEquals(bp.getLMSTitle(), "LMS - Learning Management System");
    }

    @Then("Admin should see the Manage Batch Heading")
    public void admin_should_see_the_manage_batch_heading() {
        Assert.assertEquals(bp.getBatchTitle(), "Manage Batch");
    }

    @Then("Admin should see the disabled Delete Icon under the header")
    public void admin_should_see_the_disabled_delete_icon_under_the_header() {
        Assert.assertEquals(bp.clickDeleteIconManage(), false);
    }

    @Then("Admin should see the enabled pagination controls under the data table")
    public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
        Assert.assertEquals(bp.clickPaginationControl(), true);
    }

    @Then("Admin should see the edit icon in each row")
    public void admin_should_see_the_edit_icon_in_each_row() {
        Assert.assertEquals(bp.clickEditIcon(), 5);
    }

    @Then("Admin should see the delete icon in each row")
    public void admin_should_see_the_delete_icon_in_each_row() {
        Assert.assertEquals(bp.clickDeleteIcon(), 5);
    }

    @Then("Admin should see the checkbox in each row")
    public void admin_should_see_the_checkbox_in_each_row() {
        Assert.assertEquals(bp.clickCheckBoxRow(), 5);
    }

    @Then("Admin should see the correct datatable headers")
    public void admin_should_see_the_correct_datatable_headers() {
        Assert.assertEquals(bp.verifyHeader(), "Batch Name,Batch Description,Batch Status,No Of Classes,Program Name,Edit / Delete");
    }

    @Then("Admin should see the checkbox in the datatable header row")
    public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
        Assert.assertEquals(bp.clickCheckBoxHeader(), true);
    }

    @Then("Admin should see the sort icon next to all Datatable headers")
    public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
        Assert.assertEquals(bp.seeSortIconHeader(), 5);
    }

}
