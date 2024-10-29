@dashboard
Feature: Dashboard Page


Background: Admin gives the correct LMS portal URL

Scenario: Verify after login Admin lands on dashboard page
Given Admin is in loginPage.
When Admin enter valid credentials and clicks login button.
Then Admin should see dashboard

Scenario: Verify the response time
Then Maximum navigation time in milliseconds, defaults to 30 seconds

Scenario: Verify broken link
Then HTTP response >= 400. Then the link is broken

Scenario: Verify LMS title
Then Admin should see LMS -Learning management system as title

Scenario: Verify LMS title alignment
Then LMS title should be on the top left corner of page

Scenario Outline: Validate navigation bar text
Then Admin should see correct spelling in navigation bar text '<expectedField>'

Examples:
|expectedField|
|Program      |
|Batch        |
|Class        |
|Logout       |

Scenario: Validate LMS title has correct spelling and space
Then Admin should see correct spelling and space in LMS title

Scenario: Validate alignment for navigation bar
Then Admin should see the navigation bar text on the top right side

#OUT OF SCOPE

#Scenario: Validate navigation bar order 1st home
#Then Admin should see Home in the 1st place
#
#Scenario: Validate navigation bar order 2nd program
#Then Admin should see program in the 2nd place
#
#Scenario: Validate navigation bar order 3rd batch
#Then Admin should see batch in the 3rd place
#
#Scenario: Validate navigation bar order 4th class
#Then Admin should see class in the 4th place
#
#Scenario: validate navigation bar order 5th logout
#Then Admin should see logout in the 5th place
