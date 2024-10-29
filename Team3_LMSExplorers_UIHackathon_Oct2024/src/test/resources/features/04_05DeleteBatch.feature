@batch
Feature: Delete Batch

Background: 

Given Admin is logged in to LMS Portal
Given Admin is on dashboard page after Loggingin

Scenario: validate delete Icon on any row
When Admin clicks on delete button for a batch
Then Admin will get confirm deletion popup for batch


Scenario Outline: Validate yes button on the confirm alert box
When Admin searches with newly updated batch Name from "<sheetName>" with scenario name "<scenarioName>"
When Admin clicks on "Yes" button for batch
Then Admin can see message for batch from "<sheetName>" with scenario name "<scenarioName>"

Examples:
 |sheetName|scenarioName|
 |Batch|deletingTheUpdatedBatch|



Scenario: validate no button on the confirm alert box

When Admin clicks on the "No" button for batch
Then Admin can see Confirmation form disappears for batch

Scenario Outline: validate close Icon on the alert box 
When Admin clicks on the delete button for a batch
When Admin Clicked on "X" button for batch
Then Admin can see Confirmation form disappears for batch

 
 

