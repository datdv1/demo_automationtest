@Insurer @EditInsurerAddress
Feature: Edit address
  this feature will edit insurer address information.

  Background: User logged in as administrator
    Given the user is on login page
    When the user enters username & password
    And the user clicks on the login button
    Then the dashboard page is opened

  @DataDisplay @TC_14
  Scenario: Verify user can save data without update
    Given the user is on Edit Insurer page
    And the user locates to "Addresses" section
    When the user click to button 'Save'
    Then the user can save page successfully with message 'Insurer modifications applied successfully.' pop up


  @EditInsurerSuccessful
  Scenario: Edit insurer successful
    Given the user is on Edit Insurer page
    When the user edits general information
    And the user edits contact information
    And the user edits address information
    And the user click to button 'Save'
    Then the user can save page successfully with message 'Insurer modifications applied successfully.' pop up
    And the user can see new information in insurer detail page