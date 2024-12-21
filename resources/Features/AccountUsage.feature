Feature: Account Usage

  Background:
  @AccountUsage
    Scenario: Check the Account usage
      Given User is navigating to VWO website
      When User enters a valid email address and a valid password
      And User clicks on Sign in button
      And User is successfully logged in to the application
      And User click on Usage Activity Button
      Then User is able to check his activities