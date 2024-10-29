@batch
Feature: Edit Batch

Background: 

Given Admin is logged in to LMS Portal
Given Admin is on dashboard page after Loggingin

Scenario: Validate Edit icon feature in any row
When Admin clicks on "Edit Option" for particular batch
Then Admin should see pop up window for batch details


Scenario: Validate program name  value is disabled to edit
When Admin clicks on "Edit Option" for particular batch
Then Admin should see Program name value field is disabled for editing

Scenario: Validate batch name  value is disabled to edit
When Admin clicks on "Edit Option" for particular batch
Then Admin should see batch name value field is disabled for editing

Scenario: Validate editing description and No. of classes fields with invalid data in the pop up
When Admin Updates any fields with invalid data and click save button
Then Admin should get a error message under the respective field


Scenario Outline: validate save button in Batch details pop up

When Admin enters the valid data to all the mandatory fields and click  button  from "<sheetName>" with scenario name "<scenarioName>" 
Then Admin should get a message for editing the batch from "<sheetName>" with scenario name "<scenarioName>" 

Examples:
|sheetName|scenarioName|
|Batch|editNewBatchOnlyForMandatoryFields|




Scenario Outline: validate save button in Batch details pop up

When Admin enters the valid data to all the mandatory fields and click  button  from "<sheetName>" with scenario name "<scenarioName>" 
Then Admin can see the batch details popup closes without editing batch from "<sheetName>" with scenario name "<scenarioName>" 

Examples:
|sheetName|scenarioName|
|Batch|canceleditNewbatchForMandatoryFields|

