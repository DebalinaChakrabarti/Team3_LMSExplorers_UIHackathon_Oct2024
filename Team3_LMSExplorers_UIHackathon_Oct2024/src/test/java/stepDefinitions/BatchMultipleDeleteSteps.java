package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Batch;
import utilities.Constants;
import utilities.Context;
import org.testng.Assert;

public class BatchMultipleDeleteSteps extends Constants {

	Context context;
	Batch batch;

	public BatchMultipleDeleteSteps(Context context) {
		this.context = context;
		batch = context.getBatch();
	}

	@Given("None of the checkboxes in data table are selected in the batch module")
	public void none_of_the_checkboxes_in_data_table_are_selected_in_the_batch_module() {
	}

	@Then("The delete icon under the {string} header should be disabled in the batch module")
	public void the_delete_icon_under_the_header_should_be_disabled_in_the_batch_module(String string) {
		Assert.assertEquals(batch.isDisabledCommonDeleteBtn().trim(), "true");
	}

	@Given("One of the checkbox row is selected  in the batch module")
	public void one_of_the_checkbox_row_is_selected_in_the_batch_module() {
		batch.selectOneBatchChk();
	}

	@When("Click delete icon below {string} header  in the batch module")
	public void click_delete_icon_below_header_in_the_batch_module(String string) {
		batch.clickCommonDeleteButton();
	}

	@Then("The respective row in the table is deleted  in the batch module")
	public void the_respective_row_in_the_table_is_deleted_in_the_batch_module() throws InterruptedException {
		Assert.assertTrue(batch.commonDeleteAlertConfirmYes(), "Selected Batch successfully Deleted");
	}

	@Given("Two or more checkboxes row is selected  in the batch module")
	public void two_or_more_checkboxes_row_is_selected_in_the_batch_module(){
		batch.selectMultipleBatchChk();
	}

	@Then("The respective rows in the table is deleted  in the batch module")
	public void the_respective_rows_in_the_table_is_deleted_in_the_batch_module() throws InterruptedException {
		Assert.assertTrue(batch.commonDeleteMultipleAlertConfirmYes(), "Selected Multiple Batches successfully Deleted");
	}

}
