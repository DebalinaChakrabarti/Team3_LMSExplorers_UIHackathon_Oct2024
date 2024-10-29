package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPageValidation;

import pageObjects.LoginPage;
import utilities.Context;

public class ClassPageValidationSteps {

	Context context;
	LoginPage loginPage;
	ClassPageValidation classPageValidation;

	public ClassPageValidationSteps(Context context) {
		this.context = context;
		loginPage = context.getLoginPage();
		classPageValidation = context.getClassPageValidation();
	}

	@Given("Admin is on the dashboard page after login in class module")
	public void admin_is_on_the_dashboard_page_after_login() {

		classPageValidation.validateDashboardPage();

	}

	@When("Admin clicks the Class Navigation bar in the Header in class module")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
		classPageValidation.clickClass();
	}

	@Then("Admin should land on the Manage class page in class module")
	public void admin_should_land_on_the_manage_class_page() throws InterruptedException {

		classPageValidation.isClassPage();

	}

	@Then("Admin should see the {string} Title in class module")
	public void admin_should_see_the_title(String expectedValue) {
		classPageValidation.validateLMSHeading(expectedValue);
	}

	@Then("Admin should see the {string} Header in class module")
	public void admin_should_see_the_header(String manageHeader) {
		classPageValidation.validateManageHeader(manageHeader);
	}

	@Then("Admin should see Search bar with text as {string} in class module")
	public void admin_should_see_search_bar_with_text_as(String expectedSearchPlaceholder) {
		classPageValidation.validateSearchBar(expectedSearchPlaceholder);
	}

	@Then("Admin should see the datatable heading like Batch Name,Class Topic,Class Description,Status,Class Date,Staff Name,Edit\\/Delete in class module")
	public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_descrption_status_class_date_staff_name_edit_delete() {

		classPageValidation.validateAllColumnHeaders("Batch Name", "Class Topic", "Class Description", "Status",
				"Class Date", "Staff Name", "Edit / Delete");
	}

	@Then("Admin should see the Delete button under the Manage class page header in class module")
	public void sdmin_should_see_the_delete_button_under_the_manage_class_page_header() {
		classPageValidation.hiddenDeleteElement();
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table. in class module")
	public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table(
			String text) {
		classPageValidation.validatePaginationTextandIcons(text);

	}

	@Then("Admin should see the Sort icon of all the field in the datatable. in class module")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
		classPageValidation.validateSortIcons();
	}

	@Then("Admin should see Total no of classes in below of the data table in class module")
	public void ddmin_should_see_total_no_of_classes_in_below_of_the_data_table() {
		classPageValidation.totalNoOfClasses();
	}
}