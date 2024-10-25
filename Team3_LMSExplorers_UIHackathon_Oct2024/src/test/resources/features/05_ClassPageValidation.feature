Feature: @Class

  Background: Given Admin logged on the Dashboard page

  Scenario: Validating the Title in the Manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should land on the Manage class page

  Scenario: Validating the Title in the Manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "LMS - Learning Management System" Title

  Scenario: Validating the Title in the Manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "Manage Class" Header

  Scenario: Validating Search bar in class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see Search bar with text as "Search..."

  Scenario: Verify pagination icons below data table in manage class
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.

  Scenario: Validate the sort icon of all the field in datatable
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Sort icon of all the field in the datatable.

  Scenario: Validating the Delete button under the Manage class
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Delete button under the Manage class page header

  Scenario: Validate the total no of classes in manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see Total no of classes in below of the data table

  Scenario: Validating the data table headers in the class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the datatable heading like Batch Name,Class Topic,Class Description,Status,Class Date,Staff Name,Edit/Delete
