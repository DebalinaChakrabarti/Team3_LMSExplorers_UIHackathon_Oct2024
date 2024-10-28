
Feature: Login

  Scenario: Verify Admin is able to land on login page
    Given Admin launch the browser
    When  Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  Scenario Outline: Validate login with valid credentials
    When Admin enters credentials '<Uname>' and '<Pwd>' and clicks login button
    Then Admin should land on dashboard page

    Examples:
      | Uname          | Pwd            |
      | Sdet@gmail.com | LmsHackathon@2024 |
