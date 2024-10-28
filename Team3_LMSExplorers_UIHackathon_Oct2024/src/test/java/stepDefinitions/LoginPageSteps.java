package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import io.cucumber.java.en.Then;
import utilities.Constants;
import utilities.Context;

public class LoginPageSteps extends Constants {

	Context context;
	LoginPage loginPage;

	public LoginPageSteps(Context context) {
		this.context = context;
		loginPage = context.getLoginPage();
	}

	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		loginPage.getloginUrl();
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
	}
	@When("Admin enters credentials {string} and {string} and clicks login button")
	public void user_enters_valid_credentials(String Uname, String Pwd) throws InterruptedException {
		System.out.println("Enter Valid Credentials");
		loginPage.EnterUserName(Uname);
		loginPage.EnterPassword(Pwd);
		System.out.println("Click Login Button");
		loginPage.clickOnloginButton();
	}
	@Then("Admin should land on dashboard page")
	public void Admin_should_land_on_dashboard_page() throws InterruptedException {

	}

}
