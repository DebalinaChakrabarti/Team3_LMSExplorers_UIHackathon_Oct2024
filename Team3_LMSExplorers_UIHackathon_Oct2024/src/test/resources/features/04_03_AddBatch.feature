@batch
Feature: Add New Batch

Background: 

Given Admin is logged in to LMS Portal
Given Admin is on dashboard page after Loggingin


Scenario: Verify sub menu displayed in batch menu bar

When Admin clicks "Batch" option on the navigation bar
Then Admin should see sub menu in menu bar as "Add New Batch" option


Scenario: Validate Admin able to click on the Add new Batch Option
Given Admin is on dashboard page after Loggingin 
When Admin clicks on "Add New batch" option under the "batch" menu bar 
Then Admin should see the Batch Details pop up window


Scenario: Validate all the fields exist in pop up 
When Admin clicks "Batch" option on the navigation bar and checks all the fields are enabled
Then The pop up should include the fields Batch Name,Number of classes and Description as text box,Program Name as drop down,Status as radio button

Scenario: Validate batchname prefix selected batch name
Given Admin is on the Batch Details Pop Up WIndow
When Admin selects program name present in the dropdown
Then Admin should see selected program name in the batch name prefix box

Scenario: Validate batch name suffix box should accept only numbers
Given Admin is on the Batch Details Pop Up WIndow
When Admin enters alphabets in batch name suffix box
Then Admin should get error message below the text box of respective field

Scenario: Validate batch name prefix box is not editable
Given Admin is on the Batch Details Pop Up WIndow
When Admin enters alphabets in batch name prefix box
Then Admin should see empty text box


Scenario Outline: Verify data for mandatory fields
Given Admin is on the Batch Details Pop Up WIndow
When Admin enters the data only to the mandatory fields and clicks button from "<sheetName>" with scenario name "<scenarioName>" 
Then Admin should get a message from "<sheetName>" with scenario name "<scenarioName>" 

Examples:
|sheetName|scenarioName|
|Batch|addNewBatchOnlyForMandatoryFields|
|Batch|addNewBatchWithMissingData|



Scenario Outline: validate cancel button in Batch details pop up
Given Admin is on the Batch Details Pop Up WIndow
When Admin enters the data only to the mandatory fields and clicks button from "<sheetName>" with scenario name "<scenarioName>" 
Then Admin can see the batch details popup closes without creating any batch from "<sheetName>" with scenario name "<scenarioName>"

Examples:
|sheetName|scenarioName|
|Batch|enterValiddetailsAndClickCancel|


Scenario: Verify close window with "X" 
Given Admin is on the Batch Details Pop Up WIndow
 When Admin Click on "X" button for batch
 Then Admin can see batch Details form disappears 
 
 
 

