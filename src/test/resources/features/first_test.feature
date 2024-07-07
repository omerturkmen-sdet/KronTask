Feature: Search Product Feature

  @wip
  Scenario: User searches a product with sensible search key
    Given User navigates home page
    When User searches "tshirt" on search bar
    Then Verify that user landed on result page
    And Verify that products are listed related with search key

  @wip
  Scenario: User searches a product with meaningless search key
    Given User navigates home page
    When User searches "qweqweqeq" on search bar
    Then Verify that user landed on result page
    And Verify that no products listed and proper page displayed

  @new
  Scenario: User searches a product with sensible search key
    Given User navigates home page
    When User searches "tshirt" on search bar
    Then Verify that user landed on result page
    When User select random product from the list
    Then Verify that user landed on product page
    And Verify that product info are match with the previous page


