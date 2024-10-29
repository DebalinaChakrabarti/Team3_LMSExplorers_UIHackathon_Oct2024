package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPg;
//import pageObjects.Class;
import utilities.Constants;
import utilities.Context;

public class ClassPaginationSteps extends Constants{

	Context context;
	ClassPg classPg;

	public ClassPaginationSteps(Context context) {
		this.context = context;
		classPg = context.getClassPg();
	}
	@Given("Check if Admin is logged in or not for the Class Module")
	public void admin_is_logged_in() throws InterruptedException {
		log.info("Admin is logged in");
		Thread.sleep(2000);
		Assert.assertEquals(classPg.checkLogoutLink(), true);//checking if logged in
		
	}

	@When("Admin clicks on Class on the Navigation Bar")
	public void admin_clicks_on_on_the_navigation_bar() {
		log.info("ClassPaginationSteps---------Admin clicks on Class on the Navigation Bar");
			log.info("Admin clicks on Class on the Navigation Bar");
			classPg.clickClassLink();
	}

	@Then("Admin should be on Manage Class Page in Class module")
	public void admin_should_be_on_manage_class_page_in_class_module() {
		log.info("ClassPaginationSteps----------Admin should be on Manage Class Page in class module");

		Assert.assertTrue(classPg.getClassHeaderName().equalsIgnoreCase("Manage Class"));
	}

	@Given("Admin is on Manage Class page in Class module")
	public void admin_is_on_manage_class_page_in_class_module() {
		log.info("ClassPaginationSteps--------Admin is on Manage Class page in class module");

		Assert.assertTrue(classPg.getClassHeaderName().equalsIgnoreCase("Manage Class"));
	}

	@When("Admin clicks Next page link on the Class table")
	public void admin_clicks_next_page_link_on_the_class_table() throws InterruptedException {
		log.info("ClassPaginationSteps---Admin clicks Next page link on the class table");
		classPg.clickNextLink();
	}

	@Then("Admin should see the Pagination has {string} active link on the Class table")
	public void admin_should_see_the_pagination_has_active_link_on_the_class_table(String string) {
		log.info("ClassPaginationSteps---Admin should see the Pagination has Next active link");
		Assert.assertTrue(classPg.isActiveNextLink(),"Next Page Link is Active");
	}
	@When("Admin clicks Last page link on the Class table")
	public void admin_clicks_last_page_link_on_the_program_table() {
		log.info("ClassPaginationSteps---Admin clicks Last page link on the class table");
		classPg.clickLastLink();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled in Class module")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled_in_class_module() {
		log.info("ClassPaginationSteps---Admin should see the last page record on the table with Next page link are disabled in class module");
		Assert.assertTrue(!classPg.isActiveNextLink(),"Next Page link is Disabled");
		Assert.assertTrue(classPg.getOriginalClassNameList().size()>0,"Last page record is present");
	}
	@Given("Admin is on last page of Class table")
	public void admin_is_on_last_page_of_class_table() {
		log.info("ClassPaginationSteps---Admin is on last page of Class table");
		Assert.assertTrue(!classPg.isActiveLastLink(),"Admin is on last page of Class table as the LastPage Link is Disabled");
	}

	@When("Admin clicks Previous page link on the Class table")
	public void admin_clicks_previous_page_link_on_the_class_table() {
		log.info("ClassPaginationSteps---Admin clicks Previous page link");
		classPg.clickPreviousLink();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link in Class module")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_in_class_module() {
		log.info("ClassPaginationSteps---Admin should see the previous page record on the table with pagination has previous page link in class module");
		Assert.assertTrue(classPg.isActivePreviousLink(),"Previous Page Link is Enabled");
		Assert.assertTrue(classPg.getOriginalClassNameList().size()>0,"Previous page record is present");
	}

	@Given("Admin is on Previous Class page")
	public void admin_is_on_previous_class_page() {
		log.info("ClassPaginationSteps---Admin is on Previous Class page");
		Assert.assertTrue(classPg.isActivePreviousLink() && classPg.isActiveNextLink(),"Admin is on Previous Class page");
	}

	@When("Admin clicks First page link on the Class table")
	public void admin_clicks_first_page_link_on_the_class_table() {
		log.info("ClassPaginationSteps---Admin clicks First page link on the class table");
		classPg.clickFirstLink();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled in Class module")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled_in_class_module() {
		log.info("ClassPaginationSteps---Admin should see the very first page record on the table with Previous page link are disabled in class module");
		Assert.assertTrue(!classPg.isActivePreviousLink(),"Previous Page Link is Disabled");
		Assert.assertTrue(classPg.isFirstPage(),"First Page Record is present");
	}


}
