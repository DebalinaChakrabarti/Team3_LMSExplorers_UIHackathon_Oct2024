@login
Feature: Login

Background: Admin gives the correct LMS portal URL

Scenario Outline: Validate login with invalid credentials
Given Admin is in login Page.
When Admin enter invalid  credentials with "<sheetname>" and "<scenarioName>" and clicks login button in login module.
Then Admin should check error message "please check adminname/password." 

Examples: 
	
|sheetname |scenarioName							|
| Login   |LoginWithInvalidCredentials|
| Login    |LoginWithNullAdminname|
| Login    |LoginWithNullPassword|


Scenario Outline: Validate login with valid credentials
Given Admin is in login Page.
When Admin enter valid  credentials with "<sheetname>" and "<scenarioName>" and clicks login button in login module.
Then Admin should land on dashboard page ( centre of the page will be empty , menu bar is present). 

Examples: 
|sheetname |scenarioName							|	
| Login    |LoginWithValidCredentials|



Scenario Outline: verify login button action through keyboard
Given Admin is in login Page. 
When Admin enter valid credentials and clicks login button through keyboard
Then Admin should land on dashboard Page

Scenario: verify login button action through mouse
Given Admin is in login Page.
When Admin enter valid credentials and clicks login button through mouse
Then Admin should land on dashboard Page
