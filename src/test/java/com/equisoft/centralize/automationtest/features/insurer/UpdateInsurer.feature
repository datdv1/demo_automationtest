@Insurer @EditInsurerAddress
Feature: Edit address
  this feature will edit insurer address information.

  Background: User logged in as administrator
    Given the user is on login page
    When the user enters username & password
    And the user clicks on the login button
    Then the dashboard page is opened

  @EditInsurerSuccessful
  Scenario Outline: Edit insurer successful
    Given the user is on Edit Insurer page
    When the user edits 'displayName' to '<DisplayName>' and the user edits 'companyName' to '<CompanyName>' and 'language' to '<Language>' and 'website' to '<Website>'
    And the user edits 'emailType' to '<EmailType>' and 'email' to '<Email>' and 'phoneType' to '<PhoneType>' and 'phoneValue' to '<PhoneValue>' and 'phoneExt' to '<PhoneExt>'
    And the user edits 'addressType' to '<AddressType>' and 'country' to '<Country>' and 'address' to '<Address>' and 'apt' to '<AddressApt>' and 'city' to '<City>' and 'province' to '<Province>' and 'postalCode' to '<PostalCode>'
    And the user click to button 'Save'
    Then the user can save page successfully with message 'Insurer modifications applied successfully.' pop up
    And the user can see new information in insurer detail page
    Examples:
      | DisplayName              | CompanyName      | Language | Website                                | EmailType     | Email                         | PhoneType | PhoneValue        | PhoneExt | AddressType | Country | Address              | AddressApt | City          | Province | PostalCode |
      | New insurer display name | New company name | French   | new-company-website.company-domain.com | New bussiness | newcompany@company-domain.com | Company   | +1 (098) 765-4321 | ABC      | Claim       | Canada  | 481 Rue Saint-Pierre | 3rd floor  | Drummondville | Quebec   | J2C 3W4    |
    