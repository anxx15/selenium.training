#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.

Feature: Title of your feature
  I want to use this template for my feature file

  @tc001
  Scenario Outline: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition <TCID>
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

    Examples: 
      | TCID    |
      | "TC001" |
      #| "TC002" |
      #| "TC003" |
      #| "TC004" |
