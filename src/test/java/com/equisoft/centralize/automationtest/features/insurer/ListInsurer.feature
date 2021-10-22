@Insurer @InsurerListPage
Feature: ListInsurer
  This feature will get insurer list and detail.

  Background: User logged in as administrator
    Given the user is on login page
    When the user enters username & password
    And the user clicks on the login button
    Then the dashboard page is opened

  @SelectedRecord @TC21
  Scenario: Verify selection of a row record will display insurer information
    Given the user go to insurers list page by click to link Insurer under Folder
    And the user can see insurers list page
    And the user can see the list of insurers
    When the user select a row record
    Then the user should see the insurer information with selected record in the Insurer Folder menu
