#Author: your.email@your.domain.com
#Keywords Summary :
Feature: Use of data table in scenario
  I want to use this template for my feature file

  @tc002
  Scenario: Use of data table in scenario
    Given I want to write a step with precondition
    When I enter username and password thru list:
      | anup | password |
    Then I enter username and password thru map:
      | username | anup     |
      | password | password |
