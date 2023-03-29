@Home
Feature: Feature is to test login
  I want to use this template for my feature file

  Background: 
    Given Navigate to URL given in property file

  #
  @TC1 @Sanity @Regression @bath1
  Scenario: Scenario is to learn how to write step definition
    Given User navigate to the URL
    And User clicks Login Button to get logged in

  #
  #@TC2
  #Scenario: Scenario is to learn how to write step definition for the parameterized steps
  #And User enters "ABCD" in User Name field
  #And User enters "Password@1" in Password field
  #
  #@TC3
  #Scenario Outline: : Scenario is to learn how to Read Data from Examples
  #Then User takes value from examples "<UserName>"
  #And User enters <UserName> and <Password> to login
  #
  #Examples:
  #| UserName | Password   |
  #| Hello    | Password@1 |
  #
  #@TC4
  #Scenario: Scenario is to learn how to Read Data from Cucumber Data Table
  #Then User takes values from Data Table
  #| ABCD | Password@1 |
  #
  #@TC3
  #Scenario: Scenario is to learn write step definition for the parameterized steps
  #Given User navigate to the Test Application Login URL
  #When User enters "ABCD" and "Password" to get logged in
  #And User clicks Login button
  #Then User validates the Home Page
  #@tag
  #Feature: Learning how to create a Step Definition for given scenario
  @TC3
  Scenario Outline: Scenario is to learn how to Read Data from Examples
    Given User navigate to the Test Application Login URL
    When User enters "ABCD" and "Password" to get logged into the system
    When User takes <UserName> and <Password> to get logged in
    And User clicks Login button
    Then User validates the Home Page

    Examples: 
      | UserName | Password   |
      | "ABCD"   | "Password" |
