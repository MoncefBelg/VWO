Feature: login scenario
  Background:

  Scenario: valid user
    Given User is navigating to VWO website
    When User enters a valid email address and a valid password
    And User clicks on Sign in button
    Then User is successfully logged in to the application

