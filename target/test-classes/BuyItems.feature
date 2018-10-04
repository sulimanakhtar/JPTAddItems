	Feature: As a customer i can buy items
  
  Scenario: I want to add items to my cart so i can buy them
    Given I am at home screen
    And I click on  shop button
    And I click on  buy button of the items
    And I click on cart button
    And I click on checkout button
    And I enter payment details
    And I click on submit button
    Then I should receive order confirmation number