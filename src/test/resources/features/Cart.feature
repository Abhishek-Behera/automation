Feature: Adding Products to the Shopping Cart

  Scenario: Add last product to the cart
    Given the user is on the homepage
    When the user navigates to the last page by clicking next
    And the user selects the last product
    And the user adds the product to the cart
    Then the product should be added to the cart
