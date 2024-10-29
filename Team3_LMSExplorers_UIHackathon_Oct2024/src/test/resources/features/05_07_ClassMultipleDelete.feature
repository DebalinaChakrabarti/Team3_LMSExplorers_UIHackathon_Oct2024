@class
Feature: Delete Multiple Classes

 	Background: Admin is on the Class Page after logged in
    Given Check if Admin is logged in or not for the Class Module
    When Admin clicks on Class on the Navigation Bar
    Then Admin should be on Manage Class Page in Class module
 
 
 
  Scenario: Validate the delete icon below the header 
    Given None of the checkboxes in data table are selected in the class module
    Then The delete icon under the 'Manage Class' header should be disabled in the class module


  Scenario: Check for single row delete
    Given One of the checkbox row is selected  in the class module
    When Click delete icon below 'Manage Class' header  in the class module
    Then The respective row in the table is deleted after clicking YES in confirm delete form in the class module

    Given One of the checkbox row is selected  in the class module
    When Click delete icon below 'Manage Class' header  in the class module
    Then The respective row in the table is not Deleted after clicking NO in confirm delete form in the class module

 
  Scenario: Check for multi row delete
    Given Two or more checkboxes row is selected  in the class module
    When Click delete icon below 'Manage Class' header  in the class module
    Then The respective rows in the table is deleted after clicking YES in confirm delete form  in the class module

    Given Two or more checkboxes row is selected  in the class module
    When Click delete icon below 'Manage Class' header  in the class module
    Then The respective rows in the table is not deleted after clicking NO in confirm delete form  in the class module
    