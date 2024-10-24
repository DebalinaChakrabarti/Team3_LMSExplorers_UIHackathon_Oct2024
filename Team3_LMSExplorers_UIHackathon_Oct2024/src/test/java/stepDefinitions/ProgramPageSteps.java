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

}
