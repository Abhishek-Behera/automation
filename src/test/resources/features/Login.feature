Feature: User Login

  Scenario: Login with valid credentials
    Given the user is on the home page
    When the user clicks on Login button
    And the user enters login username and password
    And clicks on the login button
    Then the user should be logged in successfully

  Scenario: Login with invalid credentials
    Given the user is on the home page
    When the user clicks on Login button
    And the user enters invalid login username and password
    And clicks on the login button
    Then the user should see an error message for invalid credentials

  Scenario: Successfully log out
    Given the user is on the home page
    Given the user is logged in with username "user4005" and password "pass4005"
    When the user clicks the logout button
    Then the user should be logged out