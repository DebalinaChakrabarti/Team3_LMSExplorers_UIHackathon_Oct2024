@program
Feature: Multiple Delete Program
 
	Scenario: Admin is on the Manage Program Page after logged in
    Given Check if Admin is logged in or not for the Program Mdule
    When Admin clicks on "Program" on the Navigation Bar to reach the Program module
    Then Admin should be on Manage Program Page in program module


 Scenario:  Verify Admin is able to select multiple programs
  Given Admin is on the manage program page after clicking Program on the navigation bar in the Program module
  When Admin selects more than one program by clicking on the checkbox in the Program module
  Then Programs in the Program module get selected 


 Scenario:  Verify Admin is able to delete Multiple programs
  Given Admin is in the manage program page along with multiple program selected in the Program module
  When Admin clicks on the common delete button in the Program module
  Then Admin should land on Confirmation form in the Program module.
  
 Scenario:  Verify Admin is able to click 'Yes' Button
  Given Admin is on confirm deletion form in the manage program page after clicking common delete button in the Program module
  When Admin clicks <YES> button on the alert in the Program module
  Then Admin should see "Successful  program deleted" message in the Program module
  
 Scenario:  Verify Admin is able to delete program
  Given Admin is on Program module after Delete operation 
  When Admin Searches for "Deleted Program names" in the Program module.
  Then There should be zero results.in the Program page

Scenario:  Verify Admin is able to click 'No' Button
  Given Admin clicks common delete after selecting multiple check boxes in the data table to reach on confirm deletion alert in the Program module
  When Admin clicks <NO> button on the alert in the Program module
  Then Admin should see Programs are still selected and not deleted in the Program module

 Scenario: Validate Close X icon on Confirm Deletion alert in the Program module
    Given Admin is on Confirm Delete alert popup after selecting a program to delete in the Program module
    When Admin clicks Close X Icon on Deletion alert in the Program module
    Then Admin can see the deletion alert disappears without any changes in the Program module
