@Insurer @CreateInsurer
Feature: CreateInsurer
  This feature will create an insurer.

  Background: User logged in as administrator
    Given the user is on login page
    When the user enters username & password
    And the user clicks on the login button
    Then the dashboard page is opened

  @CreateInsurerSuccessful
  Scenario: CreateInsurerSuccessful
    Given the user opens create insurer popup
    When the user enters general information
    And the user enters contact information
    And the user enters address information
    And the user clicks on the create button
    Then the user created and user details page is opened