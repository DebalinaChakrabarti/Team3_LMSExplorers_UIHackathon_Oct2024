package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.ProgramPage;
import utilities.Context;

public class ProgramPageSteps {

	Context context;
	LoginPage loginPage;
	ProgramPage programPage;


	public ProgramPageSteps(Context context) {
		this.context = context;
		loginPage = context.getLoginPage();
		programPage = context.getProgramPage();
	}

	@Given("Admin is logged in to LMS Portal")
	public void admin_is_logged_in_to_lms_portal() {
		loginPage.getloginUrl();
		if (!loginPage.isLoggedIn()) {
			loginPage.enterCredentials();
		}
	}

	@Given("Admin is on dashboard page after Loggingin")
	public void admin_is_on_dashboard_page_after_Loggingin() {
		programPage.validateDashboardPage();
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String menuBar) {
		if (menuBar.equalsIgnoreCase("Program")) {
			programPage.clickProgram();
		}
	}

	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_program_module() {
		if (programPage.isProgramPage()) {
			Assert.assertTrue(true, "Program Page is validated successfully");
		}
	}

	@Then("Admin should not have any broken links for Program module")
	public void admin_should_not_have_any_broken_links_for_program_module() throws Throwable {
		programPage.checkForBrokenLinks();
	}

	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String expectedValue) {
		programPage.validateLMSHeading(expectedValue);
	}

	@Then("Admin should see the module names as in order {string}")
	public void admin_should_see_the_module_names_as_in_order(String expectedOrder) {
		programPage.validateModuleNames(expectedOrder);
	}

	@Then("Admin should see {string} in menu bar")
	public void admin_should_see_in_menu_bar(String logout) {
		programPage.validateLogoutInMenubar(logout);
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String addNewProg) {
		programPage.validateAddNewProgBtn(addNewProg);
	}

	@Then("Admin should see the heading as {string}")
	public void admin_should_see_the_heading_as(String manageHeader) {
		programPage.validateManageHeader(manageHeader);
	}

	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
		programPage.validateColheaders("Program Name", "Program Description", "Program Status");
	}

	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		programPage.validateMultipleDeleteBtnDisabled();
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String expectedSearchPlaceholder) {
		programPage.validateSearchBar(expectedSearchPlaceholder);
	}

	@Then("Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit\\/Delete")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
		programPage.validateAllColHeaders("Program Name", "Program Description", "Program Status", "Edit / Delete");
	}

	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
		programPage.validateheaderCheckBoxUnchecked();
	}

	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		programPage.validateAllCheckBoxesUnchecked();
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		programPage.validateSortIcons();
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		programPage.validateEditDelIcons();
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table(
			String text) throws InterruptedException {
		programPage.validatePaginationTextandIcons(text);
	}

	@Then("Admin should see the footer as {string}")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs(String count) {
		programPage.validateFooter(count);
	}

	// Add New Program

	@Given("Admin is on Program module for adding program")
	public void admin_is_on_program_module_for_adding_program() {
		if (programPage.isProgramPage()) {
			Assert.assertTrue(true, "Admin is on program page for adding new program");
		}
	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String addNewProgram, String menuBar) {
		if (menuBar.equals("Program")) {
			programPage.clickProgram();
		} else {
			Assert.fail("The Program button is not available to click");
		}
		if (addNewProgram.equals("Add New Program")) {
			programPage.clickAddnewProgram();
		} else {
			Assert.fail("The Add New Program button is not available to click");
		}
	}

	@Then("Admin should see pop up window for program details")
	public void admin_should_see_pop_up_window_for_program_details() {
		programPage.validateProgramDetailsPopUp("Name", "Description", "Status", "Cancel", "Save");
	}

	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String progDetails) {
		System.out.println("=====progDetails===="+progDetails);
		programPage.validateProgramDetailsTitle(progDetails);
	}

	@Then("Admin should see red {string} mark beside mandatory field {string}")
	public void admin_should_see_red_mark_beside_mandatory_field(String asterisk, String field) {
		programPage.validateAsterisk(asterisk, field);
	}

	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() {
		programPage.clickProgram();
		programPage.clickAddnewProgram();
		if (programPage.isProgramDetailsPopup()) {
			Assert.assertTrue(true, "Admin is on program details pop up window for adding new program");
		}
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
		programPage.clickSaveBtn();
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String field) {
		String validateErrors = programPage.validateEmptyFormSubmissionErrors(field);
		Assert.assertEquals(field, validateErrors);

	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		programPage.clickCancelBtn();
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {
		programPage.isProgramDetailsPopupDisappears();
	}

	@When("Admin enters the Name in the text box")
	public void admin_enters_the_name_in_the_text_box() {
		programPage.enterProgramName();
	}

	@Then("Admin can see the text entered")
	public void admin_can_see_the_text_entered() {
		programPage.validateEnteredText();
	}

	@When("Admin enters the Description in text box")
	public void admin_enters_the_description_in_text_box() {
		programPage.enterProgramDesc();
	}

	@Then("Admin can see the text entered in description box")
	public void admin_can_see_the_text_entered_in_description_box() {
		programPage.validateEnteredDesc();
	}

	@When("Admin selects the status of the program by clicking on the radio button {string}")
	public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button(String status) {
		programPage.selectStatus(status);
	}

	@Then("Admin can see {string} status selected")
	public void admin_can_see_status_selected(String status) {
		programPage.validateSelectedStatus(status);
	}
	
	@When("Admin enters valid details for mandatory fields from {string} with scenario name {string} and clicks on the save button")
	public void admin_enters_valid_details_for_mandatory_fields_from_with_scenario_name_and_clicks_on_the_save_button(String sheetName, String scenarioName) throws IOException{
	  programPage.enterValidProgramDetails(sheetName, scenarioName);
	}

	@Then("Admin gets message for new program for each {string} and  {string}")
	public void admin_gets_message_for_new_program(String sheetName,String scenarioName) {
	   programPage.validatemessage(sheetName,scenarioName);
	}

	@When("Admin searches with newly created program name from {string} with scenario name {string}")
	public void admin_searches_with_newly_created(String sheetName,String scenarioName) throws IOException {
		programPage.clickProgram();
	    programPage.searchProgName(sheetName,scenarioName);
	}

	@Then("Records of the newly created program name is displayed from {string} with scenario name {string}")
	public void records_of_the_newly_created_is_displayed_and_match_the_data_entered(String sheetName,String scenarioName) {
	    programPage.validateProgName(sheetName,scenarioName);
	}

	@When("Admin Click on {string} button")
	public void admin_click_on_button(String string) {
	   programPage.clickCloseBtn();
	}
//Edit Program
	
	@Given("Admin is on program details window")
	public void admin_is_on_program_details_for_window() {
			programPage.clickProgram();
			programPage.clickEditBtn();
	}
	
	@When("Admin clicks on {string} for particular program")
	public void admin_clicks_on_for_particular_program(String string) {
	   programPage.clickProgram();
	   programPage.clickEditBtn();
	}

	@When("Admin edits the program and click on save button from {string} with scenario name {string}")
	public void admin_edits_the_program_and_click_on_save_button(String sheetName,String scenarioName) throws IOException {
	    programPage.editProgramName(sheetName, scenarioName);
	}

	@Then("Updated program name is seen by the Admin from {string} with scenario name {string}")
	public void updated_program_name_is_seen_by_the_admin(String sheetName,String scenarioName) {
	   programPage.validateEditedProg(sheetName, scenarioName);
	}

	
	@When("Admin searches with newly updated Program Name from {string} with scenario name {string}")
	public void admin_searches_with_newly_updated_program_name_from_with_scenario_name(String sheetName, String scenarioName) throws IOException {
		programPage.clickProgram();
		programPage.searchProgName(sheetName,scenarioName);
	}

	@Then("Admin verifies that the details are correctly updated from {string} with scenario name {string}")
	public void admin_verifies_that_the_details_are_correctly_updated_from_with_scenario_name(String sheetName, String scenarioName) {
		programPage.validateUpdatedProgDetails(sheetName, scenarioName);
	}
	
	//Delete Program
	
	
	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
		programPage.clickProgram();
		programPage.clickDeleteBtn();
	}

	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
	    programPage.validateDeleteConfirmPopUp();
	}

	

	@When("Admin clicks on {string} button")
	public void admin_clicks_on_button(String option) {
		programPage.clickDeleteBtn();
	    if(programPage.isConfirmDelPopUp()){
	    	Assert.assertTrue(true, "Admin is on delete confirmation pop up page");
	    }
	   programPage.clickConfirmationOption(option);
	}

	@Then("Admin can see {string} message")
	public void admin_can_see_message(String msg) {
	  programPage.validateSuccessfulDelmessage(msg);
	}

	@When("Admin Searches for Deleted Program name from {string} with scenario name {string}")
	public void admin_searches_for_deleted_program_name_from_with_scenario_name(String sheetName, String scenarioName) throws IOException {
		programPage.clickProgram();
		programPage.searchProgName(sheetName, scenarioName);
	}
	
	@When("Admin clicks on the {string} button")
	public void admin_clicks_on_the_button(String option) {
		programPage.clickProgram();
		programPage.clickDeleteBtn();
	    if(programPage.isConfirmDelPopUp()){
	    	Assert.assertTrue(true, "Admin is on delete confirmation pop up page");
	    }
	   programPage.clickConfirmationOption(option);
	}
	
	

	@Then("There should be zero results.")
	public void there_should_be_zero_results() {
	    programPage.validateZeroResults();
	}

	@Then("Admin can see Confirmation form disappears")
	public void admin_can_see_confirmation_form_disappears() {
	   programPage.validateConfirmationFormDisappears();
	}

	
	@When("Admin Clicked on {string} button")
	public void admin_clicked_on_button(String string) {
	   programPage.clickDeleteCloseBtn();
	}
	
	

}
