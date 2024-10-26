package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Program;
import utilities.Constants;
import utilities.Context;

public class PaginationSteps extends Constants{

	Context context;
	Program program;

	public PaginationSteps(Context context) {
		this.context = context;
		program = context.getProgram();
	}

	@When("Admin clicks on {string} on the Navigation Bar")
	public void admin_clicks_on_on_the_navigation_bar(String linkName) {
		log.info("PaginationSteps---------Admin clicks on Program on the Navigation Bar");
		if(linkName.equalsIgnoreCase("Program"))
		{
			log.info("Admin clicks on {string} on the Navigation Bar" +linkName);
			program.clickProgramLink();
			
		}
	}

	@Given("Admin is on Manage Program page in program module")
	public void admin_is_on_manage_program_page_in_program_module() {
		log.info("PaginationSteps--------Admin is on Manage Program page in program module");

		Assert.assertTrue(program.getProgramHeaderName().equalsIgnoreCase("Manage Program"));
	}

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() throws InterruptedException {
		log.info("PaginationSteps---Admin clicks Next page link on the program table");
//		Thread.sleep(1000);
		program.clickNextLink();
	}

	@Then("Admin should see the Pagination has {string} active link on the program table")
	public void admin_should_see_the_pagination_has_active_link_on_the_program_table(String string) {
		log.info("PaginationSteps---Admin should see the Pagination has Next active link");
		Assert.assertTrue(program.isActiveNextLink(),"Next Page Link is Active");
	}
	@When("Admin clicks Last page link on the program table")
	public void admin_clicks_last_page_link_on_the_program_table() {
		log.info("PaginationSteps---Admin clicks Last page link on the program table");
		program.clickLastLink();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled in program module")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled_in_program_module() {
		log.info("PaginationSteps---Admin should see the last page record on the table with Next page link are disabled in program module");
		Assert.assertTrue(!program.isActiveNextLink(),"Next Page link is Disabled");
		Assert.assertTrue(program.getOriginalProgramNameList().size()>0,"Last page record is present");
	}
	@Given("Admin is on last page of Program table")
	public void admin_is_on_last_page_of_program_table() {
		log.info("PaginationSteps---Admin is on last page of Program table");
		Assert.assertTrue(!program.isActiveLastLink(),"Admin is on last page of Program table as the LastPage Link is Disabled");
	}

	@When("Admin clicks Previous page link on the program table")
	public void admin_clicks_previous_page_link_on_the_program_table() {
		log.info("PaginationSteps---Admin clicks Previous page link");
		program.clickPreviousLink();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link in program module")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_in_program_module() {
		log.info("PaginationSteps---Admin should see the previous page record on the table with pagination has previous page link in program module");
		Assert.assertTrue(program.isActivePreviousLink(),"Previous Page Link is Enabled");
		Assert.assertTrue(program.getOriginalProgramNameList().size()>0,"Previous page record is present");
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
		log.info("PaginationSteps---Admin is on Previous Program page");
		Assert.assertTrue(program.isActivePreviousLink() && program.isActiveNextLink(),"Admin is on Previous Program page");
//		Assert.assertTrue(program.isActiveNextLink(),"Next Page link is Enabled");
	}

	@When("Admin clicks First page link on the program table")
	public void admin_clicks_first_page_link_on_the_program_table() {
		log.info("PaginationSteps---Admin clicks First page link on the program table");
		program.clickFirstLink();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled in program module")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled_in_program_module() {
		log.info("PaginationSteps---Admin should see the very first page record on the table with Previous page link are disabled in program module");
		Assert.assertTrue(!program.isActivePreviousLink(),"Previous Page Link is Disabled");
		Assert.assertTrue(program.isFirstPage(),"First Page Record is present");
	}


}
