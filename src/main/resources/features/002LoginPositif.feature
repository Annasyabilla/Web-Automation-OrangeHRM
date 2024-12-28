Feature: Login Page
  Scenario: Login With Valid Username and Password
    Given Input Valid Username
    And Input Valid Password
    And Click Login Button
    Then Directed to Dashboard Page
