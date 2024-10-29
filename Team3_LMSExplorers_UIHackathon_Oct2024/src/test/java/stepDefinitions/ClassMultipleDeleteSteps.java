package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPg;
import utilities.Constants;
import utilities.Context;
import org.testng.Assert;

public class ClassMultipleDeleteSteps extends Constants {

	Context context;
	ClassPg classPg;

	public ClassMultipleDeleteSteps(Context context) {
		this.context = context;
		classPg = context.getClassPg();
	}

	@Given("None of the checkboxes in data table are selected in the class module")
	public void none_of_the_checkboxes_in_data_table_are_selected_in_the_class_module() {
	}

	@Then("The delete icon under the {string} header should be disabled in the class module")
	public void the_delete_icon_under_the_header_should_be_disabled_in_the_class_module(String string) {
		Assert.assertEquals(classPg.isDisabledCommonDeleteBtn().trim(), "true");
	}

	@Given("One of the checkbox row is selected  in the class module")
	public void one_of_the_checkbox_row_is_selected_in_the_class_module() {
		classPg.selectOneClassChk();
	}

	@When("Click delete icon below {string} header  in the class module")
	public void click_delete_icon_below_header_in_the_class_module(String string) {
		classPg.clickCommonDeleteButton();
	}

	@Then("The respective row in the table is deleted after clicking YES in confirm delete form in the class module")
	public void the_respective_row_in_the_table_is_deleted_in_the_class_module() throws InterruptedException {
		Assert.assertTrue(classPg.commonDeleteAlertConfirmYes(), "Selected Class successfully Deleted");
	}

	@Then("The respective row in the table is not Deleted after clicking NO in confirm delete form in the class module")
	public void the_respective_row_in_the_table_is_not_deleted_in_the_class_module() throws InterruptedException {
		Assert.assertTrue(classPg.commonDeleteAlertConfirmNo(), "Selected Class is not Deleted");
	}

	@Given("Two or more checkboxes row is selected  in the class module")
	public void two_or_more_checkboxes_row_is_selected_in_the_class_module(){
		classPg.selectMultipleClassChk();
	}

	@Then("The respective rows in the table is deleted after clicking YES in confirm delete form  in the class module")
	public void the_respective_rows_in_the_table_is_deleted_in_the_class_module() throws InterruptedException {
		Assert.assertTrue(classPg.commonDeleteMultipleAlertConfirmYes(), "Selected Multiple Classes successfully Deleted");
	}

	@Then("The respective rows in the table is not deleted after clicking NO in confirm delete form  in the class module")
	public void the_respective_rows_in_the_table_is_not_deleted_in_the_class_module() throws InterruptedException {
		Assert.assertTrue(classPg.commonDeleteMultipleAlertConfirmNo(), "Selected Multiple Classes successfully Deleted");
	}

}
