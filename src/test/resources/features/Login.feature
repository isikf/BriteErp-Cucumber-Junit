@BE_001 @login
Feature: User login the web page
  User login with valid credentials and not login with invalid credentials

  @positive
  Scenario: Login as a CRMmanager
    Given the user logged in
    Then the "Discuss" page should be displayed


