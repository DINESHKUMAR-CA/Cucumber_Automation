Feature: Check All Products and Their Details Page

  Scenario: Verify All Products and product detail page
  
    And The user clicks on Products option in the homepage
    Then The user should be navigated to the ALL PRODUCTS page and the page title should be 'Automation Exercise - All Products'
    And The user should see the products list
    When The user clicks on 'View Product' of the first product
    Then The user should be landed to the product detail page
    And The user should see the product name, category, price, availability, condition, and brand
