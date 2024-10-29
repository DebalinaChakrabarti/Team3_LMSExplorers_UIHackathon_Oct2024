package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Batch;
import utilities.Constants;
import utilities.Context;

public class BatchPaginationSteps extends Constants{

	Context context;
	Batch batch;

	public BatchPaginationSteps(Context context) {
		this.context = context;
		batch = context.getBatch();
	}
	@Given("Check if Admin is logged in or not for the Batch Module")
	public void admin_is_logged_in() throws InterruptedException {
		log.info("Admin is logged in");
		Thread.sleep(2000);
		Assert.assertEquals(batch.checkLogoutLink(), true);//checking if logged in
		
	}

	@When("Admin clicks on Batch on the Navigation Bar")
	public void admin_clicks_on_on_the_navigation_bar() {
		log.info("PaginationSteps---------Admin clicks on Batch on the Navigation Bar");
			log.info("Admin clicks on Batch on the Navigation Bar");
			batch.clickBatchLink();
	}

	@Then("Admin should be on Manage Batch Page in Batch module")
	public void admin_should_be_on_manage_batch_page_in_batch_module() {
		log.info("Admin should be on Manage Batch Page in batch module");

		Assert.assertTrue(batch.getBatchHeaderName().equalsIgnoreCase("Manage Batch"));
	}

	@Given("Admin is on Batch page in batch module")
	public void admin_is_on_manage_batch_page_in_batch_module() {
		log.info("PaginationSteps--------Admin is on Manage Batch page in batch module");

		Assert.assertTrue(batch.getBatchHeaderName().equalsIgnoreCase("Manage Batch"));
	}

	@When("Admin clicks Next page link on the Batch table")
	public void admin_clicks_next_page_link_on_the_batch_table() throws InterruptedException {
		log.info("PaginationSteps---Admin clicks Next page link on the batch table");
		batch.clickNextLink();
	}

	@Then("Admin should see the Pagination has {string} active link on the Batch table")
	public void admin_should_see_the_pagination_has_active_link_on_the_batch_table(String string) {
		log.info("PaginationSteps---Admin should see the Pagination has Next active link");
		Assert.assertTrue(batch.isActiveNextLink(),"Next Page Link is Active");
	}
	@When("Admin clicks Last page link on the batch table")
	public void admin_clicks_last_page_link_on_the_program_table() {
		log.info("PaginationSteps---Admin clicks Last page link on the batch table");
		batch.clickLastLink();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled in batch module")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled_in_batch_module() {
		log.info("PaginationSteps---Admin should see the last page record on the table with Next page link are disabled in batch module");
		Assert.assertTrue(!batch.isActiveNextLink(),"Next Page link is Disabled");
		Assert.assertTrue(batch.getOriginalBatchNameList().size()>0,"Last page record is present");
	}
	@Given("Admin is on last page of batch table")
	public void admin_is_on_last_page_of_batch_table() {
		log.info("PaginationSteps---Admin is on last page of Batch table");
		Assert.assertTrue(!batch.isActiveLastLink(),"Admin is on last page of Batch table as the LastPage Link is Disabled");
	}

	@When("Admin clicks Previous page link on the batch table")
	public void admin_clicks_previous_page_link_on_the_batch_table() {
		log.info("PaginationSteps---Admin clicks Previous page link");
		batch.clickPreviousLink();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link in batch module")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_in_batch_module() {
		log.info("PaginationSteps---Admin should see the previous page record on the table with pagination has previous page link in batch module");
		Assert.assertTrue(batch.isActivePreviousLink(),"Previous Page Link is Enabled");
		Assert.assertTrue(batch.getOriginalBatchNameList().size()>0,"Previous page record is present");
	}

	@Given("Admin is on Previous batch page")
	public void admin_is_on_previous_batch_page() {
		log.info("PaginationSteps---Admin is on Previous Batch page");
		Assert.assertTrue(batch.isActivePreviousLink() && batch.isActiveNextLink(),"Admin is on Previous Batch page");
	}

	@When("Admin clicks First page link on the batch table")
	public void admin_clicks_first_page_link_on_the_batch_table() {
		log.info("PaginationSteps---Admin clicks First page link on the batch table");
		batch.clickFirstLink();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled in batch module")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled_in_batch_module() {
		log.info("PaginationSteps---Admin should see the very first page record on the table with Previous page link are disabled in batch module");
		Assert.assertTrue(!batch.isActivePreviousLink(),"Previous Page Link is Disabled");
		Assert.assertTrue(batch.isFirstPage(),"First Page Record is present");
	}


}
