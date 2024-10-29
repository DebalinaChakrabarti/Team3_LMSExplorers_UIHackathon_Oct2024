package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Program;
import utilities.Constants;
import utilities.Context;

public class ProgramSortingSteps extends Constants {


	Context context;
	Program program;

	public ProgramSortingSteps(Context context) {
		this.context = context;
		program = context.getProgram();
	}

	@Then("Admin should be redirected to the Manage Program Page in the Program module")
	public void admin_should_be_redirected_to_the_manage_program_page_in_the_program_module() {
		log.info("ProgramSortingSteps-------Admin should be redirected to the Manage Program Page in the Program module");

		Assert.assertTrue(program.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@Given("Admin is on Manage Program page in the Program module")
	public void admin_is_on_manage_program_page_in_the_program_module() {
		log.info("ProgramSortingSteps------------Admin is on Manage Program page in the Program module");
		Assert.assertTrue(program.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@When("Admin clicks the sort icon of Program Name column in the Program module")
	public void admin_clicks_the_sort_icon_of_program_name_column_in_the_program_module() {
		log.info("ProgramSortingSteps---Admin clicks the sort icon of program name column");
		program.clickProgramNameColumnHeader();
	}

	@Then("The data get sorted on the table based on the Program Name column values in ascending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the program name column values in ascending order");
		program.getSortedProgramNameListAsc();
		//compare original vs sorted list
		  Assert.assertTrue(program.getOriginalProgramNameList().equals(program.getSortedProgramNameListAsc()),"The data is sorted on the table based on the program name column values in ascending order");
	}
	@Given("The data is in the ascending order on the table based on Program Name column in the Program module")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column_in_the_program_module() {
		//compare original vs sorted list
		  Assert.assertTrue(program.getOriginalProgramNameList().equals(program.getSortedProgramNameListAsc()),"The data is sorted on the table based on the program name column values in ascending order");
	}

	@When("Admin clicks the sort icon of Program Name column to sort Program Name in descending order in the Program module")
	public void admin_clicks_the_sort_icon_of_program_name_column_to_sort_program_name_in_descending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---Admin clicks the sort icon of Program Name column to sort Program Name in descending order in the Program module");
		program.clickProgramNameColumnHeader();
	}

	@Then("The data get sorted on the table based on the Program Name column values in descending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Name column values in descending order in the Program module");
		//compare original vs sorted list
		Assert.assertTrue(program.getOriginalProgramNameList().equals(program.getSortedProgramNameListDesc()),"The data is sorted on the table based on the Program Name column values in descending order");
	}
	@When("Admin clicks the sort icon of Program Description column in the Program module")
	public void admin_clicks_the_sort_icon_of_program_description_column_in_the_program_module() {
		log.info("ProgramSortingSteps---Admin clicks the sort icon of Program Name column to sort Program Name in descending order in the Program module");
		program.clickProgramDescColumnHeader();
	}

	@Then("The data get sorted on the table based on the Program Description column values in ascending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Description column values in ascending order in the Program module");
		//compare original vs sorted list
		  Assert.assertTrue(program.getOriginalProgramDescList().equals(program.getSortedProgramDescriptionListAsc()),"The data is sorted on the table based on the Program Description column values in ascending order");
	}

	@Given("The data is in the ascending order on the table based on Program Description column in the Program module")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column_in_the_program_module() {
	}

	@When("Admin clicks the sort icon of Program Description column to sort Program Description in descending order in the Program module")
	public void admin_clicks_the_sort_icon_of_program_description_column_to_sort_program_description_in_descending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---Admin clicks the sort icon of Program Description column to sort Program Description in descending order in the Program module");
		program.clickProgramDescColumnHeader();
	}

	@Then("The data get sorted on the table based on the Program Description column values in descending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Description column values in descending order in the Program module");
		//compare original vs sorted list
		Assert.assertTrue(program.getOriginalProgramDescList().equals(program.getSortedProgramDescriptionListDesc()),"The data get sorted on the table based on the Program Description column values in descending order");
	}
	@When("Admin clicks the sort icon of Program Status column in the Program module")
	public void admin_clicks_the_sort_icon_of_program_status_column_in_the_program_module() {
		log.info("ProgramSortingSteps---Admin clicks the sort icon of Program Status column in the Program module");
		program.clickProgramStatusColumnHeader();
	}

	@Then("The data get sorted on the table based on the Program Status column values in ascending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Status column values in ascending order in the Program module");
		//compare original vs sorted list
		  Assert.assertTrue(program.getOriginalProgramStatusList().equals(program.getSortedProgramStatusListAsc()),"The data get sorted on the table based on the Program Status column values in ascending order");
	}

	@Given("The data is in the ascending order on the table based on Program Status column in the Program module")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column_in_the_program_module() {
	}

	@When("Admin clicks the sort icon of Program Status column to sort Program status in descending order in the Program module")
	public void admin_clicks_the_sort_icon_of_program_status_column_to_sort_program_status_in_descending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---Admin clicks the sort icon of Program Status column to sort Program status in descending order in the Program module");
		program.clickProgramStatusColumnHeader();
	}

	@Then("The data get sorted on the table based on the Program Status column values in descending order in the Program module")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order_in_the_program_module() {
		log.info("ProgramSortingSteps---The data get sorted on the table based on the Program Status column values in descending order in the Program module");
		//compare original vs sorted list
		Assert.assertTrue(program.getOriginalProgramStatusList().equals(program.getSortedProgramStatusListDesc()),"The data get sorted on the table based on the Program Status column values in descending order");
	}


}
