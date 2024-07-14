Feature: Product Browsing

  Scenario: Products are displayed correctly on the homepage
    Given the user is on the homepage
    Then user should see a list of products

  Scenario: Product categories can be navigated successfully
    Given the user is on the homepage
    When the user navigates to a product category "Laptops"
    Then the user should see a list of products in that category
