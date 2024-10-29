package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddNewClassPopup;
import pageObjects.LoginPage;
import utilities.Context;

public class AddNewClassPopupSteps {

	WebDriver driver;
	WebDriverWait wait;
	Context context;
	LoginPage loginPage;
	AddNewClassPopup addNewClassPopup;

	public AddNewClassPopupSteps(WebDriver driver) {
		this.driver = driver;
	}

	public AddNewClassPopupSteps(Context context) {
		this.context = context;
		loginPage = context.getLoginPage();
		addNewClassPopup = context.getAddNewClassPopup();
	}

	@Given("Admin is on the Class Popup window in class module")
	public void admin_is_on_the_class_popup_window_in_class_module() {

		addNewClassPopup.addNewClass();
	}

	@When("Admin enters mandatory fields in the form and clicks on save button in class module")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button() throws InterruptedException {
		addNewClassPopup.selectBatchnameDropdown();
		addNewClassPopup.classTopic();
		addNewClassPopup.selectClassDates();
		addNewClassPopup.selectStaffName();
		addNewClassPopup.statusActive();

	}

	@When("Admin enters mandatory fields in the form and clicks on save button from {string} with scenario name {string} in class module")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button_from_with_scenario_name(
			String sheetName, String scenarioName) throws IOException, InterruptedException {
		addNewClassPopup.enterMandatoryClassDetails(sheetName, scenarioName);
	}

	@Then("Admin gets message Class added Successfully from {string} with scenario name {string} in class module")
	public void admin_gets_message_class_added_successfully_from_with_scenario_name(String sheetName,
			String scenarioName) {
		addNewClassPopup.validateSuccessClassCreated(sheetName, scenarioName);
	}

}
