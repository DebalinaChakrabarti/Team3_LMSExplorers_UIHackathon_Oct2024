package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import utilities.Constants;
import utilities.Context;

public class DashboardPageSteps extends Constants{

	Context context;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	
	public DashboardPageSteps (Context context) {
	this.context = context;
	loginPage = context.getLoginPage();
	dashboardPage = context.getDashboardPage();
	}
	
	@Given("Admin is in loginPage.")
	public void admin_is_in_login_page() {
	   loginPage.getloginUrl();
	}

	@When("Admin enter valid credentials and clicks login button.")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
	    loginPage.enterCredentials();
	}

	@Then("Admin should see dashboard")
	public void admin_should_see_dashboard() {
		Assert.assertTrue(loginPage.getCurrentUrl().contains(baseURL),"Admin is in Dashboard Page");   
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
	 
		if (dashboardPage.navigation_Time() <= 30) {
			Assert.assertTrue(true, "Dashboard page navigation time is " + dashboardPage.navigation_Time());
		} else {
			Assert.assertTrue(false, "Dashboard page navigation time is " + dashboardPage.navigation_Time());
		}
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) throws Throwable {
		dashboardPage.verifyLink();
	}

	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		Assert.assertTrue(
				dashboardPage.getLearningManagementSystemTitle().trim().contains("LMS - Learning Management System"),
				"'LMS - Learning Management System' page is not displayed");
		System.out.println("'LMS - Learning Management System' page is displayed");

	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		dashboardPage.checkLMSAlignment();
		}
	

	@Then("Admin should see correct spelling in navigation bar text {string}")
	public void admin_should_see_correct_spelling_in_navigation_bar_text(String expField) {
		if (expField.contains("Program")) {
			Assert.assertTrue(dashboardPage.getProgrambuttonlink().contains("Program"),
					"'Program' spelling is  not as expected");
			System.out.println("'Program' spelling is as expected");
			
		} else if (expField.contains("Batch")) {
			Assert.assertTrue(dashboardPage.getbatchbuttonlink().contains("Batch"),
					"'Batch' spelling is  not as expected");
			System.out.println("'Batch' spelling is as expected");
			
		} else if (expField.contains("Class")) {
			Assert.assertTrue(dashboardPage.getclassbuttonlink().contains("Class"), "'Class' spelling is  not as expected");
			System.out.println("'Class' spelling is as expected");
			
		} else if (expField.contains("Logout")) {
			Assert.assertTrue(dashboardPage.getlogoutbuttonlink().contains("Logout"),
					"'Logout' spelling is  not as expected");
			System.out.println("'Logout' spelling is as expected");
		}

	}
	

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		dashboardPage.titleSpellCheckSpaceCheck();
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		dashboardPage.lmsNavigationBarValidation();
	}

	
}


