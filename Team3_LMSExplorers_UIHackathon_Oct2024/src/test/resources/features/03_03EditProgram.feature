@program
Feature: Edit Program

Background: 

Given Admin is logged in to LMS Portal
Given Admin is on dashboard page after Loggingin

Scenario: Verify Edit option
When Admin clicks on "Edit Option" for particular program
Then Admin should see pop up window for program details


Scenario: Verify title of the pop up window
When Admin clicks on "Edit Option" for particular program
Then Admin should see window title as "Program Details"


Scenario Outline: Verify mandatory fields with red "*" mark 
When Admin clicks on "Edit Option" for particular program
Then Admin should see red "*" mark beside mandatory field '<field>'

Examples:
|field|
|Program name|
|Description|
|Status|



Scenario: Verify Admin able to click cancel button
Given Admin is on program details window
When Admin clicks Cancel button
Then Admin can see Program Details form disappears 

Scenario Outline: Verify edit program 
Given Admin is on program details window
When Admin edits the program and click on save button from "<sheetName>" with scenario name "<scenarioName>"
Then Updated program name is seen by the Admin from "<sheetName>" with scenario name "<scenarioName>"

Examples:
|sheetName|scenarioName|
|Program|editProgramWithProgramName| 
|Program|editProgramWithProgramDescription|
|program|editProgramWithProgramStatus|


Scenario Outline: Verify edited Program details are updated
 When Admin searches with newly updated Program Name from "<sheetName>" with scenario name "<scenarioName>"
 Then Admin verifies that the details are correctly updated from "<sheetName>" with scenario name "<scenarioName>"
 
Examples:
 |sheetName|scenarioName|
 |Program|searchingTheUpdatedProgram|
 

Scenario: Verify close window with "X" 
 Given Admin is on Program details form
 When Admin Click on "X" button
 Then Admin can see Program Details form disappears 
 
 
 

