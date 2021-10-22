@Login
Feature: Login
  I want to use this template for my feature file

  @LoginSuccessful
  Scenario: Login
    Given the user is on login page
    When the user enters username & password
    And the user clicks on the login button
    Then the dashboard page is opened