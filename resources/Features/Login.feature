Feature: login scenario
  Background:

    @validUser
  Scenario: valid user
    Given User is navigating to VWO website
    When User enters a valid email address and a valid password
    And User clicks on Sign in button
    Then User is successfully logged in to the application



  @invalidUser
     Scenario Outline:
      Given User is navigating to VWO website
      When User enters invalid "<email>" address and a invalid "<password>"
      And User clicks on Sign in button
      Then "<error>" message is displayed
      Examples:
        |email                   |password |error
        |jhshdhvsdhdeu@gmail.com |hwjd@12  |Your email, password, IP address or location did not match
       # |hyyxjwjiwggbx@gmail.com |yahnu7899|Your email, password, IP address or location did not match
        |                        |uIeOO172 |Your email, password, IP address or location did not match
        |freYeudu289@hotmail.com |         |Your email, password, IP address or location did not match






