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
