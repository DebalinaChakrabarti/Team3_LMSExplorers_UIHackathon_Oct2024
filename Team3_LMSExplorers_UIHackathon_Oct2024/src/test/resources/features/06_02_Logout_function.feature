@logout
Feature: Validation on Logout button

Background: Admin is logged out of the application

Scenario: Verify back button function 
Given Admin is in login page
When 	Admin clicks  browser back button
Then Admin should receive error message