@Insurer @CreateInsurer
Feature: CreateInsurer
  This feature will create an insurer.

  Background: User logged in as administrator
    Given the user is on login page
    When the user enters username & password
    And the user clicks on the login button
    Then the dashboard page is opened

  @CreateInsurerSuccessful
  Scenario Outline: CreateInsurerSuccessful
    Given the user opens create insurer popup
    When the user enters displayName is '<DisplayName>' and companyName is '<CompanyName>' and language is '<Language>' and website is '<Website>'
    And the user enters emailType is '<EmailType>' and email is '<Email>' and phoneType is '<PhoneType>' and phoneValue is '<PhoneValue>' and phoneExt is '<PhoneExt>'
    And the user enters addressType is '<AddressType>' and country is '<Country>' and address is '<Address>' and addressApt is '<AddressApt>' and city is '<City>' and province is '<Province>' and postalCode is '<PostalCode>'
    And the user clicks on the create button
    Then the user created and user details page is opened
    Examples:
      | DisplayName            | CompanyName | Language | Website                   | EmailType     | Email               | PhoneType | PhoneValue        | PhoneExt | AddressType | Country | Address          | AddressApt | City    | Province | PostalCode |
      | ABC AUTOMATION Company | ABC         | English  | website.domain.com | New bussiness | thien.dao@dirox.net | Company   | +1 (098) 765-4321 | ABC      | Head office | Canada  | 731 Ontario Road | 3rd floor  | Welland | Ontario  | L3B        |
