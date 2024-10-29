@batch
Feature: Batch Page Navigation

  Background:
Given Admin is logged in to LMS Portal
Given Admin is on dashboard page after Loggingin


  Scenario: Admin Navigate to Batch page successfully
    Given Admin is on the Dashboard Page
    When Clicks on the Batch menu from the header
    Then Admin should be in the Manage Batch Page

