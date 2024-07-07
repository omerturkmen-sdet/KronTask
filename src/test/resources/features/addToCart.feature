Feature: Add to Cart Feature

  Background: User navigates to product page
    Given User navigates home page
    When User searches "tshirt" on search bar
    Then Verify that user landed on result page
    When User select random product from the list
    Then Verify that user landed on product page

  @addToCart @negative
  Scenario: User add product without selecting size
    And  User adds product to cart
    Then Verify that cart have "0" product
    And Verify that add to cart button text is changed as "LÜTFEN BEDEN SEÇİNİZ"

  @addToCart @positive
  Scenario: User add product after selecting size
    When User selects one of the available size option
    And  User adds product to cart
    Then Verify that cart have "1" product
    And Verify that add to cart button text is changed as "SEPETE EKLENDİ"

  @checkProductAtCart @positive @runnn
  Scenario: User add product after selecting size
    When User selects one of the available size option
    And  User adds product to cart
    Then Verify that cart have "1" product
    And Verify that add to cart button text is changed as "SEPETE EKLENDİ"
    When User navigates cart page
    Then Verify that product info are match on the cart page
