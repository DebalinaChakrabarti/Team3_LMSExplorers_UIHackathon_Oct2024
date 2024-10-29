package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BatchPage;
import utilities.Constants;
import utilities.Context;

public class BatchPageSteps extends Constants {

	Context context;
	BatchPage batchPage;

	public BatchPageSteps(Context context) {
		this.context = context;

		batchPage = context.getBatchPage();
	}

	@When("Admin clicks {string} option on the navigation bar")
	public void admin_clicks_option_on_the_navigation_bar(String string) {
		batchPage.clickBatch();
	}

	@Then("Admin should see sub menu in menu bar as {string} option")
	public void admin_should_see_sub_menu_in_menu_bar_as_option(String addNewBatchbtn) {
		batchPage.validateAddNewBatchBtn(addNewBatchbtn);
	}

	@When("Admin clicks on {string} option under the {string} menu bar")
	public void admin_clicks_on_option_under_the_menu_bar(String string, String string2) {
		batchPage.clickBatch();
		batchPage.clickAddnewBatch();
	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		batchPage.validateBatchPopUp();
		batchPage.clickCloseBtn();
	}

	@When("Admin clicks {string} option on the navigation bar and checks all the fields are enabled")
	public void admin_clicks_option_on_the_navigation_bar_and_checks_all_the_fields_are_enabled(String string) {
		batchPage.clickBatch();
		batchPage.clickAddnewBatch();
	}

	@Then("The pop up should include the fields Batch Name,Number of classes and Description as text box,Program Name as drop down,Status as radio button")
	public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {
		batchPage.validateBatchDetailsPopUp("Program Name", "Batch Name", "Description", "Status", "Number of Classes",
				"Cancel", "Save");
		batchPage.clickCloseBtn();
	}

	@Given("Admin is on the Batch Details Pop Up WIndow")
	public void admin_is_on_the_batch_details_pop_up_w_indow() {
		batchPage.clickBatch();
		batchPage.clickAddnewBatch();
	}

	@When("Admin selects program name present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown() {
		batchPage.selectProgramNamedropDown();
	}

	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		batchPage.validateSelectedProgName();
		batchPage.clickCloseBtn();
	}

	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
		batchPage.clickBatchName();
	}

	@Then("Admin should get error message below the text box of respective field")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field() {
		batchPage.validateBatchNameError();
		batchPage.clickCloseBtn();
	}

	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
		batchPage.clickBatchName();
	}

	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() {
		batchPage.validateEmptyTextBox();
		batchPage.clickCloseBtn();
	}

	@When("Admin enters the data only to the mandatory fields and clicks button from {string} with scenario name {string}")
	public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_button_from_with_scenario_name(
			String sheetName, String scenarioName) throws IOException {
		batchPage.enterBatchDetails(sheetName, scenarioName);
	}

	@Then("Admin should get a message from {string} with scenario name {string}")
	public void admin_should_get_a_successful_message(String sheetName, String scenarioName) {
		batchPage.validatemessage(sheetName, scenarioName);
	}

	@Then("Admin can see the batch details popup closes without creating any batch from {string} with scenario name {string}")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch(String sheetName,
			String scenarioName) throws IOException {
		batchPage.validateCanceledBatch(sheetName, scenarioName);
	}

	@When("Admin Click on {string} button for batch")
	public void admin_click_on_button_for_batch(String string) {

		batchPage.clickCloseBtn();
	}

	@Then("Admin can see batch Details form disappears")
	public void admin_can_see_batch_details_form_disappears() {
		batchPage.isBatchDetailsPopupDisappears();
	}

//Edit Batch

	@When("Admin clicks on {string} for particular batch")
	public void admin_clicks_on_for_particular_batch(String string) {
		batchPage.clickBatch();
		batchPage.clickEditBatchBtn();
	}

	@Then("Admin should see pop up window for batch details")
	public void admin_should_see_pop_up_window_for_batch_details() {
		batchPage.validateBatchPopUp();
	}

	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing() {
		batchPage.validateProgramTextBoxNonEditable();
	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
		batchPage.validateBatchTextBoxNonEditable();
	}

	@When("Admin Updates any fields with invalid data and click save button")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button() {
		batchPage.clickBatch();
		batchPage.clickEditBatchBtn();
		batchPage.sendInvalidBatchDescClasses();
	}

	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {
		batchPage.validateInvalidData();
	}

	@When("Admin enters the valid data to all the mandatory fields and click  button  from {string} with scenario name {string}")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_button_from_with_scenario_name(
			String sheetName, String scenarioName) throws IOException {
		batchPage.clickBatch();
		batchPage.clickEditBatchBtn();
		batchPage.editBatchDetails(sheetName, scenarioName);
	}

	@Then("Admin should get a message for editing the batch from {string} with scenario name {string}")
	public void admin_should_get_a_message_for_editing_the_batch_from_with_scenario_name(String sheetName,
			String scenarioName) {
		batchPage.validateEditmessage(sheetName, scenarioName);
	}

	@Then("Admin can see the batch details popup closes without editing batch from {string} with scenario name {string}")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_any_batch(String sheetName,
			String scenarioName) throws IOException {
		batchPage.validateCanceledBatch(sheetName, scenarioName);
	}

	@When("Admin clicks on delete button for a batch")
	public void admin_clicks_on_delete_button_for_a_batch() {
		batchPage.clickBatch();
		batchPage.clickDeleteBtn();
	}

	@Then("Admin will get confirm deletion popup for batch")
	public void admin_will_get_confirm_deletion_popup_for_batch() {
		batchPage.validateDeleteConfirmPopUp();
	}

	@When("Admin searches with newly updated batch Name from {string} with scenario name {string}")
	public void admin_searches_with_newly_updated_batch_name_from_with_scenario_name(String sheetName,
			String scenarioName) throws IOException {
		batchPage.clickBatch();
		batchPage.searchBatchName(sheetName, scenarioName);
	}

	@When("Admin clicks on {string} button for batch")
	public void admin_clicks_on_button_for_batch(String option) {
		batchPage.clickDeleteBtn();
		if (batchPage.isConfirmDelPopUp()) {
			Assert.assertTrue(true, "Admin is on delete confirmation pop up page");
		}
		batchPage.clickConfirmationOption(option);
	}

	@Then("Admin can see message for batch from {string} with scenario name {string}")
	public void admin_can_see_message_for_batch(String sheetName, String scenarioName) {
		batchPage.validateSuccessfulDelmessage(sheetName, scenarioName);
	}

	@When("Admin clicks on the {string} button for batch")
	public void admin_clicks_on_the_button_for_batch(String option) {
		batchPage.clickBatch();
		batchPage.clickDeleteBtn();
		if (batchPage.isConfirmDelPopUp()) {
			Assert.assertTrue(true, "Admin is on delete confirmation pop up page");
		}
		batchPage.clickConfirmationOption(option);

	}

	@When("Admin clicks on the delete button for a batch")
	public void admin_clicks_on_the_delete_button_for_a_batch() {
		batchPage.clickBatch();
		batchPage.clickDeleteBtn();
	}

	@When("Admin Clicked on {string} button for batch")
	public void admin_clicked_on_button_for_batch(String string) {
		batchPage.clickCloseBtn();
	}
	
	@Then("Admin can see Confirmation form disappears for batch")
	public void admin_can_see_confirmation_form_disappears_for_batch() {
	   batchPage.validateConfirmationFormDisappears();
	}

}
