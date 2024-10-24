Feature: Program Module
Background:
Given Admin is logged in to LMS Portal

Scenario: Verify that Admin is able to navigate to Program module
Given Admin is on dashboard page after Loggingin
When Admin clicks "Program" on the navigation bar
Then Admin should be navigated to Program module

Scenario: Verify any broken links on program page  
Given Admin is on dashboard page after Loggingin
When Admin clicks "Program" on the navigation bar
Then Admin should not have any broken links for Program module

Scenario: Verify heading in menu bar
Given Admin is on dashboard page after Loggingin
When Admin clicks "Program" on the navigation bar
Then Admin should see the heading "LMS - Learning Management System"

Scenario: Verify other modules name displayed in menu bar
Given Admin is on dashboard page after Loggingin
When Admin clicks "Program" on the navigation bar
Then Admin should see the module names as in order "Program Batch Class"

Scenario: Verify Logout displayed in menu bar
Given Admin is on dashboard page after Loggingin
When Admin clicks "Program" on the navigation bar
Then Admin should see "Logout" in menu bar

Scenario: Verify sub menu displayed in program menu bar
Given Admin is on dashboard page after Loggingin
When Admin clicks "Program" on the navigation bar
Then Admin should see sub menu in menu bar as "Add New Program"




