package stepDefinitions;

import org.testng.Assert;

import utilities.Constants;
import utilities.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Program;

public class ProgramMultipleDeleteSteps extends Constants {

	Context context;
	Program program;

	public ProgramMultipleDeleteSteps(Context context) {
		this.context = context;
		program = context.getProgram();
	}



	@Given("Check if Admin is logged in or not for the Program Mdule")
	public void admin_is_logged_in() throws InterruptedException {
		log.info("Admin is logged in");
		Thread.sleep(2000);
		Assert.assertEquals(program.checkLogoutLink(), true);//checking if logged in
		
	}

	@When("Admin clicks on {string} on the Navigation Bar to reach the Program module")
	public void admin_clicks_on_on_the_navigation_bar(String linkName) throws InterruptedException {
		log.info("Admin clicks on Program on the Navigation Bar");
		if(linkName.equalsIgnoreCase("Program"))
		{
			Thread.sleep(2000);
			log.info("Admin clicks on {string} on the Navigation Bar" +linkName);
			program.clickProgramLink();
			
		}
	}

	@Then("Admin should be on Manage Program Page in program module")
	public void admin_should_be_on_manage_program_page_in_program_module() {
		log.info("Admin should be on Manage Program Page in program module");

		Assert.assertTrue(program.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	
	@When("Admin selects more than one program by clicking on the checkbox in the Program module")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox_in_the_program_module() throws InterruptedException {
		log.info("Admin selects more than one program by clicking on the checkbox in the Program module");
		program.selectMultipleProgramChk();
		
	}

	@Then("Programs in the Program module get selected")
	public void programs_in_the_program_module_get_selected() {
		Assert.assertTrue(program.isSelectedMultipleProgramChk(), "Multiple Programs are selected");
	}
	
	@Given("Admin is in the manage program page along with multiple program selected in the Program module")
	public void admin_is_in_the_manage_program_page_along_with_multiple_program_selected_in_the_program_module() {
		Assert.assertTrue(program.isSelectedMultipleProgramChk(), "Multiple Programs are selected");
	}

	@When("Admin clicks on the common delete button in the Program module")
	public void admin_clicks_on_the_common_delete_button_in_the_program_module() {
		Assert.assertTrue(program.isEnabledCommonDeleteBtn(), "Common Delete Button is Enabled");
		program.clickCommonDeleteButton();
	}

	@Then("Admin should land on Confirmation form in the Program module.")
	public void admin_should_land_on_confirmation_form_in_the_program_module() {
		Assert.assertTrue(program.isCommonDeleteConfirmForm(), "Admin landed on Common Delete Confirmation Form");

	}

	
	@Given("Admin is on confirm deletion form in the manage program page after clicking common delete button in the Program module")
	public void admin_is_on_confirm_deletion_form_in_the_manage_program_page_after_clicking_common_delete_button_in_the_program_module() {
		Assert.assertTrue(program.isCommonDeleteConfirmForm(), "Admin is on Common Delete Confirmation Form");
	}

	@When("Admin clicks <YES> button on the alert in the Program module")
	public void admin_clicks_yes_button_on_the_alert_in_the_program_module() throws InterruptedException {
		log.info("ProgramMultipleDeleteSteps-------Admin clicks <YES> button on the alert in the Program module");
		Thread.sleep(2000);
		Assert.assertTrue(program.commonDeleteMultipleAlertConfirmYes(),"Selected Programs was successfully Deleted");
		Thread.sleep(1000);
		Assert.assertTrue(program.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}
	
	@Then("Admin should see {string} message in the Program module")
	public void admin_should_see_message_in_the_program_module(String string) {
		Assert.assertTrue(program.getToastMessage().contains("Programs Deleted"),"Programs Successfully Deleted");
	}

	@Given("Admin is on Program module after Delete operation")
	public void admin_is_on_program_module_after_delete_operation() {
		Assert.assertTrue(program.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@When("Admin Searches for {string} in the Program module.")
	public void admin_searches_for_in_the_program_module(String string) {
	}

	@Then("There should be zero results.in the Program page")
	public void there_should_be_zero_results_in_the_program_page() throws InterruptedException {
		program.searchMultipleDeletedProgram();
	}

	
	@Given("Admin clicks common delete after selecting multiple check boxes in the data table to reach on confirm deletion alert in the Program module")
	public void admin_clicks_common_delete_after_selecting_multiple_check_boxes_in_the_data_table_to_reach_on_confirm_deletion_alert_in_the_program_module() throws InterruptedException {
		log.info("ProgramMultipleDeleteSteps-------Admin clicks delete after selecting multiple check boxes in the data table to reach on confirm deletion alert");
		program.selectMultipleProgramChk();
		Thread.sleep(1000);
		program.clickCommonDeleteButton();
		Thread.sleep(1000);
		Assert.assertTrue(program.isCommonDeleteConfirmForm(), "Admin is on Common Delete Confirmation Form");
	}

	@When("Admin clicks <NO> button on the alert in the Program module")
	public void admin_clicks_no_button_on_the_alert_in_the_program_module() {
	}

	@Then("Admin should see Programs are still selected and not deleted in the Program module")
	public void admin_should_see_programs_are_still_selected_and_not_deleted_in_the_program_module() throws InterruptedException {
		log.info("ProgramMultipleDeleteSteps-------Admin should land on Manage Program page and can see the selected programs are not deleted from the data table");
		Assert.assertTrue(program.commonDeleteMultipleAlertConfirmNo(),"Programs are still in the Data table and not deleted");
		Thread.sleep(1000);
		Assert.assertTrue(program.isSelectedMultipleProgramChk(),"Programs are still selected and not deleted");
		Assert.assertTrue(program.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	
	@Given("Admin is on Confirm Delete alert popup after selecting a program to delete in the Program module")
	public void admin_is_on_confirm_delete_alert_popup_after_selecting_a_program_to_delete_in_the_program_module() throws InterruptedException {
		program.clickCommonDeleteButton();
		Thread.sleep(1000);
		Assert.assertTrue(program.isCommonDeleteConfirmForm(), "Admin is on Common Delete Confirmation Form");
	}

	@When("Admin clicks Close X Icon on Deletion alert in the Program module")
	public void admin_clicks_close_x_icon_on_deletion_alert_in_the_program_module() {
	}

	@Then("Admin can see the deletion alert disappears without any changes in the Program module")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes_in_the_program_module() throws InterruptedException {
		log.info("ProgramMultipleDeleteSteps-------Admin can see the deletion alert disappears without any changes in the Program module");
		Assert.assertTrue(program.clickXbuttonCofirmForm(),"Programs are still in the Data table and not deleted");
		Thread.sleep(1000);
		Assert.assertTrue(program.isSelectedMultipleProgramChk(),"Programs are still selected and not deleted");
		Assert.assertTrue(program.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
		program.selectMultipleProgramChk();//to uncheck the selected check boxes
	}

}
