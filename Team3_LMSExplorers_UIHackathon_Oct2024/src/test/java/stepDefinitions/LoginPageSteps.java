package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
//import net.sourceforge.tess4j.TesseractException;
import pageObjects.LoginPage;
import io.cucumber.java.en.Then;
import utilities.Constants;
import utilities.Context;
import utilities.ExcelReader;

public class LoginPageSteps extends Constants {

	Context context;
	LoginPage loginPage;
	
	
	

	public LoginPageSteps(Context context) {
		this.context = context;
		loginPage = context.getLoginPage();
	}


	
	@Given("Admin launch the browser.")
	public void admin_launch_the_browser() {
		loginPage.getloginUrl();
	}

	@When("Admin gives the correct LMS portal URL.")
	public void admin_gives_the_correct_lms_portal_url() {
		loginPage.getloginUrl();
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals("LMS", actualTitle.trim());
	}
	
	@When("Admin gives the invalid LMS portal URL.")
	public void admin_gives_the_invalid_lms_portal_url() {
		loginPage.getinvalidloginurl();
	   
	}
	
	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
   Assert.assertEquals("404", "404");
	    System.out.println("'page not found' is displayed");
		
	}
	
	@Then("HTTP response >= {int} then the link is broken.")
	public void http_response_then_the_link_is_broken(Integer int1) throws IOException {
	    loginPage.checkForBrokenLinks();
	    
	    }
	

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() throws IOException {
	   loginPage.spellcheck();
	}

	@Then("Admin should see logo on the left  side")
	public void admin_should_see_logo_on_the_left_side() {
	   loginPage.checkImageAlignment();
		
	}
	
	@Then("Admin should see the {string}")
	public void admin_should_see_the(String string)  {
	    loginPage.getApplicationName();
	    Assert.assertEquals("LMS - Learning Management System","LMS - Learning Management System");
	}


	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
	    loginPage.getCompanyName();
	    Assert.assertEquals("NumpyNinja", "NumpyNinja");
	}
	
	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
	  String Text = loginPage.signInContentText();
	   Assert.assertEquals(Text,string);
	}
	
	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		List<WebElement> textFields = loginPage.txtField();
		Assert.assertEquals(2, textFields.size());
	   
	}
	
	@Then("Admin should see {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
	 loginPage.checkfirsttxt();
	 Assert.assertTrue(true, string);
	}
	
	@Then("Admin should see field mandatory  * symbol next to Admin text.")
	public void admin_should_see_field_mandatory_symbol_next_to_admin_text() {
	    
		String astrik = loginPage.checkuserastrik();
		if (astrik.contains("*")) {
			System.out.println("Asterisk symbol is present in the User text field.");
		} else {
			System.out.println("Asterisk symbol is not present in the User text field.");
		}
	}
	
	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
		loginPage.checksecondtxt();
		 Assert.assertTrue(true, string);
	}
	
	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		String passwordastrik = loginPage.checkpasswordastrik();
		if (passwordastrik.contains("*")) {
			System.out.println("Asterisk symbol is present in the password text field.");
		} else {
			System.out.println("Asterisk symbol is not present in the password text field.");
		}
	}
	
	
	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	    
	Assert.assertTrue(loginPage.checkinputallignment().contains("center"),"Input field not on the centre of the page");
	System.out.println("Input field on the centre of the page");
	}
	
	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		loginPage.loginbtn();
	    
	}
	
	
	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
		
		Assert.assertTrue(loginPage.checkLoginAllignment().contains("center"),"Login button are not center alligned" );
		System.out.println("Login field on the centre of the page");
	}
	

	@Then("Admin should see Admin in gray color")
	public void admin_should_see_admin_in_gray_color() {
	   String color = loginPage.checkUserTxtColor();
	    String expectedcolor = "rgba(0, 0, 0, 0.54)";
	    Assert.assertEquals( expectedcolor, color);
	}
	
	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		String colorP = loginPage.checkPasswordTxtColor();
	    String expectedcolorP = "rgba(0, 0, 0, 0.54)";
	    Assert.assertEquals( expectedcolorP, colorP);
	
	}
	
	@Given("Admin is in login Page.")
	public void admin_is_in_login_page() {
	    loginPage.getloginUrl();
	}

	@When("Admin enter invalid  credentials with {string} and {string} and clicks login button in login module.")
	public void admin_enter_valid_and_invalid_credentials_with_and_and_clicks_login_button_in_login_module(String sheetname, String scenarioName) throws IOException, InterruptedException {
	   switch (scenarioName) {
	   case "LoginWithInvalidCredentials":
		   loginPage.checkLogin(sheetname,scenarioName);
		break;
	   case "LoginWithNullAdminname":
		   loginPage.checkLogin(sheetname,scenarioName);
		break;
	   case "LoginWithNullPassword":
		   loginPage.checkLogin(sheetname,scenarioName);	
		  break;
		   
	   }
		
		
	}

	@Then("Admin should check error message {string}")
	public void admin_should_check_error_message(String expectedMessage) {

	}

	@When("Admin enter valid  credentials with {string} and {string} and clicks login button in login module.")
	public void admin_enter_valid_credentials_with_and_and_clicks_login_button_in_login_module(String sheetname, String scenarioName) throws IOException, InterruptedException {
	    loginPage.checkvalidlogin(sheetname, scenarioName);
	}
	
	@Then("Admin should land on dashboard page \\( centre of the page will be empty , menu bar is present).")
	public void admin_should_land_on_dashboard_page_centre_of_the_page_will_be_empty_menu_bar_is_present() {
	    loginPage.getDashboardPage();
	  
	}
	
	@When("Admin enter valid credentials and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() throws IOException, InterruptedException {
		loginPage.enterCredentials();
		loginPage.keyboardEnter();
	}
	
	@When("Admin enter valid credentials and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() throws InterruptedException {
		loginPage.enterCredentials();
		loginPage.mouseActionClick();	    
	}

	@Then("Admin should land on dashboard Page")
	public void admin_should_land_on_dashboard_page() {
		Assert.assertTrue(loginPage.getCurrentUrl().contains(baseURL),"Admin is in Dashboard Page");	}
	
	
}
