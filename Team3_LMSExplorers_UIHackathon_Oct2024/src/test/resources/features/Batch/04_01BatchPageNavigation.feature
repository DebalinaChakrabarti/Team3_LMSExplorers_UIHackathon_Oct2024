@batchPageNavigation
Feature: Batch Page Navigation

  Background:
    Given Admin launch the browser
    When Admin enters credentials 'Sdet@gmail.com' and 'LmsHackathon@2024' and clicks login button
    Then Admin should land on dashboard page

  Scenario: Admin Navigate to Batch page successfully
    Given Admin is on the Dashboard Page
    When Clicks on the Batch menu from the header
    Then Admin should be in the Manage Batch Page

