package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import utilities.Constants;
import utilities.Context;

public class LogoutPageSteps extends Constants{

	Context context;
	LoginPage loginPage;
	LogoutPage logoutPage;
	
	public LogoutPageSteps(Context context) {
		this.context = context;
		loginPage = context.getLoginPage();
		logoutPage = context.getLogoutPage();
	}
	
	
	
	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
		Assert.assertTrue(loginPage.getCurrentUrl().contains(baseURL),"Admin is in DashBoard Page");
		
	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
	   logoutPage.clickLogoutBtn();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		
	  Assert.assertTrue(loginPage.getCurrentUrl().contains("login"),"Admin is in Login Page");
			
	}
	

	@Given("Admin is in login page")
	public void Admin_is_in_login_page() throws InterruptedException {
		Thread.sleep(1000);
	  Assert.assertTrue(loginPage.getCurrentUrl().contains("login"),"Admin is in Login Page");
			
	}
	
	

	@When("Admin clicks  browser back button")
	public void admin_clicks_browser_back_button() {
		logoutPage.clickBack();
	 
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
	    
	}


}
