@batch

Feature: Batch Page Validation

  Background:
Given Admin is logged in to LMS Portal
Given Admin is on dashboard page after Loggingin


  Scenario: Validate "Title" in Batch Page
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the LMS Title

  Scenario: Validate "heading" in the Batch Page
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the Manage Batch Heading

  Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the disabled Delete Icon under the header

  Scenario: Validate pagination in the Batch Page
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the enabled pagination controls under the data table

  Scenario: Validate edit icon in each data rows
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the edit icon in each row

  Scenario: Validate delete icon in each data rows
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the delete icon in each row

  Scenario: validate checkbox in each data rows
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the checkbox in each row

  Scenario: Validate Datatable headers
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the correct datatable headers

  Scenario: Validate Checkbox in the Datatable header row
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the checkbox in the datatable header row

  Scenario: Validate "sort icon" next to all the datatable header
  When Admin Clicks on the Batch menu from the header
  Then Admin should see the sort icon next to all Datatable headers