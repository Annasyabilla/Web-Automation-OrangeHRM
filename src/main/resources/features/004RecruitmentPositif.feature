Feature: Recruitment Positif


  Scenario: Fill in candidate data with valid nformation
    Given Open the Recruitment menu
    When Click the +add button
    And Fill in the first name field
    And Fill in the middle name field
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
    Then Data successfully added and entered the application stage