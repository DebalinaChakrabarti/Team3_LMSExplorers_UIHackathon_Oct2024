@program
Feature: Delete Program

Background: 

Given Admin is logged in to LMS Portal
Given Admin is on dashboard page after Loggingin

Scenario: Verify Delete Button
When Admin clicks on delete button for a program
Then Admin will get confirm deletion popup


Scenario Outline: Verify Admin is able to click 'Yes'
When Admin searches with newly updated Program Name from "<sheetName>" with scenario name "<scenarioName>"
When Admin clicks on "Yes" button
Then Admin can see 'Successful Program Deleted' message

Examples:
 |sheetName|scenarioName|
 |Program|deletingTheUpdatedProgram|
 
Scenario Outline: Verify Admin is able to search the deleted program 
When Admin Searches for Deleted Program name from "<sheetName>" with scenario name "<scenarioName>"
Then There should be zero results.

Examples:

 |sheetName|scenarioName|
 |Program|searchingTheDeletedProgram|

Scenario: Verify Admin is able to click 'No'

When Admin clicks on the "No" button
Then Admin can see Confirmation form disappears 

Scenario Outline: Verify Admin is able to close the window with "X" 
When Admin clicks on delete button for a program
When Admin Clicked on "X" button
Then Admin can see Confirmation form disappears

 
 

