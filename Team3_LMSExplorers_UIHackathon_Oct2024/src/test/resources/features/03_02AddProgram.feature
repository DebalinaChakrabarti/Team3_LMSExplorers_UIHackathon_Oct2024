@program
Feature: Add New Program

Background: 

Given Admin is logged in to LMS Portal
Given Admin is on dashboard page after Loggingin

Scenario: Verify add New Program
Given Admin is on Program module for adding program
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see pop up window for program details


Scenario: Verify title of the pop up window
Given Admin is on Program module for adding program
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see window title as "Program Details"


Scenario Outline: Verify mandatory fields with red "*" mark 
Given Admin is on Program module for adding program
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see red "*" mark beside mandatory field '<field>'

Examples:
|field|
|Program name|
|Description|
|Status|


Scenario Outline: Verify empty form submission
Given Admin is on Program details form
When Admin clicks save button without entering mandatory 
Then Admin gets message '<field> is required.'

Examples:
|field|
|Program name|
|Description|
|Status|

Scenario: Verify cancel button
Given Admin is on Program details form
When Admin clicks Cancel button
Then Admin can see Program Details form disappears 

Scenario: Verify enter program name
Given Admin is on Program details form
When Admin enters the Name in the text box
Then Admin can see the text entered

Scenario: Verify enter description
Given Admin is on Program details form
When Admin enters the Description in text box
Then Admin can see the text entered in description box

Scenario Outline: Verify select Status
    Given Admin is on Program details form
    When Admin selects the status of the program by clicking on the radio button "<status>"
    Then Admin can see "<status>" status selected

Examples:
|status|
|Active|
|Inactive|

Scenario Outline: Verify Admin is able to save the program details
  Given Admin is on Program details form
   When Admin enters valid details for mandatory fields from "<sheetName>" with scenario name "<scenarioName>" and clicks on the save button
  Then Admin gets message for new program for each "<sheetName>" and  "<scenarioName>"
Examples:
 |sheetName|scenarioName|
 |Program|addNewProgramWithValidData|
 
 
Scenario Outline: Verify added Program is created
 When Admin searches with newly created program name from "<sheetName>" with scenario name "<scenarioName>"
 Then Records of the newly created program name is displayed from "<sheetName>" with scenario name "<scenarioName>"
 
Examples:

 |sheetName|scenarioName|
 |Program|searchingTheAddedProgram|
 

Scenario: Verify close window with "X" 
 Given Admin is on Program details form
 When Admin Click on "X" button
 Then Admin can see Program Details form disappears 
 
 
 

