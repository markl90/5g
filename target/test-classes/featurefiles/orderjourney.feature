Feature: Performing a search

#  Background:

  @test
  Scenario: Successful search with primary search bar
    Given the user is on the landing page
    When the the user selects the phones link
    And the user specifies a search selecting a result
      | brand       | Capacity   |
      | BlackBerry  | 32GB       |
    When the user clicks the product
    And specifies contract details selecting a plan
    When the user answers product setup questions
      | device 1 answer | spending cap | Extra data |
    And selects go to checkout
    And fills in customer details
    And fills out business details
    And fills out credit check information
    And fills out account details
