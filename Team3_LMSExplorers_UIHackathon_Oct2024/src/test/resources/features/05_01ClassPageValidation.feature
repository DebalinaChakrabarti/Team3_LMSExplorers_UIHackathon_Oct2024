@class
Feature: Class Page Validations

  Background: 
Given Admin is logged in to LMS Portal
Given Admin is on dashboard page after Loggingin

  Scenario: Validating the Title in the Manage class page in class module
    Given Admin is on the dashboard page after login in class module
    When Admin clicks the Class Navigation bar in the Header in class module
    Then Admin should land on the Manage class page in class module

  Scenario: Validating the Title in the Manage class page in class module
    Given Admin is on the dashboard page after login in class module
    When Admin clicks the Class Navigation bar in the Header in class module
    Then Admin should see the "LMS - Learning Management System" Title in class module

  Scenario: Validating the Title in the Manage class page in class module
    Given Admin is on the dashboard page after login in class module
    When Admin clicks the Class Navigation bar in the Header in class module
    Then Admin should see the "Manage Class" Header in class module

  Scenario: Validating Search bar in class page in class module
    Given Admin is on the dashboard page after login in class module
    When Admin clicks the Class Navigation bar in the Header in class module
    Then Admin should see Search bar with text as "Search..." in class module

  Scenario: Verify pagination icons below data table in manage class in class module
    Given Admin is on the dashboard page after login in class module
    When Admin clicks the Class Navigation bar in the Header in class module
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table. in class module

  Scenario: Validate the sort icon of all the field in datatable  in class module
    Given Admin is on the dashboard page after login in class module
    When Admin clicks the Class Navigation bar in the Header in class module
    Then Admin should see the Sort icon of all the field in the datatable. in class module

  Scenario: Validating the Delete button under the Manage class in class module
    Given Admin is on the dashboard page after login in class module
    When Admin clicks the Class Navigation bar in the Header in class module
    Then Admin should see the Delete button under the Manage class page header in class module

  Scenario: Validate the total no of classes in manage class page in class module
    Given Admin is on the dashboard page after login in class module
    When Admin clicks the Class Navigation bar in the Header in class module
    Then Admin should see Total no of classes in below of the data table in class module

  Scenario: Validating the data table headers in the class page in class module
    Given Admin is on the dashboard page after login in class module
    When Admin clicks the Class Navigation bar in the Header in class module
    Then Admin should see the datatable heading like Batch Name,Class Topic,Class Description,Status,Class Date,Staff Name,Edit/Delete in class module
