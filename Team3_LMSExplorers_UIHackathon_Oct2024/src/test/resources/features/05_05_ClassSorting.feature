@class
 Feature: Class Sorting Validation

 	Background: Admin is on the Class Page after logged in
 	Given Admin is logged in to LMS Portal
	Given Admin is on dashboard page after Loggingin
 #Given Check if Admin is logged in or not for the Class Module
  When Admin clicks on Class on the Navigation Bar
  Then Admin should be on Manage Class Page in Class module

  Scenario: Validates Sorting(data ordering) of Class Name on the Class Data table
    Given Admin is on Manage Class page in the Class module
    When Admin clicks the sort icon of Class Name column in the Class module
    Then The data get sorted on the table based on the Class Name column values in ascending order in the Class module

    Given The data is in the ascending order on the table based on Class Name column in the Class module
    When Admin clicks the sort icon of Class Name column to sort Class Name in descending order in the Class module
    Then The data get sorted on the table based on the Class Name column values in descending order in the Class module
 
  Scenario: Validates Sorting(data ordering) of Class Description on the Class Data table
    Given Admin is on Manage Class page in the Class module
    When Admin clicks the sort icon of Class Description column in the Class module
    Then The data get sorted on the table based on the Class Description column values in ascending order in the Class module

    Given The data is in the ascending order on the table based on Class Description column in the Class module
    When Admin clicks the sort icon of Class Description column to sort Class Description in descending order in the Class module
    Then The data get sorted on the table based on the Class Description column values in descending order in the Class module

  Scenario: Validates Sorting(data ordering) of Class Status on the Class Data table
    Given Admin is on Manage Class page in the Class module
    When Admin clicks the sort icon of Class Status column in the Class module
    Then The data get sorted on the table based on the Class Status column values in ascending order in the Class module
    
    Given The data is in the ascending order on the table based on Class Status column in the Class module
    When Admin clicks the sort icon of Class Status column to sort Class status in descending order in the Class module
    Then The data get sorted on the table based on the Class Status column values in descending order in the Class module



