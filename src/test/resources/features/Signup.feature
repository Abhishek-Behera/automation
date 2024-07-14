Feature: User SignUp

  Scenario: Signup with valid details
    Given the user is on the home page
    When the user clicks on Sign up button
    And  user enters login username and password
    And clicks on the signup button
    Then the user should be registered successfully

  Scenario: Signup with invalid details
    Given the user is on the home page
    When the user clicks on Sign up button
    And user enters invalid username and password
    And clicks on the signup button
    Then the user should see an error message
