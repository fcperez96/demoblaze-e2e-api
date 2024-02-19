Feature: Buy products

  @BuyTwoProducts
  Scenario: Buy two products
    When Buyer add two products in the cart to buy
    Then he should see the productos in the cart
    And he should be able to finalize the purchase

