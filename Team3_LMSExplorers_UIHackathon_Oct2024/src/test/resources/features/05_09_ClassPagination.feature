
@class
Feature: Class Pagination

	Background: Admin is on the Class Page after logged in
    Given Check if Admin is logged in or not for the Class Module
    When Admin clicks on Class on the Navigation Bar
    Then Admin should be on Manage Class Page in Class module



 
  Scenario: Verify Next page link
    Given Admin is on Manage Class page in Class module
    When Admin clicks Next page link on the Class table 
    Then Admin should see the Pagination has "Next" active link on the Class table


  Scenario: Verify Last page link
    Given Admin is on Manage Class page in Class module
    When Admin clicks Last page link on the Class table
    Then Admin should see the last page record on the table with Next page link are disabled in Class module

    Scenario: Verify Previous page link
    Given Admin is on last page of Class table
    When Admin clicks Previous page link on the Class table 
    Then Admin should see the previous page record on the table with pagination has previous page link in Class module
  
    Scenario: Verify First page link
    Given Admin is on Previous Class page 
    When Admin clicks First page link on the Class table
    Then Admin should see the very first page record on the table with Previous page link are disabled in Class module
 
  