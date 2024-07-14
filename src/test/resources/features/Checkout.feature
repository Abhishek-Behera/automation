Feature: Checkout Process

  Scenario: Successfully check out items in the cart
    Given the user has products in their cart
    When the user proceeds to checkout
    Then the user should be able to complete the checkout process
    And the user should see a confirmation of the successful purchase

  Scenario: Checkout without adding any products to the cart
    Given the user's cart is empty
    When the user proceeds to checkout
    Then the user should see an error message indicating no products to checkout

