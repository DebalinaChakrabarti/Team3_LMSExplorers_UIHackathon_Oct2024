@batch
Feature: Delete Multiple Batches

 	Background: Admin is on the Batch Page after logged in
    Given Check if Admin is logged in or not for the Batch Module
    When Admin clicks on Batch on the Navigation Bar
    Then Admin should be on Manage Batch Page in Batch module
 
 
 
  Scenario: Validate the delete icon below the header 
    Given None of the checkboxes in data table are selected in the batch module
    Then The delete icon under the 'Manage Batch' header should be disabled in the batch module


  Scenario: Check for single row delete
    Given One of the checkbox row is selected  in the batch module
    When Click delete icon below 'Manage Batch' header  in the batch module
    Then The respective row in the table is deleted  in the batch module

 
  Scenario: Check for multi row delete
    Given Two or more checkboxes row is selected  in the batch module
    When Click delete icon below 'Manage Batch' header  in the batch module
    Then The respective rows in the table is deleted  in the batch module
