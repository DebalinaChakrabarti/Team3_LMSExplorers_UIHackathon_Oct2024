@logout
Feature: Validation on Logout button


Background: Admin is logged into the appilcation
Scenario: Verify logout function
Given Admin is in dashboard page
When Admin clicks on the logout in the menu bar
Then Admin should be redirected to login page



