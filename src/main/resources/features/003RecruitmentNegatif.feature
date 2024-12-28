Feature: Recruitment Negatif
  Scenario: Fill in candidate data with blank empty information
    Given Open the Recruitment menu
    When Click the +add button
    And leave empty the first name field
    And leave empty the middle name field
    And leave empty the last name field
    And leave empty the email
    And leave empty the contact number
    And leave empty keywords
    And  leave empty Date of Application
    And leave empty notes
    And Click the Save button
    Then Data failed to be added and an alert appears saying required in the mandatory section

  Scenario: Leave empty the first name field
    Given leave empty the first name field
    When Fill in the middle name field
    And Fill in the last name field
    And Select Vacancy
    And Fill in the email
    And Fill in the contact number
    And Input resume
    And Fill in keywords
    And  Select Date of Application
    And Fill in notes
    And Click the checkbox consent to keep data
    And Click the Save button
    Then Data failed to be added and an alert appears saying required in the first name section

  Scenario: Leave empty the last name field
    Given Fill in the first name field
    And leave empty the last name field
    And Click the Save button
    Then Data failed to be added and an alert appears saying required in the last name section

  Scenario: Leave empty the email field
    Given Fill in the last name field
    When leave empty the email
    And Click the Save button
    Then Data failed to be added and an alert appears saying required in the email section

  Scenario: Fill the email field with invalid email
    Given Fill in the email with invalid email
    And Click the Save button
    Then Data failed to be added and an alert appears showing Expected format in the email section

  Scenario: Validation cancel button on the add recruitment form
    Given Click cancel button
    Then The system will return to the previous recruitment page