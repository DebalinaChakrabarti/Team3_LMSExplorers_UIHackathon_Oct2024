package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ClassPg;
import utilities.Constants;
import utilities.Context;

public class ClassSortingSteps extends Constants {


	Context context;
	ClassPg classPg;

	public ClassSortingSteps(Context context) {
		this.context = context;
		classPg = context.getClassPg();
	}

	@Then("Admin should be redirected to the Manage Class Page in the Class module")
	public void admin_should_be_redirected_to_the_manage_class_page_in_the_class_module() {
		log.info("ClassSortingSteps-------Admin should be redirected to the Manage Class Page in the Class module");

		Assert.assertTrue(classPg.getClassHeaderName().equalsIgnoreCase("Manage Class"));
	}

	@Given("Admin is on Manage Class page in the Class module")
	public void admin_is_on_manage_class_page_in_the_class_module() {
		log.info("ClassSortingSteps------------Admin is on Manage Class page in the Class module");
		Assert.assertTrue(classPg.getClassHeaderName().equalsIgnoreCase("Manage Class"));
	}

	@When("Admin clicks the sort icon of Class Name column in the Class module")
	public void admin_clicks_the_sort_icon_of_class_name_column_in_the_program_module() {
		log.info("ClassSortingSteps---Admin clicks the sort icon of program name column");
		classPg.clickClassNameColumnHeader();
	}

	@Then("The data get sorted on the table based on the Class Name column values in ascending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_name_column_values_in_ascending_order_in_the_class_module() {
		log.info("ClassSortingSteps---The data get sorted on the table based on the program name column values in ascending order");
		classPg.getSortedClassNameListAsc();
		//compare original vs sorted list
		  Assert.assertTrue(classPg.getOriginalClassNameList().equals(classPg.getSortedClassNameListAsc()),"The data is sorted on the table based on the class topic column values in ascending order");
	}
	@Given("The data is in the ascending order on the table based on Class Name column in the Class module")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_class_name_column_in_the_class_module() {
		//compare original vs sorted list
		  Assert.assertTrue(classPg.getOriginalClassNameList().equals(classPg.getSortedClassNameListAsc()),"The data is sorted on the table based on the class topic column values in ascending order");
	}

	@When("Admin clicks the sort icon of Class Name column to sort Class Name in descending order in the Class module")
	public void admin_clicks_the_sort_icon_of_class_name_column_to_sort_class_name_in_descending_order_in_the_class_module() {
		log.info("ClassSortingSteps---Admin clicks the sort icon of Class Name column to sort Class Name in descending order in the Class module");
		classPg.clickClassNameColumnHeader();
	}

	@Then("The data get sorted on the table based on the Class Name column values in descending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_name_column_values_in_descending_order_in_the_class_module() {
		log.info("ClassSortingSteps---The data get sorted on the table based on the Class Name column values in descending order in the Class module");
		//compare original vs sorted list
		Assert.assertTrue(classPg.getOriginalClassNameList().equals(classPg.getSortedClassNameListDesc()),"The data is sorted on the table based on the Class Topic column values in descending order");
	}
	@When("Admin clicks the sort icon of Class Description column in the Class module")
	public void admin_clicks_the_sort_icon_of_class_description_column_in_the_class_module() {
		log.info("ClassSortingSteps---Admin clicks the sort icon of Class Description column in the Class module");
		classPg.clickClassDescColumnHeader();
	}

	@Then("The data get sorted on the table based on the Class Description column values in ascending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_description_column_values_in_ascending_order_in_the_class_module() {
		log.info("ClassSortingSteps---The data get sorted on the table based on the Class Description column values in ascending order in the Class module");
		//compare original vs sorted list
		  Assert.assertTrue(classPg.getOriginalClassDescList().equals(classPg.getSortedClassDescriptionListAsc()),"The data is sorted on the table based on the Class Description column values in ascending order");
	}

	@Given("The data is in the ascending order on the table based on Class Description column in the Class module")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_class_description_column_in_the_class_module() {
	}

	@When("Admin clicks the sort icon of Class Description column to sort Class Description in descending order in the Class module")
	public void admin_clicks_the_sort_icon_of_class_description_column_to_sort_class_description_in_descending_order_in_the_class_module() {
		log.info("ClassSortingSteps---Admin clicks the sort icon of Class Description column to sort Class Description in descending order in the Class module");
		classPg.clickClassDescColumnHeader();
	}

	@Then("The data get sorted on the table based on the Class Description column values in descending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_description_column_values_in_descending_order_in_the_class_module() {
		log.info("ClassSortingSteps---The data get sorted on the table based on the Class Description column values in descending order in the Class module");
		//compare original vs sorted list
		Assert.assertTrue(classPg.getOriginalClassDescList().equals(classPg.getSortedClassDescriptionListDesc()),"The data get sorted on the table based on the Class Description column values in descending order");
	}
	@When("Admin clicks the sort icon of Class Status column in the Class module")
	public void admin_clicks_the_sort_icon_of_class_status_column_in_the_class_module() {
		log.info("ClassSortingSteps---Admin clicks the sort icon of Class Status column in the Class module");
		classPg.clickClassStatusColumnHeader();
	}

	@Then("The data get sorted on the table based on the Class Status column values in ascending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_status_column_values_in_ascending_order_in_the_class_module() {
		log.info("ClassSortingSteps---The data get sorted on the table based on the Class Status column values in ascending order in the Class module");
		//compare original vs sorted list
		  Assert.assertTrue(classPg.getOriginalClassStatusList().equals(classPg.getSortedClassStatusListAsc()),"The data get sorted on the table based on the Class Status column values in ascending order");
	}

	@Given("The data is in the ascending order on the table based on Class Status column in the Class module")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_class_status_column_in_the_class_module() {
	}

	@When("Admin clicks the sort icon of Class Status column to sort Class status in descending order in the Class module")
	public void admin_clicks_the_sort_icon_of_class_status_column_to_sort_class_status_in_descending_order_in_the_class_module() {
		log.info("ClassSortingSteps---Admin clicks the sort icon of Class Status column to sort Class status in descending order in the Class module");
		classPg.clickClassStatusColumnHeader();
	}

	@Then("The data get sorted on the table based on the Class Status column values in descending order in the Class module")
	public void the_data_get_sorted_on_the_table_based_on_the_class_status_column_values_in_descending_order_in_the_class_module() {
		log.info("ClassSortingSteps---The data get sorted on the table based on the Class Status column values in descending order in the Class module");
		//compare original vs sorted list
		Assert.assertTrue(classPg.getOriginalClassStatusList().equals(classPg.getSortedClassStatusListDesc()),"The data get sorted on the table based on the Class Status column values in descending order");
	}


}
