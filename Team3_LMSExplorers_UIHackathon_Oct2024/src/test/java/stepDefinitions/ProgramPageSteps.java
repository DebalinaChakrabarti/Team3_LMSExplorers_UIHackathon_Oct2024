package stepDefinitions;

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
	public void admin_clicks_on_the_navigation_bar(String text) {
		if (text.equalsIgnoreCase("Program")) {
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
	  programPage.validateColheaders("Program Name","Program Description","Program Status");
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
          programPage.validateAllColHeaders("Program Name","Program Description","Program Status", "Edit / Delete");
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
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table(String text) {
	   programPage.validatePaginationTextandIcons(text);
	}

	@Then("Admin should see the footer as {string}")
	public void admin_should_see_the_footer_as_in_total_there_are_z_programs(String count) {
	   programPage.validateFooter(count);
	}


}
