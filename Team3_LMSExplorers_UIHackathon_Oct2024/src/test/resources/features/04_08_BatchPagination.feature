
@batch
Feature: Batch Pagination

	Background: Admin is on the Batch Page after logged in
    Given Check if Admin is logged in or not for the Batch Module
    When Admin clicks on Batch on the Navigation Bar
    Then Admin should be on Manage Batch Page in Batch module



 
  Scenario: Verify Next page link
    Given Admin is on Batch page in batch module
    When Admin clicks Next page link on the Batch table 
    Then Admin should see the Pagination has "Next" active link on the Batch table


  Scenario: Verify Last page link
    Given Admin is on Batch page in batch module
    When Admin clicks Last page link on the batch table
    Then Admin should see the last page record on the table with Next page link are disabled in batch module

    Scenario: Verify Previous page link
    Given Admin is on last page of batch table
    When Admin clicks Previous page link on the batch table 
    Then Admin should see the previous page record on the table with pagination has previous page link in batch module
  
    Scenario: Verify First page link
    Given Admin is on Previous batch page 
    When Admin clicks First page link on the batch table
    Then Admin should see the very first page record on the table with Previous page link are disabled in batch module
 
  