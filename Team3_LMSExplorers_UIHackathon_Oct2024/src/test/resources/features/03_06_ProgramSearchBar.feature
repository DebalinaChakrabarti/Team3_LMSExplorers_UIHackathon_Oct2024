@program
Feature: Manage Program Search Bar
 
	Background: Admin is on the Manage Program Page after logged in
    Given Check if Admin is logged in or not for the Program Mdule
    Then Admin should be on Manage Program Page in program module



 Scenario Outline: Verify Admin is able to search results found for valid/invalid program inputs
  Given Admin is on the manage program page after clicking Program on the navigation bar in the Program module
  When Admin enters the program to search By valid or invalid program name and Description with "<sheetname>" and "<scenarioName>" in the Program module
  Then Admin should able to see Program name, description, and status in the data table for searched program name in the Program module

Examples:

		|	sheetname	| scenarioName												|
		|	Program		|	searchWithValidProgramName					|
		|	Program		|	searchWithValidProgramDesc					|
		|	Program		|	searchWithInvalidProgramName				|			
		|	Program		|	searchWithPartialProgramName				|
		