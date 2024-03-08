Feature: Cart Page

  Scenario: Removing products from the cart page
  
    And The user clicks on Products option in the homepage
     When The user hover over on first product and clicks on Add to cart
    Then Product added pop-up should pop-up and the user click on 'Continue Shopping'
    And The user hover over on second product and clicks on Add to cart
    Then Product added pop-up should pop-up and the user click on 'Continue Shopping'
    When The user clicks on cart option
    Then The cart page title should be 'Automation Exercise - Checkout'
    And The added products should be available in the cart page and the user clicks on X button on particluar product
    Then The particular product should be removed from cart
    
