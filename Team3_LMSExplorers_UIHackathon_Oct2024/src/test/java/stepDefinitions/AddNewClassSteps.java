package stepDefinitions;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddNewClass;
import pageObjects.LoginPage;
import utilities.Context;

public class AddNewClassSteps {
	WebDriver driver;
	WebDriverWait wait;
	Context context;
	LoginPage loginPage;
	AddNewClass addNewClass;
	
	public AddNewClassSteps(WebDriver driver) {
		this.driver = driver;
	}
	public AddNewClassSteps(Context context) {
		this.context = context;
		loginPage = context.getLoginPage();
		addNewClass = context.getAddNewClass();
	}
	@Given("Admin Is on the Manage class page after login in class module")
	public void admin_is_on_the_manage_class_page_after_login() {
		addNewClass.manageClass();
	}

	@When("Admin click add new class under the class menu bar. in class module")
	public void admin_click_add_new_class_under_the_class_menu_bar() throws TimeoutException {
		addNewClass.addNewClass();
	}

	@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window in class module")
	public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		addNewClass.saveClass();
		addNewClass.cancelClass();
		addNewClass.closeIcon();
	}
	@Then("Admin should see few input fields and their respective text boxes in the class details window in class module")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() throws InterruptedException {
		
		addNewClass.inputFields();
		
	}


}
