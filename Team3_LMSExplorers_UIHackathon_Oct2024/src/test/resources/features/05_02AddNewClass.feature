@class
Feature: Add New Class

  Background: 
  Given Admin is logged in to LMS Portal
  Given Admin is on dashboard page after Loggingin
  

  Scenario: Validate Class Details Popup window in class module
    Given Admin Is on the Manage class page after login in class module
    When Admin click add new class under the class menu bar. in class module
    Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window in class module
    
     Scenario: Validate input fields and their text boxes in Class details form in class module 
    Given Admin Is on the Manage class page after login in class module
    When Admin click add new class under the class menu bar. in class module
    Then Admin should see few input fields and their respective text boxes in the class details window in class module
    
