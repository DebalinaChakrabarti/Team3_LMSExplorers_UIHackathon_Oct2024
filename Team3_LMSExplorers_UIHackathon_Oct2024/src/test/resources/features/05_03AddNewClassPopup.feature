@class
Feature: Add New Class popup

  Background:   
  Given Admin is logged in to LMS Portal
  Given Admin is on dashboard page after Loggingin

  Scenario: Check if class is created when only mandatory fields are entered with valid data in class module
    Given Admin is on the Class Popup window in class module 
    When Admin enters mandatory fields in the form and clicks on save button in class module
    

  Scenario Outline: Check if class is created when only mandatory fields are entered with valid data in class module
    Given Admin is on the Class Popup window in class module 
    When Admin enters mandatory fields in the form and clicks on save button from "<sheetName>" with scenario name "<scenarioName>" in class module
    Then Admin gets message Class added Successfully from "<sheetName>" with scenario name "<scenarioName>" in class module

    Examples: 
      | sheetName | scenarioName                    |
      | Class     | addClassWithOnlyMandatoryFields |
      | Class     | addClassWithAllFields           |
