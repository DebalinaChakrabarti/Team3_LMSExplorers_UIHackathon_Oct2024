package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Program;
import utilities.Constants;
import utilities.Context;

public class ProgramSreachBarSteps extends Constants {

	Context context;
	Program program;

	public ProgramSreachBarSteps(Context context) {
		this.context = context;
		program = context.getProgram();
	}
	@Given("Admin is on the manage program page after clicking Program on the navigation bar in the Program module")
	public void admin_is_on_the_manage_program_page_after_clicking_program_on_the_navigation_bar_in_the_program_module() {
		log.info("ProgramSreachBarSteps--------Admin should be on Manage Program Page in program module");
		Assert.assertTrue(program.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@When("Admin enters the program to search By valid or invalid program name and Description with {string} and {string} in the Program module")
	public void admin_enters_the_program_to_search_by_valid_or_invalid_program_name_and_description_with_and_in_the_program_module(String sheetname, String scenarioname) throws IOException, InterruptedException {
		program.searchProgram(sheetname, scenarioname);
	}

	@Then("Admin should able to see Program name, description, and status in the data table for searched program name in the Program module")
	public void admin_should_able_to_see_program_name_description_and_status_in_the_data_table_for_searched_program_name_in_the_program_module() {
	}
}
